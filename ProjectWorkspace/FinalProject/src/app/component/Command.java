package app.component;

import java.util.Date;
import java.util.HashMap;
import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import app.repositories.AccessLogRepository;
import app.repositories.PromoRepository;
import app.repositories.StudentRepository;
import app.repositories.TerminalRepository;


public abstract class Command {
	
	//Student keys
	public static final String IDNO = "idNo";
	public static final String FIRSTNAME = "firstName";
	public static final String LASTNAME = "lastName";
	
	//Promo keys
	public static final String PROMOPK = "promoPk";
		
	//Terminal keys
	public static final String TERMINALPK = "terminalAccessPk";
	public static final String TERMINALNUM = "terminalNum";
	public static final String ROOMNAME = "roomName";
	
	//AccessLog keys
	public static final String ACCESSLOGPK = "accessLogPk";
	public static final String TIMEIN = "timeIn";
	public static final String TIMEOUT = "timeOut";
	
	@Autowired
	protected AccessLogRepository accessLogDao;
	
	@Autowired
	protected StudentRepository studentDao;
	
	@Autowired
	protected TerminalRepository terminalDao;
	
	@Autowired
	protected PromoRepository promoDao;
	
	public abstract String undo(Exception e);
	public abstract String execute(HashMap map);
	
	protected Timestamp getDate(){
		Calendar calendar = Calendar.getInstance();
		Date current = (Date) calendar.getTime();
		Timestamp timestamp = new Timestamp(current.getTime());
		
		return timestamp;
	}
}
