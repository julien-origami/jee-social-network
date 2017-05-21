package fr.jcjTeam.theSocialNetwork.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.jcjTeam.theSocialNetwork.beans.Constant;
import fr.jcjTeam.theSocialNetwork.beans.User;
import fr.jcjTeam.theSocialNetwork.service.MessageService;
import fr.jcjTeam.theSocialNetwork.service.UserService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/"+Constant.ADMIN)
public class AdminServlet extends AuthenticatorServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        this.path = Constant.WEBFILEPATH+Constant.ADMIN+".jsp";
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = this.getConnectedUser(request);
		if(user!=null){
			if(user.getAdministrator()){
				MessageService messageService = new MessageService();
				UserService userService = new UserService();
				request.setAttribute(Constant.MESSAGES, messageService.getAllMessagesForAdmin());
				request.setAttribute(Constant.USERS, userService.getListOfUsers());
			}
		}
		this.redirectionSystem(true, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
