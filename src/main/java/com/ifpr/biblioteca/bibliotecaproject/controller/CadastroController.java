package com.ifpr.biblioteca.bibliotecaproject.controller;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.Admin;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.SituacaoUsuario;
import com.ifpr.biblioteca.bibliotecaproject.repository.UsuarioRepository;
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
    Usuario usuario;
    UsuarioRepository usuarioRepository;

    public CadastroController() {
        usuario = new Usuario();
        usuarioRepository = new UsuarioRepository();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String flag = req.getParameter("flag");

        if (action != null) {
            if (action.equals("telaCadastro")) {
                resp.sendRedirect("http://localhost:8080/app/usuarioCadastro.jsp");
            } else if (action.equals("usuarioCadastro")){
                this.cadastrar(req, resp);
            }
        }
    }

    protected void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fieldNome = req.getParameter("field_nome");
        String fieldSobrenome = req.getParameter("field_sobrenome");
        String fieldEmail = req.getParameter("field_email");
        String fieldSenha = req.getParameter("field_senha");
        String fieldSenhaConfirma = req.getParameter("field_confirmaSenha");

        if (!fieldSenha.trim().equals(fieldSenhaConfirma.trim())) {
            String message = "Senhas diferentes.";
            req.setAttribute("message", message);
            req.getRequestDispatcher("usuarioCadastro.jsp").forward(req, resp);
        } else {
            usuario.setNome(fieldNome);
            usuario.setSobrenome(fieldSobrenome);
            usuario.setEmail(fieldEmail);
            usuario.setSenha(fieldSenha);
            usuario.setAdmin(Admin.NAO);
            usuario.setSituacaoUsuario(SituacaoUsuario.LIVRE);

            usuarioRepository.create(usuario);

            AuthentificationService service = new AuthentificationService();
            try {
                service.validateLogin(fieldEmail, fieldSenha, req);
                resp.sendRedirect("http://localhost:8080/app/home");
            } catch (Exception e) {
                resp.sendRedirect("http://localhost:8080/app/index.jsp");
            }
        }


    }
}
