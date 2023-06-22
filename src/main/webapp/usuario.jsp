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
	Usuario usuarios = (Usuario) request.getAttribute("attr_usuario");

	List<Object[]> emprestimosUsuario = (List<Object[]>) request.getAttribute("attr_usuarioHistorico");


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
		<div class="tableUsuario">
			<div class="right">
				<table class="table table-success table-striped">
					<thead>
					<tr>
						<th>Nome</th>
						<th>Sobrenome</th>
						<th>Email</th>
						<th>Situação</th>
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
						<td>
							<%= usuarios.getSituacaoUsuario() %>
						</td>
					</tr>
					</tbody>
				</table>
			</div>
			<div class="tableEmprestimo">
				<table class="table table-success table-striped">
					<thead>
					<tr>
						<th>Titulo</th>
						<th>Data Empreśtimo</th>
						<th>Data Devolução</th>
					</tr>
					</thead>
					<tbody>
					<% for (Object[] emprestimo : emprestimosUsuario) { %>

					<tr>
						<td>
							<%= emprestimo[0] %>
						</td>
						<td>
							<%= emprestimo[1] %>
						</td>
						<td>
							<%= emprestimo[2] %>
						</td>
					</tr>
					<% } %>

					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>
