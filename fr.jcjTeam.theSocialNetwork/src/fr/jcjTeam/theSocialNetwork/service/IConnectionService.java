package fr.jcjTeam.theSocialNetwork.service;

import fr.jcjTeam.theSocialNetwork.beans.User;

public interface IConnectionService {

	boolean isAuthorized(User user);
	String needToBeRedirected(String path, Boolean autorisationRequired, User user);
}
