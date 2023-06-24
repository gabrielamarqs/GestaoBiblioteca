package com.ifpr.biblioteca.bibliotecaproject.controller;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.Admin;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.SituacaoUsuario;
import com.ifpr.biblioteca.bibliotecaproject.repository.UsuarioRepository;
import com.ifpr.biblioteca.bibliotecaproject.service.AuthentificationService;
import com.ifpr.biblioteca.bibliotecaproject.service.UsuarioService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/cadastro")
public class CadastroController extends HttpServlet {
    Usuario usuario;
    UsuarioRepository usuarioRepository;
    UsuarioService usuarioService;

    public CadastroController() {
        usuario = new Usuario();
        usuarioRepository = new UsuarioRepository();
        usuarioService = new UsuarioService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null) {
            if (action.equals("telaCadastro")) {
                resp.sendRedirect("http://localhost:8080/app/usuarioCadastro.jsp");
            } else if (action.equals("usuarioCadastro")){
                usuarioService.cadastrar(req, resp);
            }
        }
    }
}
