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
}