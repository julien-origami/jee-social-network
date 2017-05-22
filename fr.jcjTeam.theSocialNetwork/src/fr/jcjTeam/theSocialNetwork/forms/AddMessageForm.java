package fr.jcjTeam.theSocialNetwork.forms;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import fr.jcjTeam.theSocialNetwork.beans.Constant;
import fr.jcjTeam.theSocialNetwork.beans.Message;
import fr.jcjTeam.theSocialNetwork.beans.User;
import fr.jcjTeam.theSocialNetwork.service.MessageService;

public class AddMessageForm extends AForm{

	private static final String CHAMP_TITLE  = Constant.TITLE;
    private static final String CHAMP_CONTENT   = Constant.CONTENT;

	@Override
	public boolean canValidateForm(HttpServletRequest request) {
        Boolean canValidate = false;

        try {
            this.postMessage(request);
        } catch ( Exception e ) {
            this.setMistakes( CHAMP_TITLE, e.getMessage() );
        }

        if ( mistakes.isEmpty() ) {
            result = "Message ajouté.";
            canValidate = true;
        } else {
            result = "Échec de l'ajout du message.";
        }

        return canValidate;
	}
	
	public void postMessage(HttpServletRequest request) throws Exception {
		String title = getValueFromRequest( request, CHAMP_TITLE );
        String content = getValueFromRequest( request, CHAMP_CONTENT );
        User user = (User) request.getSession().getAttribute(Constant.USER);
        
		int titleLength = title.length();
		int contentLength = content.length();
		if ( titleLength > Constant.TITLEMAXSIZE || contentLength > Constant.CONTENMAXSIZE ) {
            throw new Exception( "Titre ou contenu trop long" );
        }else{
        	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        	Message message = new Message(title, content, user, timestamp, Constant.DEFAULTMESSAGESTATUS);
        	MessageService messageService = new MessageService();
            messageService.addMessage(message);
        }	
	}

}
