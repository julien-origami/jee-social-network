package fr.jcjTeam.theSocialNetwork.service;

import fr.jcjTeam.theSocialNetwork.beans.User;

public class SigninService implements IConnectionService{

	@Override
	public boolean isAuthorized(User user) {
		Boolean res = false;
		if(user.getAdministrator()){
			res = true;
		}
		return res;
	}

	@Override
	public String needToBeRedirected(String path, Boolean autorisationRequired, User user) {
		Boolean isAuthorized;
		String finalPath = "/";
		if(user!=null){
			isAuthorized = true;
			if(autorisationRequired){
				isAuthorized = isAuthorized(user);
			}
		}else{
			isAuthorized = false;
		}
		if(isAuthorized){
			finalPath += path;
		}
		return finalPath;
	}
	
}
