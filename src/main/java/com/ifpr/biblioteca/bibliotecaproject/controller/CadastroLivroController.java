package com.ifpr.biblioteca.bibliotecaproject.controller;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.SituacaoLivro;
import com.ifpr.biblioteca.bibliotecaproject.repository.LivroRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@WebServlet(value = "/cadastro_livro")
public class CadastroLivroController extends HttpServlet {
    Livro livro;
    LivroRepository livroRepository;

    public CadastroLivroController() {
        livro = new Livro();
        livroRepository = new LivroRepository();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String fieldTitulo = req.getParameter("field_titulo");
            String fieldAutor = req.getParameter("field_autor");
            String fieldSinopse = req.getParameter("field_sinopse");
            String fieldEditora = req.getParameter("field_editora");
            String fieldIsbn = req.getParameter("field_isbn");
            String fieldGenero = req.getParameter("field_genero");
            String fieldPagina = req.getParameter("field_pagina");
            String fieldPublicacao = req.getParameter("field_publicacao");

            Livro livroFindByIsbn = livroRepository.findByIsbn(fieldIsbn);

            if (livroFindByIsbn != null) {
                livroFindByIsbn.setQuantidade(livroFindByIsbn.getQuantidade() + 1);
                livroRepository.update(livroFindByIsbn);
            } else {
                livro.setTitulo(fieldTitulo);
                livro.setAutor(fieldAutor);
                livro.setSinopse(fieldSinopse);
                livro.setEditora(fieldEditora);
                livro.setIsbn(fieldIsbn);
                livro.setGenero(fieldGenero);
                livro.setNumeroPaginas(Integer.valueOf(fieldPagina));
                livro.setDtaPublicacao(LocalDate.parse(fieldPublicacao));
                livro.setQuantidade(1);
                livro.setSituacaoLivro(livro.getSituacaoLivro(SituacaoLivro.DISPONIVEL));

                livroRepository.create(livro);
            }



            resp.sendRedirect("http://localhost:8080/app/controller_livro");

        } catch (DateTimeParseException e1) {
            String message = "Formato de data incorreto";
            req.setAttribute("message", message);
            req.getRequestDispatcher("cadastroLivro.jsp").forward(req, resp);
        } catch (Exception e) {

        }



    }
}
