package fr.jcjTeam.theSocialNetwork.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.jcjTeam.theSocialNetwork.beans.Constant;
import fr.jcjTeam.theSocialNetwork.beans.User;
import fr.jcjTeam.theSocialNetwork.service.UserService;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/"+Constant.DELETEUSERADMIN)
public class DeleteUserServlet extends AuthenticatorServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        this.path = Constant.ADMIN;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.redirectionSystem(false, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = this.getConnectedUser(request);
		if(user!=null){
			if(user.getAdministrator()){
				UserService userService = new UserService();
				String idUser = request.getParameter(Constant.IDUSER);
				userService.deleteUser(idUser);
			}
		}
		doGet(request, response);
	}

}
