<%@page import="fr.jcjTeam.theSocialNetwork.beans.Constant"%>
<jsp:include page="/WEB-INF/header.jsp">
	<jsp:param name="title" value="The Social Network - Bienvenue sur la super communauté" />
</jsp:include>
	<div class="mainSection">
		<section class="row">
			<div class="shadowEffect">
				<div class="col-md-6 hidden-sm hidden-xs mainTitle">
						<h1>The Social<br>Network</h1>
				</div>
				<div class="col-md-6 col-sm-12 col-xs-12 logArea">
					<div class="">
						<div>
							<div>
								<ul class="nav nav-tabs">
									<li class="active"><a data-toggle="tab" href="#<% out.print(Constant.SIGNIN); %>">Sign-In</a></li>
									<li><a data-toggle="tab" href="#<% out.print(Constant.SIGNUP); %>">Sign-Up</a></li>
								</ul>
								
								<div class="tab-content">
									<div id="<% out.print(Constant.SIGNIN); %>" class="tab-pane fade in active">
										<form method="post" action="${pageContext.request.contextPath}/<% out.print(Constant.SIGNIN); %>">
									    	<h3>Connectez-vous</h3>
									    	<p>Entrez votre Email/Mot de passe pour accéder à votre compte.</p>
									    	<div class="input-group">
  												<span required="required" class="input-group-addon" id="basic-addon1">@</span>
  												<input required="required" type="email" name="<% out.print(Constant.EMAIL); %>" class="form-control" placeholder="Email" aria-describedby="basic-addon1">
											</div>
											<div class="input-group">
  												<span required="required" class="glyphicon glyphicon-lock input-group-addon" id="basic-addon1"></span>
  												<input required="required" type="password" class="form-control" name="<% out.print(Constant.PASSWORD); %>" placeholder="Password" aria-describedby="basic-addon1">
											</div>
											<button type="submit" class="btn btn-default">Connection</button>
										</form>
								  	</div>
								  	<div id="<% out.print(Constant.SIGNUP); %>" class="tab-pane fade">
								  		<form method="post" action="${pageContext.request.contextPath}/<% out.print(Constant.SIGNUP); %>">
									    	<h3>Inscrivez-vous</h3>
									    	<p>Créez votre compte et rejoignez notre communauté, échangez des messages publics et privés.</p>
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
		</section>
	</div>

<jsp:include page="/WEB-INF/footer.jsp" />