package dao.lugar;

import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.lugar.Cidade;

public class DAOCidade {
    private Conexao conexao;

    public ArrayList<Cidade> readAll(){
        try {
            ArrayList<Cidade> arrayCidade = new ArrayList<Cidade>();
            conexao = new Conexao();
            conexao.conect();

            String codBusca = "Select * from funcionario";
            ResultSet resultado = conexao.executaQuery(codBusca);
            
            while(resultado.next()){
                int id;
                String est, nome;
                id = resultado.getInt("id");
                est = resultado.getString("id_estado");
                nome = resultado.getString("nome");
                Cidade cidade = new Cidade(id, nome, est);
                arrayCidade.add(cidade);
            }

            return arrayCidade;
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
