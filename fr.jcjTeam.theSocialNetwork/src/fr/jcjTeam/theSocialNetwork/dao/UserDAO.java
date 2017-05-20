package fr.jcjTeam.theSocialNetwork.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.jcjTeam.theSocialNetwork.beans.User;

public class UserDAO implements IUserDao{
	
	public Connection connection;
	
	public UserDAO() {
		connection = ConnectionTool.getConnection();
	}
	
	@Override
	public List<User> getListOfUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(String id) {
		ResultSet resultats = null;
		User user = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USERS WHERE ID = ?");
			preparedStatement.setString(1, id);
			resultats = preparedStatement.executeQuery();
			while(resultats.next()) {
				user = new User(resultats.getString(1), resultats.getString(2), resultats.getString(3), resultats.getString(4), resultats.getBoolean(5));
			}		
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
