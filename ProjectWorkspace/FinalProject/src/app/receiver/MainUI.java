package app.receiver;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;


import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class MainUI extends javax.swing.JFrame {
	
	//Student keys
	public static final String IDNO = "idNo";
	public static final String FIRSTNAME = "firstName";
	public static final String LASTNAME = "lastName";
	
	//Promo keys
	public static final String PROMOPK = "promoPk";
		
	//Terminal keys
	public static final String TERMINALPK = "terminalAccessPk";
	public static final String TERMINALNUM = "terminalNum";
	public static final String ROOMNAME = "roomName";
	
	//AccessLog keys
	public static final String ACCESSLOGPK = "accessLogPk";
	public static final String TIMEIN = "timeIn";
	public static final String TIMEOUT = "timeOut";
	
	private static String IPPORT = "";
	
	public void setIPPORT(String s){
		this.IPPORT = s;
	}
	
	protected static HashMap doCommand(String action, HashMap map) throws Exception
	{
		String url1 = "http://" + IPPORT + "/" +action;
		
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
