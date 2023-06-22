<%@ page import="com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: gabrielamarques
  Date: 28/05/2023
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%
	List<Livro> livros = (List<Livro>) request.getAttribute("attr_livros");

	Boolean isAdminHome = (Boolean) request.getSession().getAttribute("admin");

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Tela home</title>
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

					<% if (isAdminHome != null && isAdminHome) { %>

					<div class="d-grid gap-2 d-md-flex justify-content-md-end">
						<a href="livros?action=redirecionar" class="btn btn-primary" role="button">
							Cadastrar Livros
						</a>
					</div>

					<% } %>

					<table class="table">
						<thead>
						<tr>
							<th>Codigo</th>
							<th>Titulo</th>
							<th>Autor</th>
							<th>Sinopse</th>
							<th>Gênero</th>
							<th>Status</th>
							<% if (isAdminHome != null && isAdminHome) { %>

							<th>Opções</th>
							<% } %>
						</tr>
						</thead>
						<tbody>
						<% for (Livro l : livros) {%>
						<tr>
							<td>
								<%= l.getCodigoLivro() %>
							</td>
							<td>
								<%= l.getTitulo() %>
							</td>
							<td>
								<%= l.getAutor() %>
							</td>
							<td>
								<%= l.getSinopse() %>
							</td>
							<td>
								<%= l.getGenero() %>
							</td>
							<td>
								<%= l.getSituacaoLivro() %>
							</td>
							<% if (isAdminHome != null && isAdminHome) { %>

							<td><a href="#" onclick="emprestarLivro(<%= l.getCodigoLivro() %>, )">Emprestar</a></td>

							<% } %>

						</tr>
						<% } %>
						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel">Email</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				<span id="errorMessage">${errorMessage}</span>
			</div>
			<div class="modal-body">
				<input type="text" name="email" id="inputEmail" class="form-control">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">cancelar</button>
				<button type="button" class="btn btn-primary" id="emprestarButton">emprestar</button>
			</div>
		</div>
	</div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>


<script>

    const emprestarButton = document.getElementById("emprestarButton");
    const inputEmail = document.getElementById("inputEmail");
    const errorMessage = document.getElementById("errorMessage");

    let codigoLivro;
    let emailUsuario;


    const myModal = new bootstrap.Modal('#exampleModal', {
        keyboard: false
    });

    function emprestarLivro(codigoLivroParam) {

        codigoLivro = codigoLivroParam;
        myModal.show();
    }


    emprestarButton.addEventListener('click', () => {

        // errorMessage.textContent = "";
        // inputEmail.value = "";

        let url = "http://localhost:8080/app/livros?action=emprestar&codigo=" + codigoLivro + "&email=" + inputEmail.value;


        fetch(url).then((response) => {
            if (!response.ok) {
                errorMessage.textContent = "Problema ao tentar emprestar.";
                myModal.show();
                throw new Error("Request failed: " + response.status);
            }
            myModal.hide();



        }).catch((error) => {
            errorMessage.textContent = "Problema ao tentar emprestar: " + error.message;
            myModal.show();
        });
    });

</script>

</body>
</html>
