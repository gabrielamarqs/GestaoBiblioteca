package com.ifpr.biblioteca.bibliotecaproject.controller;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Emprestimo;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import com.ifpr.biblioteca.bibliotecaproject.repository.EmprestimoRepository;
import com.ifpr.biblioteca.bibliotecaproject.repository.LivroRepository;
import com.ifpr.biblioteca.bibliotecaproject.repository.UsuarioRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/emprestimo_controller")
public class EmprestimosController extends HttpServlet {
    Usuario usuario;
    Livro livro;
    Emprestimo emprestimo;
    LivroRepository livroRepository;
    UsuarioRepository usuarioRepository;
    EmprestimoRepository emprestimoRepository;

    public EmprestimosController() {
        usuario = new Usuario();
        livro = new Livro();
        emprestimo = new Emprestimo();
        livroRepository = new LivroRepository();
        usuarioRepository = new UsuarioRepository();
        emprestimoRepository = new EmprestimoRepository();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO
        // 1 - criar uma nova pagina só para cadastro de empréstimo
        // ---- a - colocar nela só o email e o isbn
        // ---- b - quando clicar em cadastrar o empréstimo quero que mostre os livros emprestados para aquele email e caso não dê para cadastrar o motivo (usuario bloqueado, livro indisponivel, livro inexistente)
        // ---- c - botão sair dai, ai vai pra página de empréstimos
        // 2 - fazer toda a lógica do usuario
        // --- a - livros emprestados no momento
        // --- b - livros atrasados se tiver
        // --- c - histórico de livros e quantas vezes foram renovados
    }
}
