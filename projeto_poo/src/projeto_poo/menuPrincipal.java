/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo;
import sistema.Conexao;
import views.sistema.menulogin.viewMenuLogin;
/**
 *
 * @author juand
 */
public class menuPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("projeto_poo.menuPrincipal.main()");
        viewMenuLogin.main(args);
        Conexao conexao = new Conexao();
        conexao.conect();
        conexao.disconect();
    }
    
}
