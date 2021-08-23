package dao.lugar;

import sistema.Conexao;
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
            return bairro;
        }catch(SQLException bancoError){
               System.err.println("Ocorreu um erroao buscar no banco de dados: " +bancoError);
               return null;

        }catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " +geralError);
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

    public boolean insertBairro(Bairro bairro){
        try{
            conexao = new Conexao();
            conexao.conect();
            String sqlInsertion = "Insert into public Bairro(id, nome, id_cidade)"
                                + "values " + "(" + bairro + ")";
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

    public boolean updateBairro(int id, Bairro bairro){
        try {
            conexao = new Conexao();
            String sqlUpdate = "Update Bairro \n"+
                               "set nome = "+bairro.getNome()+" , "+
                               "id_cidade = "+bairro.getId_cidade()+" \n"+
                               "where id = " +bairro.getId();
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
