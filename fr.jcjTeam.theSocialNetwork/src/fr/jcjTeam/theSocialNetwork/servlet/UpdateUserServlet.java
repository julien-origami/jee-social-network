package fr.jcjTeam.theSocialNetwork.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.jcjTeam.theSocialNetwork.beans.Constant;
import fr.jcjTeam.theSocialNetwork.forms.IForm;
import fr.jcjTeam.theSocialNetwork.forms.UpdateUserForm;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/"+Constant.UPDATEUSER)
public class UpdateUserServlet extends AuthenticatorServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see AuthenticatorServlet#AuthenticatorServlet()
     */
    public UpdateUserServlet() {
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
		UpdateUserForm updateUserForm = new UpdateUserForm();
		updateUserForm.canValidateForm(request);
		
		request.setAttribute( Constant.FORM, (IForm)updateUserForm );
		
		doGet(request, response);
	}

}
