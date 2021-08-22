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

                String codBusca_pessoa = "Select * from Pessoa where cpf = " +cpf;
                ResultSet result_pessoa = conexao.executaQuery(codBusca_pessoa);
                String nome,login,senha,tipo;
                Date data_nasc;
                int id_endereco;

                nome = result_pessoa.getString("nome");
                login = result_pessoa.getString("login");
                senha = result_pessoa.getString("senha");
                tipo = result_pessoa.getString("tipo");
                data_nasc = result_pessoa.getDate("data_nasc");
                id_endereco = result_pessoa.getInt("id_endereco");

                String codBusca_funcionario = "Select * from Funcionario where cpf = " +cpf;
                ResultSet result_funcionario = conexao.executaQuery(codBusca_funcionario);
                Double bonificacao = 0.0;
                int id_categoria = 0, id_setor = 0, dia_pag = 0;
                Date data_inicio;
                Boolean achou = false; 

                if(result_funcionario.next()){
                    achou = true;
                    bonificacao = result_funcionario.getDouble("bonificacaoficacao");
                    id_categoria = result.getInt("id_categoria");
                    id_setor = result.getInt("id_setor");
                    dia_pag = result.getInt("dia_pagamento");
                    data_inicio = result.getDate("data_inicio");
                }

                if(achou){
                    throw new NullPointerException();
                }

                Gerente gente = new Gerente (nome, login, senha, tipo, cpf, data_nasc.toLocalDate(), bonificacao, bonificacao);
                arrayGerente.add(gente);
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