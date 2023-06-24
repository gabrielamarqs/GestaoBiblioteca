package com.ifpr.biblioteca.bibliotecaproject.repository;

import com.ifpr.biblioteca.bibliotecaproject.connection.ConnectionFactory;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Emprestimo;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.SituacaoLivro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class LivroRepository {

    private EntityManager entityManager;

    private EntityTransaction transaction;

    public LivroRepository() {
        this.entityManager = ConnectionFactory.getConnection();
        this.entityManager.getEntityManagerFactory().getCache().evictAll();
        this.transaction = entityManager.getTransaction();
    }

    // criar um dado no bd
    public Livro create(Livro livro) {
        transaction.begin();
        entityManager.persist(livro);
        transaction.commit();
        return livro;
    }

    // encontrar pelo id
    public Livro findById(Long id) {
        Livro livro = entityManager.find(Livro.class, id);
        return livro;
    }

    public Livro findByIsbn(String isbn) {
        return entityManager.createQuery("select l from tb_livros l  where l.isbn = :isbn", Livro.class).setParameter("isbn", isbn).getSingleResult();

    }

    // listar todos os livros
    public List<Livro> getAll() {
        entityManager.getEntityManagerFactory().getCache().evictAll();

        return entityManager.createQuery("SELECT l FROM tb_livros l order by l.titulo", Livro.class).getResultList();
    }

    public List<Livro> getAllLivrosDisponiveis(SituacaoLivro situacao) {
        return entityManager.createQuery("SELECT l FROM tb_livros l WHERE l.situacaoLivro = :situacao ORDER BY l.codigoLivro", Livro.class).setParameter("situacao", situacao).getResultList();
    }


    // alterar
    public Livro update(Livro livro){
        transaction.begin();
        livro = entityManager.merge(livro);
        transaction.commit();
        entityManager.detach(livro);

        return livro;
    }

    public void remove(Livro livro){
        entityManager.getTransaction().begin();
        entityManager.remove(livro);
        entityManager.getTransaction().commit();
    }

    public List<Livro> getByName(String tituloBuscado) {

        TypedQuery<Livro> query =  entityManager.createQuery("SELECT l FROM tb_livros l WHERE l.titulo LIKE :titulo", Livro.class);

        query =  query.setParameter("titulo", "%" +tituloBuscado + "%");

        return query.getResultList();

    }
}
