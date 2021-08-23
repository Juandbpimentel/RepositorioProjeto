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

    public boolean insertLogInteracao(LogInteracao logInteracao){
        try{
            conexao = new Conexao();
            conexao.conect();
            String sqlInsertion = "Insert into public log_interacao(data, tipo, codigo, mensagem, id, login_pessoa)"
                                + "values " + "(" + logInteracao + ")";
            int resultado = conexao.executaSql(sqlInsertion);
            
            if(resultado != 0){
                return false;
            }
            return true;

        } catch(SQLException SQLError){
            System.err.println("Ocorreu um erro com Inserção no Banco de Dados: " + SQLError);
            return false;
        } catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            return false;
        }
    }

    public boolean updateLogInteracao(int id, LogInteracao logInteracao){
        try {
            conexao = new Conexao();
            String sqlUpdate = "Update Log_interacao \n"+
                               "set data = "+logInteracao.getData()+" , "+
                               "tipo = "+logInteracao.getTipo()+" , "+
                               "codigo = "+logInteracao.getCodigo()+" , "+
                               "mensagem = "+logInteracao.getMensagem()+" , "+
                               "login_pessoa = "+logInteracao.getLogin_pessoa()+" \n"+
                               "where id = " +logInteracao.getId();
            int resultado = conexao.executaSql(sqlUpdate);
            
            return (resultado != 0)?true:false;
        } catch (SQLException SQLError) {
            System.err.println("Ocorreu um erro durante a atualização do Banco de Dados: " + SQLError);
            return false;
        } catch (Exception geralError) {
            System.err.println("Ocorreu um erro geral: " + geralError);
            return false;
        }
    }
}