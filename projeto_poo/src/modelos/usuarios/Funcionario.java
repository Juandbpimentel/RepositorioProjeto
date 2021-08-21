package modelos.usuarios;


import modelos.empresa.Categoria;
import modelos.lugar.Endereco;
import sistema.Conexao;
import interfaces.gui.FuncionarioGUI;

import java.time.LocalDate;
import java.util.ArrayList;

public class Funcionario extends Pessoa implements FuncionarioGUI {
    protected double bonificacao;
    protected Categoria categoria;
    ArrayList<Estagiario> estagiarios;

    public Funcionario(String nome, String login, String senha, String tipo, String cpf, LocalDate dataNasc,/* Endereco endereco, Conexao conexao,*/ double bonificacao/*, Categoria categoria, ArrayList<Estagiario> estagiarios*/) {
        super(nome, login, senha, tipo, cpf, dataNasc/*, endereco, conexao*/);
        this.bonificacao = bonificacao;
        //this.categoria = categoria;
        //this.estagiarios = estagiarios;
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
