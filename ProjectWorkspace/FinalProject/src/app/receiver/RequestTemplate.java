package app.receiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class RequestTemplate {
	//protected Command command;
	
	public void attemptRequest(HttpServletRequest request, HttpServletResponse response){
		HashMap map = convertJsonToCommand(request);
		getArgs();
		String reply = doCommand();
		writeReply(response, reply);
	}
	
	abstract void getArgs();
	abstract String doCommand();
	
	private void writeReply(HttpServletResponse response, String reply){
		try {
			response.getWriter().println(reply);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	private static String readStreamAsString(InputStream is) throws IOException {
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
