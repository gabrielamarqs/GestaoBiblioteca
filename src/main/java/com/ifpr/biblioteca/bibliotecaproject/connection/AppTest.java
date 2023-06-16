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
import java.util.List;

public class AppTest {
    public static void main(String[] args) {
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        LivroRepository livroRepository = new LivroRepository();
        EmprestimoRepository emprestimoRepository = new EmprestimoRepository();

        Usuario user = new Usuario();

        user.setNome("admin");
        user.setSobrenome("admin");
        user.setEmail("admin@gmail.com");
        user.setSenha("123456");
        user.setAdmin(Admin.SIM);
//        usuarioRepository.create(user);

        Livro livro = new Livro();
//        livro = livroRepository.findByIsbn("dsnknaskasd");

//        if (livro != null) {
//            livro.setQuantidade(livro.getQuantidade() + 1);
//            livroRepository.update(livro);
//        } else {
//        livro.setAutor("Gustavo");
//        livro.setEditora("Martin Claret");
//        livro.setIsbn("123458");
//        livro.setGenero("romance");
//        livro.setSinopse("sdksnknasknksnwjijwiwjejwe");
//        livro.setNumeroPaginas(1500);
//        livro.setSituacaoLivro(SituacaoLivro.DISPONIVEL);
//        livro.setTitulo("java 2");

//        livroRepository.create(livro);
//
//        }
//


        Livro l1 = livroRepository.findById(10L);
        Usuario u1 = usuarioRepository.getUserByEmail("gabriela2013.ms@gmail.com");
        // o que fazer quando o usuario n existe
//
        Emprestimo emprestimo = new Emprestimo();
//
//        emprestimo.setLivro(l1);
//        emprestimo.setUsuario(u1);
//        emprestimo.setDataEmprestimo(LocalDate.parse("2022-05-07"));
//        emprestimo.setDataDevolucao();
//        emprestimoRepository.create(emprestimo);

        Usuario usuario = usuarioRepository.findById(2L);
        String  usuario2 = usuario.getEmail();
        List<Object[]> emprestimosUsuario = emprestimoRepository.getAllEmprestimoUsuario(usuario2);

        for (Object[] linha : emprestimosUsuario) {
            String tituloLivro = (String) linha[0];
            LocalDate dataEmprestimo = (LocalDate) linha[1];
            LocalDate dataDevolucao = (LocalDate) linha[2];

            // Faça o que desejar com os valores obtidos
            System.out.println("Título do livro: " + tituloLivro);
            System.out.println("Data de Empréstimo: " + dataEmprestimo);
            System.out.println("Data de Devolução: " + dataDevolucao);
        }
////
    }
}
