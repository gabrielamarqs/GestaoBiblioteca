<%@ page import="com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: gabrielamarques
  Date: 28/05/2023
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%
List<Livro> livros =  (List<Livro>) request.getAttribute("attr_livros");
%>
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
        <%@ include file="menu.jsp"%>>
    </div>
    <div class="right">
        <table>
            <% for (Livro l : livros) {%>
            <tr>
                <td> <%= l.getTitulo() %></td>
                <td> <%= l.getAutor() %></td>
            </tr>
            <% } %>
        </table>
    </div>
    </div>
</body>
</html>
