package dao.usuarios;

import modelos.usuarios.Dono;
import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class DAODono {
    private Conexao conexao;

    public DAODono(){
        this.conexao = new Conexao();
    }
    public ArrayList<Dono> readAll() {
        try {
            ArrayList<Dono> arrayDono = new ArrayList<>();
            conexao.conect();

            String codigoBusca = "select * from dono";
            ResultSet resultado = conexao.executaQuery(codigoBusca);

            if (!resultado.next()) {
                throw new NullPointerException("Não foi possível achar nenhum dono");
            }else{
                do{
                String cpf;

                cpf = resultado.getString("cpf");

                String sqlQueryPessoa = "Select * from pessoa where cpf = \'"+cpf+"\'";
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
                }while(resultado.next());
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
    public Dono readOneDono(String cpf){
        try{
            conexao.conect();
            String sqlQueryDono = "Select * from DONO where cpf = \'"+cpf+"\'";
            ResultSet resultadoQueryDono = conexao.executaQuery(sqlQueryDono);
            if(!resultadoQueryDono.next()){
                throw new NullPointerException("O Dono que você está procurando não foi encontrado, retornou nulo");
            }else{ 
                String sqlQueryPessoa = "select * from pessoa where cpf = \'"+cpf+"\'";
                ResultSet resultadoQueryPessoa = conexao.executaQuery(sqlQueryPessoa);
                if (!resultadoQueryPessoa.next()){
                    throw new NullPointerException("O Dono que você está procurando não foi encontrado, retornou nulo");
                }else{
                    String  nome = resultadoQueryPessoa.getString("nome"),
                            login = resultadoQueryPessoa.getString("login"),
                            senha = resultadoQueryPessoa.getString("senha"),
                            tipo = resultadoQueryPessoa.getString("tipo");
                    Date data_nasc  = resultadoQueryPessoa.getDate("data_nasc");
                    int id_endereco = resultadoQueryPessoa.getInt("id_endereco");

                    Dono dono = new Dono(nome, login, senha, tipo, cpf, data_nasc.toLocalDate(), id_endereco);
                    return dono;

                }
                
            }

            
        }
        catch (SQLException erroSQL) {
            System.err.println("Ocorreu um erro durante a busca do banco de dados: " + erroSQL);
            return null;
        } catch (Exception erroGeral) {
            System.err.println("ocorreu um erro Geral: " + erroGeral);
            return null;
        }
    }

    public boolean deleteDono(String cpf){
        try{
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
    public boolean insertDono(Dono dono){
        try{

            conexao.conect();
            String sqlInsertDono = "insert into public.Dono(cpf)\n"
                                 + "values (\'"+dono.getCpf()+"\')";
            int resultado = conexao.executaSql(sqlInsertDono);
            return (resultado != 0);
        } catch(SQLException e){
            System.err.println("Houve um erro durante a inserção no banco de dados: "+e);
            return false;
        }catch(Exception e){
            System.err.println("Houve um erro geral: "+e);
            return false;

        }
    }

    public boolean updateDono(String opt, int cpf ,String dado){
        try {
            // programador
            // programa a dor
            conexao.conect();
            String sqlUpdate;

            switch (opt) {
                case "nome":
                sqlUpdate = "Update Pessoa set nome = \'" + dado + "\' where cpf = \'" + cpf+"\';";

                    conexao.executaSql(sqlUpdate);
                    break;

                case "login":
                    sqlUpdate = "Update Pessoa set login = \'" + dado + "\' where cpf = \'" + cpf+"\';";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "senha":
                    sqlUpdate = "Update Pessoa set senha = \'" + dado + "\' where cpf = \'" + cpf+"\';";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "tipo":
                    sqlUpdate = "Update Pessoa set tipo = \'" + dado + "\' where cpf = \'" + cpf+"\';";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "cpf":
                    sqlUpdate = "Update Pessoa set cpf = \'" + dado + "\' where cpf = \'" + cpf+"\';";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "data_nasc":
                    sqlUpdate = "Update Pessoa set data_nasc = \'" + dado + "\' where cpf = \'" + cpf+"\';";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "id_endereco":
                    sqlUpdate = "Update Pessoa set id_endereco = " + dado + " where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;

                default:
                        throw new Exception("Valor não encontrado");
            }

            conexao.disconect();
            return true;

        }catch(SQLException e){
            System.err.println("Houve um erro durante a inserção no banco de dados: "+e);
            return false;
        }catch(Exception e){
            System.err.println("Houve um erro geral: "+e);
            return false;

        }     

    }

}