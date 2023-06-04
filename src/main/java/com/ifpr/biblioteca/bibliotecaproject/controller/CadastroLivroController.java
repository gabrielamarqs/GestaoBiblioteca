package com.ifpr.biblioteca.bibliotecaproject.controller;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
import com.ifpr.biblioteca.bibliotecaproject.repository.BookRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/cadastro_livro")
public class CadastroLivroController {
    Livro book;
    BookRepository bookRepository;

    public CadastroLivroController() {
        book = new Livro();
        bookRepository = new BookRepository();
    }

    public static void main(String[] args) {
        //TODO
        // pegar todos os meus atributos (criar neh no jsp
        //
    }
}
