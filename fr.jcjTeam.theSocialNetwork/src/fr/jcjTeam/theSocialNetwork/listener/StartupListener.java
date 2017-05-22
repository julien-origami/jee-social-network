package fr.jcjTeam.theSocialNetwork.listener;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.jcjTeam.theSocialNetwork.jmx.Message;

/**
 * Application Lifecycle Listener implementation class StartupListener
 *
 */
@WebListener
public class StartupListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public StartupListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
    	ObjectName name = null;

    	try {
    	    name = new ObjectName("fr.epsi.myEpsi.jmx:type=MessageMBean");
    	    Message mbean = new Message();
    	    
    	    mbs.registerMBean(mbean, name);

    	} catch (MalformedObjectNameException e) {
    	    e.printStackTrace();
    	} catch (NullPointerException e) {
    	    e.printStackTrace();
    	} catch (InstanceAlreadyExistsException e) {
    	    e.printStackTrace();
    	} catch (MBeanRegistrationException e) {
    	    e.printStackTrace();
    	} catch (NotCompliantMBeanException e) {
    	    e.printStackTrace();
    	}

    }
	
}
