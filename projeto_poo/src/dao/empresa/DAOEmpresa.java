package dao.empresa;

import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.empresa.Empresa;

public class DAOEmpresa {
    private Conexao conexao;

    public DAOEmpresa() {
        conexao = new Conexao();
    }

    public ArrayList<Empresa> readAll(){
        try {
            ArrayList<Empresa> arrayEmpresa = new ArrayList<Empresa>();
            
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

            conexao.disconect();
            return arrayEmpresa;
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

    public boolean deleteEmpresa(String cnpj){
        try{
            conexao.conect();

            String codigoDelete = "delete from empresa where cnpj = "+ cnpj;
            int resultado = conexao.executaSql(codigoDelete);
            if(resultado != 1){
                System.out.println("Você teve sucesso em deletar a Empresa");
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

    public boolean insertEmpresa(Empresa empresa){
        try{
            conexao.conect();

            String sqlInsertion = "Insert into public Empresa(nome, orcamento, cnpj, cpf_dono)"
                                + "values " + "(" + empresa + ")";
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

    public Empresa readOnEmpresa(String cnpj) {
        try {
            conexao.conect();

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
            conexao.disconect();
            return empresa;
        } catch (SQLException SQLError) {
            System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
            conexao.disconect();
            return null;
        } catch (Exception geralError) {
            System.err.println("Ocorreu um erro geral: " + geralError);
            conexao.disconect();
            return null;
        }
    }

    public boolean updateEmpresa(String opt, String cnpj, String dado){
        try {
            conexao.conect();
            
            int resultado;
            String sqlUpdate;

            switch (opt) {
                case "orcamento":
                    sqlUpdate = "Update Empresa set id = "+dado+" where cnpj = \'"+cnpj+"\'";
                    resultado = conexao.executaSql(sqlUpdate);
                    break;
    
                case "nome":
                    sqlUpdate = "Update Empresa set nome = \'"+dado+"\' where cnpj = \'"+cnpj+"\'";
                    resultado = conexao.executaSql(sqlUpdate);
                    break;

                case "cpf_dono":
                    sqlUpdate = "Update Empresa set cpf_dono = \'"+dado+"\' where cnpj = \'"+cnpj+"\'";
                    resultado = conexao.executaSql(sqlUpdate);
                    break;
                
                case "cnpj":
                    sqlUpdate = "Update Empresa set cnpj = \'"+dado+"\' where cnpj = \'"+cnpj+"\'";
                    resultado = conexao.executaSql(sqlUpdate);
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


