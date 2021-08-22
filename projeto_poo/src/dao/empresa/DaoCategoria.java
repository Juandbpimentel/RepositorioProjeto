package dao.empresa;

import sistema.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.empresa.Categoria;

public class DAOCategoria {
    private Conexao conexao;

    public ArrayList<Categoria> readAll(){

        try{
            ArrayList<Categoria> arrayCategoria = new ArrayList<Categoria>();
            conexao = new Conexao();
            conexao.conect();
            
            String codigoBusca = "Select * from categoria";
            ResultSet busca = conexao.executaQuery(codigoBusca);

            while(busca.next()){
                
            }

            return arrayCategoria; 

        } catch(SQLException sqlError){
            System.err.println("Houve um erro na leitura do Banco de Dados: "+ sqlError);
            return null;
        }
        catch(Exception error){
            System.err.println("Houve um erro geral: " + error);
            return null;
        }
    }

}