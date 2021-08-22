package dao.lugar;

import java.util.ArrayList;
import modelos.lugar.Endereco;
import sistema.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOEndereco {
    private Conexao conexao;

    public ArrayList<Endereco> readAll(){
        try {
            ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
            conexao = new Conexao();
            conexao.conect();

            ResultSet resultado = conexao.executaQuery("select * from Endereco");
            
            while (resultado.next()) {
                
            }
            return enderecos;
        } catch(SQLException e){
            System.err.println("Erro ao recuperar do banco de dados" + e);
            return null;
        } catch (Exception e) {
            System.err.println("Erro Geral: " + e);
            return null;
        }
    }
    
}
