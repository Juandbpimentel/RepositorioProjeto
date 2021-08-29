/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo;

import javax.swing.JFrame;

import dao.usuarios.DAOPessoa;
import modelos.usuarios.Pessoa;
import sistema.Conexao;
import views.sistema.menulogin.MenuLogin;
import views.sistema.pessoa.MenuRegistroADM;
/**
 *
 * @author juand
 */
public class Projeto_poo {
    
    
    public static void main(String[] args) {
        Projeto_poo main = new Projeto_poo(); 
        
        boolean db = Conexao.startDatabase();
        System.out.println(db);
        if(db){
            Conexao.createTables();
            //Conexao.createTriggers();
            Conexao.insertData();
        }

        Pessoa ADM = new DAOPessoa().readOneADM();
        
        if (ADM == null) {
            
            MenuRegistroADM menu = new MenuRegistroADM();
            
            menu.setVisible(true);
            menu.pack();
            menu.setLocationRelativeTo(null);
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        }else{
            System.out.println(ADM.getCpf());
            System.out.println("teste");
            main.menu();
        
        }
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
