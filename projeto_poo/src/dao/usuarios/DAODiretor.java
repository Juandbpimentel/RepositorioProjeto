package dao.usuarios;

import modelos.usuarios.Diretor;
import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.sql.Date;

public class DAODiretor {
    private Conexao conexao;

    public ArrayList<Diretor> readAll() {
        try {
            ArrayList<Diretor> arrayDiretores = new ArrayList<Diretor>();
            conexao = new Conexao();
            conexao.conect();

            String codigoBusca = "select * from diretor";
            ResultSet resultado = conexao.executaQuery(codigoBusca);

            while (resultado.next()) {
                String nome, login, senha, tipo, cpf, cnpjEmpresa, idCategoria;
                Date dataNasc;

                nome = resultado.getString("nome");
                login = resultado.getString("login");
                senha = resultado.getString("senha");
                tipo = resultado.getString("tipo");
                cpf = resultado.getString("cpf");
                dataNasc = resultado.getDate("data_nasc");
                cnpjEmpresa = resultado.getString("cnpj_empresa");
                idCategoria = resultado.getString("id_categoria");

                Diretor diretor = new Diretor(nome, login, senha, tipo, cpf, dataNasc.toLocalDate(), cnpjEmpresa, idCategoria);
                arrayDiretores.add(diretor);

            }
            return arrayDiretores;
        } catch (SQLException erroSQL) {
            System.err.println("Erro ao recuperar do banco de dados: " + erroSQL);
            return null;
        } catch (Exception erroGeral) {
            System.err.println("Erro Geral: " + erroGeral);
            return null;
        }
    }
}