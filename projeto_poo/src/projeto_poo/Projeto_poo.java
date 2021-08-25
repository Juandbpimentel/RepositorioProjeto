/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.concurrent.atomic.AtomicBoolean;
import sistema.Conexao;

import javax.swing.JFrame;

import dao.usuarios.DAOFuncionario;
import dao.usuarios.DAOPessoa;
import modelos.usuarios.Funcionario;
import modelos.usuarios.Pessoa;
import views.sistema.menulogin.MenuLogin_Registro;
import views.sistema.menulogin.viewMenuLogin;
/**
 *
 * @author juand
 */
public class Projeto_poo {
    
    
    public static void main(String[] args) {
        Projeto_poo main = new Projeto_poo(); 
        /*Conexao conexao = new Conexao();
         conexao.startDatabase();
         conexao.conect();
         conexao.createTables();
         conexao.createTriggers();
         conexao.insertData();
         */
        // Pessoa = Funcionario = gerente
         /*conexao.insertData();*/


        main.menu();
    }
    private void menu(){
        viewMenuLogin telaLogin = viewMenuLogin.getObj();

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
