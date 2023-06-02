package com.ifpr.biblioteca.bibliotecaproject.controller;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
import com.ifpr.biblioteca.bibliotecaproject.repository.BookRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeController extends HttpServlet {

    BookRepository livroRepository;

    public HomeController() {
        livroRepository = new BookRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //chmar validacao de login

        List<Livro> livros = livroRepository.getAll();
        req.setAttribute("attr_livros", livros);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
        requestDispatcher.forward(req, resp);

    }
}
