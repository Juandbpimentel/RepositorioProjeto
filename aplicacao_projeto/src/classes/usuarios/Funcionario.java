package classes.usuarios;


import classes.empresa.Categoria;
import classes.local.Endereco;
import classes.sistema.Conexao;
import interfaces.alterDB.PessoaAlterDB;
import interfaces.gui.FuncionarioGUI;
import interfaces.gui.PessoaGUI;

import java.time.LocalDate;
import java.util.Collection;

public class Funcionario extends Pessoa implements FuncionarioGUI {
    protected double bonificacao;
    protected Categoria categoria;
    Collection<Estagiario> estagiarios;

    public Funcionario(double bonificacao, Categoria categoria, Collection<Estagiario> estagiarios) {
        this.bonificacao = bonificacao;
        this.categoria = categoria;
        this.estagiarios = estagiarios;
    }

    public Funcionario(String nome, String login, String senha, String tipo, String cpf, LocalDate dataNasc, Endereco endereco, Conexao conexao, double bonificacao, Categoria categoria, Collection<Estagiario> estagiarios) {
        super(nome, login, senha, tipo, cpf, dataNasc, endereco, conexao);
        this.bonificacao = bonificacao;
        this.categoria = categoria;
        this.estagiarios = estagiarios;
    }

    public Funcionario() {
        
    }

/**
 * GUI
 */
    @Override
    public void consultarDadosEmprego() {

    }

    @Override
    public void consultarEstagiarios() {

    }
/*
 AlterDB
 */

}
