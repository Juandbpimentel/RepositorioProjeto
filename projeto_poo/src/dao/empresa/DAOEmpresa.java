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
}


