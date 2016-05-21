package app.receiver.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import app.component.LogoutCommand;

@Component
public class RequestFactory {
	/*
	@Autowired
	private CreateStudentRequest createStudentRequest;
	
	@Autowired
	private CreateTerminalRequest createTerminalRequest;
	
	@Autowired
	private LoginRequest loginRequest;
	
	@Autowired
	private LogoutRequest logoutRequest;
	
	@Autowired
	private GetPromoRequest getPromoRequest;
	
	@Autowired
	private ViewTerminalsRequest viewTerminalsRequest;
	
	@Autowired
	private ViewAccessLogsRequest viewAccessLogsRequest;*/
	
	@Autowired
	private AbstractApplicationContext ctx;
	
	private RequestTemplate requestTemplate;
	
	public void createRequest(HttpServletRequest request, HttpServletResponse response,
			String target){
		if (target.equalsIgnoreCase("/createStudent")) 
		{
			requestTemplate = ctx.getBean(CreateStudentRequest.class);
			requestTemplate.attemptRequest(request, response);
			//createStudentRequest.attemptRequest(request, response);
		}
		else if (target.equalsIgnoreCase("/connect")) 
		{
			try {
				response.getWriter().println("1");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else if (target.equalsIgnoreCase("/createTerminal")) 
		{
			requestTemplate = ctx.getBean(CreateTerminalRequest.class);
			requestTemplate.attemptRequest(request, response);
			//createTerminalRequest.attemptRequest(request, response);
		} 
		else if (target.equalsIgnoreCase("/login")) 
		{
			requestTemplate = ctx.getBean(LoginRequest.class);
			requestTemplate.attemptRequest(request, response);
			//loginRequest.attemptRequest(request, response);
		} 
		else if (target.equalsIgnoreCase("/logout")) 
		{
			requestTemplate = ctx.getBean(LogoutRequest.class);
			requestTemplate.attemptRequest(request, response);
			//logoutRequest.attemptRequest(request, response);
		} 
		else if (target.equalsIgnoreCase("/getPromoURL")) 
		{
			requestTemplate = ctx.getBean(GetPromoRequest.class);
			requestTemplate.attemptRequest(request, response);
			//getPromoRequest.attemptRequest(request, response);
		} 
		else if (target.equalsIgnoreCase("/viewTerminals")) 
		{
			requestTemplate = ctx.getBean(ViewTerminalsRequest.class);
			requestTemplate.attemptRequest(request, response);
			//viewTerminalsRequest.attemptRequest(request, response);
		} 
		else if (target.equalsIgnoreCase("/viewAccessLogs")) 
		{
			requestTemplate = ctx.getBean(ViewAccessLogsRequest.class);
			requestTemplate.attemptRequest(request, response);
			//viewAccessLogsRequest.attemptRequest(request, response);
		} 
		else {
			// invalid request
			try {
				response.getWriter().println("Unsupported POST request: " + target);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
