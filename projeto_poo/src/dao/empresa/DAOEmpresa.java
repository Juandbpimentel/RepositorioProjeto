package dao.empresa;

import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.empresa.Empresa;

public class DAOEmpresa {
    private Conexao conexao;

    public ArrayList<Empresa> readAll(){
        try {
            ArrayList<Empresa> arrayEmpresa = new ArrayList<Empresa>();
            conexao = new Conexao();
            conexao.conect();

            String codBusca = "Select * from funcionario";
            ResultSet resultado = conexao.executaQuery(codBusca);
            
            while(resultado.next()){
                Double orc;
                String cnpj, nome, cpf;
                orc = resultado.getDouble("orcamento");
                cnpj = resultado.getString("cnpj");
                nome = resultado.getString("nome");
                cpf = resultado.getString("cpf_dono");
                Empresa empresa = new Empresa(nome, orc, cnpj, cpf);
                arrayEmpresa.add(empresa);
            }
            return arrayEmpresa;
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
    public boolean deleteEmpresa(String cnpj){
        try{
            Conexao conexao = new Conexao();
            conexao.conect();
            String codigoDelete = "delete from empresa where cnpj = "+ cnpj;
            int resultado = conexao.executaSql(codigoDelete);
            if(resultado != 1){
                System.out.println("Você teve sucesso em deletar a Empresa");
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

    public boolean insertEmpresa(Empresa empresa){
        try{
            conexao = new Conexao();
            conexao.conect();
            String sqlInsertion = "Insert into public Empresa(nome, orcamento, cnpj, cpf_dono)"
                                + "values " + "(" + empresa + ")";
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

    public Empresa readOnEmpresa(String cnpj) {
        try {
            conexao = new Conexao();
            Empresa empresa;
            String queryEmpresa = "SELECT * FROM Empresa WHERE cnpj = " + cnpj;
            ResultSet resultadoQuery = conexao.executaQuery(queryEmpresa);
            if (!resultadoQuery.next()) {
                throw new NullPointerException("Não foi possível achar a empresa");
            } else {
                String nome = resultadoQuery.getString("nome"), cpf_dono = resultadoQuery.getString("cpf_dono");
                Double orcamento = resultadoQuery.getDouble("orcamento");
                empresa = new Empresa(nome, orcamento, cnpj, cpf_dono);
            }
            return empresa;
        } catch (SQLException SQLError) {
            System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
            return null;
        } catch (Exception geralError) {
            System.err.println("Ocorreu um erro geral: " + geralError);
            return null;
        }
    }

    public boolean updateEmpresa(String cnpj, Empresa empresa){
        try {
            conexao = new Conexao();
            String sqlUpdate = "Update Empresa \n"+
                               "set orcamento = "+empresa.getOrcamento()+" , "+
                               "nome = "+empresa.getNome()+" , "+
                               "cpf_dono = "+empresa.getCpf_dono()+" \n"+
                               "where cnpj = " +empresa.getCnpj();
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


