package app.receiver;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	
	public static Object fromJsonToObject(String jsonString, Class c) throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();	
		Object s = mapper.readValue(jsonString, c);
		return s;
	}
	
	
	public static String fromJsonFile(String path) throws Exception
	{
		InputStream is = null ;
	
		try
		{
			is = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(is);
			
			BufferedReader reader = new BufferedReader(isr);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
	
			return sb.toString().trim();
		}
		finally 
		{
			try {
				is.close();
			} catch (Exception e) {}
		}

	}	
}

