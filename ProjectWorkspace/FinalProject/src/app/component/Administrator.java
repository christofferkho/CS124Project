package app.component;

/**
 * Grocery simulator
 */

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.entity.Message;
import app.entity.OverdueFee;
import app.entity.Student;
import app.entity.TerminalAccess;
import app.receiver.NetUtil;
import app.repositories.MessageRepository;
import app.repositories.OverdueFeeRepository;
import app.repositories.StudentRepository;
import app.repositories.TerminalAccessRepository;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

//@Component classes will be compiled and run automatically if they are autowired
@Component
public class Administrator 
//the methods here currently have no way of rollbackign information in case of a database error.
//as such, the Administrator will be overhauled to have a superclass Command.
//all methods inside this current administrator will be concrete classes of the superclass Command.

{
	final String clientId = "53ca85c8624935b3a7b03e574d4131aa3757f00d215666fa2f1b44dc79b4029b";
	final String secretKey = "876677ebc689e3825ce206e5fb05df03b88d1883b0cad7a63a951d5d5375579a";
	final String shortCode = "292908682";
	final String url = "https://post.chikka.com/smsapi/request";
	
    @Autowired
    private StudentRepository studentDao;
    //Data Access Object
    
    @Autowired
    private TerminalAccessRepository terminalAccessDao;
    
    @Autowired 
    private OverdueFeeRepository overdueFeeDao;
    
    @Autowired
    private MessageRepository messageDao;

    private ObjectMapper om = new ObjectMapper();

    @PostConstruct
    public void init()
    {  	
    }
    
    public String createStudent(int idNo, String firstName, String lastName, String phoneNumber){
    	try {
			Student student = new Student(idNo, firstName, lastName, phoneNumber, false);
			studentDao.save(student);
			return "New Student: " + firstName + " " + lastName + ": " + idNo + ", " + phoneNumber;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Database error " + e.getMessage();
		}
    }
    
    public String login(int idNo, String terminal, String location){
    	Student student = studentDao.findByIdNo(idNo);
		if(student!= null){
			if (!student.isFlagged()) {
				String timeIn = "";
				timeIn = getDate();
				TerminalAccess access = new TerminalAccess(student, timeIn, "not timed out yet",
						terminal, location);
				terminalAccessDao.save(access);
				return timeIn;
			}
			else{
				List<OverdueFee> fees = overdueFeeDao.findByStudent(student);
				double totalDue = 0.0;
				for(OverdueFee fee: fees){
					totalDue += fee.getAmountDue();
				}
				return "access denied. \nPlease proceed to the Rizal Library lobby. \nDues: Php " + Double.toString(totalDue);
			}
		}
		else{
			return "access denied. Student does not exist.";
		}
    }
    
    public String logOut(int idNo, String timeIn){
    	Student student = studentDao.findByIdNo(idNo); 
    	String timeOut = "";
		timeOut = getDate();
    	TerminalAccess access;
		try {
			access = terminalAccessDao.findByTimeLogAndStudent(timeIn, student);
			//access = terminalAccessDao.findByTimeLog(timeIn);
			if(access == null){
				return "cant find log";
			}
			else{
				access.setTimeOut(timeOut);
		    	terminalAccessDao.save(access);
		    	return timeOut;
			}
	    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
    }
    
    public String viewStudents(){
    	List<Student> students = studentDao.findByFlagged(true);
    	String list = "";
		try {
			list = om.writeValueAsString(students);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return list;
    }
    
	public String createOverdueFee(int idNo, double amount, String type){
		Student student = studentDao.findByIdNo(idNo);
		if(student!= null){
			String time = "";
			time = getDate();
			try {
				OverdueFee fee = new OverdueFee(student, amount, time, type);
				overdueFeeDao.save(fee);
				student.setFlagged(true);
				studentDao.save(student);
				return "Fee created for " + idNo + ": Php" + amount;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Database error " + e.getMessage();
			}
		}
		else{
			return "Student does not exist";
		}
		
		
	}
	
	public String messageStudent(int idNo) throws Exception{
		Student student = studentDao.findByIdNo(idNo);
		if(student!=null){
			String phoneNumber = student.getPhoneNumber();
			String uuid = (String.valueOf(UUID.randomUUID()).replaceAll("-",""));
			List<OverdueFee> fees = overdueFeeDao.findByStudent(student);
			if(fees.size() == 0){
				return "Student does not have any overdue fees";
			}
			else{
				String message = "You have overdue fees in the Rizal library amounting to: ";
				double totalAmount = 0.0;
				for(OverdueFee fee: fees){
					double thisAmount = fee.getAmountDue();
					totalAmount += thisAmount;
				}
				String time = "";
				time = getDate();
				Message messageLog = new Message(student, time, totalAmount, false);
				messageDao.save(messageLog);
				try {
					String sTotalAmount = Double.toString(totalAmount);
					message = message + sTotalAmount + ". Please settle these fees as soon as possible.";
					String encodedString = URLEncoder.encode(message, "UTF-8");
					String postBody = "message_type=SEND"
							+"&mobile_number="+phoneNumber
							+"&shortcode="+shortCode
							+"&message_id="+uuid
							+"&message="+encodedString
							+"&client_id="+clientId
							+"&secret_key="+secretKey;
					String reply = NetUtil.postToUrlChikka(url, postBody);
					
					ObjectMapper mapper = new ObjectMapper();
					HashMap<String, Object> replyMap = mapper.readValue(reply, HashMap.class);
					int status = (Integer) replyMap.get("status");
					if(status == 200){
						messageLog.setSent(true);
						messageDao.save(messageLog);
					}
					
					System.out.println(replyMap);
					return "Chikka return:\n " + replyMap;
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "error sending message: " + e.getMessage();
				}
			}	
		}
		else{
			return "student not found";
		}
	}
	
	public String dropAllOverdueFees(int idNo){
		Student student = studentDao.findByIdNo(idNo);
		if(student!=null){
			List<OverdueFee> fees = overdueFeeDao.findByStudent(student);
			for(OverdueFee fee: fees){
				overdueFeeDao.delete(fee);
			}
			student.setFlagged(false);
			studentDao.save(student);
			return "all fees deleted";
		}
		else{
			return "student not found";
		}
	}
	
	public String dropOverdueFee(int overdueFeePk){
		OverdueFee fee = overdueFeeDao.findById(overdueFeePk);
		if(fee!= null){
			Student student = fee.getStudent();
			overdueFeeDao.delete(fee);
			List<OverdueFee> fees = overdueFeeDao.findByStudent(student);
			if(fees.size() == 0){
				student.setFlagged(false);
				studentDao.save(student);
			}
			return "fee deleted";
		}
		else
			return "fee not found";
	}
	
	public String viewOverdueFees(int idNo){
		Student student = studentDao.findByIdNo(idNo);
		if(student!=null){
			List<OverdueFee> fees = overdueFeeDao.findByStudent(student);
			String reply = "";
			try {
				reply = om.writeValueAsString(fees);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return reply;
		}
		else{
			return null;
		}
	}
	
	public String viewMessages(int idNo){
		Student student = studentDao.findByIdNo(idNo);
		if(student!=null){
			List<Message> messages = messageDao.findByStudent(student);
			String reply = "";
			try {
				reply = om.writeValueAsString(messages);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return reply;
		}
		else{
			return null;
		}
	}
	
	public String getDate(){
		Calendar calendar = Calendar.getInstance();
		Date current = calendar.getTime();
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		
		return date.format(current);
	}
	
	
    
}