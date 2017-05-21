package fr.jcjTeam.theSocialNetwork.service;

import java.util.List;

import fr.jcjTeam.theSocialNetwork.beans.Message;
import fr.jcjTeam.theSocialNetwork.beans.User;
import fr.jcjTeam.theSocialNetwork.dao.MessageDAO;

public class MessageService implements IMessageService {
	
	private MessageDAO messageDAO;
	
	public MessageService() {
		this.messageDAO = new MessageDAO();
	}
	
	@Override
	public List<Message> getListOfMessages(User user) {
		List<Message> messages = messageDAO.getListOfMessages(user); 
		return messages;
	}

	@Override
	public Message getMessage(Long id) {
		return messageDAO.getMessage(id);
	}

	@Override
	public void addMessage(Message message) {
		messageDAO.addMessage(message);
	}

	@Override
	public void updateMessageStatus(Message message, int status) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMessage(Long idMessage, User user) {
		messageDAO.deleteMessage(idMessage, user);
	}

	@Override
	public List<Message> getAllMessages(User user) {
		List<Message> messages = messageDAO.getAllMessages(user); 
		return messages;
	}

	@Override
	public List<Message> getAllMessagesForAdmin() {
		List<Message> messages = messageDAO.getAllMessagesForAdmin(); 
		return messages;
	}

	@Override
	public void updateMessage(Message message) {
		messageDAO.updateMessage(message);
	}

}
