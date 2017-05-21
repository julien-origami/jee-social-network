package fr.jcjTeam.theSocialNetwork.forms;

import javax.servlet.http.HttpServletRequest;

import fr.jcjTeam.theSocialNetwork.beans.Constant;
import fr.jcjTeam.theSocialNetwork.beans.User;
import fr.jcjTeam.theSocialNetwork.service.UserService;

public class SigninForm extends AForm{
	private static final String CHAMP_EMAIL  = Constant.EMAIL;
    private static final String CHAMP_PASS   = Constant.PASSWORD;

    public User canConnectUser( HttpServletRequest request ) {
        String email = getValueFromRequest( request, CHAMP_EMAIL );
        String password = getValueFromRequest( request, CHAMP_PASS );

        User user = new User();

        try {
            user = userExist( email, password );
        } catch ( Exception e ) {
            this.setMistakes( CHAMP_EMAIL, e.getMessage() );
        }

        if ( mistakes.isEmpty() ) {
            result = "Succès de la connexion.";
        } else {
            result = "Échec de la connexion.";
        }

        return user;
    }

 
    private User userExist( String email, String password ) throws Exception {
        UserService userService = new UserService();
        User user = userService.getUserById(email);
        String currentPassword = userService.getHashPassword(password);
    	if ( user==null || !currentPassword.equals(user.getPassword()) ) {
            throw new Exception( "Login / Mot de passe incorrect" );
        }
		return user;
    }


	@Override
	public boolean canValidateForm(HttpServletRequest request) {
		return false;
	}
}
