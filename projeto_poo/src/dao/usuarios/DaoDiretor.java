package dao.usuarios;

import modelos.usuarios.Diretor;
import modelos.sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAODiretor {
    private Conexao conexao;

    public ArrayList<Diretor> readAll() {
        try {
            ArrayList<Diretor> diretores = new ArrayList<Diretor>();
            conexao = new Conexao();
            conexao.conect();

            String codigoBusca = "select * from diretor";
            ResultSet rs = conexao.executaQuery(codigoBusca);

            while (rs.next()) {
                Diretor dir = new Diretor();
                dir.setCpf(rs.getString("cpf"));

            }
        return diretores;
        } catch (SQLException erroSQL) {
            System.err.println("Erro ao recuperar do banco de dados: " + erroSQL);
            return null;
        } catch (Exception erroGeral) {
            System.err.println("Erro Geral: " + erroGeral);
            return null;
        }
    }
}