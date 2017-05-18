package fr.jcjTeam.theSocialNetwork.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.jcjTeam.theSocialNetwork.beans.User;

public class UserDAO implements IUserDao{

	@Override
	public List<User> getListOfUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(String id) {
		Connection connection = ConnectionTool.getConnection();
		ResultSet resultats = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
			preparedStatement.setString(1, id);
			resultats = preparedStatement.executeQuery();
			System.out.println(preparedStatement.getParameterMetaData());
			while(resultats.next()) {
				System.out.println(resultats.getString(0));
				System.out.println(resultats.getString(1));
				System.out.println(resultats.getString(2));
				System.out.println(resultats.getString(4));
			}		
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
