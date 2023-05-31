package com.ifpr.biblioteca.bibliotecaproject.controller;

import com.ifpr.biblioteca.bibliotecaproject.service.LoginService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/loginn")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        String email = req.getParameter("field_email");
        String password = req.getParameter("field_password");

        LoginService service = new LoginService();


        try {
            service.validateLogin(email, password, req);

            //se está aqui nessa é porque não ocorreu nenhum erro
            resp.sendRedirect("http://localhost:8080/login/home.jsp");

        } catch (Exception e) {
            String msg = e.getMessage();
            resp.sendRedirect("http://localhost:8080/login/index.jsp?msg=" + msg );
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {


        HttpSession session = req.getSession(false);

        //validar sessao
        session.setAttribute("is_logged_in", false);
        session.invalidate();


        resp.sendRedirect("http://localhost:8080/login/index.jsp");

    }
}