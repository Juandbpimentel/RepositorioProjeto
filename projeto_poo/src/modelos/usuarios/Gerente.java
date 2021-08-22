package modelos.usuarios;

import modelos.empresa.Categoria;
import modelos.lugar.Endereco;
import sistema.Conexao;
import interfaces.alterDB.GerenteAlterDB;
import interfaces.gui.GerenteGUI;

import java.time.LocalDate;
import java.util.ArrayList;

public class Gerente extends Funcionario implements GerenteGUI,GerenteAlterDB {
    private double bonificacao_gerente;


    public Gerente(String nome, String login, String senha, String tipo, String cpf, LocalDate dataNasc, double bonificacao, double bonificacaoGerente) {
        super(nome, login, senha, tipo, cpf, dataNasc, bonificacao);
        this.bonificacao_gerente = bonificacaoGerente;
    }

    /**
 * GUI
 */
    @Override
    public void administrarFuncionarios() {

    }

    @Override
    public void administrarEstagiarios() {

    }

    @Override
    public void consultarFuncionarios() {

    }

    @Override
    public void consultarEstagiarios() {

    }

/**
 * AlterDB
 */
    @Override
    public void demitirFuncionario() {

    }

    @Override
    public void bonificarFuncionario() {

    }

    @Override
    public void admitirFuncionario() {

    }

    @Override
    public void admitirEstagiario() {

    }

    @Override
    public void dispensarEstagiario() {

    }

    @Override
    public void trocarEstagiarioSetor() {

    }

    //Getters e Setters

    public double getBonificacaoGerente() {
        return bonificacao_gerente;
    }

    public void setBonificacaoGerente(double bonificacaoGerente) {
        this.bonificacao_gerente = bonificacaoGerente;
    }


}
