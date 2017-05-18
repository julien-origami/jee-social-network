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
						    	<div class="col-md-6">
						    		<form method="post" action="/fr.jcjTeam.theSocialNetwork/signin">
						    			<p>Supprimez des message</p>
								    	<div class="input-group">
													<span required="required" class="input-group-addon" id="basic-addon1">@</span>
													<input required="required" type="email" name="email" class="form-control" placeholder="Email" aria-describedby="basic-addon1">
										</div>
										<div class="input-group">
													<span required="required" class="glyphicon glyphicon-lock input-group-addon" id="basic-addon1"></span>
													<input required="required" type="password" class="form-control" name="password" placeholder="Password" aria-describedby="basic-addon1">
										</div>
										<button type="submit" class="btn btn-default">Connection</button>
									</form>
						    	</div>
						    	<div class="col-md-6">
						    		<form method="post" action="/fr.jcjTeam.theSocialNetwork/signup">
								    	<p>Ajoutez un nouveau message public en temps qu'administrateur</p>
								    	<div class="input-group">
													<span required="required" class="glyphicon glyphicon-user input-group-addon" id="basic-addon1"></span>
													<input required="required" type="text" class="form-control" placeholder="Nom" name="surname" aria-describedby="basic-addon1">
										</div>
										<div class="input-group">
													<span required="required" class="glyphicon glyphicon-user input-group-addon" id="basic-addon1"></span>
													<input required="required" type="text" name="name" class="form-control" placeholder="Prenom" aria-describedby="basic-addon1">
										</div>
										<div class="input-group">
													<span required="required" class="input-group-addon" id="basic-addon1">@</span>
													<input required="required" type="email" class="form-control" name="email" placeholder="Email" aria-describedby="basic-addon1">
										</div>
										<div class="input-group">
													<span required="required" class="glyphicon glyphicon-lock input-group-addon" id="basic-addon1"></span>
													<input required="required" type="password" class="form-control" name="password" placeholder="Password" aria-describedby="basic-addon1">
										</div>
										<div class="input-group">
													<span required="required" class="glyphicon glyphicon-lock input-group-addon" id="basic-addon1"></span>
													<input required="required" type="password" class="form-control" name="passwordConfirmed" placeholder="Confirmation de Password" aria-describedby="basic-addon1">
										</div>
										<button type="submit" class="btn btn-default">Inscription</button>
									</form>
						    	</div>
						    	</div>
						  	</div>
						  	<div id="signup" class="tab-pane fade">
						  		<form method="post" action="/fr.jcjTeam.theSocialNetwork/signup">
							    	<h3>Inscrivez-vous</h3>
							    	<p>Créez votre compte et rejoignez notre communauté, échangez des messages publics et privés.</p>
							    	<div class="input-group">
												<span required="required" class="glyphicon glyphicon-user input-group-addon" id="basic-addon1"></span>
												<input required="required" type="text" class="form-control" placeholder="Nom" name="surname" aria-describedby="basic-addon1">
									</div>
									<div class="input-group">
												<span required="required" class="glyphicon glyphicon-user input-group-addon" id="basic-addon1"></span>
												<input required="required" type="text" name="name" class="form-control" placeholder="Prenom" aria-describedby="basic-addon1">
									</div>
									<div class="input-group">
												<span required="required" class="input-group-addon" id="basic-addon1">@</span>
												<input required="required" type="email" class="form-control" name="email" placeholder="Email" aria-describedby="basic-addon1">
									</div>
									<div class="input-group">
												<span required="required" class="glyphicon glyphicon-lock input-group-addon" id="basic-addon1"></span>
												<input required="required" type="password" class="form-control" name="password" placeholder="Password" aria-describedby="basic-addon1">
									</div>
									<div class="input-group">
												<span required="required" class="glyphicon glyphicon-lock input-group-addon" id="basic-addon1"></span>
												<input required="required" type="password" class="form-control" name="passwordConfirmed" placeholder="Confirmation de Password" aria-describedby="basic-addon1">
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
<jsp:include page="/WEB-INF/footer.jsp" />