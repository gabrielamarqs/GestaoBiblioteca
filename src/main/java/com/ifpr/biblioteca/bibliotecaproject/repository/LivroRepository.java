package com.ifpr.biblioteca.bibliotecaproject.repository;

import com.ifpr.biblioteca.bibliotecaproject.connection.ConnectionFactory;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Emprestimo;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class LivroRepository {

    private EntityManager entityManager;

    private EntityTransaction transaction;

    public LivroRepository() {
        this.entityManager = ConnectionFactory.getConnection();
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
        return entityManager.createQuery("select l from tb_livro l  where l.isbn = :isbn", Livro.class).setParameter("isbn", isbn).getSingleResult();

    }

    // listar todos os livros
    public List<Livro> getAll() {
        return entityManager.createQuery("SELECT l FROM tb_livro l", Livro.class).getResultList();
    }

    // alterar
    public Livro update(Livro livro){
        transaction.begin();
        livro = entityManager.merge(livro);
        transaction.commit();
        return livro;
    }

    public void remove(Livro livro){
        entityManager.getTransaction().begin();
        entityManager.remove(livro);
        entityManager.getTransaction().commit();
    }
}
