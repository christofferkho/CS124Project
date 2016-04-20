package app.receiver.handler;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.component.Administrator;

@Component
public class CreateStudentRequest extends RequestTemplate{

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
		return admin.createStudent(id, firstName, lastName, phoneNumber);
	}

}