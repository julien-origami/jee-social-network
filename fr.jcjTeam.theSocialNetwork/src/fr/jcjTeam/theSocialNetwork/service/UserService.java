package fr.jcjTeam.theSocialNetwork.service;

import java.util.List;

import fr.jcjTeam.theSocialNetwork.beans.User;
import fr.jcjTeam.theSocialNetwork.dao.UserDAO;

public class UserService implements IUserService{
	private UserDAO userDAO;
	
	public UserService() {
		this.userDAO = new UserDAO();
	}
	
	@Override
	public List<User> getListOfUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(String id) {		
        User user = userDAO.getUserById(id);
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
	
	public String getHashPassword(String password){ 
		 /* 
		 *  TODO IMPLEMENT A HASH METHOD FOR PASSWORD
		 * */
		return password;
	}

}
