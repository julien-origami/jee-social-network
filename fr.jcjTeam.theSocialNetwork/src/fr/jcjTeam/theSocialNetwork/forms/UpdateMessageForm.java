package fr.jcjTeam.theSocialNetwork.forms;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import fr.jcjTeam.theSocialNetwork.beans.Constant;
import fr.jcjTeam.theSocialNetwork.beans.Message;
import fr.jcjTeam.theSocialNetwork.beans.Status;
import fr.jcjTeam.theSocialNetwork.beans.User;
import fr.jcjTeam.theSocialNetwork.service.MessageService;

public class UpdateMessageForm extends AForm {
	
	private static final String CHAMP_TITLE  = Constant.TITLE;
    private static final String CHAMP_CONTENT   = Constant.CONTENT;
    private static final String CHAMP_STATUS   = Constant.STATUS;
    private static final String CHAMP_ID   = Constant.IDMESSAGE;

	public boolean canValidateForm(HttpServletRequest request) {
        Boolean canValidate = false;

        try {
            this.updateMessage(request);
        } catch ( Exception e ) {
            this.setMistakes( CHAMP_TITLE, e.getMessage() );
        }

        if ( mistakes.isEmpty() ) {
            result = "Succès de la modification";
            canValidate = true;
        } else {
            result = "Échec de la modification";
        }

        return canValidate;
	}
	
	public void updateMessage(HttpServletRequest request) throws Exception {
		String title = getValueFromRequest( request, CHAMP_TITLE );
		Long id = Long.decode(getValueFromRequest( request, CHAMP_ID ));
		Status status = Status.values()[Integer.parseInt(getValueFromRequest( request, CHAMP_STATUS ))];
        String content = getValueFromRequest( request, CHAMP_CONTENT );
        User user = (User) request.getSession().getAttribute(Constant.USER);
        
		int titleLength = title.length();
		int contentLength = content.length();
		if ( titleLength > Constant.TITLEMAXSIZE || contentLength > Constant.CONTENMAXSIZE ) {
            throw new Exception( "Titre ou contenu trop long" );
        }else{
        	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        	Message message = new Message(id, title, content, user, timestamp, timestamp, status);
        	MessageService messageService = new MessageService();
            messageService.updateMessage(message);
        }	
	}

}
