package dao.lugar;

import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.lugar.Bairro;

public class DAOBairro {
    private Conexao conexao;

    public DAOBairro(){
        conexao = new Conexao();
    }

    public ArrayList<Bairro> readAll(){
        try {
            ArrayList<Bairro> arrayBairro = new ArrayList<Bairro>();

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
            conexao.disconect();
            return arrayBairro;
        } 
        catch(SQLException SQLError){
            System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
            conexao.disconect();
            return null;
        }
        catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            conexao.disconect();
            return null;
        }
    }

    public Bairro readOneBairro(int id){
        try{
            conexao = new Conexao();
            Bairro bairro;
            String queryBairro = "Select * from Estado where id = " +id;
            ResultSet resultadoQuery = conexao.executaQuery(queryBairro);
            if(!resultadoQuery.next()){
                throw new NullPointerException("Não foi possível achar nenhum bairro");
            } else{
                String nome = resultadoQuery.getString("nome");
                int id_cidade = resultadoQuery.getInt("id_cidade");
                bairro = new Bairro(id, nome, id_cidade);
            }
            conexao.disconect();
            return bairro;
        }catch(SQLException bancoError){
               System.err.println("Ocorreu um erroao buscar no banco de dados: " +bancoError);
               conexao.disconect();
               return null;

        }catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " +geralError);
            conexao.disconect();
            return null;
        }
    }
    public boolean deleteBairro(int id){
        try{
            Conexao conexao = new Conexao();
            conexao.conect();
            String codigoDelete = "delete from bairro where id = "+ id;
            int resultado = conexao.executaSql(codigoDelete);
            if(resultado != 1){
                System.out.println("Você teve sucesso em deletar o Bairro");
                conexao.disconect();
                return true;
            }

        }catch(SQLException e){
            System.err.println("Houve um erro durante a exclusão do Banco de Dados: "+e);
            conexao.disconect();
            return false;
        }catch (Exception e){
            System.err.println("Houve um erro geral: "+e);
            conexao.disconect();
            return false;
        }
        conexao.disconect();
        return false;
    }

    public boolean insertBairro(Bairro bairro){
        try{
            conexao = new Conexao();
            conexao.conect();
            String sqlInsertion = "Insert into public Bairro(nome, id_cidade)"
                                + "values " + "(" + bairro + ")";
            int resultado = conexao.executaSql(sqlInsertion);
            
            if(resultado != 0){
                conexao.disconect();
                return false;
            }
            conexao.disconect();
            return true;
            
        } catch(SQLException SQLError){
            System.err.println("Ocorreu um erro com Inserção no Banco de Dados: " + SQLError);
            conexao.disconect();
            return false;
        } catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            conexao.disconect();
            return false;
        }
    }

    public boolean updateBairro(String opt, int id, String dado){
        try {
            conexao.conect();
            
            int resultado;
            String sqlUpdate;

            switch (opt) {
                case "id":
                    sqlUpdate = "Update Bairro set id = "+dado+" where id = " + id;
                    conexao.executaSql(sqlUpdate);
                    break;
    
                case "nome":
                    sqlUpdate = "Update Bairro set nome = \'"+dado+"\' where id = " + id;
                    conexao.executaSql(sqlUpdate);
                    break;

                case "id_cidade":
                    sqlUpdate = "Update Categoria set id_cidade = \'"+dado+"\' where id = " + id;
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
