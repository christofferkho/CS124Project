package app.receiver.handler;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.component.Administrator;
import app.component.CreateStudentCommand;

@Component
public class CreateStudentRequest extends RequestTemplate{
	
	@Autowired
	protected CreateStudentCommand command;

	public CreateStudentRequest(){}
	
	private String firstName, lastName, phoneNumber = "";
	private int id = -1;
	@Override
	protected void getArgs(HashMap map) {
		// TODO Auto-generated method stub
		String idNo = (String) map.get(IDNO);
		firstName = (String) map.get(FN);
		lastName = (String) map.get(LN);
		phoneNumber = (String) map.get(PNUMBER);
		id = Integer.parseInt(idNo);
	}

	@Override
	protected String doCommand() {
		// TODO Auto-generated method stub
		command.createStudent(id, firstName, lastName, phoneNumber);
		return command.execute();
	}

}
