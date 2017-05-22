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
		ResultSet resultats = null;
		Message mes = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MESSAGES JOIN USERS ON (MESSAGES.USER_ID = USERS.ID) WHERE ID = ?");
			preparedStatement.setLong(1, id);
			resultats = preparedStatement.executeQuery();
			while(resultats.next()) {
				User newUser = new User(resultats.getString(8), resultats.getString(9), resultats.getString(10), resultats.getBoolean(12));
				mes = new Message(resultats.getLong(1), resultats.getString(2), resultats.getString(3), newUser, resultats.getTimestamp(5), resultats.getTimestamp(6), Status.values()[resultats.getInt(7)] );
			}		
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mes;
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
	public int getNumberOfMessage() {
		ResultSet resultats = null;
		int res = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM MESSAGES");
			resultats = preparedStatement.executeQuery();
			while(resultats.next()) {
				res = resultats.getInt(1);
			}		
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public void deleteMessage(Long idMessage, User user) {
		String request = "DELETE FROM MESSAGES WHERE ID = ? AND USER_ID = ? ";
		if(user.getAdministrator()){
			request = "DELETE FROM MESSAGES WHERE ID = ? ";
		}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(request);
			preparedStatement.setLong(1, idMessage);
			if(!user.getAdministrator()){
				preparedStatement.setString(2, user.getId());
			}
			preparedStatement.executeUpdate();		
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	@Override
	public void updateMessage(Message message) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE MESSAGES SET TITLE = ? , CONTENT = ? , STATUS = ? , UPDATE_DATE = ? WHERE ID = ? AND USER_ID = ? ");
			preparedStatement.setString(1, message.getTitle());
			preparedStatement.setString(2, message.getContent());
			preparedStatement.setInt(3, message.getStatus().ordinal());
			preparedStatement.setTimestamp(4, message.getRealUpdateDate());
			preparedStatement.setLong(5, message.getId());
			preparedStatement.setString(6, message.getAuthor().getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
