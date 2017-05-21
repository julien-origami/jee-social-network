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
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MESSAGES WHERE USER_ID = ? ORDER BY UPDATE_DATE DESC");
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
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MESSAGES (TITLE, CONTENT, USER_ID, CREATION_DATE, UPDATE_DATE, STATUS) VALUES( ? , ? , ? , ? , ? , ? );");
			preparedStatement.setString(1, message.getTitle());
			preparedStatement.setString(2, message.getContent());
			preparedStatement.setString(3, message.getAuthor().getId());
			preparedStatement.setTimestamp(4, message.getCreationDate());
			preparedStatement.setTimestamp(5, message.getRealUpdateDate());
			preparedStatement.setInt(6, message.getStatus().ordinal());
			preparedStatement.executeUpdate();		
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateMessageStatus(Message message, int status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Message> getAllMessages(User user) {
		List<Message> messages = new ArrayList<>();
		ResultSet resultats = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MESSAGES JOIN USERS ON (MESSAGES.USER_ID = USERS.ID) WHERE STATUS = 0 OR USER_ID = ? ORDER BY UPDATE_DATE DESC");
			preparedStatement.setString(1, user.getId());
			resultats = preparedStatement.executeQuery();
			while(resultats.next()) {
				User newUser = new User(resultats.getString(8), resultats.getString(9), resultats.getString(10), resultats.getBoolean(12));
				Message mes = new Message(resultats.getLong(1), resultats.getString(2), resultats.getString(3), newUser, resultats.getTimestamp(5), resultats.getTimestamp(6), Status.values()[resultats.getInt(7)] );
				messages.add(mes);
			}		
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return messages;
	}

	@Override
	public List<Message> getAllMessagesForAdmin() {
		List<Message> messages = new ArrayList<>();
		ResultSet resultats = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MESSAGES JOIN USERS ON (MESSAGES.USER_ID = USERS.ID) ORDER BY UPDATE_DATE DESC");
			resultats = preparedStatement.executeQuery();
			while(resultats.next()) {
				User newUser = new User(resultats.getString(8), resultats.getString(9), resultats.getString(10), resultats.getBoolean(12));
				Message mes = new Message(resultats.getLong(1), resultats.getString(2), resultats.getString(3), newUser, resultats.getTimestamp(5), resultats.getTimestamp(6), Status.values()[resultats.getInt(7)] );
				messages.add(mes);
			}		
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return messages;
	}

}
