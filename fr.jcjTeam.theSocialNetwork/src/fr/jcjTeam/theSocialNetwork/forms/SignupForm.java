package fr.jcjTeam.theSocialNetwork.forms;

import javax.servlet.http.HttpServletRequest;

import fr.jcjTeam.theSocialNetwork.beans.Constant;
import fr.jcjTeam.theSocialNetwork.beans.User;
import fr.jcjTeam.theSocialNetwork.service.UserService;

public class SignupForm extends AForm {
	
	private static final String CHAMP_EMAIL  = Constant.EMAIL;
    private static final String CHAMP_PASS   = Constant.PASSWORD;
    private static final String CHAMP_PASS_CONFIRM   = Constant.PASSWORD_CONFIRMED;
    private static final String CHAMP_NAME  = Constant.NAME;
    private static final String CHAMP_SURNAME   = Constant.SURNAME;
    private Boolean admin;
    
	@Override
	public boolean canValidateForm(HttpServletRequest request) {
		return false;
	}
	
	public SignupForm(){
		this.admin = false;
	}
	
	public SignupForm(Boolean admin){
		this.admin = admin;
	}
	
	public User canCreateUser( HttpServletRequest request ) {
        String email = getValueFromRequest( request, CHAMP_EMAIL );
        String password = getValueFromRequest( request, CHAMP_PASS );
        String passConfirmed = getValueFromRequest( request, CHAMP_PASS_CONFIRM );
        String name = getValueFromRequest( request, CHAMP_NAME );
        String surname = getValueFromRequest( request, CHAMP_SURNAME );
        
        Boolean resAdmin = admin;
        
        try {
            nameSurnameNotNull(name, surname);
        } catch ( Exception e ) {
            this.setMistakes( Constant.PASSWORD, e.getMessage() );
        }

        try {
            identicPassword(passConfirmed, password);
        } catch ( Exception e ) {
            this.setMistakes( Constant.PASSWORD, e.getMessage() );
        }

        User user = new User(email, name, surname, password, resAdmin);
        
        if ( mistakes.isEmpty() ) {
	        try {
	            user = addUser( user );
	        } catch ( Exception e ) {
	            this.setMistakes( Constant.USER, e.getMessage() );
	        }
        }

        if ( mistakes.isEmpty() ) {
            result = "Succès de la connexion.";
        } else {
            result = "Échec de la connexion.";
        }

        return user;
    }
	
	private User addUser( User newUser ) throws Exception {
        UserService userService = new UserService();
        User user = userService.addUser(newUser);
    	if ( user==null ) {
            throw new Exception( "Identifiant déjà utilisé" );
        }
		return user;
    }
	
	private void identicPassword( String passConfirmed, String password ) throws Exception {
    	if ( !password.equals(passConfirmed) ) {
            throw new Exception( "Mot de passe de confirmation différent" );
        }
    }
	
	private void nameSurnameNotNull( String name, String surname ) throws Exception {
    	if ( name.length()<3 || surname.length()<3 || name == null || surname == null) {
            throw new Exception( "Mot de passe de confirmation différent" );
        }
    }
}
