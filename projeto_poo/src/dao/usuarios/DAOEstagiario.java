package dao.usuarios;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.usuarios.Estagiario;
import modelos.usuarios.Pessoa;
import sistema.Conexao;

public class DAOEstagiario{
    private Conexao conexao;
    public ArrayList<Estagiario> ReadAll(){
        try {
            ArrayList<Estagiario> estagiario = new ArrayList<Estagiario>();
            conexao.conect();
            String sql = "SELECT * FROM Estagiario";
            ResultSet result = conexao.executaQuery(sql);
            while(result.next()){
                String cpf;
                int cat, setor, pay, testagio;
                Date destagio; 
                cpf = result.getString("cpf");
                cat = result.getInt("id_categoria");
                setor = result.getInt("id_setor");
                pay = result.getInt("dia_pagamento");
                testagio = result.getInt("tempo_estagio");
                destagio = result.getDate("inicio_estagio");
                String sql2 = "SELECT * FROM Pessoa WHERE cpf = "+cpf;
                ResultSet result2 = conexao.executaQuery(sql2);
                String nome,login,senha,tipo;
                Date data_nasc;
                int id_endereco;
                nome = result2.getString("nome");
                login = result2.getString("login");
                senha = result2.getString("senha");
                tipo = result2.getString("tipo");
                data_nasc = result2.getDate("data_nasc");
                id_endereco = result2.getInt("id_endereco");
            }
            return estagiario;
        } catch (SQLException e) {
            System.err.println("Erro no banco de dados:" +e);            
            return null; 
        } catch (Exception e){
            System.err.println("Erro no código:" +e);            
            return null;
        }
    }
}