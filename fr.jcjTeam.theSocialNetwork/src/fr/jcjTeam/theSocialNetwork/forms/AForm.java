package fr.jcjTeam.theSocialNetwork.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public abstract class AForm implements IForm{
	
	protected String result;
	protected Map<String, String> mistakes = new HashMap<String, String>();

    public String getResult() {
        return result;
    }

    public Map<String, String> getMistakes() {
        return mistakes;
    }
	
	protected void setMistakes( String champ, String message ) {
        mistakes.put( champ, message );
    }

    
    public String getValueFromRequest( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
