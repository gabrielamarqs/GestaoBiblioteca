<%--
  Created by IntelliJ IDEA.
  User: gabrielamarques
  Date: 01/06/2023
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Cadastro Livro</title>
	<link href="assets/styles/cadastrolivro.css" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
	<div class="biblioteca">
		<form action="livros?action=cadastrar" method="post">
			<div class="divForm">
				<div class="divTitulo">
					<h2>Cadastro Livro</h2>
				</div>
				<div class="divCadastroLivro titulo">
					<label class="label labelTitulo" for="inputTitulo">Titulo:</label>
					<input name="field_titulo" type="text" class="inputCadastroLivro tituloLivro" id="inputTitulo">
				</div>
				<div class="divCadastroLivro autor">
					<label class="label labelAutor" for="inputAutor">Autor:</label>
					<input name="field_autor" type="text" class="inputCadastroLivro autorLivro" id="inputAutor">
				</div>
				<div class="divCadastroLivro sinopse">
					<label class="label labelSinopse" for="inputSinopse">Sinopse:</label>
					<input name="field_sinopse" type="text" class="inputCadastroLivro sinopseLivro" id="inputSinopse">
				</div>
				<div class="divCadastroLivro editora">
					<label class="label labelEditora" for="inputEditora">Editora:</label>
					<input name="field_editora" type="text" class="inputCadastroLivro editoraLivro" id="inputEditora">
				</div>
				<div class="divCadastroLivro isbn">
					<label class="label labelIsbn" for="inputIsbn">ISBN:</label>
					<input name="field_isbn" type="text" class="inputCadastroLivro isbnLivro" id="inputIsbn">
				</div>
				<div class="divCadastroLivro genero">
					<label class="label labelGenero" for="inputGenero">Gênero:</label>
					<input name="field_genero" type="text" class="inputCadastroLivro generoLivro" id="inputGenero">
				</div>
				<div class="divCadastroLivro nroPagina">
					<label class="label labelPagina" for="inputNroPagina">No. páginas:</label>
					<input name="field_pagina" type="text" class="inputCadastroLivro paginasLivro" id="inputNroPagina">
					<p>${message}</p>
				</div>
				<div class="divCadastroLivro divBtn">
					<button name="" type="submit" class="btnLivro" id="btnCadastrarLivro">Cadastrar</button>
				</div>
				<div class="divCadastroLivro divBtn">
					<button name="" type="submit" class="btnLivro" id="btnVoltar">
						<a href="livros">Voltar</a>
					</button>
				</div>
			</div>
		</form>
	</div>
</div>
</body>
</html>
