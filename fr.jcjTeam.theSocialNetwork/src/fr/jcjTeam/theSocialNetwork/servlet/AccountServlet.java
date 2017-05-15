package fr.jcjTeam.theSocialNetwork.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.jcjTeam.theSocialNetwork.beans.Constant;
import fr.jcjTeam.theSocialNetwork.beans.Message;
import fr.jcjTeam.theSocialNetwork.beans.Status;
import fr.jcjTeam.theSocialNetwork.beans.User;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/"+Constant.ACCOUNT)
public class AccountServlet extends AuthenticatorServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        this.path = Constant.WEBFILEPATH+Constant.ACCOUNT+".jsp";
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*FAKE CODE ######## Just for TEST*/
		User user = (User) request.getSession().getAttribute(Constant.USER);
		ArrayList<Message> messages = new ArrayList<>();
		for(int i=0;i<10;i++){
			//Long id, String title, String content, User author, Timestamp creationDate, Timestamp updateDate, Status status
			String content = "Lorem Ipsum dolor sit amet Voici un objet bien pratique. ArrayList est un de ces objets qui n'ont pas de taille limite et qui, en plus, acceptent n'importe quel type de données, y compris null ! Nous pouvons mettre tout ce que nous voulons dans un ArrayList, voici un morceau de code qui le prouve :";
			Message mes = new Message(new Long(i), "Mon Tilte "+i, content, user, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), Status.PUBLIC);
			messages.add(mes);
		}
		request.setAttribute(Constant.MESSAGES, messages);
		/* ######## */
		
		this.redirectionSystem(false, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
