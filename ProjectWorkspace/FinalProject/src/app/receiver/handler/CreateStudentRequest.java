package app.receiver.handler;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.component.CreateStudentCommand;

@Component
public class CreateStudentRequest extends RequestTemplate{
	
	@Autowired
	private CreateStudentCommand command;
	
	@Override
	protected String doCommand(HashMap map) {
		// TODO Auto-generated method stub
		return command.execute(map);
	}

}
