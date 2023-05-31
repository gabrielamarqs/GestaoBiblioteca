package com.ifpr.biblioteca.bibliotecaproject.connection;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import com.ifpr.biblioteca.bibliotecaproject.repository.BookRepository;
import com.ifpr.biblioteca.bibliotecaproject.repository.UserRepository;

public class AppTest {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        Usuario user = new Usuario();

        user.setNome("Maria");
        user.setSobrenome("Santos");
        user.setEmail("ma_sa@gmail.com");
        user.setSenha("123456");

        userRepository.create(user);

        BookRepository bookRepository = new BookRepository();
        Livro livro = new Livro();

        livro.setTitulo("Java");
        livro.setAutor("Gustavo");
        livro.setEditora("Martin Claret");
        livro.setIsbn("dsnknaskasd");
        livro.setGenero("romance");
        livro.setSinopse("sdksnknasknksnwjijwiwjejwe");
        livro.setNumeroPaginas(1500);

        bookRepository.create(livro);
    }
}
