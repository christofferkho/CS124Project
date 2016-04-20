package app.receiver.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.jetty.Request;
import org.mortbay.jetty.handler.AbstractHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.component.Administrator;
import app.entity.OverdueFee;
import app.entity.Student;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
class URLHandler extends AbstractHandler {
	
	//Student keys
	public static final String IDNO = "idNo";
	public static final String FN = "firstName";
	public static final String LN = "lastName";
	public static final String PNUMBER = "phoneNumber";
	public static final String FLAGGED = "flagged";
	
	//fee keys
	public static final String AMOUNT = "amount";
	public static final String FEEPK = "overdueFeePk";
	public static final String TYPE = "type";
	
	//terminal keys
	public static final String TERMINALPK = "terminalAccessPk";
	public static final String TERMINAL = "terminal";
	public static final String LOCATION = "location";
	public static final String TIMEIN = "timeIn";

	//@Autowired
	//private Administrator admin;
	
	@Autowired
	private CreateStudentRequest requestTemplate;
	
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch)
			throws IOException, ServletException {

		System.out.println("=============================================================================");
		
		System.out.println("Target: "+target);
		System.out.println("URL : "+request.getRequestURL().toString());
		System.out.println("RequestType : "+request.getMethod());

		
		// // You can uncomment this to see what kind of HTTP headers and attributes are being sent
		//
		// System.out.println("\nHeaders:");
		// for (Enumeration<?> e = request.getHeaderNames();
		// e.hasMoreElements(); )
		// {
		// String key = (String) e.nextElement();
		// System.out.println(key+" = "+request.getHeader(key));
		// }
		//
		// System.out.println("\nAttributes:");
		// for (Enumeration<?> e = request.getAttributeNames();
		// e.hasMoreElements(); )
		// {
		// String key = (String) e.nextElement();
		// System.out.println(key+" = "+request.getAttribute(key));
		// }

		// System.out.println("=============================================================================");

		// convert the json from the stream to a DragonCommand object
		// read dragon reply convert to json
		// write to response
		
		// WARNING: these methods all assume JSON is being sent in the body
		// 			i.e. they are all POSTs
		 try {
			if (request.getMethod().equals("POST"))
			 {
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
					requestTemplate.attemptRequest(request, response);
					
					
				} /*
				else if (target.equalsIgnoreCase("/login")) 
				{
					// read the parameters
					HashMap command = convertJsonToCommand(request);
					
					String id = (String) command.get(IDNO);
					String terminal = (String) command.get(TERMINAL);
					String location = (String) command.get(LOCATION);
					
					int idNo = Integer.parseInt(id);
					// send stuff to Administrator
					String reply = admin.login(idNo, terminal, location);
					
					// write the reply
					response.getWriter().println(reply);
				} 
				else if (target.equalsIgnoreCase("/logout")) 
				{
					// read the parameters
					HashMap command = convertJsonToCommand(request);
					
					String id = (String) command.get(IDNO);
					String timeIn = (String) command.get(TIMEIN);
					
					int idNo = Integer.parseInt(id);
					// send stuff to Administrator
					String reply = admin.logOut(idNo, timeIn);
					
					// write the reply
					response.getWriter().println(reply);
				} 
				else if (target.equalsIgnoreCase("/viewStudents")) 
				{
					// read the parameters
					//no need to read anything!
					// send stuff to Administrator
					String reply = admin.viewStudents();
					
					// write the reply
					response.getWriter().println(reply);
				} 
				else if (target.equalsIgnoreCase("/createOverdueFee")) 
				{
					// read the parameters
					HashMap command = convertJsonToCommand(request);
					
					String id = (String) command.get(IDNO);
					String amount = (String) command.get(AMOUNT);
					String type = (String) command.get(TYPE);
					
					int idNo = Integer.parseInt(id);
					double dAmount = Double.parseDouble(amount);
					// send stuff to Administrator
					String reply = admin.createOverdueFee(idNo, dAmount, type);
					
					// write the reply
					response.getWriter().println(reply);
				} 
				else if (target.equalsIgnoreCase("/messageStudent")) 
				{
					// read the parameters
					HashMap command = convertJsonToCommand(request);
					
					String id = (String) command.get(IDNO);
					
					int idNo = Integer.parseInt(id);
					// send stuff to Administrator
					String reply = admin.messageStudent(idNo);
					
					// write the reply
					response.getWriter().println(reply);
				} 
				else if (target.equalsIgnoreCase("/dropAllOverdueFees")) 
				{
					// read the parameters
					HashMap command = convertJsonToCommand(request);
					
					String id = (String) command.get(IDNO);
					
					int idNo = Integer.parseInt(id);
					// send stuff to Administrator
					String reply = admin.dropAllOverdueFees(idNo);
					
					// write the reply
					response.getWriter().println(reply);
				} 
				else if (target.equalsIgnoreCase("/dropOverdueFee")) 
				{
					// read the parameters
					HashMap command = convertJsonToCommand(request);
					
					String overdueFeePk = (String) command.get(FEEPK);
					
					int feePk = Integer.parseInt(overdueFeePk);
					// send stuff to Administrator
					String reply = admin.dropOverdueFee(feePk);
					
					// write the reply
					response.getWriter().println(reply);
				} 
				else if (target.equalsIgnoreCase("/viewOverdueFees")) 
				{
					// read the parameters
					HashMap command = convertJsonToCommand(request);
					
					String id = (String) command.get(IDNO);
					
					int idNo = Integer.parseInt(id);
					// send stuff to Administrator
					String reply = admin.viewOverdueFees(idNo);
					
					// write the reply
					response.getWriter().println(reply);
				} 
				else if (target.equalsIgnoreCase("/viewMessages")) 
				{
					// read the parameters
					HashMap command = convertJsonToCommand(request);
					
					String id = (String) command.get(IDNO);
					
					int idNo = Integer.parseInt(id);
					// send stuff to Administrator
					String reply = admin.viewMessages(idNo);
					
					// write the reply
					response.getWriter().println(reply);
				} */
				else 
				{
					// invalid request
					response.getWriter().println("Unsupported POST request: " + target);
				}
			}
			else
			{
				// invalid request
				response.getWriter().println("Unsupported GET request: " + target);			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((Request) request).setHandled(true);
	}

	private HashMap convertJsonToCommand(HttpServletRequest request) {
		try {
			String rawJson = null;

			// extract any sent data
			rawJson = readStreamAsString(request.getInputStream());
			System.out.println("RAW COMMAND JSON: " + rawJson);

			ObjectMapper mapper = new ObjectMapper();
			HashMap requestData = (HashMap) mapper.readValue(rawJson, HashMap.class);

			return requestData;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String readStreamAsString(InputStream is) throws IOException {
		InputStreamReader isr = new InputStreamReader(is);

		BufferedReader reader = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}

		return sb.toString();
	}

}