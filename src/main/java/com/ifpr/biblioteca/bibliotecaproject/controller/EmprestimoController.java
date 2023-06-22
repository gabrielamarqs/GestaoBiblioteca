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
import com.ifpr.biblioteca.bibliotecaproject.service.EmprestimoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(value = "/emprestimos")
public class EmprestimoController extends HttpServlet {
    Usuario usuario;
    Livro livro;
    Emprestimo emprestimo;
    LivroRepository livroRepository;
    UsuarioRepository usuarioRepository;
    EmprestimoRepository emprestimoRepository;
    LivroController livroController;
    EmprestimoService emprestimoService;

    public EmprestimoController() {
        usuario = new Usuario();
        livro = new Livro();
        emprestimo = new Emprestimo();
        livroRepository = new LivroRepository();
        usuarioRepository = new UsuarioRepository();
        emprestimoRepository = new EmprestimoRepository();
        livroController = new LivroController();
        emprestimoService = new EmprestimoService();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        // situação emprestimo - emprestimo
        if (action != null) {
            if (action.equals("livrosAtrasados")) {
                SituacaoLivro situacaoLivro = SituacaoLivro.ATRASADO;
                req.setAttribute("mostrarColunas", true);
                emprestimoService.livroSituacao(situacaoLivro, req, resp);
            } else if (action.equals("livrosEmprestados")) {
                SituacaoLivro situacaoLivro = SituacaoLivro.EMPRESTADO;
                req.setAttribute("mostrarColunas", true);
                emprestimoService.livroSituacao(situacaoLivro, req, resp);
//                this.livroSituacao(situacaoLivro, req, resp);
            } else if (action.equals("emprestimoHistorico")) {
                req.setAttribute("mostrarColunas", false);
                emprestimoService.livroHistorico(req, resp);
            } else if (action.equals("devolucao")) {
                Long codigo = Long.valueOf(req.getParameter("codigo"));
                req.setAttribute("mostrarColunas", true);
                emprestimoService.livroDevolucao(codigo, req, resp);
            } else if (action.equals("renovar")) {
                Long codigo = Long.valueOf(req.getParameter("codigo"));
                req.setAttribute("mostrarColunas", true);
                emprestimoService.livroRenovar(codigo, req, resp);
            }
        }
    }

//    protected void livroRenovar(Long codigo, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // atualiza o status do livro, do emprestimo e do usuário caso ele esteja bloqueado
//        Emprestimo emprestimoCodigo = emprestimoRepository.findById(codigo);
////        Livro livroCodigo = emprestimoCodigo.getLivro();
//        Usuario usuarioCodigo = emprestimoCodigo.getUsuario();
////        String email = usuarioCodigo.getEmail();
//
//        if (usuarioCodigo.getSituacaoUsuario().equals(SituacaoUsuario.LIVRE)
//                && emprestimoCodigo.getSituacaoEmprestimo().equals(SituacaoEmprestimo.EMPRESTIMO)) {
//            if (LocalDate.now().equals(emprestimoCodigo.getDataDevolucao())) {
//                System.out.println("passou aqui? if");
//                emprestimoCodigo.setDataDevolucao(LocalDate.now());
//                emprestimoRepository.update(emprestimoCodigo);
//                System.out.println(emprestimoCodigo.getDataDevolucao());
//            } else if (LocalDate.now().isBefore(emprestimoCodigo.getDataDevolucao())) {
//                System.out.println("passou aqui? if else");
//                // data nao atualiza
//                LocalDate novaDtaDevolucao = emprestimoCodigo.getDataDevolucao().plusDays(7);
//                emprestimoCodigo.setDataDevolucao(novaDtaDevolucao);
//                emprestimoRepository.update(emprestimoCodigo);
//                System.out.println(emprestimoCodigo.getDataDevolucao());
//            }
//
//            req.setAttribute("mensagem", "Livro renovado com sucesso!");
//            SituacaoLivro situacaoLivro = SituacaoLivro.EMPRESTADO;
//            emprestimoService.livroSituacao(situacaoLivro, req, resp);
//        }
//    }

//    protected void livroDevolucao(Long codigo, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // atualiza o status do livro, do emprestimo e do usuário caso ele esteja bloqueado
//        Emprestimo emprestimoCodigo = emprestimoRepository.findById(codigo);
//        Livro livroCodigo = emprestimoCodigo.getLivro();
//        livroCodigo.setSituacaoLivro(SituacaoLivro.DISPONIVEL);
//        livroRepository.update(livroCodigo);
//        Usuario usuarioCodigo = emprestimoCodigo.getUsuario();
//        usuarioCodigo.setSituacaoUsuario(SituacaoUsuario.LIVRE);
//        usuarioRepository.update(usuarioCodigo);
//        emprestimoCodigo.setSituacaoEmprestimo(SituacaoEmprestimo.DEVOLVIDO);
//        emprestimoRepository.update(emprestimoCodigo);
//        req.setAttribute("mensagem", "Livro devolvido com sucesso!");
//
//        SituacaoLivro situacaoLivro = SituacaoLivro.EMPRESTADO;
//        emprestimoService.livroSituacao(situacaoLivro, req, resp);
//
//    }

//    protected void livroSituacao(SituacaoLivro situacaoLivro, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        System.out.println(situacaoLivro);
//        try {
//            List<Object[]> livrosEmprestados = emprestimoRepository.getAllLivrosSituacao(situacaoLivro);
//
//            req.setAttribute("attr_livrosBiblioteca", livrosEmprestados);
//            req.getRequestDispatcher("emprestimo.jsp").forward(req, resp);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
}


