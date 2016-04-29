package app.receiver.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestFactory {
	
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
	private ViewAccessLogsRequest viewAccessLogsRequest;
	//private RequestTemplate requestTemplate;
	
	public void createRequest(HttpServletRequest request, HttpServletResponse response,
			String target){
		if (target.equalsIgnoreCase("/createStudent")) 
		{
			//requestTemplate = new CreateStudentRequest();
			createStudentRequest.attemptRequest(request, response);
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
			//requestTemplate = new CreateTerminalRequest();
			createTerminalRequest.attemptRequest(request, response);
		} 
		else if (target.equalsIgnoreCase("/login")) 
		{
			//requestTemplate = new LoginRequest();
			loginRequest.attemptRequest(request, response);
		} 
		else if (target.equalsIgnoreCase("/logout")) 
		{
			//requestTemplate = new LogoutRequest();
			logoutRequest.attemptRequest(request, response);
		} 
		else if (target.equalsIgnoreCase("/getPromoURL")) 
		{
			getPromoRequest.attemptRequest(request, response);
		} 
		else if (target.equalsIgnoreCase("/viewTerminals")) 
		{
			viewTerminalsRequest.attemptRequest(request, response);
		} 
		else if (target.equalsIgnoreCase("/viewAccessLogs")) 
		{
			viewAccessLogsRequest.attemptRequest(request, response);
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
