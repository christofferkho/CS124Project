package app.receiver.handler;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import app.component.ViewTerminalsCommand;

@Component
public class ViewTerminalsRequest extends RequestTemplate {
	
	@Override
	protected String doCommand(HashMap map) {
		// TODO Auto-generated method stub
		if(ctx != null){
			command = ctx.getBean(ViewTerminalsCommand.class);
			return command.execute(map);
		}
		else{
			return "fail";
		}
		
	}

}
