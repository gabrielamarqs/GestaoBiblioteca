<%@ page import="com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: gabrielamarques
  Date: 10/06/2023
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
	Usuario usuarios = (Usuario) request.getAttribute("attr_usuario");
%>

<html>
<head>
	<title>Title</title>
	<link href="assets/styles/usuario.css" rel="stylesheet">

	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
	<div class="biblioteca">
		<div class="left">
			<%@ include file="menu.jsp" %>
		</div>
		<div class="right">
			<table class="table table-success table-striped">
				<thead>
				<tr>
					<th>Nome</th>
					<th>Sobrenome</th>
					<th>Email</th>
				</tr>
				</thead>
				<tbody>
				<tr>
					<td>
						<%= usuarios.getNome() %>
					</td>
					<td>
						<%= usuarios.getSobrenome() %>
					</td>
					<td>
						<%= usuarios.getEmail() %>
					</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>
