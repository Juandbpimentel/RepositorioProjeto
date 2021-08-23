/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo;

import java.util.ArrayList;

import dao.lugar.DAOEstado;
import modelos.lugar.Estado;
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
        DAOEstado daoEstado = new DAOEstado();

        ArrayList<Estado> estados = daoEstado.readAll();
        
        System.out.println(estados);
    }

}
