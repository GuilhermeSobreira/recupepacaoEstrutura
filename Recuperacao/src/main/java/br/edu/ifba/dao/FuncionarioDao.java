package br.edu.ifba.dao;

import java.util.List;

import br.edu.ifba.basicas.Funcionario;
import jakarta.persistence.EntityManager;

public class FuncionarioDao {

    EntityManager em = GetEntityManager.getConnectionJpa();

    public void adicionarFuncionario(Funcionario f) {
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
    }

    public Funcionario buscarFuncionario(int id) {
        return em.find(Funcionario.class, id);
    }

    public void atualizarFuncionario(Funcionario f) {
        em.getTransaction().begin();
        em.merge(f);
        em.getTransaction().commit();
    }

    public void removerFuncionario(Funcionario f) {
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
    }

    public List<Funcionario> listarFuncionarios() {
        return em.createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList();
    }
}