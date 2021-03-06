package fr.jcjTeam.theSocialNetwork.dao;

import java.util.List;

import fr.jcjTeam.theSocialNetwork.beans.Message;
import fr.jcjTeam.theSocialNetwork.beans.User;

public interface IMessageDao {

	List<Message> getListOfMessages(User user);
	List<Message> getAllMessages(User user);
	List<Message> getAllMessagesForAdmin();
	Message getMessage(Long id);
	void addMessage(Message message);
	void updateMessageStatus(Message message, int status);
	void updateMessage(Message message);
	void deleteMessage(Long idMessage, User user);
	int getNumberOfMessage();

}
