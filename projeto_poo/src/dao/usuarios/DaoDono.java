package dao.usuarios;

import modelos.usuarios.Diretor;
import modelos.usuarios.Dono;
import modelos.sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAODono {
    private Conexao conexao;

    public ArrayList<Dono> readAll() {
        try {
            ArrayList<Dono> donoEmpresa = new ArrayList<Dono>();
            conexao = new Conexao();
            conexao.conect();

            String codigoBusca = "select * from dono";
            ResultSet rs = conexao.executaQuery(codigoBusca);

            while (rs.next()) {
                Dono don = new Dono();
                don.setCpf(rs.getString("cpf"));
            }
            return donoEmpresa;
        } catch (SQLException erroSQL) {
            System.err.println("Erro ao recuperar do banco de dados: " + erroSQL);
            return null;
        } catch (Exception erroGeral) {
            System.err.println("Erro Geral: " + erroGeral);
            return null;
        }

    }
}