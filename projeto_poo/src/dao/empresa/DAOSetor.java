package dao.empresa;

import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.empresa.Setor;

public class DAOSetor {
    private Conexao conexao;

    public ArrayList<Setor> readAll(){
        try {
            ArrayList<Setor> arraySetor = new ArrayList<Setor>();
            conexao = new Conexao();
            conexao.conect();

            String codBusca = "Select * from funcionario";
            ResultSet resultado = conexao.executaQuery(codBusca);
            
            while(resultado.next()){

            }

            return arraySetor;
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