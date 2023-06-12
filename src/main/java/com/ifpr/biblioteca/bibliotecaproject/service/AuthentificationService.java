package com.ifpr.biblioteca.bibliotecaproject.service;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.Admin;
import com.ifpr.biblioteca.bibliotecaproject.exception.UsuarioInexistenteException;
import com.ifpr.biblioteca.bibliotecaproject.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


public class AuthentificationService {

    UsuarioRepository repository;

    public AuthentificationService() {
        repository = new UsuarioRepository();
    }

    public Usuario validateLogin(String email, String password, HttpServletRequest request) throws Exception {

        if (email == null || email.isEmpty()) {
            throw new Exception("Email inválido");
        }

        if (password == null || password.isEmpty()) {
            throw new Exception("Senha inválida");
        }

        Usuario usuario = repository.getUserByEmail(email);

        if (usuario == null) {
            throw new UsuarioInexistenteException("Esse usuario não existe.");
        }

        if (!usuario.getSenha().equals(password)) {
            throw new UsuarioInexistenteException("Essa não é a senha correta.");
        }

        if (usuario.getAdmin() == Admin.SIM) {
            HttpSession session = request.getSession(true);
            // se não tiver uma sessão ativa, cria
            session.setAttribute("usuario", usuario);
            session.setAttribute("admin", true);
        } else {
            HttpSession session = request.getSession(true);
            // se não tiver uma sessão ativa, cria
            session.setAttribute("usuario", usuario);
        }

        return usuario;
    }

    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.invalidate();
        session.setMaxInactiveInterval(0);
    }

    public  Usuario isUserLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        // se false quer dizer que se não tiver uma sessão ativa, não cria
        return  (Usuario) session.getAttribute("usuario");
    }

}