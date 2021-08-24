/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo;

import java.util.ArrayList;

import dao.lugar.DAOEstado;
import dao.usuarios.DAOPessoa;
import modelos.lugar.Estado;
import modelos.usuarios.Pessoa;
import sistema.Conexao;
import sistema.MenuLogin;

/**
 *
 * @author juand
 */
public class Projeto_poo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       /* Conexao conexao = new Conexao();
        conexao.startDatabase();
        conexao.conect();
        conexao.createTables();
        conexao.createTriggers();
        conexao.insertData();
        */
       MenuLogin.main(args);
    }

}
