<%@ page import="com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: gabrielamarques
  Date: 04/06/2023
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<title>livros</title>
	<link href="assets/styles/emprestimo.css" rel="stylesheet">
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
		<div class="header">
			<div>
				<button>
					<a href="">
						Cadastrar Usuarios
					</a>>
				</button>
			</div>
			<div>
				<button>
					<a href="">
						Cadastrar Livros
					</a>>
				</button>
			</div>
			<div>
				<button>
					<a href="emprestimo_controller?action=historico">
						Historico
					</a>
				</button>
			</div>
		</div>
		<div class="main">
			<form class="" action="emprestimo_controller" method="post">
				<div class="">
					<label>
						Email:
					</label>
					<input type="email" name="field_email">
					<p>${messageUsuario}</p>
				</div>
				<div class="">
					<label>
						ISBN:
					</label>
					<input type="text" name="field_isbn">
					<p>${messageLivro}</p>
				</div>
				<div class="">
					<button>
						Cadastrar
					</button>
				</div>
			</form>

			<span>Nome usuário situação</span>
			<table>
				<thead>
				<th>Titulo</th>
				<th>Autor</th>
				<th>ISBN</th>
				<th>Data Empréstimo</th>
				<th>Data Devolução</th>
				<th>Devolução</th>
				<th>Renovar</th>

				</thead>
				<tbody>
				<a href="controller_all_users?action=admin&codigo=<%= usuario.getCodigoUsuario() %>">
					Admin
				</a>
				</tbody>
			</table>
			<%--			<table>--%>
			<%--				<thead>--%>
			<%--				<tr>--%>
			<%--					<th>Titulo</th>--%>
			<%--					<th>Autor</th>--%>
			<%--					<th>Sinopse</th>--%>
			<%--					<th>Gênero</th>--%>
			<%--				</tr>--%>
			<%--				</thead>--%>
			<%--				<tbody>--%>
			<%--				<% for (Livro l : livros) {%>--%>
			<%--				<tr>--%>
			<%--					<td>--%>
			<%--						<%= l.getTitulo() %>--%>
			<%--					</td>--%>
			<%--					<td>--%>
			<%--						<%= l.getAutor() %>--%>
			<%--					</td>--%>
			<%--					<td>--%>
			<%--						<%= l.getSinopse() %>--%>
			<%--					</td>--%>
			<%--					<td>--%>
			<%--						<%= l.getGenero() %>--%>
			<%--					</td>--%>
			<%--				</tr>--%>
			<%--				<% } %>--%>
			<%--				</tbody>--%>
			<%--			</table>--%>
		</div>
	</div>

</div>
</body>
</html>
