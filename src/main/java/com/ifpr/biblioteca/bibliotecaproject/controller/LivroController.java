package com.ifpr.biblioteca.bibliotecaproject.controller;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Emprestimo;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.SituacaoEmprestimo;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.SituacaoLivro;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.SituacaoUsuario;
import com.ifpr.biblioteca.bibliotecaproject.repository.EmprestimoRepository;
import com.ifpr.biblioteca.bibliotecaproject.repository.LivroRepository;
import com.ifpr.biblioteca.bibliotecaproject.repository.UsuarioRepository;
import com.ifpr.biblioteca.bibliotecaproject.service.LivroService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(value = "/livros")
public class LivroController extends HttpServlet {
    Livro livro;
    LivroRepository livroRepository;
    UsuarioRepository usuarioRepository;
    EmprestimoRepository emprestimoRepository;
    LivroService livroService;

    public LivroController() {
        livro = new Livro();
        livroRepository = new LivroRepository();
        usuarioRepository = new UsuarioRepository();
        emprestimoRepository = new EmprestimoRepository();
        livroService = new LivroService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null) {

            livroService.listar(req, resp);

        } else if (action.equals("redirecionar")) {

            req.getRequestDispatcher("cadastroLivro.jsp").forward(req, resp);

        } else if (action.equals("cadastrar")) {

            livroService.cadastrar(req, resp);

        } else if (action.equals("emprestar")) {

            Long codigo = Long.valueOf(req.getParameter("codigo"));
            String email = req.getParameter("email");
            livroService.emprestar(codigo, email, req, resp);

        } else if (action.equals("buscar")) {

            livroService.buscar(req, resp);

        } else {

            livroService.listar(req, resp);

        }
    }
}