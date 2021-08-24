/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo;

import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import dao.lugar.DAOEstado;
import dao.usuarios.DAOPessoa;
import modelos.lugar.Estado;
import modelos.usuarios.Pessoa;
import sistema.Conexao;
import views.sistema.menulogin.viewMenuLogin;
/**
 *
 * @author juand
 */
public class Projeto_poo {
    private Pessoa usuario;
    /**
     * @param args the command line arguments
     */
    public Projeto_poo(){
        this.usuario = null;
    }
    
    public static void main(String[] args) {
       Projeto_poo main = new Projeto_poo(); 
       /* Conexao conexao = new Conexao();
        conexao.startDatabase();
        conexao.conect();
        conexao.createTables();
        conexao.createTriggers();
        conexao.insertData();
        */
       viewMenuLogin telaLogin = new viewMenuLogin();
       
       telaLogin.setVisible(true);
       
       System.out.println("Usuario: " + main.getUsuario());
       System.out.println("Usuario: " + main.getUsuario());
    }
    
    @SuppressWarnings("unused")
	private void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
    
    public Pessoa getUsuario(){
        return usuario;
    }
    
    public void setUsuario(Pessoa usuario){
        this.usuario = usuario;
    }
}
