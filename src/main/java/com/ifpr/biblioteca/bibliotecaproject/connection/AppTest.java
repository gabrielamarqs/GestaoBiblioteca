package com.ifpr.biblioteca.bibliotecaproject.connection;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Emprestimo;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.Admin;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.SituacaoLivro;
import com.ifpr.biblioteca.bibliotecaproject.repository.EmprestimoRepository;
import com.ifpr.biblioteca.bibliotecaproject.repository.LivroRepository;
import com.ifpr.biblioteca.bibliotecaproject.repository.UsuarioRepository;

import java.time.LocalDate;

public class AppTest {
    public static void main(String[] args) {
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        LivroRepository livroRepository = new LivroRepository();
        EmprestimoRepository emprestimoRepository = new EmprestimoRepository();

        Usuario user = new Usuario();

//        user.setNome("admin");
//        user.setSobrenome("admin");
//        user.setEmail("admin@gmail.com");
//        user.setSenha("123456");
//        user.setAdmin(Admin.SIM);
//        usuarioRepository.create(user);

        Livro livro = new Livro();
        livro = livroRepository.findByIsbn("dsnknaskasd");

//        if (livro != null) {
//            livro.setQuantidade(livro.getQuantidade() + 1);
//            livroRepository.update(livro);
//        } else {
//            livro.setTitulo("java 2");
//            livro.setAutor("Gustavo");
//            livro.setEditora("Martin Claret");
//            livro.setIsbn("dsnknaskasd");
//            livro.setGenero("romance");
//            livro.setSinopse("sdksnknasknksnwjijwiwjejwe");
//            livro.setNumeroPaginas(1500);
//            livro.setQuantidade(1);
//            livro.setSituacaoLivro(SituacaoLivro.DISPONIVEL);
//            livroRepository.create(livro);
//        }
//


//        Livro l1 = livroRepository.findById(2L);
        Usuario u1 = usuarioRepository.getUserByEmail("mary@g.com");

        Emprestimo emprestimo = new Emprestimo();

        emprestimo.setLivro(livro);
        emprestimo.setUsuario(u1);
        emprestimo.setDataEmprestimo(LocalDate.parse("2022-05-07"));
        emprestimo.setDataDevolucao(LocalDate.parse("2022-05-07"));
        emprestimoRepository.create(emprestimo);
    }
}
