package fr.jcjTeam.theSocialNetwork.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.jcjTeam.theSocialNetwork.beans.Constant;
import fr.jcjTeam.theSocialNetwork.forms.UpdateMessageForm;

/**
 * Servlet implementation class UpdateMessage
 */
@WebServlet("/"+Constant.UPDATEMESSAGE)
public class UpdateMessageServlet extends AuthenticatorServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see AuthenticatorServlet#AuthenticatorServlet()
     */
    public UpdateMessageServlet() {
        super();
        this.path = Constant.ACCOUNT;
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
		UpdateMessageForm updateMessageForm = new UpdateMessageForm();
		updateMessageForm.canValidateForm(request);
		
		doGet(request, response);
	}

}
