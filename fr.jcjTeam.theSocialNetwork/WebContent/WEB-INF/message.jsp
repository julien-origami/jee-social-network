<%@page import="java.util.ArrayList"%>
<%@page import="fr.jcjTeam.theSocialNetwork.beans.Constant"%>
<%@page import="fr.jcjTeam.theSocialNetwork.beans.Message"%>
<% ArrayList<Message> messages = (ArrayList<Message>) request.getAttribute(Constant.MESSAGES);
for ( Message message : messages){ %>
	<div class="message">
		<h1><% out.print(message.getTitle()); %></h1>
		<h6><% out.print(message.getAuthor()); %><i><% out.print(message.getUpdateDate()); %></i></h6>
		<p><% out.print(message.getContent()); %></p>
	</div>
<% } %>