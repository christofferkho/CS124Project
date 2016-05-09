package app.component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import app.entity.AccessLog;

@Component
public class LogoutCommand extends Command {
	
	private AccessLog logout;

	@Override
	public String undo(Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(HashMap map) {
		// TODO Auto-generated method stub
		logout = findAccessLog(map);
		
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		try {
			logout = accessLogDao.save(logout);
			String ret = date.format(logout.getTimeOut());
			logout = null;
			
			return ret;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "Database error " + e.getMessage();
		}
	}
	
	private AccessLog findAccessLog(HashMap map){
		String value = (String) map.get(ACCESSLOGPK);
		
		long pk = Long.parseLong(value);
		
		logout = accessLogDao.findById(pk);
		if(logout != null){
			logout.setTimeOut(getDate());
		}
		return logout;
	}

}
