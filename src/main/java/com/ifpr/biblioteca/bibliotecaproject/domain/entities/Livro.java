package com.ifpr.biblioteca.bibliotecaproject.domain.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity(name = "tb_livro")
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
    @Column(name = "livro_isbn")
    private String isbn;
    @Column(name = "livro_dtaPublicacao")
    private Date dataPublicacao;
    @Column(name = "livro_genero")
    private String genero;
    @Column(name = "livro_numeroPaginas")
    private Integer numeroPaginas;

    // perguntar do enum
    private enum situacao{
        DISPONIVEL,
        INDISPONIVEL,
        INATIVO
    };

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

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
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
                ", dataPublicacao=" + dataPublicacao +
                ", genero='" + genero + '\'' +
                ", numeroPaginas=" + numeroPaginas +
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
