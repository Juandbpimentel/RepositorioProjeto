/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import sistema.Conexao;

import javax.swing.JFrame;

import dao.usuarios.DAOFuncionario;
import dao.usuarios.DAOPessoa;
import modelos.usuarios.Funcionario;
import modelos.usuarios.Pessoa;
import views.sistema.menulogin.viewMenuLogin;
/**
 *
 * @author juand
 */
public class Projeto_poo {
    private static Pessoa usuario;
    /**
     * @param args the command line arguments
     */
    public Projeto_poo(){
        this.usuario = null;
    }
    
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
         
        
        int x = (int) 0.5;

        Pessoa teste = new DAOPessoa().readOnePessoa("333333333-33");
        Pessoa teste2 = (Pessoa) (new DAOFuncionario().readOneFuncionario("333333333-33"));
        Funcionario func = (Funcionario) teste2;
        main.menu();
        if(main.getUsuario() == null){
            try{
                throw new Exception("Houve algum erro durante a execução do login");
            }catch(Exception e){
               System.err.println("");
            }
        }
        //usuario.menulogin();
    }
    private void menu(){
        viewMenuLogin telaLogin = new viewMenuLogin();

        AtomicBoolean closed = new AtomicBoolean(false);
        telaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        telaLogin.addWindowListener(new WindowAdapter() {
                 @Override
                 public void windowClosed(WindowEvent e) {
                     synchronized(closed) {
                         closed.set(true);
                         closed.notify();
                     }
                     super.windowClosed(e);
                 }
             } 
        );

        telaLogin.setVisible(true);
            synchronized(closed) {
            while (!closed.get()) {
                try{
                    closed.wait();
                }catch(Exception e){
                    System.out.println("Erro dutante a execução da janela");
                }
            }   
        }
            
        this.setUsuario(telaLogin.getUsuario());
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
