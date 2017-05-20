package fr.jcjTeam.theSocialNetwork.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.jcjTeam.theSocialNetwork.beans.Constant;
import fr.jcjTeam.theSocialNetwork.beans.User;
import fr.jcjTeam.theSocialNetwork.service.UserService;

public class SigninForm implements IForm{
	private static final String CHAMP_EMAIL  = Constant.EMAIL;
    private static final String CHAMP_PASS   = Constant.PASSWORD;

    private String result;
    private Map<String, String> mistakes = new HashMap<String, String>();

    public String getResult() {
        return result;
    }

    public Map<String, String> getMistakes() {
        return mistakes;
    }

    public User canConnectUser( HttpServletRequest request ) {
        String email = getValueFromRequest( request, CHAMP_EMAIL );
        String password = getValueFromRequest( request, CHAMP_PASS );

        User user = new User();

        /* Validation du champ email. */
        try {
            user = userExist( email, password );
        } catch ( Exception e ) {
            setMistakes( CHAMP_EMAIL, e.getMessage() );
        }

        /* Initialisation du résultat global de la validation. */
        if ( mistakes.isEmpty() ) {
            result = "Succès de la connexion.";
        } else {
            result = "Échec de la connexion.";
        }

        return user;
    }

    
    /*TODO Vérification en BDD Use IUserDao !!*/
    private User userExist( String email, String password ) throws Exception {
        UserService userService = new UserService();
        User user = userService.getUserById(email);
        String currentPassword = userService.getHashPassword(password);
    	if ( user==null || !currentPassword.equals(user.getPassword()) ) {
            throw new Exception( "Login / Mot de passe incorrect" );
        }
		return user;
    }
    
    
    private void setMistakes( String champ, String message ) {
        mistakes.put( champ, message );
    }

    
    private static String getValueFromRequest( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
