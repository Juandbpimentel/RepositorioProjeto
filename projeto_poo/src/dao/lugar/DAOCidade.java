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
            conexao = new Conexao();
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

            return arrayCidade;
        } catch (SQLException SQLError) {
            System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
            return null;
        } catch (Exception geralError) {
            System.err.println("Ocorreu um erro geral: " + geralError);
            return null;
        }
    }

    public Cidade readOnCidade(int id) {
        try {
            conexao = new Conexao();
            Cidade cidade;
            String queryCidade = "SELECT * FROM CIDADE WHERE ID = " + id;
            ResultSet resultadoQuery = conexao.executaQuery(queryCidade);
            if (!resultadoQuery.next()) {
                throw new NullPointerException("Não foi possível achar nenhuma cidade");
            } else {
                String nome = resultadoQuery.getString("nome"), uf = resultadoQuery.getString("uf");
                cidade = new Cidade(id, nome, uf);
            }
            return cidade;
        } catch (SQLException SQLError) {
            System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
            return null;
        } catch (Exception geralError) {
            System.err.println("Ocorreu um erro geral: " + geralError);
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

    public boolean insertCidade(Cidade cidade){
        try{
            conexao = new Conexao();
            conexao.conect();
            String sqlInsertion = "Insert into public Cidade(nome, uf)"
                                + "values "+ cidade;
            int resultado = conexao.executaSql(sqlInsertion);

            return (resultado != 0);
        } catch(SQLException SQLError){
            System.err.println("Ocorreu um erro com Inserção no Banco de Dados: " + SQLError);
            return false;
        } catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            return false;
        }
    }

    public boolean updateCidade(int id, Cidade cidade){
        try {
            conexao = new Conexao();
            String sqlUpdate = "Update Cidade \n"+
                               "set nome = "+cidade.getNome()+" , "+
                               "uf = "+cidade.getUf()+" \n"+
                               "where id = " +cidade.getId();
            int resultado = conexao.executaSql(sqlUpdate);
            
            return (resultado != 0)?true:false;
        } catch (SQLException SQLError) {
            System.err.println("Ocorreu um erro durante a atualização do Banco de Dados: " + SQLError);
            return false;
        } catch (Exception geralError) {
            System.err.println("Ocorreu um erro geral: " + geralError);
            return false;
        }
    }
}