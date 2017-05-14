package fr.jcjTeam.theSocialNetwork.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.jcjTeam.theSocialNetwork.beans.Constant;
import fr.jcjTeam.theSocialNetwork.beans.User;
import fr.jcjTeam.theSocialNetwork.service.ConnectionService;
import fr.jcjTeam.theSocialNetwork.service.IConnectionService;

/**
 * Servlet implementation class AuthenticatorServlet
 */
public abstract class AuthenticatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String path;
    
    public AuthenticatorServlet() {
        super();
    }

	protected void redirectionSystem(Boolean autorisationRequired, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		IConnectionService connectionService = (IConnectionService) new ConnectionService();
		String resPath = connectionService.needToBeRedirected(path, autorisationRequired, (User)request.getSession().getAttribute(Constant.USER));
		request.getRequestDispatcher(resPath).forward(request, response);
	}
}
