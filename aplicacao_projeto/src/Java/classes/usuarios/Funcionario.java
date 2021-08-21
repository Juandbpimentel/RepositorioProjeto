package Java.classes.usuarios;


import Java.classes.empresa.Categoria;
import Java.classes.local.Endereco;
import Java.classes.sistema.Conexao;
import Java.classes.usuarios.pessoa.Pessoa;
import Java.interfaces.gui.FuncionarioGUI;

import java.time.LocalDate;
import java.util.ArrayList;

public class Funcionario extends Pessoa implements FuncionarioGUI {
    protected double bonificacao;
    protected Categoria categoria;
    ArrayList<Estagiario> estagiarios;

    public Funcionario(double bonificacao, Categoria categoria, ArrayList<Estagiario> estagiarios) {
        this.bonificacao = bonificacao;
        this.categoria = categoria;
        this.estagiarios = estagiarios;
    }

    public Funcionario(String nome, String login, String senha, String tipo, String cpf, LocalDate dataNasc, Endereco endereco, Conexao conexao, double bonificacao, Categoria categoria, ArrayList<Estagiario> estagiarios) {
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
