package com.ifpr.biblioteca.bibliotecaproject.controller;

import com.ifpr.biblioteca.bibliotecaproject.exception.UsuarioInexistenteException;
import com.ifpr.biblioteca.bibliotecaproject.service.AuthentificationService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/loginn")
public class LoginController extends HttpServlet {

    AuthentificationService service;

    public LoginController() {
        service = new AuthentificationService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException, UsuarioInexistenteException {

        String email = req.getParameter("field_email");
        String password = req.getParameter("field_password");

        AuthentificationService service = new AuthentificationService();

        try {
            service.validateLogin(email, password, req);

            //se está aqui nessa é porque não ocorreu nenhum erro
            resp.sendRedirect("http://localhost:8080/app/home");

        } catch (Exception e) {
            String msg = e.getMessage();
            resp.sendRedirect("http://localhost:8080/app/index.jsp");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        service.logout(req);

        resp.sendRedirect("http://localhost:8080/app/index.jsp");

    }
}