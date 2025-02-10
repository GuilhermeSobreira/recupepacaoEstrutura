package br.edu.ifba.principal;

import java.util.List;

import br.edu.ifba.basicas.Empresa;
import br.edu.ifba.basicas.Funcionario;
import br.edu.ifba.dao.FuncionarioDao;
import br.edu.ifba.dao.GetEntityManager;
import jakarta.persistence.EntityManager;

public class Principal {

    public static void main(String[] args) {
        EntityManager em = GetEntityManager.getConnectionJpa();
        FuncionarioDao funcionarioDao = new FuncionarioDao();

        Empresa empresa = new Empresa();
        empresa.setNomeFantasia("Tech Solutions");
        empresa.setCnpj("12.345.678/0001-99");

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("João Silva");
        funcionario.setCpf("123.456.789-00");
        funcionario.setRg("MG-12.345.678");
        funcionario.setMatricula("2024001");
        funcionario.setEndereco("Rua das Flores, 100");
        funcionario.setEmpresa(empresa);

        funcionarioDao.adicionarFuncionario(funcionario);

        Funcionario funcionarioEncontrado = funcionarioDao.buscarFuncionario(1);
        if (funcionarioEncontrado != null) {
            System.out.println("Funcionário encontrado: " + funcionarioEncontrado);
        }

        if (funcionarioEncontrado != null) {
            funcionarioEncontrado.setEndereco("Avenida Central, 200");
            funcionarioDao.atualizarFuncionario(funcionarioEncontrado);
        }

        List<Funcionario> listaFuncionarios = funcionarioDao.listarFuncionarios();
        listaFuncionarios.forEach(System.out::println);
    }
}
