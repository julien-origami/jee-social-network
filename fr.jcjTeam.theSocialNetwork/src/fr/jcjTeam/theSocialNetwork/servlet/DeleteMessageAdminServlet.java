package fr.jcjTeam.theSocialNetwork.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import fr.jcjTeam.theSocialNetwork.beans.Constant;

/**
 * Servlet implementation class DeleteMessageAdmin
 */
@WebServlet("/"+Constant.DELETEMESSAGEADMIN)
public class DeleteMessageAdminServlet extends DeleteMessageServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMessageAdminServlet() {
        super();
        this.path = Constant.ADMIN;
    }
}
