package fr.jcjTeam.theSocialNetwork.service;

import java.util.List;

import fr.jcjTeam.theSocialNetwork.beans.User;

public interface IUserService {

	List<User> getListOfUsers();
	User getUserById(String id);
	User addUser(User user);
	void updateUser(User user);
	void deleteUser(String idUser);
	String getHashPassword(String password);
}
