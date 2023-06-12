package com.ifpr.biblioteca.bibliotecaproject.domain.entities;

import com.ifpr.biblioteca.bibliotecaproject.domain.enums.SituacaoLivro;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity(name = "tb_livro")
// TODO
// mudar para tb_livros
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "livro_codigo")
    private Long codigoLivro;
    @Column(name = "livro_titulo")
    private String titulo;
    @Column(name = "livro_autor")
    private String autor;
    @Column(name = "livro_sinopse")
    private String sinopse;
    @Column(name = "livro_editora")
    private String editora;
    @Column(name = "livro_isbn", unique = true)
    private String isbn;
    @Column(name = "livro_genero")
    private String genero;
    @Column(name = "livro_numeroPaginas")
    private Integer numeroPaginas;

    @Column(name = "livro_dtaPublicacao")
    private LocalDate dtaPublicacao;

    @Column(name = "livro_qtde")
    private Integer quantidade;

    @Enumerated(value = EnumType.STRING)
    private SituacaoLivro situacaoLivro;

    @OneToMany(mappedBy = "livro")
    private Set<Emprestimo> emprestimo;

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDtaPublicacao() {
        return dtaPublicacao;
    }

    public void setDtaPublicacao(LocalDate dtaPublicacao) {
        this.dtaPublicacao = dtaPublicacao;
    }

    public SituacaoLivro getSituacaoLivro() {
        return situacaoLivro;
    }

    public SituacaoLivro getSituacaoLivro(SituacaoLivro disponivel) {
        return situacaoLivro;
    }

    public void setSituacaoLivro(SituacaoLivro situacaoLivro) {
        this.situacaoLivro = situacaoLivro;
    }

    public Set<Emprestimo> getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Set<Emprestimo> emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Long getCodigoLivro() {
        return codigoLivro;
    }

    public void setCodigoLivro(Long codigoLivro) {
        this.codigoLivro = codigoLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "codigoLivro=" + codigoLivro +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", editora='" + editora + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genero='" + genero + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", situacaoLivro=" + situacaoLivro +
                ", emprestimo=" + emprestimo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Livro livro = (Livro) o;

        return Objects.equals(codigoLivro, livro.codigoLivro);
    }

    @Override
    public int hashCode() {
        return codigoLivro != null ? codigoLivro.hashCode() : 0;
    }
}
