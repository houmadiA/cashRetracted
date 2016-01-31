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
<title>Espace Client</title>

<style type="text/css">
<%@ include file="/assets/css/bootstrap.min.css"%>
</style>

</head>
<body class="container">

	<div class="header clearfix">
		<div class="jumbotron"><h2>Espace Client : Bonjour ${pageContext.request.userPrincipal.name}</h2><p>la régularisation des retraits GAB non servis pour le motif «cash-retracted»</p></div>
        <nav>
          <ul class="nav nav-pills pull-right">
            <li class="active"><a href="javascript:window.location.reload()">Liste des transactions</a></li>
            <li ><a href="/cashRetractedProject/j_spring_security_logout">Se déconnecter</a></li>
          </ul>
        </nav>
     </div>

	<h2 class="bg-danger" style="padding: 5px">Votre solde actuel est de ${solde} MAD.</h2>
	<table class="table table-hover" style="text-align: center;">
		<thead class="bg-primary">
			<tr class="row">
				<td>Id Transaction</td>
				<td>Id Compte</td>
				<td>Montant (MAD)</td>
				<td>Date</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${transactions}" var="tx">
				<tr class="row">
					<td>${tx.idtransaction}</td>
					<td>${tx.compte.idcompte}</td>
					<td>${tx.montant}</td>
					<td>${tx.date}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>