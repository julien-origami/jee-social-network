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
 * Servlet implementation class NewsServlet
 */
@WebServlet("/"+Constant.NEWS)
public class NewsServlet extends AuthenticatorServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsServlet() {
        super();
        this.path = Constant.WEBFILEPATH+Constant.NEWS+".jsp";
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*FAKE CODE ######## Just for TEST*/
		User user = (User) request.getSession().getAttribute(Constant.USER);
		ArrayList<Message> messages = new ArrayList<>();
		for(int i=0;i<10;i++){
			Message mes = new Message();
			mes.setAuthor(user);
			mes.setContent("Lorem Ipsum dolor sit amet Voici un objet bien pratique. ArrayList est un de ces objets qui n'ont pas de taille limite et qui, en plus, acceptent n'importe quel type de données, y compris null ! Nous pouvons mettre tout ce que nous voulons dans un ArrayList, voici un morceau de code qui le prouve :");
			mes.setId(new Long(i));
			mes.setStatus(Status.PUBLIC);
			mes.setTitle("Mon Tilte "+i);
			mes.setUpdateDate(new Timestamp(System.currentTimeMillis()));
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
		doGet(request, response);
	}

}
