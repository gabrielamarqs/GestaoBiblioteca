package com.ifpr.biblioteca.bibliotecaproject.controller;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import com.ifpr.biblioteca.bibliotecaproject.repository.EmprestimoRepository;
import com.ifpr.biblioteca.bibliotecaproject.repository.UsuarioRepository;
import com.ifpr.biblioteca.bibliotecaproject.service.AuthentificationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(value ="/usuarios")
public class UsuarioController extends HttpServlet {
    Usuario usuario;
    UsuarioRepository usuarioRepository;
    EmprestimoRepository emprestimoRepository;
    AuthentificationService authentificationService;

    public UsuarioController() {
        usuario = new Usuario();
        usuarioRepository = new UsuarioRepository();
        authentificationService = new AuthentificationService();
        emprestimoRepository = new EmprestimoRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuarioLogado = authentificationService.isUserLoggedIn(req);

        String action = req.getParameter("action");

        if (usuarioLogado != null) {
            if (action != null && action.equals("usuario")) {
                String email = usuarioLogado.getEmail();
                usuario = usuarioRepository.getUserByEmail(email);
                System.out.println(email);
                req.setAttribute("attr_usuario", usuario);
                req.getRequestDispatcher("usuario.jsp").forward(req, resp);
            }
        }
    }

    protected void livroHistorico(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Usuario usuario = usuarioRepository.findById(2L);
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
        }    }

    // TODO:
    // arrumar meu design
    // arrumar meus livros
    // fazer as minhas coisitas

}



