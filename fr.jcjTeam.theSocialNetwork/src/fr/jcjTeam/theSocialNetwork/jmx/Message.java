package fr.jcjTeam.theSocialNetwork.jmx;

import java.sql.Timestamp;

import fr.jcjTeam.theSocialNetwork.dao.MessageDAO;

public class Message implements MessageMBean {

    private int messageNumber = 0; 

    public void addMessage(String title, String content) {
    	MessageDAO messageDAO = new MessageDAO();
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	fr.jcjTeam.theSocialNetwork.beans.User user = new fr.jcjTeam.theSocialNetwork.beans.User("admin@test.fr", "admin", "", "pass", true);
    	fr.jcjTeam.theSocialNetwork.beans.Message message = new fr.jcjTeam.theSocialNetwork.beans.Message(title, content, user, timestamp, 0);
    	messageDAO.addMessage(message);
    }
	
	public int getMessageNumber() {
        return messageNumber;
    }

    public void refreshMessageNumber() {
    	MessageDAO messageDAO = new MessageDAO();
		this.messageNumber =  messageDAO.getNumberOfMessage();
    }

}

