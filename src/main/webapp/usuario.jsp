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
	<link href="assets/styles/livro.css" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
</head>
<body>
<div class="container">
	<div class="left">
		<%@ include file="menu.jsp" %>
	</div>
	<div class="right">
		<table>
			<tr>
				<th>Nome</th>
				<th>Sobrenome</th>
				<th>Email</th>
			</tr>
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
		</table>
	</div>
</div>
</body>
</html>
