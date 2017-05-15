<%@page import="fr.jcjTeam.theSocialNetwork.beans.User"%>
<%@page import="fr.jcjTeam.theSocialNetwork.beans.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><%= request.getParameter("title")%></title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="./ressources/tsnTheme/css/style.css" rel="stylesheet" >
	<script src="./ressources/tsnTheme/js/script.js" ></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div>
			<header>
				<div class="row">
					<nav class="navbar navbar-default">
						<div class="container">
								
						  	<div class="navbar-header">
						    	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								    <span class="sr-only">Toggle navigation</span>
								    <span class="icon-bar"></span>
								    <span class="icon-bar"></span>
						      		<span class="icon-bar"></span>
						    	</button>
						    	<a class="navbar-brand" href="${pageContext.request.contextPath}/<% out.print(Constant.NEWS); %>">
						    		<span class="glyphicon glyphicon-home"></span>
						    	</a>
						  	</div>
						
						  	<% User user = (User) request.getSession().getAttribute(Constant.USER); 
							if(user != null) { %>
							  	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							    	<ul class="nav navbar-nav navbar-right">
							      		<li class="dropdown">
							        		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%= user.getName() %><span class="caret"></span></a>
							        		<ul class="dropdown-menu">
							          			<li><a href="${pageContext.request.contextPath}/<% out.print(Constant.SIGNOUT); %>">Logout</a></li>
							          			<% if(user.getAdministrator()){ %>
							          			<li><a href="#">Panel Administrateur</a></li>
							          			<% } %>
							          			<li><a href="${pageContext.request.contextPath}/<% out.print(Constant.ACCOUNT); %>">Mon compte</a></li>
							        		</ul>
							    		</li>
							    	</ul>
								</div>
							<% } %>
						</div>
					</nav>
				</div>
			</header>
		</div>