package com.ifpr.biblioteca.bibliotecaproject.service;

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
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class EmprestimoService {
    Emprestimo emprestimo;
    EmprestimoRepository emprestimoRepository;
    Livro livro;
    LivroRepository livroRepository;
    UsuarioRepository usuarioRepository;

    public EmprestimoService() {
        emprestimo = new Emprestimo();
        emprestimoRepository = new EmprestimoRepository();
        livroRepository = new LivroRepository();
        usuarioRepository = new UsuarioRepository();
    }

    public void livroSituacao(SituacaoLivro situacaoLivro, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(situacaoLivro);
        try {
            List<Object[]> livrosEmprestados = emprestimoRepository.getAllLivrosSituacao(situacaoLivro);

            req.setAttribute("attr_livrosBiblioteca", livrosEmprestados);
            req.getRequestDispatcher("emprestimo.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void livroHistorico(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Object[]> livrosEmprestados = emprestimoRepository.getAllLivrosHistorico();

            req.setAttribute("attr_livrosBiblioteca", livrosEmprestados);
            req.getRequestDispatcher("emprestimo.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void livroRenovar(Long codigo, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // atualiza o status do livro, do emprestimo e do usuário caso ele esteja bloqueado
        Emprestimo emprestimoCodigo = emprestimoRepository.findById(codigo);
//        Livro livroCodigo = emprestimoCodigo.getLivro();
        Usuario usuarioCodigo = emprestimoCodigo.getUsuario();
//        String email = usuarioCodigo.getEmail();

        if (usuarioCodigo.getSituacaoUsuario().equals(SituacaoUsuario.LIVRE)
                && emprestimoCodigo.getSituacaoEmprestimo().equals(SituacaoEmprestimo.EMPRESTIMO)) {
            if (LocalDate.now().equals(emprestimoCodigo.getDataDevolucao())) {
                System.out.println("passou aqui? if");
                emprestimoCodigo.setDataDevolucao(LocalDate.now());
                emprestimoRepository.update(emprestimoCodigo);
                System.out.println(emprestimoCodigo.getDataDevolucao());
            } else if (LocalDate.now().isBefore(emprestimoCodigo.getDataDevolucao())) {
                System.out.println("passou aqui? if else");
                // data nao atualiza
                LocalDate novaDtaDevolucao = emprestimoCodigo.getDataDevolucao().plusDays(7);
                emprestimoCodigo.setDataDevolucao(novaDtaDevolucao);
                emprestimoRepository.update(emprestimoCodigo);
                System.out.println(emprestimoCodigo.getDataDevolucao());
            }

            req.setAttribute("mensagem", "Livro renovado com sucesso!");
            SituacaoLivro situacaoLivro = SituacaoLivro.EMPRESTADO;
            this.livroSituacao(situacaoLivro, req, resp);
        }
    }

    public void livroDevolucao(Long codigo, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // atualiza o status do livro, do emprestimo e do usuário caso ele esteja bloqueado
        Emprestimo emprestimoCodigo = emprestimoRepository.findById(codigo);
        Livro livroCodigo = emprestimoCodigo.getLivro();
        livroCodigo.setSituacaoLivro(SituacaoLivro.DISPONIVEL);
        livroRepository.update(livroCodigo);
        Usuario usuarioCodigo = emprestimoCodigo.getUsuario();
        usuarioCodigo.setSituacaoUsuario(SituacaoUsuario.LIVRE);
        usuarioRepository.update(usuarioCodigo);
        emprestimoCodigo.setSituacaoEmprestimo(SituacaoEmprestimo.DEVOLVIDO);
        emprestimoCodigo.setDataDevolucao(LocalDate.now());
        // não atualizou tbm
        emprestimoRepository.update(emprestimoCodigo);
        req.setAttribute("mensagem", "Livro devolvido com sucesso!");

        SituacaoLivro situacaoLivro = SituacaoLivro.EMPRESTADO;
        this.livroSituacao(situacaoLivro, req, resp);

    }
}
