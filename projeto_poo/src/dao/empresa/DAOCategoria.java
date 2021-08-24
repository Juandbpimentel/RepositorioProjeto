package dao.empresa;

import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.empresa.Categoria;

public class DAOCategoria {
    private Conexao conexao;

    public DAOCategoria(){
        conexao = new Conexao();
    }

    public ArrayList<Categoria> readAll() {
        
        try {
            ArrayList<Categoria> arrayCategoria = new ArrayList<Categoria>();
        
            conexao.conect();

            String codigoBusca = "Select * from categoria";
            ResultSet busca = conexao.executaQuery(codigoBusca);

            if (!busca.next()) {
                throw new NullPointerException("Não foi possível achar nenhuma categoria");
            }
            while (busca.next()) {
                String nome, descricao, cnpj_empresa;
                int id, carga_horaria;
                double salario;

                nome = busca.getString("nome");
                descricao = busca.getString("descricao");
                cnpj_empresa = busca.getString("cnpj_empresa");

                id = busca.getInt("id");
                carga_horaria = busca.getInt("carga_horaria");

                salario = busca.getDouble("salario");

                Categoria categoria = new Categoria(id, carga_horaria, nome, descricao, salario, cnpj_empresa);
                arrayCategoria.add(categoria);
                
            }
            conexao.disconect();
            return arrayCategoria;

        } 
        catch (SQLException sqlError) {
            System.err.println("Houve um erro na leitura do Banco de Dados: " + sqlError);
            conexao.disconect();
            return null;
        } 
        catch (Exception error) {
            System.err.println("Houve um erro geral: " + error);
            conexao.disconect();
            return null;
        }
    }

    public boolean deleteCategoria(int id){
        try{
            conexao.conect();

            String codigoDelete = "delete from categoria where id = "+ id;
            int resultado = conexao.executaSql(codigoDelete);
            if(resultado != 1){
                System.out.println("Você teve sucesso em deletar a Categoria");
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
    
    public Categoria readOneCategoria(int id){
        try {
            conexao.conect();

            Categoria categoria;
            String queryCategoria = "Select * from Categoria where id =" +id;
            ResultSet resultadoQuery = conexao.executaQuery(queryCategoria);
            if(!resultadoQuery.next()){
                throw new NullPointerException("Não foi possível achar nenhuma categoria");
            } else{
                String nome = resultadoQuery.getString("nome"), descricao = resultadoQuery.getString("descricao"), cnpj = resultadoQuery.getString("cpnj_empresa");
                int salario = resultadoQuery.getInt("salario"), carga = resultadoQuery.getInt("carga_horaria");
                categoria = new Categoria(id, carga, nome, descricao, salario, cnpj);
            }
            conexao.disconect();
            return categoria;

        }catch (SQLException sqlError) {
            System.err.println("Houve um erro na leitura do Banco de Dados: " + sqlError);
            conexao.disconect();
            return null;
        } 
        catch (Exception error) {
            System.err.println("Houve um erro geral: " + error);
            conexao.disconect();
            return null;
        }
    }

    public boolean insertCategoria(Categoria categoria){
        try{
            conexao.conect();

            String sqlInsertion = "Insert into public Categoria(carga_horaria, nome, descricao, salario, cnpj_empresa)"
                                + " values " + categoria;
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

    public boolean updateCategoria(String opt, int id, String dado){
        try {
            conexao.conect();
            
            
            String sqlUpdate;

            switch (opt) {
                case "id":
                    sqlUpdate = "Update Categoria set id = "+dado+" where id = " + id;
                    conexao.executaSql(sqlUpdate);
                    break;
    
                case "nome":
                    sqlUpdate = "Update Categoria set nome = \'"+dado+"\' where id = " + id;
                    conexao.executaSql(sqlUpdate);
                    break;

                case "carga_horaria":
                    sqlUpdate = "Update Categoria set carga_horaria = "+dado+" where id = " + id;
                    conexao.executaSql(sqlUpdate);
                    break;
                
                case "descricao":
                    sqlUpdate = "Update Categoria set descricao = \'"+dado+"\' where id = " + id;
                    conexao.executaSql(sqlUpdate);
                    break;

                case "salario":
                    sqlUpdate = "Update Categoria set salario = "+dado+" where id = " + id;
                    conexao.executaSql(sqlUpdate);
                    break;

                case "cnpj_empresa":
                    sqlUpdate = "Update Categoria set cnpj_empresa = \'"+dado+"\' where id = " + id;
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