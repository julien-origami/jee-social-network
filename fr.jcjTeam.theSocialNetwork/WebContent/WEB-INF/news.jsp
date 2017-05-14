<jsp:include page="/WEB-INF/header.jsp">
	<jsp:param name="title" value="Le fil d'actualité" />
</jsp:include>
<div class="news row">
	<div class="shadowEffect">
		<div class="container">
			<div class="newsSection col-md-8 col-md-offset-2">
				<jsp:include page="/WEB-INF/message.jsp" />
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/footer.jsp" />