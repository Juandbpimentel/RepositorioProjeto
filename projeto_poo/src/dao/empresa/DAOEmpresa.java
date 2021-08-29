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

            String codBusca = "Select * from empresa";
            ResultSet resultado = conexao.executaQuery(codBusca);
            if (!resultado.next()) {
                throw new NullPointerException("Não foi possível achar nenhuma empresa");
            }else{
                do{
                    Double orc;
                    String cnpj, nome, cpf;
                    orc = resultado.getDouble("orcamento");
                    cnpj = resultado.getString("cnpj");
                    nome = resultado.getString("nome");
                    cpf = resultado.getString("cpf_dono");
                    Empresa empresa = new Empresa(nome, orc, cnpj, cpf);
                    arrayEmpresa.add(empresa);
                }while(resultado.next());
            }
            conexao.disconect();
            return arrayEmpresa;
        } 
        catch(SQLException SQLError){
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

            String codigoDelete = "delete from empresa where cnpj = \'"+cnpj+"\'";
            boolean resultado = conexao.executaSql(codigoDelete);
            
            if(!resultado){
                conexao.disconect();
                return true;
            }

            
            System.err.println("Houve um erro durante a exclusão do Banco de Dados: ");
            conexao.disconect();
            return false;

        }catch (Exception e){
            System.err.println("Houve um erro geral: "+e);
            conexao.disconect();
            return false;
        }
    }

    public boolean insertEmpresa(Empresa empresa){
        try{
            conexao.conect();

            String sqlInsertion = "Insert into public Empresa(nome, orcamento, cnpj, cpf_dono)"
                                + "values " + "(" + empresa + ")";
            boolean resultado = conexao.executaSql(sqlInsertion);

            if(!resultado){
                conexao.disconect();
                return false;
            }
            conexao.disconect();
            return true;

        } catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            conexao.disconect();
            return false;
        }
    }

    public Empresa readOnEmpresa(String pk, String opt) {
        try {
            conexao.conect();
            String queryEmpresa;
            System.out.println("Ola ola");
            if(opt == "cnpj"){
                queryEmpresa = "SELECT * FROM Empresa WHERE cnpj = \'" + pk+"\'";
                ResultSet resultadoQuery = conexao.executaQuery(queryEmpresa);
                
                if (!resultadoQuery.next()) {
                    throw new NullPointerException("Não foi possível achar a empresa");
                } else {
                    String nome = resultadoQuery.getString("nome"), cpf_dono = resultadoQuery.getString("cpf_dono"), cnpj = resultadoQuery.getString("cnpj");
                    Double orcamento = resultadoQuery.getDouble("orcamento");
                    Empresa empresa = new Empresa(nome, orcamento, cnpj, cpf_dono);
                    conexao.disconect();
                    return empresa;
                }
            }
            else if(opt == "cpf"){
                queryEmpresa = "SELECT * FROM Empresa WHERE cpf_dono = \'" + pk+"\'";
                ResultSet resultadoQuery = conexao.executaQuery(queryEmpresa);
                            
                if (!resultadoQuery.next()) {
                    throw new NullPointerException("Não foi possível achar a empresa");
                } else {
                    String nome = resultadoQuery.getString("nome"), cpf_dono = resultadoQuery.getString("cpf_dono"), cnpj = resultadoQuery.getString("cnpj");
                    Double orcamento = resultadoQuery.getDouble("orcamento");
                    Empresa empresa = new Empresa(nome, orcamento, cnpj, cpf_dono);
                    conexao.disconect();
                    return empresa;
                }
            }
            
            conexao.disconect();
            return null;
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
            
            
            String sqlUpdate;

            switch (opt) {
                case "orcamento":
                    sqlUpdate = "Update Empresa set orcamento = "+dado+" where cnpj = \'"+cnpj+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;
    
                case "nome":
                    sqlUpdate = "Update Empresa set nome = \'"+dado+"\' where cnpj = \'"+cnpj+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "cpf_dono":
                    sqlUpdate = "Update Empresa set cpf_dono = \'"+dado+"\' where cnpj = \'"+cnpj+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;
                
                case "cnpj":
                    sqlUpdate = "Update Empresa set cnpj = \'"+dado+"\' where cnpj = \'"+cnpj+"\'";
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
    
    public ArrayList<Empresa> readAll(String cpfDono){
        try {
            ArrayList<Empresa> arrayEmpresa = new ArrayList<Empresa>();
            
            conexao.conect();

            String codBusca = "Select * from empresa where cpf_dono = \'"+cpfDono+"\'";
            ResultSet resultado = conexao.executaQuery(codBusca);
            if (!resultado.next()) {
                throw new NullPointerException("Não foi possível achar nenhuma empresa");
            }else{
                do{
                    Double orc;
                    String cnpj, nome, cpf;
                    orc = resultado.getDouble("orcamento");
                    cnpj = resultado.getString("cnpj");
                    nome = resultado.getString("nome");
                    cpf = resultado.getString("cpf_dono");
                    Empresa empresa = new Empresa(nome, orc, cnpj, cpf);
                    arrayEmpresa.add(empresa);
                }while(resultado.next());
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
}


