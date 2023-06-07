package com.ifpr.biblioteca.bibliotecaproject.repository;

import com.ifpr.biblioteca.bibliotecaproject.connection.ConnectionFactory;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Emprestimo;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

public class UsuarioRepository {

    private EntityManager entityManager;

    private EntityTransaction transaction;

    public UsuarioRepository() {
        this.entityManager = ConnectionFactory.getConnection();
        this.transaction = entityManager.getTransaction();
    }

    public Usuario create(Usuario user) {
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        return user;
    }

    public Usuario findById(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        return usuario;
    }

    public Usuario getUserByEmail(String email) throws NoResultException {
        return entityManager.createQuery("select u from tb_usuarios u  where u.email = :email", Usuario.class).setParameter("email", email).getSingleResult();
    }

    public Usuario update(Usuario usuario){
        transaction.begin();
        usuario = entityManager.merge(usuario);
        transaction.commit();
        return usuario;
    }


}
