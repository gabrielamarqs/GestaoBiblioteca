<%--
  Created by IntelliJ IDEA.
  User: gabrielamarques
  Date: 28/05/2023
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tela home</title>
    <link href="assets/styles/home.css" rel="stylesheet"  >
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="left">
        <div class="imgLogo">
            <img src="assets/librakey.svg" alt="libra key">
            <span>Logue na sua conta</span>
        </div>
        <form class="formSearch">
            <input class="btnHome" type="search" placeholder="Pesquisar" aria-label="Search" onclick="">
            <!-- pesquisar depois como faz quando der enter pra pesquisar -->
        </form>
        <div class="divBtn">
            <button class="btnHome btnDadosPessoais" type="button">Dados pessoais</button>
        </div>
        <div class="divBtn">
            <button  class="btnHome btnLivros" type="button">Livros</button>
        </div>
        <div class="divBtn">
            <button class="btnHome btnRenovar" type="button">Renovar</button>
        </div>
        <div class="divBtn">
            <button class="btnHome btnPendentes" type="button">Pendentes</button>
        </div>
        <div class="divBtn">
            <button class="btnHome btnEditarUsuario" type="button">Editar usuário</button>
        </div>
        <div class="divBtn">
            <button class="btnGreen btnLogout" type="button">Sair</button>
        </div>
    </div>
    <div class="right">
        <img src="assets/img.svg" alt="menina lendo livro">
    </div>
    </div>
</body>
</html>
