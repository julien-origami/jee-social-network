package fr.jcjTeam.theSocialNetwork.forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import fr.jcjTeam.theSocialNetwork.beans.Constant;
import fr.jcjTeam.theSocialNetwork.beans.User;
import fr.jcjTeam.theSocialNetwork.service.UserService;

public class UpdateUserForm extends AForm {

	@Override
	public boolean canValidateForm(HttpServletRequest request) {
		Boolean canValidate = false;

		User user = (User) request.getSession().getAttribute(Constant.USER);
		
        try {
            user = this.updateUser(request);
        } catch ( Exception e ) {
            this.setMistakes( Constant.NAME, e.getMessage() );
        }

        if ( mistakes.isEmpty() ) {
            result = "Succès de la modification";
            canValidate = true;
            HttpSession session = request.getSession();
            session.setAttribute( Constant.USER, user );
        } else {
            result = "Échec de la modification";
        }

        return canValidate;
	}
	
	public User updateUser(HttpServletRequest request) throws Exception {
		String name = getValueFromRequest( request, Constant.NAME );
		String surname = getValueFromRequest( request, Constant.SURNAME );
		String oldPassword = getValueFromRequest( request, Constant.PASSWORD );
		String newPassword = getValueFromRequest( request, Constant.PASSWORD_CONFIRMED );
		
		User user = (User) request.getSession().getAttribute(Constant.USER);
		String password = user.getPassword();
		UserService userService = new UserService();
		if(newPassword != null){
			if(!password.equals(userService.getHashPassword(oldPassword))){
				throw new Exception( "Mot de pass incorrect" );
			}
			password = userService.getHashPassword(newPassword);
		}
        User updateUser = new User(user.getId(), name, surname, password, user.getAdministrator());
		if ( name == null || surname == null) {
            throw new Exception( "Nom ou prénom Manquant" );
        }else{
            userService.updateUser(updateUser);
            user = updateUser;
        }	
		return user;
	}

}
