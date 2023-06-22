package com.ifpr.biblioteca.bibliotecaproject.repository;

import com.ifpr.biblioteca.bibliotecaproject.connection.ConnectionFactory;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Emprestimo;
import com.ifpr.biblioteca.bibliotecaproject.domain.entities.Livro;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.SituacaoEmprestimo;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.SituacaoLivro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmprestimoRepository {
    private EntityManager entityManager;

    private EntityTransaction transaction;

    public EmprestimoRepository() {
        this.entityManager = ConnectionFactory.getConnection();
        //entityManager.getEntityManagerFactory().getCache().evictAll();

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
        return entityManager.createQuery("SELECT e FROM tb_emprestimos e", Emprestimo.class).getResultList();
    }

    public void remove(Emprestimo emprestimo){
        entityManager.getTransaction().begin();
        entityManager.remove(emprestimo);
        entityManager.getTransaction().commit();
    }

    public Emprestimo update(Emprestimo emprestimo){
        transaction.begin();
        emprestimo = entityManager.merge(emprestimo);
        transaction.commit();
        return emprestimo;
    }

    public List<Object[]> getAllEmprestimoUsuario(String email) {
        TypedQuery<Object[]> query = entityManager.createQuery("SELECT l.titulo, e.dataEmprestimo, e.dataDevolucao FROM tb_livros l JOIN l.emprestimo e JOIN e.usuario u WHERE u.email = :email ORDER BY l.codigoLivro", Object[].class);
        query.setParameter("email", email);
        return query.getResultList();
    }

    public List<Object[]> getAllLivrosSituacao(SituacaoLivro situacao) {
        TypedQuery<Object[]> query = entityManager.createQuery("SELECT e.codigoEmprestimo, l.titulo, e.dataEmprestimo, e.dataDevolucao, u.nome FROM tb_livros l JOIN l.emprestimo e JOIN e.usuario u WHERE l.situacaoLivro = :situacao AND e.situacaoEmprestimo = :situacaoEmprestimo ORDER BY l.codigoLivro", Object[].class);
        query.setParameter("situacao", situacao).setParameter("situacaoEmprestimo", SituacaoEmprestimo.EMPRESTIMO);
        return query.getResultList();
    }

    public List<Object[]> getAllLivrosHistorico() {
        TypedQuery<Object[]> query = entityManager.createQuery("SELECT e.codigoEmprestimo, l.titulo, e.dataEmprestimo, e.dataDevolucao, u.nome FROM tb_livros l JOIN l.emprestimo e JOIN e.usuario u ORDER BY e.codigoEmprestimo", Object[].class);
        return query.getResultList();
    }

}
