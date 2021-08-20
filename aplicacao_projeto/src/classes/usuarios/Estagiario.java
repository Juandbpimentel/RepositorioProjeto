package classes.usuarios;
import classes.empresa.Categoria;
import classes.local.Endereco;
import classes.sistema.Conexao;
import interfaces.gui.EstagiarioGUI;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Estagiario extends Pessoa implements EstagiarioGUI {
   public Timestamp inicioEstagio;
   private int tempoEstagio;
   private int diaPagamento;
   private Categoria categoria;

    public Estagiario(Timestamp inicioEstagio, int tempoEstagio, int diaPagamento, Categoria categoria) {
        this.inicioEstagio = inicioEstagio;
        this.tempoEstagio = tempoEstagio;
        this.diaPagamento = diaPagamento;
        this.categoria = categoria;
    }

    public Estagiario(String nome, String login, String senha, String tipo, String cpf, LocalDate dataNasc, Endereco endereco, Conexao conexao, Timestamp inicioEstagio, int tempoEstagio, int diaPagamento, Categoria categoria) {
        super(nome, login, senha, tipo, cpf, dataNasc, endereco, conexao);
        this.inicioEstagio = inicioEstagio;
        this.tempoEstagio = tempoEstagio;
        this.diaPagamento = diaPagamento;
        this.categoria = categoria;
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

