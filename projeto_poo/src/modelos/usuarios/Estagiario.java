package modelos.usuarios;
import modelos.empresa.Categoria;
import modelos.lugar.Endereco;
import sistema.Conexao;
import interfaces.gui.EstagiarioGUI;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Estagiario extends Pessoa implements EstagiarioGUI {
   public LocalDate inicioEstagio;
   private int tempoEstagio;
   private int diaPagamento;
   private Categoria categoria;


    public Estagiario(String nome, String login, String senha, String tipo, String cpf, LocalDate dataNasc,/* Endereco endereco, Conexao conexao,*/ LocalDate inicioEstagio, int tempoEstagio, int diaPagamento/*, Categoria categoria*/) {
        super(nome, login, senha, tipo, cpf, dataNasc/*, endereco, conexao*/);
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
    public LocalDate getInicioEstagio() {
        return inicioEstagio;
    }

    public void setInicioEstagio(LocalDate inicioEstagio) {
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
