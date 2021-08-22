package dao.lugar;

import sistema.Conexao;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.lugar.Bairro;

public class DAOBairro {
    private Conexao conexao;

    public ArrayList<Bairro> readAll(){
        try {
            ArrayList<Bairro> arrayBairro = new ArrayList<Bairro>();
            conexao = new Conexao();
            conexao.conect();

            String codBusca = "Select * from funcionario";
            ResultSet resultado = conexao.executaQuery(codBusca);
            
            while(resultado.next()){
                int id, cid;
                String nome;
                id = resultado.getInt("id");
                cid = resultado.getInt("id_cidade");
                nome = resultado.getString("nome");
                Bairro bairro = new Bairro(id, nome, cid);
                arrayBairro.add(bairro);
            }
            return arrayBairro;
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
