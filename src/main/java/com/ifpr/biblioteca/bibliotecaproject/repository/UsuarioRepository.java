package com.ifpr.biblioteca.bibliotecaproject.repository;

import com.ifpr.biblioteca.bibliotecaproject.connection.ConnectionFactory;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Emprestimo;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.List;

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

    public List<Usuario> getAll() {
        return entityManager.createQuery("SELECT u FROM tb_usuarios u", Usuario.class).getResultList();
    }

    public void delete(Usuario usuario){
        entityManager.getTransaction().begin();
        entityManager.remove(usuario);
        entityManager.getTransaction().commit();
    }
}
