<%@page import="java.util.ArrayList"%>
<%@page import="fr.jcjTeam.theSocialNetwork.beans.Message"%>
<%@page import="fr.jcjTeam.theSocialNetwork.beans.User"%>
<%@page import="fr.jcjTeam.theSocialNetwork.beans.Constant"%>
<jsp:include page="/WEB-INF/header.jsp">
	<jsp:param name="title" value="Mon compte" />
</jsp:include>
<% User user = (User) request.getSession().getAttribute(Constant.USER); %>
<div class="account row">
	<div class="shadowEffect">
		<div class="container">
			<div class="accountSection col-md-12">
				<div class="row">
					<div class="whiteBG">
						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" href="#signin">Les messages</a></li>
							<li><a data-toggle="tab" href="#signup">Les utilisateurs</a></li>
						</ul>
						
						<div class="tab-content">
							<div id="signin" class="tab-pane fade in active">
						    	<h3>Modérez les Messages</h3>
						    	<div class="row">
							    	<div class="col-md-8">
						    			<p>Supprimez des message</p>
								    	<% ArrayList<Message> messages = (ArrayList<Message>) request.getAttribute(Constant.MESSAGES);
										if(messages.size()>0){
											for ( Message message : messages){ %>
											<div class="message">
												<div class="col-md-1">
													<form method="POST" action="${pageContext.request.contextPath}/<% out.print(Constant.DELETEMESSAGEADMIN); %>">
														<button class="glyphicon glyphicon-trash deleteButton" type="submit" name="<% out.print(Constant.IDMESSAGE); %>" value="<% out.print(message.getId()); %>"></button>
													</form>
												</div>
												<div class="col-md-11">
													<div class="message">
														<h4><% out.print(message.getTitle()); %></h4>
														<h6><% out.print(message.getAuthor().getName()+" "+message.getAuthor().getSurname()); %> <i><% out.print(message.getUpdateDate()); %></i></h6>
														<span class="separator"></span>
														<p><% out.print(message.getContent()); %></p>
													</div>
												</div>
											</div>
											<div>
												<span class="separator"></span>
											</div>
										<% }
										}%>
							    	</div>
							    	<div class="col-md-4">
									    <p>Ajoutez un nouveau message public en tant qu'administrateur</p>
									    <form method="POST" action="${pageContext.request.contextPath}/<% out.print(Constant.ADDMESSAGE); %>">
											<textarea data-autoresize class="border" name="<% out.print(Constant.TITLE); %>" maxlength="<% out.print(Constant.TITLEMAXSIZE); %>" placeholder="Entrez votre titre (Maximum 100 charactère)"></textarea>
											<textarea data-autoresize name="<% out.print(Constant.CONTENT); %>" class="border content" maxlength="<% out.print(Constant.CONTENMAXSIZE); %>" placeholder="Ecrivez votre message (Maximum 255 charactères)"></textarea>
											<button class="submit" type="submit"><span class="glyphicon glyphicon-share-alt"></span><span class="submitText">Partager</span></button>
										</form>
							    	</div>
						    	</div>
						  	</div>
						  	<div id="signup" class="tab-pane fade">
						  		<h3>Modérez les Utilisateurs</h3>
						    	<div class="row">
							    	<div class="col-md-8">
						    			<p>Supprimez des Utilisateurs</p>
								    	<% ArrayList<User> users = (ArrayList<User>) request.getAttribute(Constant.USERS);
										if(messages.size()>0){
											for ( User newUser : users){ %>
											<div class="message">
												<div class="col-md-1">
													<form method="POST" action="${pageContext.request.contextPath}/<% out.print(Constant.DELETEUSERADMIN); %>">
														<button class="glyphicon glyphicon-trash deleteButton" type="submit" name="<% out.print(Constant.IDUSER); %>" value="<% out.print(newUser.getId()); %>"></button>
													</form>
												</div>
												<div class="col-md-11">
													<div class="message">
														<h4><% out.print(newUser.getName()+" "+newUser.getSurname()); %></h4>
														<h6><% out.print(newUser.getId()); %></h6>
													</div>
												</div>
											</div>
											<div>
												<span class="separator"></span>
											</div>
										<% }
										}%>
							    	</div>
							    	<div class="col-md-4">
									    <p>Ajoutez un nouvel administrateur</p>
								    	<form method="post" action="${pageContext.request.contextPath}/<% out.print(Constant.SIGNUP); %>">
									    	<div class="input-group">
  												<span required="required" class="glyphicon glyphicon-user input-group-addon" id="basic-addon1"></span>
  												<input required="required" type="text" class="form-control" placeholder="Nom" name="<% out.print(Constant.SURNAME); %>" aria-describedby="basic-addon1">
											</div>
											<div class="input-group">
  												<span required="required" class="glyphicon glyphicon-user input-group-addon" id="basic-addon1"></span>
  												<input required="required" type="text" name="<% out.print(Constant.NAME); %>" class="form-control" placeholder="Prenom" aria-describedby="basic-addon1">
											</div>
											<div class="input-group">
  												<span required="required" class="input-group-addon" id="basic-addon1">@</span>
  												<input required="required" type="email" class="form-control" name="<% out.print(Constant.EMAIL); %>" placeholder=Email aria-describedby="basic-addon1">
											</div>
											<div class="input-group">
  												<span required="required" class="glyphicon glyphicon-lock input-group-addon" id="basic-addon1"></span>
  												<input required="required" type="password" class="form-control" name="<% out.print(Constant.PASSWORD); %>" placeholder="Password" aria-describedby="basic-addon1">
											</div>
											<div class="input-group">
  												<span required="required" class="glyphicon glyphicon-lock input-group-addon" id="basic-addon1"></span>
  												<input required="required" type="password" class="form-control" name="<% out.print(Constant.PASSWORD_CONFIRMED); %>" placeholder="Confirmation de Password" aria-describedby="basic-addon1">
											</div>
											<button type="submit" class="btn btn-default">Inscription</button>
										</form>
							    	</div>
						    	</div>
						  	</div>
						</div>	
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />