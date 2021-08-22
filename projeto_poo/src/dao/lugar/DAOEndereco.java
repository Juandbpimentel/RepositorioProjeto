package dao.lugar;

import java.util.ArrayList;
import modelos.lugar.Endereco;
import sistema.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOEndereco {
    private Conexao conexao;

    public ArrayList<Endereco> readAll() {
        try {
            ArrayList<Endereco> arrayEnderecos = new ArrayList<Endereco>();
            conexao = new Conexao();
            conexao.conect();

            ResultSet resultado = conexao.executaQuery("select * from Endereco");

            while (resultado.next()) {
                String cep, rua, complemento;
                int id, id_bairro, numero;

                cep = resultado.getString("cep");
                rua = resultado.getString("rua");
                complemento = resultado.getString("complemento");

                id = resultado.getInt("id");
                id_bairro = resultado.getInt("id_bairro");
                numero = resultado.getInt("numero");

                Endereco endereco = new Endereco(id, numero, cep, rua, complemento, id_bairro);
                arrayEnderecos.add(endereco);

            }
            return arrayEnderecos;
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar do banco de dados" + e);
            return null;
        } catch (Exception e) {
            System.err.println("Erro Geral: " + e);
            return null;
        }
    }

}