package fr.jcjTeam.theSocialNetwork.service;

import java.util.List;

import fr.jcjTeam.theSocialNetwork.beans.Message;
import fr.jcjTeam.theSocialNetwork.beans.User;

public interface IMessageService {

	List<Message> getListOfMessages(User user);
	Message getMessage(Long id);
	void addMessage(Message message);
	void updateMessageStatus(Message message, int status);
	void deleteMessage(Message message);

}
