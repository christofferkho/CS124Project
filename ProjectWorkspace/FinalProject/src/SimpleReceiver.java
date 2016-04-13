

import org.springframework.context.support.*;

public class SimpleReceiver
{
    private static AbstractApplicationContext ctx;

    public static void main(String[] args)
    {
        // load application context files
        System.out.println("Starting main");
        ctx = new ClassPathXmlApplicationContext(new String []{"applicationContext.xml"});
                
        // add a shutdown hook for the above context...
        ctx.registerShutdownHook();
        
        if ((args.length>0) && (args[0].equals("-forever")))
        {
            while(true)
            {
                try
                {
                    Thread.sleep(60000);
                }
                catch(Exception e)
                {
                }
            }
        }
        else
        {
            pressEnterToExit();
        }
    }
    
    private static void pressEnterToExit()
    {
        // wait for <Enter> to be pressed
        System.out.println("Press <Enter> to exit...");
        
        try
        {
            System.in.read();
            
            // then finish            
            System.out.println("Closing application...");
            System.exit(0);
        }
        catch(Exception e)
        {
        }
    }
}
