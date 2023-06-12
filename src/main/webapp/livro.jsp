<%@ page import="com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: gabrielamarques
  Date: 04/06/2023
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Livro> livros = (List<Livro>) request.getAttribute("attr_livros");

    Boolean isAdmin = (Boolean) request.getSession().getAttribute("admin");
%>



<html>
<head>
    <title>livros</title>
    <link href="assets/styles/livro.css" rel="stylesheet">
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
            <form method="post" action="controller_livro">
                <div>
                    <button>
                        <a href="cadastroLivro.jsp">
                            Cadastrar Livros
                        </a>>
                    </button>
                </div>
                <div>
                    <button name="action" value="livrosIndisponiveis">
                        Livros Emprestados
                    </button>
                </div>
                <div>
                    <button name="action" value="livrosAtrasados">
                        Livros Atrasados
                    </button>
                </div>

            </form>

        </div>
        <div class="main">
            <table>
                <thead>
                <tr>
                    <th>Titulo</th>
                    <th>Autor</th>
                    <th>Sinopse</th>
                    <th>Gênero</th>
                </tr>
                </thead>
                <tbody>
                <% for (Livro l : livros) {%>
                <tr>
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
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>
