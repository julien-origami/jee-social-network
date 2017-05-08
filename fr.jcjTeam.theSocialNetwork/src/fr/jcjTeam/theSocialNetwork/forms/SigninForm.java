package fr.jcjTeam.theSocialNetwork.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.jcjTeam.theSocialNetwork.beans.Constant;
import fr.jcjTeam.theSocialNetwork.beans.User;

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
            userExist( email );
        } catch ( Exception e ) {
            setMistakes( CHAMP_EMAIL, e.getMessage() );
        }
        user.setId( email );

        /* Initialisation du résultat global de la validation. */
        if ( mistakes.isEmpty() ) {
            result = "Succès de la connexion.";
        } else {
            result = "Échec de la connexion.";
        }

        return user;
    }

    
    /*TODO Vérification en BDD Use IUserDao !!*/
    private void userExist( String email ) throws Exception {
        /*if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }*/
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
