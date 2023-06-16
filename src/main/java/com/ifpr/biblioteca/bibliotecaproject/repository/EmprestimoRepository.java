package com.ifpr.biblioteca.bibliotecaproject.repository;

import com.ifpr.biblioteca.bibliotecaproject.connection.ConnectionFactory;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Emprestimo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

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

    public List<Object[]> getAllEmprestimoUsuario(String email) {
//        return entityManager.createNativeQuery("SELECT l.livro_titulo, e.livro_dtaEmprestimo, e.livro_dtaDevolucao FROM tb_livro AS l INNER JOIN tb_emprestimo AS e ON l.livro_codigo = e.livro_codigo INNER JOIN tb_usuarios AS u ON u.usuario_codigo = e.usuario_codigo WHERE u.usuario_email = :email ORDER BY l.livro_codigo;").setParameter("email", email).getResultList();


        TypedQuery<Object[]> query = entityManager.createQuery("SELECT l.titulo, e.dataEmprestimo, e.dataDevolucao FROM tb_livro l JOIN l.emprestimo e JOIN e.usuario u WHERE u.email = :email ORDER BY l.codigoLivro", Object[].class);
        query.setParameter("email", email);
        return query.getResultList();
    }
}
