<%@page import="java.util.ArrayList"%>
<%@page import="fr.jcjTeam.theSocialNetwork.beans.Constant"%>
<%@page import="fr.jcjTeam.theSocialNetwork.beans.Message"%>
<% ArrayList<Message> messages = (ArrayList<Message>) request.getAttribute(Constant.MESSAGES);
for ( Message message : messages){ %>
	<div class="message">
		<h3><% out.print(message.getTitle()); %></h3>
		<h6><% out.print(message.getAuthor().getName()+" "+message.getAuthor().getSurname()); %> <i><% out.print(message.getUpdateDate()); %></i></h6>
		<span class="separator"></span>
		<p><% out.print(message.getContent()); %></p>
	</div>
<% } %>