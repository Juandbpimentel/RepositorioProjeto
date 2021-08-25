package modelos.usuarios;


import modelos.empresa.Categoria;
import views.sistema.Funcionario.MenuFuncionario;
import interfaces.gui.FuncionarioGUI;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Funcionario extends Pessoa implements FuncionarioGUI {
    protected double bonificacao;
    protected int id_categoria,id_setor,dia_pagamento;
    protected LocalDate data_inicio;
    protected Categoria categoria;
    ArrayList<Estagiario> estagiarios;

    public Funcionario( String nome, 
                        String login, 
                        String senha, 
                        String tipo, 
                        String cpf, 
                        LocalDate dataNasc, 
                        int id_endereco, 
                        double bonificacao,
                        int id_categoria, 
                        int id_setor, int dia_pagamento, LocalDate data_inicio) {
        
        super(nome, login, senha, tipo, cpf, dataNasc, id_endereco);
        this.bonificacao = bonificacao;
        this.id_categoria = id_categoria;
        this.id_setor = id_setor;
        this.dia_pagamento = dia_pagamento;
        this.data_inicio = data_inicio;
    }

    public double getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(double bonificacao) {
        this.bonificacao = bonificacao;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_setor() {
        return id_setor;
    }

    public void setId_setor(int id_setor) {
        this.id_setor = id_setor;
    }

    public int getDia_pagamento() {
        return dia_pagamento;
    }

    public void setDia_pagamento(int dia_pagamento) {
        this.dia_pagamento = dia_pagamento;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Estagiario> getEstagiarios() {
        return estagiarios;
    }

    public void setEstagiarios(ArrayList<Estagiario> estagiarios) {
        this.estagiarios = estagiarios;
    }

    @Override
    public void consultarDadosEmprego() {

    }

    @Override
    public void consultarEstagiarios() {

    }

    @Override
    public void mostrarMenu() {
        MenuFuncionario menu = new MenuFuncionario(); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public String toString(){
        return super.toString()+" ( bonificacao : \'"+bonificacao+"\', cpf : \'"+cpf+"\', id_categoria : "+id_categoria+", id_setor : "+id_setor+", dia_pagamento : "+dia_pagamento+", data_inicio \'"+data_inicio+"\' )";
    }

}
