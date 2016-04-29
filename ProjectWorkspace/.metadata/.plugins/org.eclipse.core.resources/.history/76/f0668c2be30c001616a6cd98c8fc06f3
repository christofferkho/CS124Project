package app.receiver.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestFactory {
	@Autowired
	private CreateStudentRequest createStudent;
	
	public void createRequest(HttpServletRequest request, HttpServletResponse response,
			String target){
		if (target.equalsIgnoreCase("/createStudent")) 
		{
			/*
			// read the parameters
			HashMap command = convertJsonToCommand(request);
			// send stuff to grocery
			String product = (String) command.get("product");
			String quantity = (String) command.get("quantity");
			String location = (String) command.get("location");
			String employee = (String) command.get("employee");
			
			double doubleQuantity = Double.parseDouble(quantity);
			String reply = grocery.buy(product, doubleQuantity, location, employee);
			// write the reply
			response.getWriter().println(reply);
			*/
			
			// read the parameters
			/*
			HashMap command = convertJsonToCommand(request);
			
			String id = (String) command.get(IDNO);
			String firstName = (String) command.get(FN);
			String lastName = (String) command.get(LN);
			String phoneNumber = (String) command.get(PNUMBER);
			
			int idNo = Integer.parseInt(id);
			// send stuff to Administrator
			String reply = admin.createStudent(idNo, firstName, lastName, phoneNumber);
			
			// write the reply
			response.getWriter().println(reply);*/
			//requestTemplate = new CreateStudentRequest();
			createStudent.attemptRequest(request, response);
		}
		else if (target.equalsIgnoreCase("/login")) 
		{/*
			// read the parameters
			HashMap command = convertJsonToCommand(request);
			
			String id = (String) command.get(IDNO);
			String terminal = (String) command.get(TERMINAL);
			String location = (String) command.get(LOCATION);
			
			int idNo = Integer.parseInt(id);
			// send stuff to Administrator
			String reply = admin.login(idNo, terminal, location);
			
			// write the reply
			response.getWriter().println(reply);*/
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
