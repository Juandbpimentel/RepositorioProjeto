package modelos.usuarios;
import modelos.empresa.Categoria;
import modelos.lugar.Endereco;
import sistema.Conexao;
import interfaces.gui.EstagiarioGUI;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Estagiario extends Pessoa implements EstagiarioGUI {
    public LocalDate inicio_estagio;
    private int tempo_estagio, dia_pagamento, id_categoria, id_setor;
    private Categoria categoria;

    public Estagiario(String nome, String login, String senha, String tipo, String cpf, LocalDate dataNasc, LocalDate inicioEstagio, int tempoEstagio, int diaPagamento, int id_categoria, int id_setor) {
        super(nome, login, senha, tipo, cpf, dataNasc/*, endereco, conexao*/);
        this.inicio_estagio = inicioEstagio;
        this.tempo_estagio = tempoEstagio;
        this.dia_pagamento = diaPagamento;
        this.id_categoria = id_categoria;
        this.id_setor = id_setor;
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
        return inicio_estagio;
    }

    public void setInicioEstagio(LocalDate inicioEstagio) {
        this.inicio_estagio = inicioEstagio;
    }

    public int getTempoEstagio() {
        return tempo_estagio;
    }

    public void setTempoEstagio(int tempoEstagio) {
        this.tempo_estagio = tempoEstagio;
    }

    public int getDiaPagamento() {
        return dia_pagamento;
    }

    public void setDiaPagamento(int diaPagamento) {
        this.dia_pagamento = diaPagamento;
    }

/**
 * GUI
 */
    @Override
    public void consultaDadosEstagio() {

    }
}

