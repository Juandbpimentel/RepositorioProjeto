package dao.usuarios;

import modelos.usuarios.Dono;
import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class DAODono {
    private Conexao conexao;

    public ArrayList<Dono> readAll() {
        try {
            ArrayList<Dono> arrayDono = new ArrayList<Dono>();
            conexao = new Conexao();
            conexao.conect();

            String codigoBusca = "select * from dono";
            ResultSet resultado = conexao.executaQuery(codigoBusca);

            while (resultado.next()) {
                String cpf;

                cpf = resultado.getString("cpf");

                String sqlQueryPessoa = "Select * from pessoa where cpf = "+cpf;
                ResultSet resultadoQueryPessoa = conexao.executaQuery(sqlQueryPessoa);

                String nome = "", login="", senha="", tipo="";
                int id_endereco = 0;
                Date dataNasc = new Date(System.currentTimeMillis());
                boolean achou = false;

                if(resultadoQueryPessoa.next()){
                    nome = resultado.getString("nome");
                    login = resultado.getString("login");
                    senha = resultado.getString("senha");
                    tipo = resultado.getString("tipo");
                    dataNasc = resultado.getDate("data_nasc");
                    id_endereco = resultado.getInt("id_endereco");
                    achou = true;
                }
                if (!achou) {
                    throw new NullPointerException("Não foi achada nenhuma pessoa com esse cpf");
                }
                Dono dono = new Dono(nome, login, senha, tipo, cpf, dataNasc.toLocalDate(),id_endereco);
                arrayDono.add(dono);
            }
            return arrayDono;
        } catch (SQLException erroSQL) {
            System.err.println("Erro ao recuperar do banco de dados: " + erroSQL);
            return null;
        } catch (Exception erroGeral) {
            System.err.println("Erro Geral: " + erroGeral);
            return null;
        }

    }
    public boolean deleteDono(String cpf){
        try{
            Conexao conexao = new Conexao();
            conexao.conect();
            String codigoDelete = "delete from Dono where cpf = "+ cpf;
            int resultado = conexao.executaSql(codigoDelete);
            if(resultado != 1){
                System.out.println("Você teve sucesso em deletar o dono");
                return true;
            }



        }catch(SQLException e){
            System.err.println("Houve um erro durante a exclusão do Banco de Dados: "+e);
            return false;
        }catch (Exception e){
            System.err.println("Houve um erro geral: "+e);
            return false;
        }
        return false;
    }
}