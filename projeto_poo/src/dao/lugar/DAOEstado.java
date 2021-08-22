package dao.lugar;

import sistema.Conexao;

import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.lugar.Estado;

public class DAOEstado {
    private Conexao conexao;

    public ArrayList<Estado> readAll(){
        try {
            ArrayList<Estado> arrayEstado = new ArrayList<Estado>();
            conexao = new Conexao();
            conexao.conect();

            String codBusca = "Select * from estado";
            ResultSet resultado = conexao.executaQuery(codBusca);
            
            while(resultado.next()){
                String nome, uf;
                uf = resultado.getString("uf");
                nome = resultado.getString("nome");
                Estado estado = new Estado(uf, nome);
                arrayEstado.add(estado);
            }
            return arrayEstado;
        } 
        catch(SQLException SQLError){
            System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
            return null;
        }
        catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            return null;
        }
    }

    public boolean insertEstado(Estado estado){
        try {
            conexao = new Conexao();
            conexao.conect();
            String sqlInsertion = "Insert into public Estado(uf,nome)"+
                                  "Values "+"("+estado+")";
            int resultado = conexao.executaSql(sqlInsertion);
            if(resultado != 0){
                return false; 
            }
            return true;
        } 
        catch(SQLException SQLError){
            System.err.println("Ocorreu um erro com Inserção no Banco de Dados: " + SQLError);
            return false;
        }
        catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            return false;
        }
    }
}
