package com.ifpr.biblioteca.bibliotecaproject.controller;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import com.ifpr.biblioteca.bibliotecaproject.repository.EmprestimoRepository;
import com.ifpr.biblioteca.bibliotecaproject.repository.UsuarioRepository;
import com.ifpr.biblioteca.bibliotecaproject.service.AuthentificationService;
import com.ifpr.biblioteca.bibliotecaproject.service.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(value = "/usuarios")
public class UsuarioController extends HttpServlet {
    Usuario usuario;
    UsuarioRepository usuarioRepository;
    EmprestimoRepository emprestimoRepository;
    AuthentificationService authentificationService;
    UsuarioService usuarioService;
    private String action;

    public UsuarioController() {
        usuario = new Usuario();
        usuarioRepository = new UsuarioRepository();
        authentificationService = new AuthentificationService();
        emprestimoRepository = new EmprestimoRepository();
        usuarioService = new UsuarioService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuarioLogado = authentificationService.isUserLoggedIn(req);
        String action = req.getParameter("action");

        if (action != null) {

            if (action.equals("usuario")) {
                String email = usuarioLogado.getEmail();
                usuarioService.listarUsuario(email, req, resp);
            }
        }
    }
}



