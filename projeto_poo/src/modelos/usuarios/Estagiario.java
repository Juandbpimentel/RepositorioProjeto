package modelos.usuarios;
import modelos.empresa.Categoria;
import views.sistema.Estagiario.MenuEstagiario;
import interfaces.gui.EstagiarioGUI;

import java.time.LocalDate;

import javax.swing.JFrame;
import views.sistema.Estagiario.MenuEstagiario_ConsultarDados;

public class Estagiario extends Pessoa implements EstagiarioGUI {
    public LocalDate inicio_estagio;
    private int tempo_estagio, dia_pagamento, id_categoria, id_setor;
    private Categoria categoria;

    public Estagiario(  String nome, 
                        String login, 
                        String senha, 
                        String tipo, 
                        String cpf, 
                        LocalDate dataNasc, 
                        LocalDate inicioEstagio, 
                        int tempoEstagio, 
                        int diaPagamento, 
                        int id_categoria, 
                        int id_setor, int id_endereco) {
        super(nome, login, senha, tipo, cpf, dataNasc, id_endereco/*, endereco, conexao*/);
        this.inicio_estagio = inicioEstagio;
        this.tempo_estagio = tempoEstagio;
        this.dia_pagamento = diaPagamento;
        this.id_categoria = id_categoria;
        this.id_setor = id_setor;
        //this.categoria = categoria;
    }

    public LocalDate getInicio_estagio() {
        return inicio_estagio;
    }
    
    public void setInicio_estagio(LocalDate inicio_estagio) {
        this.inicio_estagio = inicio_estagio;
    }
    
    public int getDia_pagamento() {
        return dia_pagamento;
    }
    
    public void setDia_pagamento(int dia_pagamento) {
        this.dia_pagamento = dia_pagamento;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    protected void consultarDadosEstagios() {

    }

    public int getTempo_estagio() {
        return tempo_estagio;
    }

    public void setTempo_estagio(int tempoEstagio) {
        this.tempo_estagio = tempoEstagio;
    }

    @Override
    public void consultaDadosEstagio() {
        MenuEstagiario_ConsultarDados consultarDados = new MenuEstagiario_ConsultarDados(this);
        
        consultarDados.setVisible(true);
        consultarDados.pack();
        consultarDados.setLocationRelativeTo(null);
        consultarDados.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
    }

    @Override
    public void mostrarMenu() {
        MenuEstagiario menu = new MenuEstagiario(this); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String toString(){
        return "(\'"+nome+"\', \'"+login+"\', \'"+senha+"\', \'"+tipo+"\', \'"+cpf+"\', \'"+data_nasc+"\', \'"+inicio_estagio+"\', \'"+tempo_estagio+"\', \'"+dia_pagamento+"\', \'"+id_categoria+"\', \'"+id_setor+"\', \'"+id_endereco+"\')";
    }
}

