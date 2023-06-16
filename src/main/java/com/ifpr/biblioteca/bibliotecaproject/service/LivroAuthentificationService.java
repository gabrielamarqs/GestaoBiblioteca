package com.ifpr.biblioteca.bibliotecaproject.service;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
import com.ifpr.biblioteca.bibliotecaproject.exception.UsuarioInexistenteException;
import com.ifpr.biblioteca.bibliotecaproject.repository.LivroRepository;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class LivroAuthentificationService {

    LivroRepository livroRepository;

    public LivroAuthentificationService() {
        livroRepository = new LivroRepository();
    }

    public Livro validateLivro(String isbn, HttpServletRequest request) throws Exception {

        if (isbn == null || isbn.isEmpty()) {
            throw new Exception("Isbn inválido");
        }

        Livro livro = livroRepository.findByIsbn(isbn);

        if (livro == null) {
            throw new UsuarioInexistenteException("Esse livro não existe.");
        }

        return livro;

    }
}
