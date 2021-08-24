package dao.lugar;

import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.lugar.Cidade;

public class DAOCidade {
    private Conexao conexao;

    public DAOCidade(){
        this.conexao = new Conexao();
    }

    public ArrayList<Cidade> readAll() {
        try {
            ArrayList<Cidade> arrayCidade = new ArrayList<Cidade>();

            conexao.conect();

            String codBusca = "Select * from funcionario";
            ResultSet resultado = conexao.executaQuery(codBusca);

            while (resultado.next()) {
                int id;
                String est, nome;
                id = resultado.getInt("id");
                est = resultado.getString("id_estado");
                nome = resultado.getString("nome");
                Cidade cidade = new Cidade(id, nome, est);
                arrayCidade.add(cidade);
            }

            conexao.disconect();
            return arrayCidade;
        } catch (SQLException SQLError) {
            System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
            conexao.disconect();
            return null;
        } catch (Exception geralError) {
            System.err.println("Ocorreu um erro geral: " + geralError);
            conexao.disconect();
            return null;
        }
    }

    public Cidade readOnCidade(int id) {
        try {
            conexao.conect();

            Cidade cidade;
            String queryCidade = "SELECT * FROM CIDADE WHERE ID = " + id;
            ResultSet resultadoQuery = conexao.executaQuery(queryCidade);
            if (!resultadoQuery.next()) {
                throw new NullPointerException("Não foi possível achar nenhuma cidade");
            } else {
                String nome = resultadoQuery.getString("nome"), uf = resultadoQuery.getString("uf");
                cidade = new Cidade(id, nome, uf);
            }
            conexao.disconect();
            return cidade;
        } catch (SQLException SQLError) {
            System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
            conexao.disconect();
            return null;
        } catch (Exception geralError) {
            System.err.println("Ocorreu um erro geral: " + geralError);
            conexao.disconect();
            return null;
        }
    }
    public boolean deleteCidade(int id){
        try{
            conexao.conect();

            String codigoDelete = "delete from cidade where id = "+ id;
            int resultado = conexao.executaSql(codigoDelete);
            if(resultado != 1){
                System.out.println("Você teve sucesso em deletar a cidade");
                conexao.disconect();
                return true;
            }

        }catch(SQLException e){
            System.err.println("Houve um erro durante a exclusão do Banco de Dados: "+e);
            conexao.disconect();
            return false;
        }catch (Exception e){
            System.err.println("Houve um erro geral: "+e);
            conexao.disconect();
            return false;
        }
        conexao.disconect();
        return false;
    }

    public boolean insertCidade(Cidade cidade){
        try{
            conexao.conect();

            String sqlInsertion = "Insert into public Cidade(nome, uf)"
                                + "values "+ cidade;
            int resultado = conexao.executaSql(sqlInsertion);

            conexao.disconect();
            return (resultado != 0);
        } catch(SQLException SQLError){
            System.err.println("Ocorreu um erro com Inserção no Banco de Dados: " + SQLError);
            conexao.disconect();
            return false;
        } catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            conexao.disconect();
            return false;
        }
    }

    public boolean updateCidade(String opt, int id, String dado){
        try {
            conexao.conect();
            
            int resultado;
            String sqlUpdate;

            switch (opt) {
                case "id":
                    sqlUpdate = "Update Cidade set id = "+dado+" where id = " + id;
                    conexao.executaSql(sqlUpdate);
                    break;
    
                case "nome":
                    sqlUpdate = "Update Cidade set nome = \'"+dado+"\' where id = " + id;
                    conexao.executaSql(sqlUpdate);
                    break;

                case "uf":
                    sqlUpdate = "Update Cidade set uf = \'"+dado+"\' where id = " + id;
                    conexao.executaSql(sqlUpdate);
                    break;

                default:
                    throw new Exception("Valor não encontrado");
            }
            conexao.disconect();
            return true;
        } catch (SQLException SQLError) {
            System.err.println("Ocorreu um erro durante a atualização do Banco de Dados: " + SQLError);
            conexao.disconect();
            return false;
        } catch (Exception geralError) {
            System.err.println("Ocorreu um erro geral: " + geralError);
            conexao.disconect();
            return false;
        }
    }
}