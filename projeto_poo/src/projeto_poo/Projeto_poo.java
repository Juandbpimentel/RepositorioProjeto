/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;

import sistema.Conexao;
import views.sistema.menulogin.MenuLogin;
/**
 *
 * @author juand
 */
public class Projeto_poo {
    
    
    public static void main(String[] args) {
        Projeto_poo main = new Projeto_poo(); 
        
        boolean db = Conexao.startDatabase();
        if(db){
            Conexao.createTables();
            Conexao.createTriggers();
            Conexao.insertData();
        }

        main.menu();
    }
    
    private void menu(){
        
        MenuLogin telaLogin = new MenuLogin();

        telaLogin.setVisible(true);
        telaLogin.pack();
        telaLogin.setLocationRelativeTo(null);
        telaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
    
    @SuppressWarnings("unused")
	private void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
