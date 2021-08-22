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
                int id;
                String nome, cnpj;
                Double orc;
                id = resultado.getInt("id");
                nome = resultado.getString("nome");
                cnpj = resultado.getString("cnpj_empresa");
                orc = resultado.getDouble("orcamento");
                Setor setor = new Setor (orc, nome, id, cnpj);
                arraySetor.add(setor);
            }
            return arraySetor;
        } catch(SQLException SQLError){
            System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
            return null;
        }
        catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            return null;
        }
    }
public Setor readOneSetor(int id){
    try{
        conexao = new Conexao();
        Setor setor;
        String querySetor = "Select * from Setor where id = "+id;
        ResultSet resultadoQuery = conexao.executaQuery(querySetor);
        if(!resultadoQuery.next()){
            throw new NullPointerException("Não foi possível achar nenhum setor");
        } else{
            String nome = resultadoQuery.getString("nome"), cnpj = resultadoQuery.getString("cnpj_empresa");
            Double orcamento = resultadoQuery.getDouble("orcamento");
            setor = new Setor(orcamento, nome, id, cnpj);
        }
        return setor;
    } catch(SQLException SQLError){
        System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
        return null;
    }
    catch(Exception geralError){
        System.err.println("Ocorreu um erro geral: " + geralError);
        return null;
    }
}
}