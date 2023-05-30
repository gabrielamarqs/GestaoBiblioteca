package com.ifpr.biblioteca.bibliotecaproject.service;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginService {

    public void validateLogin(String email, String password, HttpServletRequest request) throws Exception {

        if(email == null || email.isEmpty()){
            throw new Exception("Email inválido");
        }

        if(password == null || password.isEmpty()){
            throw new Exception("Senha inválida");
        }

        if (email.equals("gg@gmail.com") && password.equals("admin")){

            HttpSession session = request.getSession();
            session.setAttribute("is_logged_in", true);
            session.setAttribute("email", email);

        } else {
            throw new Exception("usuário ou senha incorreto");
        }


    }

}