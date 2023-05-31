package com.ifpr.biblioteca.bibliotecaproject.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionFactory {
    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("sistema_biblioteca");
    }

    public static EntityManager getConnection() {
        return entityManagerFactory.createEntityManager();
    }

    public  static void closeEntityManager(EntityManagerFactory emFactory) {
        emFactory.close();
    }

    public static void closeEntityManager(EntityManager em) {
        em.close();
    }
}
