package dao.usuarios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import sistema.Conexao;
import modelos.usuarios.Gerente;

public class DAOGerente {
    private Conexao conexao;
    public ArrayList<Gerente> readAll(){
        try {
            ArrayList<Gerente> arrayGerente= new ArrayList<Gerente>();
            conexao = new Conexao();
            conexao.conect();

            String codBusca = "Select * from Gerente";
            ResultSet result = conexao.executaQuery(codBusca);

            while(result.next()){
                String cpf = "";
                Double bonificacao_gerente = 0.0;

                cpf = result.getString("cpf");
                bonificacao_gerente = result.getDouble("bonificacao_gerente");

                String sqlQueryPessoa = "Select * from Pessoa where cpf = "+cpf;
                ResultSet resultQueryPessoa = conexao.executaQuery(sqlQueryPessoa);

                String nome ="", 
                       login = "", 
                       senha = "", 
                       tipo = "";

                Date data_nasc= new Date(System.currentTimeMillis());
                
                int id_endereco = 0;


                if(!resultQueryPessoa.next()){
                    throw new Exception("Não foi achada nenhuma pessoa com o cpf especificado");
                }else{
                    do {
                        nome = resultQueryPessoa.getString("nome");
                        login = resultQueryPessoa.getString("login");
                        senha = resultQueryPessoa.getString("senha");
                        tipo = resultQueryPessoa.getString("tipo");
                        data_nasc = resultQueryPessoa.getDate("data_nasc");
                        id_endereco = resultQueryPessoa.getInt("id_endereco");
                        
                    } while (resultQueryPessoa.next());
                }

                String sqlQueryFuncionario = "Select * from Funcionario where cpf = " +cpf;
                ResultSet resultQueryFuncionario = conexao.executaQuery(sqlQueryFuncionario);

                Double bonificacao = 0.0;
                int id_categoria = 0, 
                    id_setor = 0, 
                    dia_pagamento = 0;
                    
                Date data_inicio;
                Boolean achou = false; 
                
                if(!resultQueryFuncionario.next()){
                    throw new Exception("Não foi achado nenhum funcionario com o cpf especificado");
                }else{
                    do {
                        bonificacao = resultQueryFuncionario.getDouble("bonificacaoficacao");
                        id_categoria = resultQueryFuncionario.getInt("id_categoria");
                        id_setor = resultQueryFuncionario.getInt("id_setor");
                        dia_pagamento = resultQueryFuncionario.getInt("dia_pagamento");
                        data_inicio = resultQueryFuncionario.getDate("data_inicio");
                    } while (resultQueryFuncionario.next());
                }

                Gerente gerente = new Gerente (nome, login, senha, tipo, cpf, data_nasc.toLocalDate(),id_categoria,id_setor,dia_pagamento,bonificacao, data_inicio.toLocalDate(), bonificacao_gerente, id_endereco);
                arrayGerente.add(gerente);
            }
        return arrayGerente;

        } 
        catch (SQLException SQLError) {
            System.err.println("Erro no banco de dados:" +SQLError);            
            return null; 
        } 
        catch (Exception geralError){
            System.err.println("Erro no código:" +geralError);            
            return null;
        }
    }
}