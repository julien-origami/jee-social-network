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
					<div class="mymessages col-md-8">
						<div>
							<h2>Mes messages</h2>
							<jsp:include page="/WEB-INF/messageUpdate.jsp" />
						</div>
					</div>
					<div class="col-md-4 myaccount">
						<div>
							<h2>Mon compte</h2>
							<div class="accountInformation">
								<form method="POST" action="${pageContext.request.contextPath}/<% out.print(Constant.UPDATEUSER); %>">
									<div>
										<label>Pr�nom</label>
										<input type="text" value="<% out.print(user.getName()); %>" name="name" id="name"/>
									</div>
									<div>
										<label>Nom</label>
										<input type="text" value="<% out.print(user.getSurname()); %>" name="surname" id="surname"/>
									</div>
									<div>
										<label>Mot de passe</label>
										<input type="password" name="oldPassword" id="oldPassword" placeholder="Saisissez votre mot de passe"/>
									</div>
									<div>
										<label>Nouveau mot de passe</label>
										<input type="password" name="newPassword" id="newPassword" placeholder="Saisissez votre nouveau mot de passe"/>
									</div>
									<div>
										<input type="submit" class="submit" value="Enregistrer les modifications"/>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	jQuery.each(jQuery('textarea[data-autoresize]'), function() {
	    var offset = this.offsetHeight - this.clientHeight;
	    var resizeTextarea = function(el) {
	        jQuery(el).css('height', 'auto').css('height', el.scrollHeight + offset);
	    };
	    jQuery(this).removeAttr('data-autoresize');
	    resizeTextarea(this);
	    jQuery(this).on('keyup input', function() { 
	    	resizeTextarea(this); 
	    }).removeAttr('data-autoresize');
	});
	$('textarea').keyup(function(){
		$(this).parent().parent().find('div.hidden').removeClass('hidden');
	});
	$('.btnLargeTop ul li a').click(function(){
		$(this).parent().parent().parent().parent().find('div.hidden').removeClass('hidden');
	});
</script>
<jsp:include page="/WEB-INF/footer.jsp" />