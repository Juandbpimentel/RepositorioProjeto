package dao.manutencao;

import modelos.manutencao.LogInteracao;
import sistema.Conexao;

import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOLogInteracao {
    
    private Conexao conexao;
    public ArrayList<LogInteracao> readAll(){
        try{
            ArrayList<LogInteracao> arrayLogInteracao = new ArrayList<LogInteracao>();
            conexao = new Conexao();
            conexao.conect();

            String codBusca = "Select * from funcionario";
            ResultSet resultado = conexao.executaQuery(codBusca);

            while(resultado.next()){
                Timestamp data;
                String tipo, cod, mensa, login;
                int id;

                data = resultado.getTimestamp("data");
                tipo = resultado.getString("tipo");
                cod = resultado.getString("codigo");
                mensa = resultado.getString("mensagem");
                login = resultado.getString("login_pessoa");
                id = resultado.getInt("id");
                LogInteracao loginteracao = new LogInteracao(data, tipo, cod, mensa, id, login);
                arrayLogInteracao.add(loginteracao);
            }
            return arrayLogInteracao;
        }catch(SQLException SQLError){
            System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
            return null;
        }catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            return null;
        }
    }
public LogInteracao readOneLogInteracao(int id){
    try {
        conexao = new Conexao();
        LogInteracao loginteracao;
        String queryLogInteracao = "Select * from Log_Interacao where id =" +id;
        ResultSet resultadoQuery = conexao.executaQuery(queryLogInteracao);
        if(!resultadoQuery.next()){
            throw new NullPointerException("Não foi possível realizar login");
        } else{
            String tipo = resultadoQuery.getString("tipo"), codigo = resultadoQuery.getString("codigo"), mensagem = resultadoQuery.getString("mensagem"), login = resultadoQuery.getString("login_pessoa");
            Timestamp data = resultadoQuery.getTimestamp("data");
            loginteracao = new LogInteracao(data, tipo, codigo, mensagem, id, login);
        }
        return loginteracao;
    } catch(SQLException SQLError){
        System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
        return null;
    } catch(Exception geralError){
        System.err.println("Ocorreu um erro geral: " + geralError);
        return null;
    }
} 
}