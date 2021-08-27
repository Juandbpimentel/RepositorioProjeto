package dao.empresa;

import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.empresa.Setor;

public class DAOSetor {
    private Conexao conexao;

    public DAOSetor() {
        conexao = new Conexao();
    }

    public ArrayList<Setor> readAll(){
        try {
            ArrayList<Setor> arraySetor = new ArrayList<Setor>();
            conexao.conect();

            String codBusca = "Select * from Setor";
            ResultSet resultado = conexao.executaQuery(codBusca);
            
            if (!resultado.next()) {
                throw new NullPointerException("Não foi possível achar nenhuma categoria");
            }else{
                do{
                    int id;
                    String nome, cnpj;
                    Double orc;
                    id = resultado.getInt("id");
                    nome = resultado.getString("nome");
                    cnpj = resultado.getString("cnpj_empresa");
                    orc = resultado.getDouble("orcamento");
                    Setor setor = new Setor (orc, nome, id, cnpj);
                    arraySetor.add(setor);
                }while(resultado.next());
            }
            conexao.disconect();
            return arraySetor;
        } 
        catch(SQLException SQLError){
            System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
            conexao.disconect();
            return null;
        }
        catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            conexao.disconect();
            return null;
        }
    }
    public boolean deleteSetor(int id){
        try{
            conexao.conect();

            String codigoDelete = "delete from setor where id = "+ id;
            boolean resultado = conexao.executaSql(codigoDelete);
            
            if(!resultado){
                System.out.println("Você teve sucesso em deletar o Setor");
                conexao.disconect();
                return true;
            }

            conexao.disconect();
            return false;
        }catch (Exception e){
            System.err.println("Houve um erro geral: "+e);
            conexao.disconect();
            return false;
        }
    }

    public boolean insertSetor(Setor setor){
        try{
            conexao.conect();

            String sqlInsertion = "Insert into public Setor(orcamento, nome, cnpj_empresa)"
                                + "values " + "(" + setor + ")";
            boolean resultado = conexao.executaSql(sqlInsertion);

            if(!resultado){
                conexao.disconect();
                return false;
            }
            conexao.disconect();
            return true;

        } catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            conexao.disconect();
            return false;
        }
    }

    public Setor readOnSetor(int id) {
        try {
            Setor setor;

            conexao.conect();

            String querySetor = "SELECT * FROM Setor WHERE id = " + id;
            ResultSet resultadoQuery = conexao.executaQuery(querySetor);
            if (!resultadoQuery.next()) {
                throw new NullPointerException("Não foi possível achar o setor");
            } else {
                String nome = resultadoQuery.getString("nome"), cnpj_empresa = resultadoQuery.getString("cnpj_empresa");
                Double orcamento = resultadoQuery.getDouble("orcamento");
                setor = new Setor(orcamento, nome, id, cnpj_empresa);
            }
            conexao.disconect();
            return setor;
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

    public boolean updateSetor(String opt, int id, String dado){
        try {
            conexao.conect();
                        
            String sqlUpdate;

            switch (opt) {
                case "id":
                    sqlUpdate = "Update Setor set id = "+dado+" where id = "+id;
                    conexao.executaSql(sqlUpdate);
                    break;
    
                case "nome":
                    sqlUpdate = "Update Setor set nome = \'"+dado+"\' where id = "+id;
                    conexao.executaSql(sqlUpdate);
                    break;

                case "orcamento":
                    sqlUpdate = "Update Setor set orcamento = "+dado+" where id = "+id;
                    conexao.executaSql(sqlUpdate);
                    break;
                
                case "cnpj_empresa":
                    sqlUpdate = "Update Setor set cnpj_empresa = \'"+dado+"\' where id = "+id;
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