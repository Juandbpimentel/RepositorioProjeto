package dao.usuarios;

import sistema.Conexao;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.usuarios.Funcionario;

public class DAOFuncionario {
    private Conexao conexao;

    public ArrayList<Funcionario> readAll(){
        try {
            ArrayList<Funcionario> arrayFuncionario = new ArrayList<Funcionario>();
            conexao = new Conexao();
            conexao.conect();

            String codBusca = "Select * from funcionario";
            ResultSet resultado = conexao.executaQuery(codBusca);
            
            while(resultado.next()){
                int id_categoria=0, 
                	id_setor=0, dia_pagamento=0;
                Double bonificacao = 0.0;
                Date data_inicio = null;
                String cpf = "";
                
                id_categoria = resultado.getInt("id_categoria");
                id_setor = resultado.getInt("id_setor");
                dia_pagamento = resultado.getInt("dia_pagamento");
                bonificacao = resultado.getDouble("bonificacao");
                cpf = resultado.getString("cpf");
                data_inicio = resultado.getDate("data_inicio");
              
                String sqlQueryPessoa = "Select * from pessoa where cpf = " +cpf;
                ResultSet resultQueryPessoa = conexao.executaQuery(sqlQueryPessoa);
                           
                String nome = "", 
                	   login = "", 
                	   senha = "", tipo = "";
                int id_endereco = 0;
                Date data_nasc = new Date(System.currentTimeMillis());
                
                if(!resultQueryPessoa.next()){
                	throw new NullPointerException();
                }else {
                	do {
                		nome = resultQueryPessoa.getString("nome");
                		login = resultQueryPessoa.getString("login");
                		senha = resultQueryPessoa.getString("senha");
                		tipo = resultQueryPessoa.getString("tipo");
                		id_endereco = resultQueryPessoa.getInt("id_endereco");
                		data_nasc = resultQueryPessoa.getDate("data_nasc");
                		id_endereco = resultQueryPessoa.getInt(id_endereco);                		
                	}while(resultQueryPessoa.next());
                }


                Funcionario funcionario = new Funcionario(nome, login, senha, tipo, cpf, data_nasc.toLocalDate(), id_endereco, bonificacao,id_categoria,id_setor, dia_pagamento,data_inicio.toLocalDate());
                arrayFuncionario.add(funcionario); 
            }
        
            return arrayFuncionario;
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