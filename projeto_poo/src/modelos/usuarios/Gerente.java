package modelos.usuarios;

import modelos.empresa.Categoria;
import modelos.lugar.Endereco;
import sistema.Conexao;
import interfaces.alterDB.GerenteAlterDB;
import interfaces.gui.GerenteGUI;

import java.time.LocalDate;
import java.util.ArrayList;

public class Gerente extends Funcionario implements GerenteGUI,GerenteAlterDB {
    private double bonificacaoGerente;

    public Gerente(double bonificacao, Categoria categoria, ArrayList<Estagiario> estagiarios, double bonificacaoGerente) {
        super(bonificacao, categoria, estagiarios);
        this.bonificacaoGerente = bonificacaoGerente;
    }

    public Gerente(String nome, String login, String senha, String tipo, String cpf, LocalDate dataNasc, Endereco endereco, Conexao conexao, double bonificacao, Categoria categoria, ArrayList<Estagiario> estagiarios, double bonificacaoGerente) {
        super(nome, login, senha, tipo, cpf, dataNasc, endereco, conexao, bonificacao, categoria, estagiarios);
        this.bonificacaoGerente = bonificacaoGerente;
    }

    public Gerente(double bonificacaoGerente) {
        this.bonificacaoGerente = bonificacaoGerente;
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
        return bonificacaoGerente;
    }

    public void setBonificacaoGerente(double bonificacaoGerente) {
        this.bonificacaoGerente = bonificacaoGerente;
    }


}
