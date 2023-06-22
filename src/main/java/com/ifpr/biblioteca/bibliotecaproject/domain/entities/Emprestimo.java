package com.ifpr.biblioteca.bibliotecaproject.domain.entities;

import com.ifpr.biblioteca.bibliotecaproject.domain.enums.SituacaoEmprestimo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "tb_emprestimos")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emprestimo_codigo")
    private Long codigoEmprestimo;
    @ManyToOne
    @JoinColumn(name = "usuario_codigo")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "livro_codigo")
    private Livro livro;
    @Column(name = "livro_dtaEmprestimo")
    private LocalDate dataEmprestimo;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "emprestimo_situacao")
    private SituacaoEmprestimo situacaoEmprestimo;
    @Column(name = "livro_renovacao")
    private Integer renovacao;
    @Column(name = "livro_dtaDevolucao")
    private LocalDate dataDevolucao;

    public SituacaoEmprestimo getSituacaoEmprestimo() {
        return situacaoEmprestimo;
    }

    public void setSituacaoEmprestimo(SituacaoEmprestimo situacaoEmprestimo) {
        this.situacaoEmprestimo = situacaoEmprestimo;
    }

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
        // todo
        // dar uma olhada aqui
        this.dataDevolucao = dataDevolucao;    }

    @Override
    public String toString() {
        return "Emprestimo{" +
//                "codigoEmprestimo=" + codigoEmprestimo +
                ", usuario=" + usuario +
                ", livro=" + livro +
                ", dataEmprestimo=" + dataEmprestimo +
                ", renovacao=" + renovacao +
                ", dataDevolucao=" + dataDevolucao +
                '}';
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
