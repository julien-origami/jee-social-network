package fr.jcjTeam.theSocialNetwork.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.jcjTeam.theSocialNetwork.beans.Message;
import fr.jcjTeam.theSocialNetwork.beans.Status;
import fr.jcjTeam.theSocialNetwork.beans.User;

public class MessageDAO implements IMessageDao {

	@Override
	public List<Message> getListOfMessages(User user) {
		List<Message> messages = new ArrayList<>();
		Connection con = ConectionTool.getConnection();
		if(con != null){
			try{
				Statement stmt = con.createStatement();
				ResultSet result = stmt.executeQuery("SELECT * FROM MESSAGES WHERE USER_ID='"+user.getId()+"'");
				while(result.next()){
					/*Fake test code*/
			
			//		Message message = new Message(Long.valueOf(result.getInt(1)), result.getString(2), result.getString(3), user, , Timestamp updateDate, Status status){);
					//message.setId(Long.valueOf(result.getInt(1)));
					//message.setTitle(result.getString(2));
					//messages.add(message);
				}
			}catch(SQLException e){
				return null;
			}
		}else{
			return null;
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
