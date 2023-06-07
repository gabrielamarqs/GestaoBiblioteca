package com.ifpr.biblioteca.bibliotecaproject.controller;

import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import com.ifpr.biblioteca.bibliotecaproject.service.AuthentificationService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/home")
public class ServletFilter implements Filter {
    AuthentificationService service;

    public ServletFilter() {
        service = new AuthentificationService();
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        service = new AuthentificationService();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResp = (HttpServletResponse) servletResponse;
        // essas duas linhas fazem um cast dos objetos das classes servlet para poderem utilizar os métodos específicos do protocolo http

        Usuario usuarioReq = service.isUserLoggedIn(httpReq);
        // verifica se o usuário está logado

        if (usuarioReq != null) {
            // se o usuario estiver logado continua
            filterChain.doFilter(servletRequest, servletResponse);
            // encaminha a requisição para o próximo filtro ou pra servlet final
        } else {
            httpResp.sendRedirect("http://localhost:8080/app/index.jsp");
        }


//        if (!true) {
//        // o que é true ???
//            System.out.println("Unauthorized access request");
//            res.sendRedirect("login.html");
//        } else {
//            // pass the request along the filter chain
//            chain.doFilter(req, res);
//        }
//
//        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
