<%@page import="java.util.ArrayList"%>
<%@page import="fr.jcjTeam.theSocialNetwork.beans.Constant"%>
<%@page import="fr.jcjTeam.theSocialNetwork.beans.Message"%>
<% ArrayList<Message> messages = (ArrayList<Message>) request.getAttribute(Constant.MESSAGES);
if(messages.size()>0){
	for ( Message message : messages){ %>
	<div class="message">
		<form method="POST" action="${pageContext.request.contextPath}/<% out.print(Constant.UPDATEMESSAGE); %>">
			<div class="col-md-8">
				<textarea data-autoresize name="title" class="title"><% out.print(message.getTitle()); %></textarea>
			</div>
			<div class="col-md-4 btnLargeTop">
			  	<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				    Public
			    	<span class="caret"></span>
			  	</button>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenu4">
					<li><a href="#">Public</a></li>
					<li class="disabled"><a href="#">Privé</a></li>
					<li><a href="#">Archivé</a></li>
				</ul>
			</div>
			<div>
				<textarea data-autoresize name="content" class="content"><% out.print(message.getContent()); %></textarea>
			</div>
			<div class="submitSection hidden">
				<button type="submit" class="submit"><span class="glyphicon glyphicon-floppy-disk"></span><span class="submitText">Enregistrer les modifications</span></button>
			</div>
		</form>
	</div>
	<div>
		<span class="separator"></span>
	</div>
<% }
}else{ %>
<h4>Vous n'avez ajouté aucun message</h4>
<% } %>