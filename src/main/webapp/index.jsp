<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="assets/styles/styles.css" rel="stylesheet"  >
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
</head>
<body>
<div class="container">

<!-- left -->
<div class="left">
        <div class="imgLogo">
            <img src="assets/librakey.svg" alt="libra key">
            <span>Logue na sua conta</span>
        </div>
        <div class="form">
        <form action="loginn" method="post">
            <div class="email">
                <label for="loginEmail" class="lEmail">Email</label>
                <input type="email" class="input loginEmail" name="field_email" id="loginEmail" placeholder="name@example.com">
            </div>
            <div class="password">
                <label for="inputPassword" class="lPassword">Senha</label>
                <div class="passwordDiv">
                    <input type="password" class="input loginPassword" name="field_password" id="inputPassword" placeholder="Insira sua senha">
                    <a href="#" class="forgotPassword"> Esqueceu a senha? </a>
                </div>

            </div>
            <div class="btnLoginDiv">
                <button type="submit" class="btnLogin">Login</button>
            </div>
            <p>OR</p>
            <div class="btnCadastrarDiv">
              <button type="submit" class="btnCadastrar">
                  <a href="cadastro.jsp">
                      Cadastrar
                  </a>
              </button>
            </div>

        </form>
    </div>
</div>
<!-- right -->
<div class="right">
    <img src="assets/img.svg" alt="menina lendo livro">
</div>

</div>

</body>
</html>