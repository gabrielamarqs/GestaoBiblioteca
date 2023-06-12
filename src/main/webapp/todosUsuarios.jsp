<%@ page import="com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: gabrielamarques
  Date: 10/06/2023
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
	List<Usuario> usuarioList = (List<Usuario>) request.getAttribute("attr_usuarioList");
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
				<th>Tornar Administrador</th>
				<!--
				Mudar o enum para sim ou para não ?????
				-->
				<th>Excluir</th>
			</tr>
			<tr>

				<% for (Usuario usuario : usuarioList) {%>

				<td>
					<%= usuario.getNome() %>
				</td>
				<td>
					<%= usuario.getSobrenome() %>
				</td>
				<td>
					<%= usuario.getEmail() %>
				</td>
				<td>
					<a href="controller_all_users?action=admin&codigo=<%= usuario.getCodigoUsuario() %>">
						Admin
					</a>
				</td>
				<td>
					<a href="controller_all_users?action=delete&codigo=<%= usuario.getCodigoUsuario() %>">
						delete
					</a>
				</td>

			</tr>

			<% } %>

		</table>
	</div>
</div>
</body>
</html>
