package com.ifpr.biblioteca.bibliotecaproject.controller;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
import com.ifpr.biblioteca.bibliotecaproject.repository.LivroRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/cadastro_livro")
public class LivroController extends HttpServlet {
    Livro book;
    LivroRepository livroRepository;

    public LivroController() {
        book = new Livro();
        livroRepository = new LivroRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Livro> livros = livroRepository.getAll();
        req.setAttribute("attr_livros", livros);
        req.getRequestDispatcher("livro.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");


        if ("livroCadastrar".equals(action)) {

            // TODO:
            // fazer meu cadastrar livro
            // fazer minhas regras de negocio la no emprestimo
            // conseguir que apartir do cadastro do usuario a pessoa vá direto para a tela home

        } else if ("livrosIndisponiveis".equals("action")) {

        } else if ("livrosAtrasados".equals("action")) {

        }
    }
}
