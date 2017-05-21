package fr.jcjTeam.theSocialNetwork.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fr.jcjTeam.theSocialNetwork.beans.User;

public class UserDAO implements IUserDao{
	
	public Connection connection;
	
	public UserDAO() {
		connection = ConnectionTool.getConnection();
	}
	
	@Override
	public List<User> getListOfUsers() {
		List<User> users = new ArrayList<>();
		ResultSet resultats = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USERS WHERE ISADMINISTRATOR <> TRUE");
			resultats = preparedStatement.executeQuery();
			while(resultats.next()) {
				User newUser = new User(resultats.getString(1), resultats.getString(2), resultats.getString(3), resultats.getString(4), resultats.getBoolean(5));
				users.add(newUser);
			}		
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
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
	public User addUser(User user) {
		User userExist = this.getUserById(user.getId());
		int canAddUser=-1;
		if(userExist == null){
			try {
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USERS (ID, NAME, SURNAME, PASSWORD, ISADMINISTRATOR) VALUES( ? , ? , ? , ? , ? );");
				preparedStatement.setString(1, user.getId());
				preparedStatement.setString(2, user.getName());
				preparedStatement.setString(3, user.getSurname());
				preparedStatement.setString(4, user.getPassword());
				preparedStatement.setBoolean(5, user.getAdministrator());
				canAddUser = preparedStatement.executeUpdate();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(canAddUser != 1 || userExist != null){
			user = null;
		}
		return user;
	}

	@Override
	public void updateUser(User user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE USERS SET NAME = ? , SURNAME = ? , PASSWORD = ? WHERE ID = ? ");
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(String idUser) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM USERS WHERE ID = ? ");
			preparedStatement.setString(1, idUser);
			preparedStatement.executeUpdate();		
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
