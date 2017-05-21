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
		List<User> users = userDAO.getListOfUsers();
		return users;
	}

	@Override
	public User getUserById(String id) {		
        User user = userDAO.getUserById(id);
        return user;
	}

	@Override
	public User addUser(User user) {
		return userDAO.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Override
	public void deleteUser(String idUser) {
		userDAO.deleteUser(idUser);
	}
	
	public String getHashPassword(String password){ 
		 /* 
		 *  TODO IMPLEMENT A HASH METHOD FOR PASSWORD
		 * */
		return password;
	}

}
