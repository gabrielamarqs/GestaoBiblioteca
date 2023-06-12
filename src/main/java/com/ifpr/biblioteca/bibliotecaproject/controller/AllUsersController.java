package com.ifpr.biblioteca.bibliotecaproject.controller;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.Admin;
import com.ifpr.biblioteca.bibliotecaproject.repository.UsuarioRepository;
import com.ifpr.biblioteca.bibliotecaproject.service.AuthentificationService;
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

    public AllUsersController() {
        usuario = new Usuario();
        usuarioRepository = new UsuarioRepository();
        authentificationService = new AuthentificationService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuarioLogado = authentificationService.isUserLoggedIn(req);
        String action = req.getParameter("action");
        Long usuarioCodigo;

        if (usuarioLogado != null) {

            if (action != null && action.equals("delete")) {
                usuarioCodigo = Long.valueOf(req.getParameter("codigo"));
                Usuario usuarioFindById = usuarioRepository.findById(usuarioCodigo);
                usuarioRepository.delete(usuarioFindById);
            } if (action != null && action.equals("admin")) {
                usuarioCodigo = Long.valueOf(req.getParameter("codigo"));
                Usuario usuarioFindById = usuarioRepository.findById(usuarioCodigo);
                usuarioFindById.setAdmin(Admin.SIM);
                usuarioRepository.update(usuarioFindById);
            }

            List<Usuario> usuarioList = usuarioRepository.getAll();
            req.setAttribute("attr_usuarioList", usuarioList);
            req.getRequestDispatcher("todosUsuarios.jsp").forward(req, resp);

        }
    }
}



