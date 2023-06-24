<%@ page import="com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
	List<Usuario> usuarioList = (List<Usuario>) request.getAttribute("attr_usuarioList");
%>

<html>
<head>
	<title>Usuarios</title>
	<link href="assets/styles/home.css" rel="stylesheet">

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
			<div class="main">

			<div class="table-container">

					<table class="table">
						<tr>
							<th>Nome</th>
							<th>Sobrenome</th>
							<th>Email</th>
							<th>Admin</th>
							<th>Administrador</th>
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
								<%= usuario.getAdmin() %>
							</td>
							<td>
								<a href="controller_all_users?action=adminSim&codigo=<%= usuario.getCodigoUsuario() %>">
									SIM
								</a>
								<span> | </span>
								<a href="controller_all_users?action=adminNao&codigo=<%= usuario.getCodigoUsuario() %>">
									NÃO
								</a>
							</td>
							<td>
								<a href="controller_all_users?action=delete&codigo=<%= usuario.getCodigoUsuario() %>">
									Deletar
								</a>
							</td>

						</tr>

						<% } %>

					</table>
				</div>

			</div>
		</div>
	</div>
</div>
</body>
</html>
