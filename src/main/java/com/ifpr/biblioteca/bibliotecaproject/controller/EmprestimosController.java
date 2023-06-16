//package com.ifpr.biblioteca.bibliotecaproject.controller;
//
//import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Emprestimo;
//import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
//import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
//import com.ifpr.biblioteca.bibliotecaproject.domain.enums.SituacaoLivro;
//import com.ifpr.biblioteca.bibliotecaproject.domain.enums.SituacaoUsuario;
//import com.ifpr.biblioteca.bibliotecaproject.repository.EmprestimoRepository;
//import com.ifpr.biblioteca.bibliotecaproject.repository.LivroRepository;
//import com.ifpr.biblioteca.bibliotecaproject.repository.UsuarioRepository;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.time.LocalDate;
//
//@WebServlet(value = "/emprestimo_controller")
//public class EmprestimosController extends HttpServlet {
//    Usuario usuario;
//    Livro livro;
//    Emprestimo emprestimo;
//    LivroRepository livroRepository;
//    UsuarioRepository usuarioRepository;
//    EmprestimoRepository emprestimoRepository;
//
//    public EmprestimosController() {
//        usuario = new Usuario();
//        livro = new Livro();
//        emprestimo = new Emprestimo();
//        livroRepository = new LivroRepository();
//        usuarioRepository = new UsuarioRepository();
//        emprestimoRepository = new EmprestimoRepository();
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            String fieldEmail = req.getParameter("field_email");
//            String fieldIsbn = req.getParameter("field_isbn");
//            String action = req.getParameter("action");
//
//            try {
//                usuario = usuarioRepository.getUserByEmail(fieldEmail);
//            } catch (Exception e1) {
//                String messageUsuario = "Usuario não cadastrado.";
//                req.setAttribute("messageUsuario", messageUsuario);
//                req.getRequestDispatcher("emprestimo.jsp").forward(req, resp);
//            }
//
//            try {
//                livro = livroRepository.findByIsbn(fieldIsbn);
//            } catch (Exception e2) {
//                String messageLivro = "Livro não encontrado.";
//                req.setAttribute("messageLivro", messageLivro);
//                req.getRequestDispatcher("emprestimo.jsp").forward(req, resp);
//            }
//
//            if (usuario.getSituacaoUsuario() == SituacaoUsuario.LIVRE) {
//
////                Integer qtd = livro.getQuantidade();
////                if (qtd == 0) {
//                    livro.setSituacaoLivro(SituacaoLivro.INDISPONIVEL);
//                    livroRepository.update(livro);
//                }
//                if (livro.getSituacaoLivro() == SituacaoLivro.DISPONIVEL) {
//                    emprestimo.setUsuario(usuario);
//                    emprestimo.setLivro(livro);
//                    emprestimo.setDataEmprestimo(LocalDate.now());
//                    emprestimo.setDataDevolucao();
//                    emprestimoRepository.create(emprestimo);
//
////                    livro.setQuantidade(livro.getQuantidade() - 1);
//                    livroRepository.update(livro);
//
//                    resp.sendRedirect("http://localhost:8080/app/emprestimo.jsp");
//                } else {
//                    String messageLivro = "Livro indisponível.";
//                    req.setAttribute("messageLivro", messageLivro);
//                    req.getRequestDispatcher("emprestimo.jsp").forward(req, resp);                }
//            } else {
//                String messageUsuario = "Usuário bloqueado.";
//                req.setAttribute("messageUsuario", messageUsuario);
//                req.getRequestDispatcher("emprestimo.jsp").forward(req, resp);
//            }
////
////            if (action != null && action.equals("historico")) {
//
//            }
//
//
//
//
//            } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        // TODO
//        // 1 - criar uma nova pagina só para cadastro de empréstimo
//        // ---- a - colocar nela só o email e o isbn
//        // ---- b - quando clicar em cadastrar o empréstimo quero que mostre os livros emprestados para aquele email e caso não dê para cadastrar o motivo (usuario bloqueado, livro indisponivel, livro inexistente)
//        // ---- c - botão sair dai, ai vai pra página de empréstimos
//        // 2 - fazer toda a lógica do usuario
//        // --- a - livros emprestados no momento
//        // --- b - livros atrasados se tiver
//        // --- c - histórico de livros e quantas vezes foram renovados
//
//        // TODO
//        // como mostrar naquela página os dados do email que eu cadastrei o empréstimo
//        // mesmo que não cadastre o empréstimo
//
//        // TODO
//        // preciso editar minhas páginas web
//
//        // TODO
//        // arrumar o neg do meu cadastro livro
//    }
//}
