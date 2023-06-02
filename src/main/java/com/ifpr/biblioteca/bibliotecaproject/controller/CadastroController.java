package com.ifpr.biblioteca.bibliotecaproject.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/cadastro")
public class CadastroController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // okay recebo aqui meus atributos
        
        String fieldNome = req.getParameter("field_nome");
        String fieldSobrenome = req.getParameter("field_sobrenome");
        String fieldEmail = req.getParameter("field_email");
        String fieldSenha = req.getParameter("field_senha");

    }
}
