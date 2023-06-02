<%--
  Created by IntelliJ IDEA.
  User: gabrielamarques
  Date: 25/05/2023
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tela de cadastro</title>
    <link href="assets/styles/cadastro.css" rel="stylesheet"  >
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">

</head>
<body>
    <div class="container">
        <div class="form">
            <div class="titulo">
                <span>Cadastro</span>
            </div>
            <form action="/cadastrar" method="get">
                <div class="divCadastro nome">
                    <label class="label inputNome" for="inputNome">Nome</label>
                    <input name="field_nome" type="text" class="inputCadastro" id="inputNome" placeholder="Informe seu nome">
                </div>
                <div class="divCadastro sobrenome">
                    <label class="label inputSobrenome" for="inputSobrenome">Sobrenome</label>
                    <input name="field_sobrenome" type="text" class="inputCadastro" id="inputSobrenome" placeholder="Informe seu sobrenome">
                </div>
                <div class="divCadastro email">
                    <label class="label inputEmail" for="exampleInputEmail1">Email</label>
                    <input name="field_email" type="email" class="inputCadastro" id="exampleInputEmail1" placeholder="Informe seu email">
                </div>
                <div class="divCadastro senha">
                    <label class="label inputSenha" for="inputSenha">Senha</label>
                    <input name="field_senha" type="password" class="inputCadastro" id="inputSenha" placeholder="Informe uma senha">
                </div>
                <div class="divCadastro confirmaSenha">
                    <label class="label inputConfirmaSenha"  for="inputConfirmaSenha">Confirmar senha</label>
                    <input name="field_confirmaSenha" type="password" class="inputCadastro" id="inputConfirmaSenha" placeholder="Confirme a senha">
                </div>
                <div class="termos">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Concordo com os termos e condições.</label>
                </div>
                <div class="btnCadastrarDiv">
                    <button type="submit" class="btnCadastrar">Cadastrar</button>
                </div>
                <div class="divCadastroOut">
                    <p class="cadastroOut">Já possui uma conta?
                        <a href="loginn" class="cadastroOutLogin">Fazer login.</a>
                    </p>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
