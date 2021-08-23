package dao.empresa;

import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.empresa.Categoria;

public class DAOCategoria {
    private Conexao conexao;

    public ArrayList<Categoria> readAll() {

        try {
            ArrayList<Categoria> arrayCategoria = new ArrayList<Categoria>();
            conexao = new Conexao();
            conexao.conect();

            String codigoBusca = "Select * from categoria";
            ResultSet busca = conexao.executaQuery(codigoBusca);

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

            return arrayCategoria;

        } 
        catch (SQLException sqlError) {
            System.err.println("Houve um erro na leitura do Banco de Dados: " + sqlError);
            return null;
        } 
        catch (Exception error) {
            System.err.println("Houve um erro geral: " + error);
            return null;
        }
    }
    public boolean deleteCategoria(int id){
        try{
            Conexao conexao = new Conexao();
            conexao.conect();
            String codigoDelete = "delete from categoria where id = "+ id;
            int resultado = conexao.executaSql(codigoDelete);
            if(resultado != 1){
                System.out.println("Você teve sucesso em deletar a Categoria");
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
    
    public Categoria readOneCategoria(int id){
        try {
            conexao = new Conexao();
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
            return categoria;
        }catch (SQLException sqlError) {
            System.err.println("Houve um erro na leitura do Banco de Dados: " + sqlError);
            return null;
        } 
        catch (Exception error) {
            System.err.println("Houve um erro geral: " + error);
            return null;
        }
    }

    public boolean insertCategoria(Categoria categoria){
        try{
            conexao = new Conexao();
            conexao.conect();
            String sqlInsertion = "Insert into public Categoria(id, carga_horaria, nome, descricao, salario, cnpj_empresa)"
                                + "values " + "(" + categoria + ")";
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

    public boolean updateCategoria(String opt, int id, Categoria categoria){
        try {
            conexao = new Conexao();
            int resultado;
            String sqlUpdate;

            switch (opt) {
                case "id":
                    sqlUpdate = "Update Categoria set id = "+categoria.getId()+" where id = " + categoria.getId();
                    resultado = conexao.executaSql(sqlUpdate);
                    break;
    
                case "nome":
                    sqlUpdate = "Update Categoria set nome = \'"+categoria.getNome()+"\' where id = " + categoria.getId();
                    resultado = conexao.executaSql(sqlUpdate);
                    break;

                case "carga_horaria":
                    sqlUpdate = "Update Categoria set carga_horaria = "+categoria.getCarga_horaria()+" where id = " + categoria.getId();
                    resultado = conexao.executaSql(sqlUpdate);
                    break;
                
                case "descricao":
                    sqlUpdate = "Update Categoria set descricao = \'"+categoria.getDescricao()+"\' where id = " + categoria.getId();
                    resultado = conexao.executaSql(sqlUpdate);
                    break;

                case "salario":
                    sqlUpdate = "Update Categoria set salario = "+categoria.getSalario()+" where id = " + categoria.getId();
                    resultado = conexao.executaSql(sqlUpdate);
                    break;

                case "cnpj_empresa":
                    sqlUpdate = "Update Categoria set cnpj_empresa = \'"+categoria.getCnpj_empresa()+"\' where id = " + categoria.getId();
                    resultado = conexao.executaSql(sqlUpdate);
                    break;

                default:
                    throw new Exception("Valor não encontrado");
            }
            conexao.disconect();
            return (resultado != 0)?true:false;
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