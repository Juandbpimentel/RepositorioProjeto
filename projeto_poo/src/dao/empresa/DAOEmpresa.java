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
}
