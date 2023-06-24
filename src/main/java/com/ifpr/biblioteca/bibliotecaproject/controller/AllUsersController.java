package com.ifpr.biblioteca.bibliotecaproject.controller;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.Admin;
import com.ifpr.biblioteca.bibliotecaproject.repository.UsuarioRepository;
import com.ifpr.biblioteca.bibliotecaproject.service.AuthentificationService;
import com.ifpr.biblioteca.bibliotecaproject.service.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/controller_all_users")
public class AllUsersController extends HttpServlet {
    Usuario usuario;
    UsuarioRepository usuarioRepository;
    AuthentificationService authentificationService;
    UsuarioService usuarioService;

    public AllUsersController() {
        usuario = new Usuario();
        usuarioRepository = new UsuarioRepository();
        authentificationService = new AuthentificationService();
        usuarioService = new UsuarioService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuarioLogado = authentificationService.isUserLoggedIn(req);
        String action = req.getParameter("action");
        Long usuarioCodigo;

        if (usuarioLogado != null) {
            if (action != null) {
                usuarioCodigo = Long.valueOf(req.getParameter("codigo"));
                Usuario usuarioFindById = usuarioRepository.findById(usuarioCodigo);

                if (  action.equals("delete")) {
                    usuarioRepository.delete(usuarioFindById);
                } else if ( action.equals("adminSim")) {
                    usuarioFindById.setAdmin(Admin.SIM);
                    usuarioRepository.update(usuarioFindById);
                } else if ( action.equals("adminNao")) {
                    usuarioFindById.setAdmin(Admin.NAO);
                    usuarioRepository.update(usuarioFindById);
                }
            }

            usuarioService.listarTodosUsuarios(req, resp);
        }
    }
}



