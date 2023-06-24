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
}


