package dao.lugar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.lugar.Estado;
import sistema.Conexao;
import java.lang.NullPointerException;

public class DAOEstado {
    private Conexao conexao;

    public DAOEstado(){
        this.conexao = new Conexao();
    }

    public ArrayList<Estado> readAll(){
        try {
            ArrayList<Estado> arrayEstado = new ArrayList<Estado>();
            conexao.conect();

            String codBusca = "Select * from estado";
            ResultSet resultado = conexao.executaQuery(codBusca);
            
            while(resultado.next()){
                String nome, uf;
                uf = resultado.getString("uf");
                nome = resultado.getString("nome");
                Estado estado = new Estado(uf, nome);
                arrayEstado.add(estado);
            }
            return arrayEstado;
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

    public boolean insertEstado(Estado estado){
        try {
            conexao.conect();
            String sqlInsertion = "Insert into public Estado(uf,nome)"+
                                  "Values "+"("+estado+")";
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

    public Estado readOnEstado(String uf){
        try {
            conexao.conect();
            Estado estado;
            String queryEstado = "SELECT * FROM ESTADO WHERE UF = \'"+uf+"\'";
            ResultSet resultadoQuery = conexao.executaQuery(queryEstado);
            if (!resultadoQuery.next()) {
                throw new NullPointerException("Não foi possível achar nenhum estado");
            } else{
                String nome = resultadoQuery.getString("nome");
                estado = new Estado(uf, nome);
            }
            return estado;
        } catch(SQLException SQLError){
            System.err.println("Ocorreu um erro com Inserção no Banco de Dados: " + SQLError);
            return null;
        }
        catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            return null;
        }
    }
    
    public boolean deleteEstado(int id){
        try{
            conexao.conect();
            String codigoDelete = "delete from estado where id = "+ id;
            int resultado = conexao.executaSql(codigoDelete);
            if(resultado != 1){
                System.out.println("Você teve sucesso em deletar o estado");
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

    public boolean updateEstado(String opt, int cpf ,String dado){
        try {
            // 
            //
            conexao = new Conexao();
            String sqlUpdate;

            switch (opt) {
                
                case "nome":
                sqlUpdate = "Update Estado set nome = \'" + dado + "\' where cpf = \'" + cpf+"\';";
                conexao.executaSql(sqlUpdate);
                break;

                case "uf":
                sqlUpdate = "Update Estado set uf = \'" + dado + "\' where cpf = \'" + cpf+"\';";
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
