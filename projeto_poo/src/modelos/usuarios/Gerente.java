package modelos.usuarios;

import interfaces.alterDB.GerenteAlterDB;
import interfaces.gui.GerenteGUI;
import views.sistema.gerente.MenuGerente;
import views.sistema.gerente.MenuGerente_AdmEstagiario;
import views.sistema.gerente.MenuGerente_AdmFuncionario;

import java.time.LocalDate;

import javax.swing.JFrame;

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

    //NÃO CRIAR MAIS
    @Override
    public void demitirFuncionario() {

    }

    @Override
    public void bonificarFuncionario() {

    }

    

    @Override
    public void dispensarEstagiario() {

    }

    @Override
    public void trocarEstagiarioSetor() {

    }

    //CRIAR

    @Override
    public void administrarFuncionarios() {
        MenuGerente_AdmFuncionario administrarFuncionario = new MenuGerente_AdmFuncionario(this.getCpf());
        
        administrarFuncionario.setVisible(true);
        administrarFuncionario.pack();
        administrarFuncionario.setLocationRelativeTo(null);
        administrarFuncionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void admitirFuncionario() {

    }

    @Override
    public void admitirEstagiario() {

    }

    @Override
    public void administrarEstagiarios() {
        MenuGerente_AdmEstagiario administrarEstagiarios = new MenuGerente_AdmEstagiario(this.getCpf());
        
        administrarEstagiarios.setVisible(true);
        administrarEstagiarios.pack();
        administrarEstagiarios.setLocationRelativeTo(null);
        administrarEstagiarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void mostrarMenu() {
        MenuGerente menu = new MenuGerente(this.getCpf()); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
