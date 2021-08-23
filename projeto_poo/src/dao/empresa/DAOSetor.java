package dao.empresa;

import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.empresa.Setor;

public class DAOSetor {
    private Conexao conexao;

    public ArrayList<Setor> readAll(){
        try {
            ArrayList<Setor> arraySetor = new ArrayList<Setor>();
            conexao = new Conexao();
            conexao.conect();

            String codBusca = "Select * from funcionario";
            ResultSet resultado = conexao.executaQuery(codBusca);
            
            while(resultado.next()){
                int id;
                String nome, cnpj;
                Double orc;
                id = resultado.getInt("id");
                nome = resultado.getString("nome");
                cnpj = resultado.getString("cnpj_empresa");
                orc = resultado.getDouble("orcamento");
                Setor setor = new Setor (orc, nome, id, cnpj);
                arraySetor.add(setor);
            }
            return arraySetor;
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
    public boolean deleteSetor(int id){
        try{
            Conexao conexao = new Conexao();
            conexao.conect();
            String codigoDelete = "delete from setor where id = "+ id;
            int resultado = conexao.executaSql(codigoDelete);
            if(resultado != 1){
                System.out.println("Você teve sucesso em deletar o Setor");
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

    public boolean insertSetor(Setor setor){
        try{
            conexao = new Conexao();
            conexao.conect();
            String sqlInsertion = "Insert into public Setor(orcamento, nome, id, cnpj_empresa)"
                                + "values " + "(" + setor + ")";
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

    public Setor readOnSetor(int id) {
        try {
            conexao = new Conexao();
            Setor setor;
            String querySetor = "SELECT * FROM Setor WHERE id = " + id;
            ResultSet resultadoQuery = conexao.executaQuery(querySetor);
            if (!resultadoQuery.next()) {
                throw new NullPointerException("Não foi possível achar o setor");
            } else {
                String nome = resultadoQuery.getString("nome"), cnpj_empresa = resultadoQuery.getString("cnpj_empresa");
                Double orcamento = resultadoQuery.getDouble("orcamento");
                setor = new Setor(orcamento, nome, id, cnpj_empresa);
            }
            return setor;
        } catch (SQLException SQLError) {
            System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
            return null;
        } catch (Exception geralError) {
            System.err.println("Ocorreu um erro geral: " + geralError);
            return null;
        }
    }

    public boolean updateSetor(int id, Setor setor){
        try {
            conexao = new Conexao();
            String sqlUpdate = "Update Setor \n"+
                               "set orcamento = "+setor.getOrcamento()+" , "+
                               "nome = "+setor.getNome()+" , "+
                               "cnpj_empresa = "+setor.getCnpj_empresa()+" \n"+
                               "where id = " +setor.getId();
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