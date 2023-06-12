package com.ifpr.biblioteca.bibliotecaproject.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "tb_emprestimo")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoEmprestimo;
    @ManyToOne
    @JoinColumn(name = "usuario_codigo")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "livro_codigo")
    private Livro livro;
    @Column(name = "livro_dtaEmprestimo")
    private LocalDate dataEmprestimo;

    @Column(name = "livro_renovacao")
    private Integer renovacao;
    @Column(name = "livro_dtaEmprestimo")
    private LocalDate dataDevolucao;

    public Integer getRenovacao() {
        return renovacao;
    }

    public void setRenovacao(Integer renovacao) {
        this.renovacao = renovacao;
    }

    public Long getCodigoEmprestimo() {
        return codigoEmprestimo;
    }

    public void setCodigoEmprestimo(Long codigoEmprestimo) {
        this.codigoEmprestimo = codigoEmprestimo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {

        this.dataDevolucao = dataEmprestimo.plusDays(7);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emprestimo that = (Emprestimo) o;

        return Objects.equals(codigoEmprestimo, that.codigoEmprestimo);
    }

    @Override
    public int hashCode() {
        return codigoEmprestimo != null ? codigoEmprestimo.hashCode() : 0;
    }
}
