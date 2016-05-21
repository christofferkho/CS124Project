package app.receiver.handler;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.component.CreateStudentCommand;
import app.component.LogoutCommand;
import app.component.ViewTerminalsCommand;

@Component
public class LogoutRequest extends RequestTemplate {
	
	@Override
	protected String doCommand(HashMap map) {
		// TODO Auto-generated method stub
		if(ctx != null){
			command = ctx.getBean(LogoutCommand.class);
			return command.execute(map);
		}
		else{
			return "fail";
		}
	}
	
}
