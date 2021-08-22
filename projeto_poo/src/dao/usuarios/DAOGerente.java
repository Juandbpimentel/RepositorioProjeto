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
            ArrayList<Gerente> gerente = new ArrayList<Gerente>();
            conexao = new Conexao();
            conexao.conect();
            String sql = "SELECT * FROM Gerente";
            ResultSet result = conexao.executaQuery(sql);
            while(result.next()){
                String cpf = "";
                Double bon = 0.0;
                cpf = result.getString("cpf");
                bon = result.getDouble("bonificacao_gerente");
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
                String sql3 = "SELECT * FROM Funcionario WHERE cpf = "+cpf;
                ResultSet result3 = conexao.executaQuery(sql3);
                Double boni = 0.0;
                int idc = 0, serial = 0, pay = 0;
                Date data;
                boni = result3.getDouble("bonificacao");
                idc = result.getInt("id_categoria");
                serial = result.getInt("id_setor");
                pay = result.getInt("dia_pagamento");
                data = result.getDate("data_inicio");
                Gerente gente = new Gerente (nome, login, senha, tipo, cpf, LocalDate.of(data_nasc.getYear(),data_nasc.getDay(),data_nasc.getMonth()), boni, bon);
                gerente.add(gente);
            }
        return gerente;
        } catch (SQLException e) {
            System.err.println("Erro no banco de dados:" +e);            
            return null; 
        } catch (Exception e){
            System.err.println("Erro no código:" +e);            
            return null;
        }
    }
}