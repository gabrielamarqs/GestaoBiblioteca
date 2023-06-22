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

    public LivroController() {
        livro = new Livro();
        livroRepository = new LivroRepository();
        usuarioRepository = new UsuarioRepository();
        emprestimoRepository = new EmprestimoRepository();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null) {
            this.listar(req, resp);
            // TODO
            // por isso aqui dentro da service
        } else if (action.equals("redirecionar")) {
            req.getRequestDispatcher("cadastroLivro.jsp").forward(req, resp);
        } else if (action.equals("cadastrar")) {

            this.cadastrar(req, resp);

        } else if (action.equals("emprestar")) {

            Long codigo = Long.valueOf(req.getParameter("codigo"));
            String email = req.getParameter("email");
            this.emprestar(codigo, email, req, resp);

        } else if (action.equals("buscar")) {

            this.buscar(req, resp);

        } else {
            this.listar(req, resp);
        }
    }

    protected void emprestar(Long codigo, String email, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Emprestimo emprestimo = new Emprestimo();
        Livro livroBuscado;
        Usuario usuarioEmail;

        livroBuscado = livroRepository.findById(codigo);
        usuarioEmail = usuarioRepository.getUserByEmail(email);

        System.out.println(livroBuscado.getSituacaoLivro());

        if (livroBuscado.getSituacaoLivro().equals(SituacaoLivro.DISPONIVEL) && usuarioEmail.getSituacaoUsuario().equals(SituacaoUsuario.LIVRE)) {

            livroBuscado.setSituacaoLivro(SituacaoLivro.EMPRESTADO);

            emprestimo.setLivro(livroBuscado);
            emprestimo.setUsuario(usuarioEmail);
            emprestimo.setDataEmprestimo(LocalDate.now());
            emprestimo.setDataDevolucao(LocalDate.now().plusDays(7));
            emprestimo.setSituacaoEmprestimo(SituacaoEmprestimo.EMPRESTIMO);
            emprestimoRepository.create(emprestimo);

            livroRepository.update(livroBuscado);

        } else {
            String errorMessage = "Ocorreu um erro interno ao processar a requisição.";
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // Definir código de status 500
            req.setAttribute("errorMessage", errorMessage);
            System.out.println(errorMessage);
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }

        resp.sendRedirect("http://localhost:8080/app/home");
    }

    protected void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Livro> livros = livroRepository.getAll();
        req.setAttribute("attr_livros", livros);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

    protected void buscar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String buscar = req.getParameter("buscar");
        List<Livro> livros = livroRepository.getByName(buscar);
        req.setAttribute("attr_livros", livros);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }


    protected void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String fieldTitulo = req.getParameter("field_titulo");
            String fieldAutor = req.getParameter("field_autor");
            String fieldSinopse = req.getParameter("field_sinopse");
            String fieldEditora = req.getParameter("field_editora");
            String fieldIsbn = req.getParameter("field_isbn");
            String fieldGenero = req.getParameter("field_genero");
            String fieldPagina = req.getParameter("field_pagina");

            // assumindo que o isbn é unico

            livro.setTitulo(fieldTitulo);
            livro.setAutor(fieldAutor);
            livro.setSinopse(fieldSinopse);
            livro.setEditora(fieldEditora);
            livro.setIsbn(fieldIsbn);
            livro.setGenero(fieldGenero);
            livro.setNumeroPaginas(Integer.valueOf(fieldPagina));
            livro.setSituacaoLivro(SituacaoLivro.DISPONIVEL);

            livroRepository.create(livro);

            resp.sendRedirect("http://localhost:8080/app/livros");

        } catch (NumberFormatException e1) {
            String message = "Número de páginas é um número inteiro";
            req.setAttribute("message", message);
            req.getRequestDispatcher("cadastroLivro.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Erro" + e.getMessage());
        }


    }


}
