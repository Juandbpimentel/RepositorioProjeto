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
    public boolean deleteLogInteracao(int id){
        try{
            Conexao conexao = new Conexao();
            conexao.conect();
            String codigoDelete = "delete from LogInteracao where id = "+ id;
            int resultado = conexao.executaSql(codigoDelete);
            if(resultado != 1){
                System.out.println("Você teve sucesso em deletar o LogInteracao");
                return true;
            }



        }catch(SQLException e){
            System.err.println("Houve um erro durante a exclusão do Banco de Dados: "+e);
            return false;
        }catch (Exception e){
            System.err.println("Houve um erro geral: "+e);
            return false;
        }
        return false;
    }
}