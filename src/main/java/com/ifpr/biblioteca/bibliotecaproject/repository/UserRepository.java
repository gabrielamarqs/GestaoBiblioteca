package com.ifpr.biblioteca.bibliotecaproject.repository;

import com.ifpr.biblioteca.bibliotecaproject.connection.ConnectionFactory;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transaction;

public class UserRepository {

    private EntityManager entityManager;

    private EntityTransaction transaction;

    public UserRepository() {
        this.entityManager = ConnectionFactory.getConnection();
        this.transaction = entityManager.getTransaction();
    }

    public Usuario create(Usuario user) {
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        return user;
    }

    public Usuario getUserByEmail(String email) throws NoResultException {
        return entityManager.createQuery("select u from tb_usuarios u  where u.email = :email", Usuario.class).setParameter("email", email).getSingleResult();
    }


}
