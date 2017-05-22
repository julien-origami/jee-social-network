package fr.jcjTeam.theSocialNetwork.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class LogClass{
	private static Logger log = (Logger) LogManager.getLogger(LogClass.class);
	
	public static void main(String[] args) {
        log.error("Hello, World!");
    }
}
