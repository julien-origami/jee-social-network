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
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher(Constant.WEBFILEPATH+Constant.NEWS+".jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter(Constant.EMAIL));
		System.out.println(request.getParameter(Constant.PASSWORD));
		SigninForm signinForm = new SigninForm();

        /* Traitement de la requête et récupération du bean en résultant */
        User user = signinForm.canConnectUser( request );

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if ( signinForm.getMistakes().isEmpty() ) {
            session.setAttribute( Constant.USER, user );
        } else {
            session.setAttribute( Constant.USER, null );
        }

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( Constant.FORM, (IForm)signinForm );
        request.setAttribute( Constant.USER, user);
		//doGet(request, response);
		request.getRequestDispatcher("/"+Constant.NEWS).forward(request, response);
	}

}
