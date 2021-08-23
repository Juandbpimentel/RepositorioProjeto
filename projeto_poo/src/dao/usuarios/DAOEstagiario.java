package dao.usuarios;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.usuarios.Estagiario;
import sistema.Conexao;

public class DAOEstagiario{
    private Conexao conexao;

    public DAOEstagiario(){
        this.conexao = new Conexao();
    }

    public ArrayList<Estagiario> ReadAll(){
        try {
            ArrayList<Estagiario> arrayEstagiario = new ArrayList<Estagiario>();
            conexao.conect();

            String sqlQueryEstagiario = "Select * from Estagiario";
            ResultSet resultQueryEstagiario = conexao.executaQuery(sqlQueryEstagiario);

            while(resultQueryEstagiario.next()){
                String cpf = "";
                int id_categoria = 0, id_setor = 0, diaPagamento = 0, tempoEstagio = 0;
                Date inicioEstagio = new Date(System.currentTimeMillis()); 
                
                cpf = resultQueryEstagiario.getString("cpf");
                id_categoria = resultQueryEstagiario.getInt("id_categoria");
                id_setor = resultQueryEstagiario.getInt("id_setor");
                diaPagamento= resultQueryEstagiario.getInt("diaPagamento");
                tempoEstagio = resultQueryEstagiario.getInt("tempoEstagio");
                inicioEstagio = resultQueryEstagiario.getDate("inicioEstagio");
                id_categoria = resultQueryEstagiario.getInt("id_categoria");
                id_setor = resultQueryEstagiario.getInt("id_setor");

                String sqlQueryPessoa = "Select * from pessoa where cpf = \'"+cpf+"\'";
                ResultSet resultQueryPessoa = conexao.executaQuery(sqlQueryPessoa);

                String nome ="", 
                       login = "", 
                       senha = "", 
                       tipo = "";

                Date data_nasc= new Date(System.currentTimeMillis());
                
                int id_endereco = 0;


                if(!resultQueryPessoa.next()){
                    throw new Exception("Não foi achada nenhuma pessoa com o cpf especificado");
                }else{
                    do {
                        nome = resultQueryPessoa.getString("nome");
                        login = resultQueryPessoa.getString("login");
                        senha = resultQueryPessoa.getString("senha");
                        tipo = resultQueryPessoa.getString("tipo");
                        data_nasc = resultQueryPessoa.getDate("data_nasc");
                        id_endereco = resultQueryPessoa.getInt("id_endereco");
                        
                    } while (resultQueryPessoa.next());
                }


                Estagiario estagiario = new Estagiario(nome, login, senha, tipo, cpf, data_nasc.toLocalDate(), inicioEstagio.toLocalDate(), tempoEstagio, diaPagamento, id_categoria, id_setor, id_endereco);
                arrayEstagiario.add(estagiario);
            }

            return arrayEstagiario;
        } 
        catch (SQLException sqlError) {
            System.err.println("Ocorreu um erro durante a busca no banco de dados:" +sqlError);            
            return null; 
        } 
        catch (Exception geralError){
            System.err.println("Ocorreu um erro geral:" +geralError);            
            return null;
        }
    }

    public Estagiario readOneEstagiario(String cpf){
        try{
            conexao.conect();
            String sqlQueryEstagiario = "Select * from Estagiario where cpf: \'"+cpf+"\'" ;
            ResultSet resultadoQueryEstagiario = conexao.executaQuery(sqlQueryEstagiario);
            if(!resultadoQueryEstagiario.next()){
                throw new NullPointerException("Não foi possível encontrar o Estagiário com este CPF");
            }else{
                int id_categoria = resultadoQueryEstagiario.getInt("id_categoria");
                int id_setor = resultadoQueryEstagiario.getInt("id_setor");
                int dia_pagamento = resultadoQueryEstagiario.getInt("dia_pagamento");
                int tempo_estagio = resultadoQueryEstagiario.getInt("tempo_estagio");
                Date inicio_estagio = resultadoQueryEstagiario.getDate("incio_estagio");
                
                String sqlQueryPessoa = "Select * from Pessoa where cpf = \'"+cpf+"\'";
                ResultSet resultadoQueryPessoa = conexao.executaQuery(sqlQueryPessoa);
                if(!resultadoQueryPessoa.next()){
                    throw new NullPointerException("Não foi possível encontrar o Estagiário com este CPF");
                    
                }else{
                    String nome = resultadoQueryPessoa.getString("nome");
                    Date data_nasc = resultadoQueryPessoa.getDate("data_nasc");
                    String login = resultadoQueryPessoa.getString("login");
                    String senha = resultadoQueryPessoa.getString("senha");
                    String tipo = resultadoQueryPessoa.getString("tipo");
                    int id_endereco = resultadoQueryPessoa.getInt("id_endereco");

                    Estagiario estagiario = new Estagiario(nome, login, senha, tipo, cpf, data_nasc.toLocalDate(), inicio_estagio.toLocalDate(), tempo_estagio, dia_pagamento, id_categoria, id_setor, id_endereco);
                    return estagiario;
                }
            }

        }catch (SQLException sqlError) {
            System.err.println("Ocorreu um erro durante a busca no banco de dados:" +sqlError);            
            return null; 
        } 
        catch (Exception geralError){
            System.err.println("Ocorreu um erro geral:" +geralError);            
            return null;
        }
    }

