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
</head>
<body>
<div class="container">
    <form action="cadastro_livro" method="post">
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
        </div>
        <div class="divCadastroLivro dtaPublicacao">
            <label class="label labelPublicacao" for="inputDtaPublicacao">Data de Publicação:</label>
            <input name="field_publicacao" type="text" class="inputCadastroLivro publicacaoLivro"
                   id="inputDtaPublicacao">
        </div>
        <div class="divCadastroLivro cadastrar">
            <button name="" type="submit" class="" id="btnCadastrarLivro">Cadastrar</button>
        </div>
    </form>
    <div class="divVoltar voltar">
        <button name="" type="submit" class="btnVoltar" id="btnVoltar">
            <a href="livro.jsp">Voltar</a>
        </button>
    </div>
</div>
</body>
</html>
