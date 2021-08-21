package dao.lugar;

import java.util.ArrayList;
import modelos.lugar.Endereco;
import modelos.sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;

public class daoEndereco {
    private Conexao conexao;

    public ArrayList<Endereco> readAll(){
        try {
            conexao = new Conexao();
            conexao.conect();

            ResultSet resultado = conexao.executaQuery("select * from Endereco");
            ArrayList<Endereco> enderecos;
            while (resultado.next()) {
                
            }
        } catch(SQLException e){
            System.err.println("Erro ao recuperar do banco de dados" + e);
        } catch (Exception e) {
            System.err.println("Erro Geral: " + e);
        }
        
    }
    
}
