package app.component;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.entity.AccessLog;
import app.entity.Student;
import app.entity.Terminal;

@Component
public class LoginCommand extends Command {
	
	private AccessLog login;

	private ObjectMapper om = new ObjectMapper();
	
	@Override
	public String undo(Exception e) {
		// TODO Auto-generated method stub
		e.printStackTrace();
		accessLogDao.delete(login);
		login = null;
		return "Database error " + e.getMessage();
	}

	@Override
	public String execute(HashMap map) {
		// TODO Auto-generated method stub
		login = createAccessLog(map);
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		HashMap<String, Object> mapSend = new HashMap<String, Object>();
		String ret = "";
		try {
			login = accessLogDao.save(login);
			String timeIn = date.format(login.getTimeIn());
			String loginPk = login.getId().toString();
			mapSend.put(ACCESSLOGPK, loginPk);
			mapSend.put(TIMEIN, timeIn);
			login = null;
			
			ret = om.writeValueAsString(mapSend);
			return ret;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "Database error " + e.getMessage();
		}
		
	}
	
	private AccessLog createAccessLog(HashMap map){
		String idNoString = (String) map.get(IDNO);
		String terminalPkString = (String) map.get(TERMINALPK);
		
		int idNo = Integer.parseInt(idNoString);
		int terminalPk = Integer.parseInt(terminalPkString);
		
		Student student = studentDao.findByIdNo(idNo);
		long pk = terminalPk;
		Terminal terminal = terminalDao.findById(pk);
		if(student != null){
			Timestamp timestamp = getDate();
			return new AccessLog(timestamp, student, terminal);
		}
		else{
			return null;
		}
	}

}
