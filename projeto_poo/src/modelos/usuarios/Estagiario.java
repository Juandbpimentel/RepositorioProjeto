package modelos.usuarios;
import interfaces.alterDB.GerenteAlterDB;
import interfaces.gui.GerenteGUI;
import modelos.empresa.Categoria;
import modelos.lugar.Endereco;
import sistema.Conexao;
import interfaces.gui.EstagiarioGUI;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Estagiario extends Pessoa implements EstagiarioGUI {
   public Timestamp inicioEstagio;
   private int tempoEstagio;
   private int diaPagamento;
   private Categoria categoria;


    public Estagiario(String nome, String login, String senha, String tipo, String cpf, LocalDate dataNasc,/* Endereco endereco, Conexao conexao,*/ Timestamp inicioEstagio, int tempoEstagio, int diaPagamento/*, Categoria categoria*/) {
        package modelos.usuarios;

import modelos.empresa.Categoria;
import modelos.lugar.Endereco;
import sistema.Conexao;
import interfaces.alterDB.GerenteAlterDB;
import interfaces.gui.GerenteGUI;

import java.time.LocalDate;
import java.util.ArrayList;

        public class Gerente extends Funcionario implements GerenteGUI, GerenteAlterDB {
            private double bonificacaoGerente;


            public Gerente(String nome, String login, String senha, String tipo, String cpf, LocalDate dataNasc, int idCategoria, int idSetor, int diaPagamento, LocalDate dataInicio, double bonificacao, double bonificacaoGerente, int idEndereco) {
                super(nome,login,senha,tipo,cpf,dataNasc,idCategoria,idSetor,diaPagamento,dataInicio,bonificacao,idEndereco);
                this.bonificacaoGerente = bonificacaoGerente;
            }

            /**
             * GUI
             */
            @Override
            public vo   @Override
            public void adminisonsultarFuncionarios() {

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

        this.inicioEstagio = inicioEstagio;
        this.tempoEstagio = tempoEstagio;
        this.diaPagamento = diaPagamento;
        //this.categoria = categoria;
    }

    @Override
    public void teste(){
        printaDeuCerto();
    }

    private void printaDeuCerto(){
       System.out.print("deu certo!");
    }

    protected void consultarDadosEstagios() {

    }

/**
 * Getters e Setters
 */
    public Timestamp getInicioEstagio() {
        return inicioEstagio;
    }

    public void setInicioEstagio(Timestamp inicioEstagio) {
        this.inicioEstagio = inicioEstagio;
    }

    public int getTempoEstagio() {
        return tempoEstagio;
    }

    public void setTempoEstagio(int tempoEstagio) {
        this.tempoEstagio = tempoEstagio;
    }

    public int getDiaPagamento() {
        return diaPagamento;
    }

    public void setDiaPagamento(int diaPagamento) {
        this.diaPagamento = diaPagamento;
    }

/**
 * GUI
 */
    @Override
    public void consultaDadosEstagio() {

    }
}

