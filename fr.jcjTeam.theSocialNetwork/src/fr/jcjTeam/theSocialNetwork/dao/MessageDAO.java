package fr.jcjTeam.theSocialNetwork.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.jcjTeam.theSocialNetwork.beans.Message;
import fr.jcjTeam.theSocialNetwork.beans.Status;
import fr.jcjTeam.theSocialNetwork.beans.User;

public class MessageDAO implements IMessageDao {

	public Connection connection;
	
	public MessageDAO() {
		connection = ConnectionTool.getConnection();
	}
	
	@Override
	public List<Message> getListOfMessages(User user) {
		List<Message> messages = new ArrayList<>();
		ResultSet resultats = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MESSAGES WHERE ID = ?");
			preparedStatement.setString(1, user.getId());
			resultats = preparedStatement.executeQuery();
			while(resultats.next()) {
				Message mes = new Message(resultats.getLong(1), resultats.getString(2), resultats.getString(3), user, resultats.getTimestamp(5), resultats.getTimestamp(6), Status.values()[resultats.getInt(7)] );
				messages.add(mes);
			}		
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return messages;
	}

	@Override
	public Message getMessage(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMessageStatus(Message message, int status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

}
