package dao.usuarios;

import modelos.usuarios.Diretor;
import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                String cnpjEmpresa = "", cpf="";
                int idCategoria = 0;

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

                Diretor diretor = new Diretor(nome, login, senha, tipo, cpf, dataNasc.toLocalDate(), cnpjEmpresa, idCategoria,id_endereco);
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
    public boolean deleteDiretor(String cpf){
        try{
            Conexao conexao = new Conexao();
            conexao.conect();
            String codigoDelete = "delete from Diretor where cpf = "+ cpf;
            int resultado = conexao.executaSql(codigoDelete);
            if(resultado != 1){
                System.out.println("Você teve sucesso em deletar o diretor");
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