package fr.jcjTeam.theSocialNetwork.forms;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface IForm {
	public String getResult();
    public Map<String, String> getMistakes();
    public String getValueFromRequest( HttpServletRequest request, String nomChamp );
    public boolean canValidateForm(HttpServletRequest request);
}
