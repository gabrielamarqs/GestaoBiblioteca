<%@ page import="com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
	List<Object[]> livros = (List<Object[]>) request.getAttribute("attr_livrosBiblioteca");
	String mensagem = (String) request.getAttribute("mensagem");
%>

<html>
<head>
	<title>Emprestimo</title>
	<link href="assets/styles/home.css" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

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

					<a href="emprestimos?action=livrosAtrasados" class="btn btn-outline-success" role="button">
						Atrasados
					</a>
					<a href="emprestimos?action=livrosEmprestados" class="btn btn-outline-success" role="button">
						Emprestados
					</a>
					<a href="emprestimos?action=emprestimoHistorico" class="btn btn-outline-success" role="button">
						Histórico
					</a>
					<a href="livros?action=livrosDisponiveis" class="btn btn-outline-success" role="button">
						Disponiveis
					</a>
					<table class="table">
						<thead>
						<tr>
							<th>Código</th>
							<th>Titulo</th>
							<th>Data Empreśtimo</th>
							<th>Data Devolução</th>
							<th>Usuário</th>

							<% if ((Boolean) request.getAttribute("mostrarColunas")) { %>

							<th>Opções</th>

							<% } %>

						</tr>
						</thead>
						<tbody>

						<% for (Object[] emprestimo : livros) { %>
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
							<td>
								<%= emprestimo[3] %>
							</td>
							<td>
								<%= emprestimo[4] %>
							</td>

							<% if ((Boolean) request.getAttribute("mostrarColunas")) { %>

							<td>
								<a href="emprestimos?action=devolucao&codigo=<%= emprestimo[0] %>">
									Devolver
								</a>
								<span>|</span>
								<a href="emprestimos?action=renovar&codigo=<%= emprestimo[0] %>">
									Renovar
								</a>
							</td>

							<% } %>

						</tr>
						<% } %>
						</tbody>
					</table>
					<% if (mensagem != null) { %>
					<div class="alert alert-success">
						<%= mensagem %>
					</div>
					<% } %>

				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
