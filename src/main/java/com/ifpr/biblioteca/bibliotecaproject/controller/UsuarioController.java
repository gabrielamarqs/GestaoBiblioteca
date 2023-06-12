package com.ifpr.biblioteca.bibliotecaproject.controller;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import com.ifpr.biblioteca.bibliotecaproject.repository.UsuarioRepository;
import com.ifpr.biblioteca.bibliotecaproject.service.AuthentificationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value ="/controller_usuario")
public class UsuarioController extends HttpServlet {
    Usuario usuario;
    UsuarioRepository usuarioRepository;
    AuthentificationService authentificationService;

    public UsuarioController() {
        usuario = new Usuario();
        usuarioRepository = new UsuarioRepository();
        authentificationService = new AuthentificationService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuarioLogado = authentificationService.isUserLoggedIn(req);

        String action = req.getParameter("action");

        if (usuarioLogado != null) {
            if (action != null && action.equals("usuario")) {
                String email = usuarioLogado.getEmail();
                usuario = usuarioRepository.getUserByEmail(email);
                System.out.println(email);
                req.setAttribute("attr_usuario", usuario);
                req.getRequestDispatcher("usuario.jsp").forward(req, resp);
            }
        }
    }
}



