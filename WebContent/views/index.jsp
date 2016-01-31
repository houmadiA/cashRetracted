<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="/assets/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/style.css" />
<title>Accueil</title>

<style type="text/css">
<%@ include file="/assets/css/bootstrap.min.css"%>
</style>

</head>
<body class="container">

	<c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
		<div class="header clearfix">
			<div class="jumbotron"><h2>Espace Administrateur</h2><p>la régularisation des retraits GAB non servis pour le motif «cash-retracted»</p></div>
	        <nav>
	          <ul class="nav nav-pills pull-right">
	            <li ><a href="/cashRetractedProject/admin/clients">Liste des transactions</a></li>
	            <li ><a href="/cashRetractedProject/admin/clients">Liste des clients</a></li>
	            <li ><a href="/cashRetractedProject/j_spring_security_logout">Se déconnecter</a></li>
	          </ul>
	        </nav>
     	</div>
     </c:if>
     <c:if test="${pageContext.request.isUserInRole('ROLE_USER')}">
		<div class="header clearfix">
			<div class="jumbotron"><h2>Espace Client : Bonjour ${pageContext.request.userPrincipal.name}</h2><p>la régularisation des retraits GAB non servis pour le motif «cash-retracted»</p></div>
	        <nav>
	          <ul class="nav nav-pills pull-right">
	            <li ><a href="/cashRetractedProject/user/clients">Liste des transactions</a></li>
	            <li ><a href="/cashRetractedProject/j_spring_security_logout">Se déconnecter</a></li>
	          </ul>
	        </nav>
     	</div>
     </c:if>
	<c:if test="${pageContext.request.userPrincipal.name == null}">
	<div class="panel panel-info" style="margin-left: 22%;margin-right: 22%;margin-top: 15%;">
		<div class="panel-heading">
			<h3 class="panel-title">Formulaire d'authentification</h3>
		</div>
		<div class="panel-body">
			<div class="bg-danger" style="padding: 2px">
				<c:if test="${not empty msg_erreur}">
					${msg_erreur}
				</c:if>
				
				<c:if test="${not empty msg_logout}">
					${msg_logout}
				</c:if>
			</div>
			<br>
			<form class="form-horizontal" action="j_spring_security_check" method="post">
				<div class="form-group">
					<label for="username" class="col-sm-3 control-label">Nom d'utilsateur</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="username" id="username"
							placeholder="Nom d'utilsateur">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-3 control-label">Mot de passe</label>
					<div class="col-sm-9">
						<input type="password" class="form-control" name="password" id="password"
							placeholder="Mot de passe">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-9">
						<button type="submit" class="btn btn-default">Se connecter</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	</c:if>
</body>
</html>