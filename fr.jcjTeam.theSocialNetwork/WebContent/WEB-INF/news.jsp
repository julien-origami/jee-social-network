<jsp:include page="/WEB-INF/header.jsp">
	<jsp:param name="title" value="Le fil d'actualité" />
</jsp:include>
<div class="news row">
	<div class="shadowEffect">
		<div class="container">
			<div class="newsSection col-md-8 col-md-offset-2">
				<div class="message formMessage">
					<h3>Postez un nouveau message</h3>
					<form method="POST" action="#">
						<textarea data-autoresize name="title" class="border" maxlength="100" placeholder="Entrez votre titre (Maximum 100 charactère)"></textarea>
						<textarea data-autoresize name="content" class="border content" placeholder="Ecrivez votre message"></textarea>
						<button class="submit" type="submit"><span class="glyphicon glyphicon-share-alt"></span><span class="submitText">Partager</span></button>
					</form>
				</div>
				<jsp:include page="/WEB-INF/message.jsp" />
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />