package fr.jcjTeam.theSocialNetwork.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.jcjTeam.theSocialNetwork.beans.Constant;
import fr.jcjTeam.theSocialNetwork.beans.Message;

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
		
		/*FAKE CODE ######## Just for TEST*/
		ArrayList<Message> messages = new ArrayList<>();
		request.setAttribute(Constant.MESSAGES, messages);
		/* ######## */
		
		Boolean isAuthorize = this.redirectionSystem(true, request, response);
		if(isAuthorize){
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
