package dao.manutencao;

import modelos.manutencao.LogInteracao;
import sistema.Conexao;

import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOLogInteracao {
    
    public DAOLogInteracao(){
        this.conexao = new Conexao();
    }

    private Conexao conexao;
    public ArrayList<LogInteracao> readAll(){
        try{
            ArrayList<LogInteracao> arrayLogInteracao = new ArrayList<LogInteracao>();
            conexao = new Conexao();
            conexao.conect();

            String codBusca = "Select * from log_interacao";
            ResultSet resultado = conexao.executaQuery(codBusca);

            if (!resultado.next()) {
                throw new NullPointerException("Não foi possível achar nenhuma log_interacao");
            }else{
                do{
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
                }while(resultado.next());
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

    public boolean updateLogInteracao(String opt, int cpf ,String dado){
        try {
            // 
            //
            conexao = new Conexao();
            String sqlUpdate;

            switch (opt) {
                
                case "data":
                    sqlUpdate = "Update LogInteracao set data = \'" + dado + "\' where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;
                case "tipo":
                    sqlUpdate = "Update LogInteracao set tipo = \'" + dado + "\' where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;
                case "codigo":
                    sqlUpdate = "Update LogInteracao set codigo = \'" + dado + "\' where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;
                case "mensagem":
                    sqlUpdate = "Update LogInteracao set mensagem = \'" + dado + "\' where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;
                case "login_pessoa":
                    sqlUpdate = "Update LogInteracao set login_pessoa = \'" + dado + "\' where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;
                case "id":
                    sqlUpdate = "Update LogInteracao set id = " + dado + " where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;
                

                default:
                    throw new Exception("Valor não encontrado");
            }

            conexao.disconect();
            return true;
        } catch (SQLException SQLError) {
            System.err.println("Ocorreu um erro durante a atualização do Banco de Dados: " + SQLError);
            conexao.disconect();
            return false;
        } catch (Exception geralError) {
            System.err.println("Ocorreu um erro geral: " + geralError);
            conexao.disconect();
            return false;
        }
    }

}