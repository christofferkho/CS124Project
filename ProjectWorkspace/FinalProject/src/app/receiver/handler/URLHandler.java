package app.receiver.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.jetty.Request;
import org.mortbay.jetty.handler.AbstractHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class URLHandler extends AbstractHandler {
	
	@Autowired
	private RequestFactory requestFactory;
	
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
				requestFactory.createRequest(request, response, target);
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

}
