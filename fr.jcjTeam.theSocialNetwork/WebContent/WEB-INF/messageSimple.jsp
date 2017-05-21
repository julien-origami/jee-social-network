<%@page import="fr.jcjTeam.theSocialNetwork.beans.Constant"%>
<%@page import="fr.jcjTeam.theSocialNetwork.beans.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fr.jcjTeam.theSocialNetwork.beans.Constant"%>
<jsp:include page="/WEB-INF/header.jsp">
	<jsp:param name="title" value="Le fil d'actualité" />
</jsp:include>
<div class="news row">
	<div class="shadowEffect">
		<div class="container">
			<div class="newsSection col-md-8 col-md-offset-2">
				<% Message message = (Message) request.getAttribute(Constant.MESSAGES); 
				if(message != null){ %>
					<div class="message">
						<h3><% out.print(message.getTitle()); %></h3>
						<h6><% out.print(message.getAuthor().getName()+" "+message.getAuthor().getSurname()); %> <i><% out.print(message.getUpdateDate()); %></i></h6>
						<span class="separator"></span>
						<p><% out.print(message.getContent()); %></p>
					</div>
				<% }else{ %>
				<h2 style="color:white;">Aucun message ne correspond à cet identifiant</h2>
				<% } %>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />