<%@page import="fr.jcjTeam.theSocialNetwork.beans.Status"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.jcjTeam.theSocialNetwork.beans.Constant"%>
<%@page import="fr.jcjTeam.theSocialNetwork.beans.Message"%>
<% ArrayList<Message> messages = (ArrayList<Message>) request.getAttribute(Constant.MESSAGES);
if(messages.size()>0){
	for ( Message message : messages){ %>
	<div class="message">
		<div class="col-md-1">
			<form method="POST" action="${pageContext.request.contextPath}/<% out.print(Constant.DELETEMESSAGE); %>">
				<button class="glyphicon glyphicon-trash deleteButton" type="submit" name="<% out.print(Constant.IDMESSAGE); %>" value="<% out.print(message.getId()); %>"></button>
			</form>
		</div>
		<div class="col-md-11">
			<div class="row">
				<form method="POST" action="${pageContext.request.contextPath}/<% out.print(Constant.UPDATEMESSAGE); %>">
					<div class="col-md-8">
						<textarea data-autoresize name="<% out.print(Constant.TITLE); %>" maxlength="<% out.print(Constant.TITLEMAXSIZE); %>" class="title"><% out.print(message.getTitle()); %></textarea>
					</div>
					<div class="col-md-4 btnLargeTop">
					  	<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						    <span class="btnText"><% out.print(message.getStatus()); %></span>
					    	<span class="caret"></span>
					  	</button>
						<ul class="dropdown-menu status" aria-labelledby="dropdownMenu4">
							<li <% if(message.getStatus()==Status.PUBLIC){ %>class="disabled"><input checked<% }else{ %>><input <% } %> type="radio" name="<% out.print(Constant.STATUS); %>" value="<% out.print(Status.PUBLIC.ordinal()); %>" id="public"><label for="public">Public</label></li>
							<li <% if(message.getStatus()==Status.PRIVATE){ %>class="disabled"><input checked<% }else{ %>><input <% } %> type="radio" name="<% out.print(Constant.STATUS); %>" value="<% out.print(Status.PRIVATE.ordinal()); %>" id="prive"><label for="prive">Privé</label></li>
							<li <% if(message.getStatus()==Status.ARCHIVED){ %>class="disabled"><input checked<% }else{ %>><input <% } %> type="radio" name="<% out.print(Constant.STATUS); %>" value="<% out.print(Status.ARCHIVED.ordinal()); %>" id="archive"><label for="archive">Archivé</label></li>
						</ul>
					</div>
					<div>
						<textarea data-autoresize name="<% out.print(Constant.CONTENT); %>" maxlength="<% out.print(Constant.CONTENMAXSIZE); %>" class="<% out.print(Constant.CONTENT); %>"><% out.print(message.getContent()); %></textarea>
					</div>
					<div class="submitSection hidden">
						<button type="submit" class="submit" name="<% out.print(Constant.IDMESSAGE); %>" value="<% out.print(message.getId()); %>"><span class="glyphicon glyphicon-floppy-disk"></span><span class="submitText">Enregistrer les modifications</span></button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div>
		<span class="separator"></span>
	</div>
<% }
}else{ %>
<h4>Vous n'avez ajouté aucun message</h4>
<% } %>