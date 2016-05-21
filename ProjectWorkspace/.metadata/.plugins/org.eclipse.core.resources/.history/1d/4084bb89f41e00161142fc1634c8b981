package app.receiver.handler;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.component.ViewTerminalsCommand;

@Component
public class ViewTerminalsRequest extends RequestTemplate {
	
	@Autowired
	private ViewTerminalsCommand command;

	@Override
	protected String doCommand(HashMap map) {
		// TODO Auto-generated method stub
		return command.execute(map);
	}

}
