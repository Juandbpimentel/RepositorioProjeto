package modelos.usuarios;

import interfaces.alterDB.GerenteAlterDB;
import interfaces.gui.GerenteGUI;

import java.time.LocalDate;

public class Gerente extends Funcionario implements GerenteGUI,GerenteAlterDB {
    private double bonificacao_gerente;
    public Gerente( String nome, 
                    String login, 
                    String senha, 
                    String tipo, 
                    String cpf, 
                    LocalDate dataNasc,
                    int id_categoria,
                    int id_setor,
                    int dia_pagamento,
                    double bonificacao,
                    LocalDate data_inicio,
                    double bonificacaoGerente, int id_endereco) {

        super(  nome, login,
                senha, tipo,
                cpf, dataNasc,
                id_endereco,bonificacao,id_categoria,id_setor,dia_pagamento,data_inicio);
        this.bonificacao_gerente = bonificacaoGerente;
    }

    public double getBonificacao_gerente() {
        return bonificacao_gerente;
    }

    public void setBonificacao_gerente(double bonificacao_gerente) {
        this.bonificacao_gerente = bonificacao_gerente;
    }

    /*
        GUI
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

/*
    AlterDB
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
