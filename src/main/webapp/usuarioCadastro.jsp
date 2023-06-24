<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tela de cadastro</title>
    <link href="assets/styles/cadastro.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">

</head>
<body>
<div class="container2">
    <div class="form">
        <div class="titulo">
            <span>Cadastro</span>
        </div>
        <form action="cadastro?action=usuarioCadastro" method="POST">
            <div class="divCadastro nome">
                <label class="label inputNome" for="inputNome">Nome</label>
                <input name="field_nome" type="text" class="inputCadastro" id="inputNome"
                       placeholder="Informe seu nome">
            </div>
            <div class="divCadastro sobrenome">
                <label class="label inputSobrenome" for="inputSobrenome">Sobrenome</label>
                <input name="field_sobrenome" type="text" class="inputCadastro" id="inputSobrenome"
                       placeholder="Informe seu sobrenome">
            </div>
            <div class="divCadastro email">
                <label class="label inputEmail" for="exampleInputEmail1">Email</label>
                <input name="field_email" type="email" class="inputCadastro" id="exampleInputEmail1"
                       placeholder="Informe seu email">
            </div>
            <div class="divCadastro senha">
                <label class="label inputSenha" for="inputSenha">Senha</label>
                <input name="field_senha" type="password" class="inputCadastro" id="inputSenha"
                       placeholder="Informe uma senha">
            </div>
            <div class="divCadastro confirmaSenha">
                <label class="label inputConfirmaSenha" for="inputConfirmaSenha">Confirmar senha</label>
                <input name="field_confirmaSenha" type="password" class="inputCadastro" id="inputConfirmaSenha"
                       placeholder="Confirme a senha">
                <p>${message}</p>
            </div>
             <div class="btnCadastrarDiv">
                <button type="submit" class="btnCadastrar">Cadastrar</button>
            </div>
        </form>
        <div class="divCadastroOut">
            <p class="cadastroOut">Já possui uma conta?
                <a href="loginn" class="cadastroOutLogin">Fazer login.</a>
            </p>
        </div>
    </div>
</div>
</body>
</html>
