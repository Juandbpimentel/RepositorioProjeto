package dao.usuarios;

import modelos.usuarios.Diretor;
import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class DAODiretor {
    private Conexao conexao;

    public DAODiretor(){
        this.conexao = new Conexao();
    }

    public ArrayList<Diretor> readAll() {
        try {
            ArrayList<Diretor> arrayDiretores = new ArrayList<>();
            conexao = new Conexao();
            conexao.conect();

            String codigoBusca = "select * from diretor";
            ResultSet resultado = conexao.executaQuery(codigoBusca);

            if (!resultado.next()) {
                throw new NullPointerException("Não foi possível achar nenhuma diretor");
            }else{
                do{
                    String cnpjEmpresa = "", cpf="";
                    int idCategoria = 0;

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

                    Diretor diretor = new Diretor(nome, login, senha, tipo, cpf, dataNasc.toLocalDate(), cnpjEmpresa, idCategoria,id_endereco);
                    arrayDiretores.add(diretor);

                }while(resultado.next());
            }
            conexao.disconect();
            return arrayDiretores;
        } catch (SQLException erroSQL) {
            System.err.println("Erro ao recuperar do banco de dados: " + erroSQL);
            conexao.disconect();
            return null;
        } catch (Exception erroGeral) {
            System.err.println("Erro Geral: " + erroGeral);
            conexao.disconect();
            return null;
        }
    }   


    public Diretor readOneDiretor(String cpf){

        try{
            conexao.conect();
            String sqlQueryDiretor = "Select * from DIRETOR where cpf = \'"+cpf+"\'";
            ResultSet resultadoQueryDiretor = conexao.executaQuery(sqlQueryDiretor);
            if(!resultadoQueryDiretor.next()){
                throw new NullPointerException("O Diretor que você está procurando não foi encontrado, retornou nulo");
            }else{ 
                String cnpj_empresa = resultadoQueryDiretor.getString("cnpj_empresa");
                int id_categoria = resultadoQueryDiretor.getInt("id_categoria");

                String sqlQueryPessoa = "select * from pessoa where cpf = \'"+cpf+"\'";
                ResultSet resultadoQueryPessoa = conexao.executaQuery(sqlQueryPessoa);
                if (!resultadoQueryPessoa.next()){
                    throw new NullPointerException("A pessoa que você está procurando não foi encontrada, retornou nulo");
                }else{
                    
                    String  nome = resultadoQueryPessoa.getString("nome"),
                            login = resultadoQueryPessoa.getString("login"),
                            senha = resultadoQueryPessoa.getString("senha"),
                            tipo = resultadoQueryPessoa.getString("tipo");
                    Date data_nasc  = resultadoQueryPessoa.getDate("data_nasc");
                    int id_endereco = resultadoQueryPessoa.getInt("id_endereco");

                    Diretor diretor = new Diretor(nome, login, senha, tipo, cpf, data_nasc.toLocalDate(),cnpj_empresa, id_categoria, id_endereco);
                    conexao.disconect();
                    return diretor;

                }
                
            }
        }catch (SQLException erroSQL) {
            System.err.println("Ocorreu um erro durante a busca do banco de dados: " + erroSQL);
            conexao.disconect();
            return null;
        } catch (Exception erroGeral) {
            System.err.println("ocorreu um erro Geral: " + erroGeral);
            conexao.disconect();
            return null;
        }
    }
    
    public boolean updateDiretor(String opt, String cpf ,String dado){
        try {
            // 
            //
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
                //Diretor
                case "cnpj_empresa":
                    sqlUpdate = "Update Diretor set cnpj_empresa = \'" + dado + "\' where cpf = \'" + cpf+"\';";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "id_categoria":
                    sqlUpdate = "Update Pessoa set id_categoria = " + dado + " where cpf = \'" + cpf+"\'";
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

    public boolean deleteDiretor(String cpf){
        try{
            conexao.conect();
            
            String codigoDelete = "delete from Diretor where cpf = \'"+ cpf +"\'";
            boolean resultado = conexao.executaSql(codigoDelete);
            
            if(resultado){
                System.out.println("Você teve sucesso em deletar o diretor");
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



    

    public boolean insertDiretor(Diretor diretor){
        try{

            conexao.conect();
            String sqlInsertDiretor = "insert into public.Diretor(cpf, cnpj_empresa, id_categoria)\n"
                                 + "values (\'"+diretor.getCpf()+"\' , \'"+diretor.getCnpj_empresa()+"\' , "+diretor.getId_categoria()+ ")\n";
            boolean resultado = conexao.executaSql(sqlInsertDiretor);

            if(!resultado){
                conexao.disconect();
                return false;
            }
            conexao.disconect();
            return true;
        } catch(Exception e){
            System.err.println("Houve um erro geral: "+e);
            conexao.disconect();
            return false;

        }

    }
}