package com.ifpr.biblioteca.bibliotecaproject.controller;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import com.ifpr.biblioteca.bibliotecaproject.repository.UserRepository;
import com.ifpr.biblioteca.bibliotecaproject.service.AuthentificationService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/cadastro")
public class CadastroController extends HttpServlet {
    Usuario user;
    UserRepository userRepository;

    public CadastroController() {
        user = new Usuario();
        userRepository = new UserRepository();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // okay recebo aqui meus atributos
        
        String fieldNome = req.getParameter("field_nome");
        String fieldSobrenome = req.getParameter("field_sobrenome");
        String fieldEmail = req.getParameter("field_email");
        String fieldSenha = req.getParameter("field_senha");
        String fieldSenhaConfirma = req.getParameter("field_senhaConfirma");

        if (!fieldSenha.equals(fieldSenhaConfirma)) {
            req.setAttribute("mensagem", "A senha está incorreta");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("cadastro.jsp");
            requestDispatcher.forward(req, resp);
        }

        user.setNome(fieldNome);
        user.setSobrenome(fieldSobrenome);
        user.setEmail(fieldEmail);
        user.setSenha(fieldSenha);

        userRepository.create(user);

        // até aqui usuário sendo criado
        // TODO
        // tratar o negocio da senha
        // depois que cadastrar mandar pra página home
        // se tiver email repetido mostrar que o email ta repetido


    }
}
