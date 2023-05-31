package com.ifpr.biblioteca.bibliotecaproject.domain.entities;

import java.util.Date;

public class Emprestimo {
    private Long codigoEmprestimo;
    private Livro livro;
    private Usuario usuario;
    private Date dataEmprestimo;

    private Date dataDevolucao;

}
