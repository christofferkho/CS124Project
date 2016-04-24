package app.receiver.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.component.Administrator;

import com.fasterxml.jackson.databind.ObjectMapper;

//@Component
public abstract class RequestTemplate {
	
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
	//protected Command command;
	
	public void attemptRequest(HttpServletRequest request, HttpServletResponse response){
		HashMap map = convertJsonToCommand(request);
		getArgs(map);
		String reply = doCommand();
		writeReply(response, reply);
	}
	
	protected abstract void getArgs(HashMap map);
	protected abstract String doCommand();
	
	protected void writeReply(HttpServletResponse response, String reply){
		try {
			response.getWriter().println(reply);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected HashMap convertJsonToCommand(HttpServletRequest request) {
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

	protected static String readStreamAsString(InputStream is) throws IOException {
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
