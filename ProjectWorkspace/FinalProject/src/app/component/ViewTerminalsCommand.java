package app.component;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.entity.Terminal;

@Component
public class ViewTerminalsCommand extends Command{
	
	private ObjectMapper om = new ObjectMapper();

	@Override
	public String undo(Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(HashMap map) {
		// TODO Auto-generated method stub
		List<Terminal> terminals = getTerminals();
		try {
			return om.writeValueAsString(terminals);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return "Database Error " + e.toString();
		}
	}
	
	private List<Terminal> getTerminals(){
		return terminalDao.findAll();
	}

}