    public boolean insertEstagiario(Estagiario estagiario){
        try{
            conexao = new Conexao();
            conexao.conect();
            String sqlInsertion = "Insert into public.Estagiario(cpf, inicio_estagio, tempo_estagio, dia_pagamento, id_categoria, id_setor, id_endereco)\n"
                                +"values (\'"+estagiario.getCpf()+"\', "+estagiario.getInicio_estagio()+", \'"+estagiario.getTempo_estagio()+", "+estagiario.getDia_pagamento()+", "+estagiario.getId_categoria()+", "+estagiario.getId_setor()+", "+estagiario.getId_endereco()+")";
            int resultado = conexao.executaSql(sqlInsertion);
            return (resultado != 0);
        }
            catch(SQLException e){
            System.err.println("Houve um erro durante a inserção no banco de dados: "+e);
            return false;
            }
            catch(Exception e){
            System.err.println("Houve um erro geral: "+e);
            return false;
            }
        
    }

    public boolean updatePessoa(String opt, int cpf ,String dado){
        try {
            // 
            //
            conexao = new Conexao();
            int resultado;
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

                //Estagiario
                case "inicio_estagio":
                    sqlUpdate = "Update Pessoa set inicio_estagio = \'" + dado + "\' where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;
                
                case "tempo_estagio":
                    sqlUpdate = "Update Pessoa set tempo_estagio = " + dado + " where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;
                
                case "dia_pagamento":
                    sqlUpdate = "Update Pessoa set dia_pagamento = " + dado + " where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "id_categoria":
                    sqlUpdate = "Update Pessoa set id_categoria = " + dado + " where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "id_setor":
                    sqlUpdate = "Update Pessoa set id_setor = " + dado + " where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;

                default:
                    throw new Exception("Valor não encontrado");
            }

            conexao.disconect();
            return (resultado != 0);
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
    
    public boolean deleteEstagiario(String cpf){
        try{
            conexao.conect();
            String codigoDelete = "delete from estagiario where cpf = "+ cpf;
            int resultado = conexao.executaSql(codigoDelete);
            if(resultado != 1){
                System.out.println("Você teve sucesso em deletar o estagiario");
                return true;
            }



        }catch(SQLException SQLError){
            System.err.println("Houve um erro durante a exclusão do Banco de Dados: "+SQLError);
            return false;
            System.err.println("Houve um erro geral: "+geralError);
            return false;
        }
        return false;
    }
}

public boolean updateLogInteracao(int id, LogInteracao logInteracao){
    try {
        conexao = new Conexao();
        String sqlUpdate = "Update Log_interacao \n"+
                           "set data = "+logInteracao.getData()+" , "+
                           "tipo = "+logInteracao.getTipo()+" , "+
                           "codigo = "+logInteracao.getCodigo()+" , "+
                           "mensagem = "+logInteracao.getMensagem()+" , "+
                           "login_pessoa = "+logInteracao.getLogin_pessoa()+" \n"+
                           "where id = " +logInteracao.getId();
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
}

/*
    if(!resultQueryClasse.next()){
        throw new Exception("Não foi achada nenhuma pessoa com o cpf especificado");
    }else{
        do {
            
        } while (resultQueryClasse.next());
    }

*/