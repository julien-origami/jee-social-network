package fr.jcjTeam.theSocialNetwork.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.jcjTeam.theSocialNetwork.beans.Constant;
import fr.jcjTeam.theSocialNetwork.beans.User;
import fr.jcjTeam.theSocialNetwork.forms.IForm;
import fr.jcjTeam.theSocialNetwork.forms.SigninForm;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/"+Constant.SIGNIN)
public class LoginServlet extends AuthenticatorServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        this.path = Constant.NEWS;
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
		SigninForm signinForm = new SigninForm();

        User user = signinForm.canConnectUser( request );

        HttpSession session = request.getSession();

        if ( signinForm.getMistakes().isEmpty() ) {
            session.setAttribute( Constant.USER, user );
        } else {
            session.setAttribute( Constant.USER, null );
        }

        request.setAttribute( Constant.FORM, (IForm)signinForm );
        request.setAttribute( Constant.USER, user);
		doGet(request, response);
	}

}
