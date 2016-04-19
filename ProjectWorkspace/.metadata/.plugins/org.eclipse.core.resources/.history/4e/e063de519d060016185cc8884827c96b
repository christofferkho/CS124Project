package app.receiver;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class MainUI extends javax.swing.JFrame {
	
	
	
	protected static HashMap doCommand(String action, String idNo, String firstName, String lastName,
			String phone, String terminal, String location, 
			String timeIn, String amount, String type, String feePk, int state) throws Exception
	{
		String url1 = "http://localhost:8080/"+action;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put(URLHandler.IDNO, idNo);
		map.put(URLHandler.FN, firstName);
		map.put(URLHandler.LN, lastName);
		map.put(URLHandler.PNUMBER, phone);
		map.put(URLHandler.TERMINAL, terminal);
		map.put(URLHandler.LOCATION, location);
		map.put(URLHandler.TIMEIN, timeIn);
		map.put(URLHandler.AMOUNT, amount);
		map.put(URLHandler.TYPE, type);
		map.put(URLHandler.FEEPK, feePk);
		
		
		
		// CONVERT JAVA DATA TO JSON
		ObjectMapper mapper = new ObjectMapper();
		String json1 = mapper.writeValueAsString(map);
		
		
		// SEND TO SERVICE
		String reply = NetUtil.postJsonDataToUrl(url1, json1);
		//System.out.println("REPLY = "+reply);
		
		try
		{
			// CONVERT REPLY JSON STRING TO A JAVA OBJECT 
			HashMap replyMap = (HashMap) mapper.readValue(reply, HashMap.class);
			return replyMap;	
		}
		catch(Exception e)
		{
			//System.out.println(reply);
			HashMap replyMap = new HashMap();
			replyMap.put("message", reply);
			return replyMap;	
			
		}
	}
    
    @PostConstruct
	public void tada()
	{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
	}
	
	@Override
	@Value("${app.name}")
	public void setTitle(String s)
	{
		super.setTitle(s);
	}
}
