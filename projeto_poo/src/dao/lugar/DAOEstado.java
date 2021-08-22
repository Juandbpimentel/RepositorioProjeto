package dao.lugar;

import sistema.Conexao;
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
                int id;
                String nome;
                id = resultado.getInt("id");
                nome = resultado.getString("nome");
                Estado estado = new Estado(id, nome);
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
}
