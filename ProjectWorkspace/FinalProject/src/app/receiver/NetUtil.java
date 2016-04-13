package app.receiver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
//NetUtil class
//this is a Facade that handles all http requests.
public class NetUtil {

	//use this to pass JSONs to a URL
	public static String postJsonDataToUrl(String url, String json) throws Exception
	{
		DefaultHttpClient httpClient = new DefaultHttpClient();
		InputStream is = null;
		try {
	        HttpPost httpPost = new HttpPost(url);
	        httpPost.setEntity(new StringEntity(json));
	        httpPost.setHeader("Accept", "application/json");
	        httpPost.setHeader("Content-type", "application/json");
	        
	        HttpResponse httpResponse = httpClient.execute(httpPost);
	        HttpEntity httpEntity = httpResponse.getEntity();
	        is = httpEntity.getContent();           
	        InputStreamReader isr = new InputStreamReader(is);
	            
	        BufferedReader reader = new BufferedReader(isr);
	        StringBuilder sb = new StringBuilder();
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	                sb.append(line + "\n");
	        }
	        
	        return sb.toString();
	    }
		finally
		{
			try
			{
				is.close();
			}
			catch(Exception e)
			{
			}
		}
	}
	
	//Post to a URL
	public static String postToUrl(String url) throws Exception
	{
		DefaultHttpClient httpClient = new DefaultHttpClient();

		InputStream is = null;
		try {
	        HttpPost httpPost = new HttpPost(url);
	        
	        HttpResponse httpResponse = httpClient.execute(httpPost);
	        HttpEntity httpEntity = httpResponse.getEntity();
	        is = httpEntity.getContent();           
	        InputStreamReader isr = new InputStreamReader(is);
	            
	        BufferedReader reader = new BufferedReader(isr);
	        StringBuilder sb = new StringBuilder();
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	                sb.append(line + "\n");
	        }
	        
	        return sb.toString();
	    }
		finally
		{
			try
			{
				is.close();
			}
			catch(Exception e)
			{
			}
		}
	}
	
	//reads the return of an HTTP request and returns a string
	public static String readUrlContentAsString(String url) throws Exception
	{
		DefaultHttpClient httpClient = new DefaultHttpClient();

		InputStream is = null;
		try
		{
			// Making HTTP request
	        HttpGet httpGet = new HttpGet(url);
	 
	        HttpResponse httpResponse = httpClient.execute(httpGet);
	        HttpEntity httpEntity = httpResponse.getEntity();
	        is = httpEntity.getContent();           
	        InputStreamReader isr = new InputStreamReader(is);
	            
	        BufferedReader reader = new BufferedReader(isr);
	        StringBuilder sb = new StringBuilder();
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	                sb.append(line + "\n");
	        }
	        
	        return sb.toString();
		}
		finally
		{
			try
			{
				is.close();
			}
			catch(Exception e)
			{
			}
		}		
	}
	
	//this is a specific httpPost method to bypass ateneo's proxy to use the Chikka API.
	//this should work even if not in ateneo, you just need to use your own chikka API account.
	public static String postToUrlChikka(String url, String body) throws Exception
	{
		HttpHost proxy = new HttpHost("proxy.admu.edu.ph", 3128);

		DefaultHttpClient httpClient = new DefaultHttpClient();
		httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,proxy);

		InputStream is = null;
		try {
	        HttpPost httpPost = new HttpPost(url);
	        
	        httpPost.setEntity(new StringEntity(body));
	        
	        HttpResponse httpResponse = httpClient.execute(httpPost);
	        HttpEntity httpEntity = httpResponse.getEntity();
	        is = httpEntity.getContent();           
	        
	        return readStreamAsString(is);
	    }
		finally
		{
			try
			{
				is.close();
			}
			catch(Exception e)
			{
			}
		}
	}

	
	// converts the InputStream into a String object
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
