package app.receiver.handler;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.component.CreateStudentCommand;
import app.component.LoginCommand;

@Component
public class LoginRequest extends RequestTemplate {
	
	@Autowired
	private LoginCommand command;
	
	@Override
	protected String doCommand(HashMap map) {
		// TODO Auto-generated method stub
		return command.execute(map);
	}

}
