<jsp:include page="/header.jsp">
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
									<li class="active"><a data-toggle="tab" href="#signin">Sign-In</a></li>
									<li><a data-toggle="tab" href="#signup">Sign-Up</a></li>
								</ul>
								
								<div class="tab-content">
									<div id="signin" class="tab-pane fade in active">
										<form method="post" action="${pageContext.request.contextPath}/signin">
									    	<h3>Connectez-vous</h3>
									    	<p>Entrez votre Email/Mot de passe pour accéder à votre compte.</p>
									    	<div class="input-group">
  												<span class="input-group-addon" id="basic-addon1">@</span>
  												<input type="email" class="form-control" placeholder="Email" aria-describedby="basic-addon1">
											</div>
											<div class="input-group">
  												<span class="glyphicon glyphicon-lock input-group-addon" id="basic-addon1"></span>
  												<input type="password" class="form-control" placeholder="Password" aria-describedby="basic-addon1">
											</div>
											<button type="submit" class="btn btn-default">Connection</button>
										</form>
								  	</div>
								  	<div id="signup" class="tab-pane fade">
								  		<form method="post" action="${pageContext.request.contextPath}/signup">
									    	<h3>Inscrivez-vous</h3>
									    	<p>Créez votre compte et rejoignez notre communauté, échangez des messages publics et privés.</p>
									    	<div class="input-group">
  												<span class="glyphicon glyphicon-user input-group-addon" id="basic-addon1"></span>
  												<input type="text" class="form-control" placeholder=Nom aria-describedby="basic-addon1">
											</div>
											<div class="input-group">
  												<span class="glyphicon glyphicon-user input-group-addon" id="basic-addon1"></span>
  												<input type="text" class="form-control" placeholder="Prenom" aria-describedby="basic-addon1">
											</div>
											<div class="input-group">
  												<span class="input-group-addon" id="basic-addon1">@</span>
  												<input type="email" class="form-control" placeholder=Email aria-describedby="basic-addon1">
											</div>
											<div class="input-group">
  												<span class="glyphicon glyphicon-lock input-group-addon" id="basic-addon1"></span>
  												<input type="text" class="form-control" placeholder="Password" aria-describedby="basic-addon1">
											</div>
											<div class="input-group">
  												<span class="glyphicon glyphicon-lock input-group-addon" id="basic-addon1"></span>
  												<input type="password" class="form-control" placeholder="Confirmation de Password" aria-describedby="basic-addon1">
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

<jsp:include page="/footer.jsp" />