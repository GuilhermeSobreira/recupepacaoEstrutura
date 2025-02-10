package br.edu.ifba.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GetEntityManager {

    private static final String JPA = "EmpresaRec";
    private static EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory(JPA);
        } catch (Exception e) {
            System.err.println("Erro ao criar EntityManagerFactory: " + e.getMessage());
        }
    }

    public static EntityManager getConnectionJpa() {
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
