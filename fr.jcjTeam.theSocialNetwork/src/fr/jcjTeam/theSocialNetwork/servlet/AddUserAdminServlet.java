package fr.jcjTeam.theSocialNetwork.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.jcjTeam.theSocialNetwork.beans.Constant;
import fr.jcjTeam.theSocialNetwork.forms.IForm;
import fr.jcjTeam.theSocialNetwork.forms.SignupForm;

/**
 * Servlet implementation class AddUserAdminServlet
 */
@WebServlet("/"+Constant.ADDUSERADMIN)
public class AddUserAdminServlet extends AuthenticatorServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserAdminServlet() {
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
		SignupForm signupForm = new SignupForm(true);

        signupForm.canCreateUser( request );

        request.setAttribute( Constant.FORM, (IForm)signupForm );
		
		doGet(request, response);
	}

}
