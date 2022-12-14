package Back_End.Util;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class UserUtil {
    
    private static SessionFactory sessionFactory=null;
   

    static {   
    	Logger log = Logger.getLogger("org.hibernate");
    	   log.setLevel(Level.OFF);
    	   System.setProperty("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");
        try 
        {
	    ResourceBundle rb = ResourceBundle.getBundle("oracle");
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            cfg.setProperty("hibernate.connection.url", rb.getString("db.url"));
            cfg.setProperty("hibernate.connection.username", rb.getString("db.username"));
            cfg.setProperty("hibernate.connection.password", rb.getString("db.password"));
            //fill your code here
            sessionFactory = cfg.buildSessionFactory();
        }
        catch (Throwable ex) 
        {
            System.err.println("SessionFactory initial creation error."+ ex);    
        }
    }
    
    public static SessionFactory getSessionFactory() 
    {
    	return sessionFactory;
    }
}