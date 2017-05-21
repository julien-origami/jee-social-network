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
							<h5>Modifiez simplement vos précédents messages en cliquant directement sur les textes.</h5>
							<jsp:include page="/WEB-INF/messageUpdate.jsp" />
						</div>
					</div>
					<div class="col-md-4 myaccount">
						<div>
							<h2>Mon compte</h2>
							<div class="accountInformation">
								<form method="POST" action="${pageContext.request.contextPath}/<% out.print(Constant.UPDATEUSER); %>">
									<div>
										<label for="name">Prénom</label>
										<input type="text" value="<% out.print(user.getName()); %>" name="<% out.print(Constant.NAME); %>" id="name"/>
									</div>
									<div>
										<label for="surname">Nom</label>
										<input type="text" value="<% out.print(user.getSurname()); %>" name="<% out.print(Constant.SURNAME); %>" id="surname"/>
									</div>
									<div>
										<label for="oldPassword">Mot de passe</label>
										<input type="password" name="<% out.print(Constant.PASSWORD); %>" id="oldPassword" placeholder="Saisissez votre mot de passe"/>
									</div>
									<div>
										<label for="newPassword">Nouveau mot de passe</label>
										<input type="password" name="<% out.print(Constant.PASSWORD_CONFIRMED); %>" id="newPassword" placeholder="Saisissez votre nouveau mot de passe"/>
									</div>
									<div class="hidden">
										<button type="submit" class="submit"><span class="glyphicon glyphicon-floppy-disk"></span><span class="submitText">Enregistrer les modifications</span></button>
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
	$('input').keyup(function(){
		$(this).parent().parent().find('div.hidden').removeClass('hidden');
	});
	$('.btnLargeTop ul li label').click(function(){
		$(this).parent().parent().parent().parent().find('div.hidden').removeClass('hidden');
		$(this).parent().parent().find('li').removeClass('disabled');
		$(this).parent().addClass('disabled');
		$(this).parent().parent().parent().parent().find('span.btnText').text($(this).text());
	});
</script>
<jsp:include page="/WEB-INF/footer.jsp" />