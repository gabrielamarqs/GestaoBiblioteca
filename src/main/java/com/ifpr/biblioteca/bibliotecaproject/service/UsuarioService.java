package com.ifpr.biblioteca.bibliotecaproject.service;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.Admin;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.SituacaoUsuario;
import com.ifpr.biblioteca.bibliotecaproject.repository.EmprestimoRepository;
import com.ifpr.biblioteca.bibliotecaproject.repository.UsuarioRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class UsuarioService {
    Usuario usuario;
    UsuarioRepository usuarioRepository;
    EmprestimoRepository emprestimoRepository;

    public UsuarioService() {
        usuario = new Usuario();
        usuarioRepository = new UsuarioRepository();
        emprestimoRepository = new EmprestimoRepository();
    }

    public void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

    public void listarUsuario(String email, HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

        usuario = usuarioRepository.getUserByEmail(email);

        List<Object[]> emprestimosUsuario = emprestimoRepository.getAllEmprestimoUsuario(email);

        for (Object[] linha : emprestimosUsuario) {
            String tituloLivro = (String) linha[0];
            LocalDate dataEmprestimo = (LocalDate) linha[1];
            LocalDate dataDevolucao = (LocalDate) linha[2];
            System.out.println(tituloLivro);
            System.out.println(dataDevolucao);
        }

        req.setAttribute("attr_usuarioHistorico", emprestimosUsuario);
        req.setAttribute("attr_usuario", usuario);
        req.getRequestDispatcher("usuario.jsp").forward(req, resp);
    }

    public void listarTodosUsuarios(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        List<Usuario> usuarioList = usuarioRepository.getAll();
        req.setAttribute("attr_usuarioList", usuarioList);
        req.getRequestDispatcher("todosUsuarios.jsp").forward(req, resp);
    }

    public void delete(Usuario usuario) {

        usuarioRepository.delete(usuario);

    }

}
