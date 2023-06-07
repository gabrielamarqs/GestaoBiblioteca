package com.ifpr.biblioteca.bibliotecaproject.repository;

import com.ifpr.biblioteca.bibliotecaproject.connection.ConnectionFactory;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Emprestimo;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class EmprestimoRepository {
    private EntityManager entityManager;

    private EntityTransaction transaction;

    public EmprestimoRepository() {
        this.entityManager = ConnectionFactory.getConnection();
        this.transaction = entityManager.getTransaction();
    }

    public Emprestimo findById(Long id) {
        Emprestimo emprestimo = entityManager.find(Emprestimo.class, id);
        return emprestimo;
    }

    public Emprestimo create(Emprestimo emprestimo) {
        transaction.begin();
        entityManager.persist(emprestimo);
        transaction.commit();
        return emprestimo;
    }

    public List<Emprestimo> getAll() {
        return entityManager.createQuery("SELECT e FROM tb_emprestimo e", Emprestimo.class).getResultList();
    }

    public void remove(Emprestimo emprestimo){
        entityManager.getTransaction().begin();
        entityManager.remove(emprestimo);
        entityManager.getTransaction().commit();
    }
}
