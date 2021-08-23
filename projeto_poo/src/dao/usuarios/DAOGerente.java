package dao.usuarios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import sistema.Conexao;
import modelos.usuarios.Gerente;

public class DAOGerente {
    private Conexao conexao;

    public DAOGerente(){
        this.conexao = new Conexao();
    }

    public ArrayList<Gerente> readAll(){
        try {
            ArrayList<Gerente> arrayGerente= new ArrayList<Gerente>();
            conexao.conect();

            String codBusca = "Select * from Gerente";
            ResultSet result = conexao.executaQuery(codBusca);

            while(result.next()){
                String cpf = "";
                Double bonificacao_gerente = 0.0;

                cpf = result.getString("cpf");
                bonificacao_gerente = result.getDouble("bonificacao_gerente");

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

                String sqlQueryFuncionario = "Select * from Funcionario where cpf = " +cpf;
                ResultSet resultQueryFuncionario = conexao.executaQuery(sqlQueryFuncionario);

                Double bonificacao = 0.0;
                int id_categoria = 0, 
                    id_setor = 0, 
                    dia_pagamento = 0;
                    
                Date data_inicio;
                
                if(!resultQueryFuncionario.next()){
                    throw new Exception("Não foi achado nenhum funcionario com o cpf especificado");
                }else{
                    do {
                        bonificacao = resultQueryFuncionario.getDouble("bonificacaoficacao");
                        id_categoria = resultQueryFuncionario.getInt("id_categoria");
                        id_setor = resultQueryFuncionario.getInt("id_setor");
                        dia_pagamento = resultQueryFuncionario.getInt("dia_pagamento");
                        data_inicio = resultQueryFuncionario.getDate("data_inicio");
                    } while (resultQueryFuncionario.next());
                }

                Gerente gerente = new Gerente (nome, login, senha, tipo, cpf, data_nasc.toLocalDate(),id_categoria,id_setor,dia_pagamento,bonificacao, data_inicio.toLocalDate(), bonificacao_gerente, id_endereco);
                arrayGerente.add(gerente);
            }
        return arrayGerente;

        } 
        catch (SQLException SQLError) {
            System.err.println("Erro no banco de dados:" +SQLError);            
            return null; 
        } 
        catch (Exception geralError){
            System.err.println("Erro no código:" +geralError);            
            return null;
        }
    }

    public Gerente readOneGerente(String cpf){
        try {
            conexao.conect();
            // select * from gerente where cpf = '162.947.147-02'
            String sqlQueryGerente = "SELECT * FROM GERENTE WHERE cpf = \'"+cpf+"\'";
            ResultSet resultadoQueryGerente = conexao.executaQuery(sqlQueryGerente);
            if (!resultadoQueryGerente.next()) {
                throw new NullPointerException("O Gerente que você está procurando não foi encontrado, retornou nulo");
            }else{
                Double bonificacao_gerente = resultadoQueryGerente.getDouble("bonificacao_gerente");
                
                String sqlQueryFuncionario = "select * from funcionario where cpf = \'"+cpf+"\'";
                ResultSet resultadoQueryFuncionario = conexao.executaQuery(sqlQueryFuncionario);
                if (!resultadoQueryFuncionario.next()) {
                    throw new NullPointerException("O Gerente que você está procurando não foi encontrado, retornou nulo");
                }else{
                    Double bonificacao = resultadoQueryFuncionario.getDouble("bonificacao");
                    
                    int id_categoria = resultadoQueryFuncionario.getInt("id_categoria"),
                        id_setor = resultadoQueryFuncionario.getInt("id_setor"),
                        dia_pagamento = resultadoQueryFuncionario.getInt("dia_pagamento");

                    Date data_inicio = resultadoQueryFuncionario.getDate("data_inicio");
                        
                    String sqlQueryPessoa = "select * from pessoa where cpf = \'"+cpf+"\'";

                    ResultSet resultadoQueryPessoa = conexao.executaQuery(sqlQueryPessoa);
                    if (!resultadoQueryPessoa.next()) {
                        throw new NullPointerException("O Gerente que você está procurando não foi encontrado, retornou nulo");
                    }else{
                        String nome = resultadoQueryPessoa.getString("nome"),
                               login = resultadoQueryPessoa.getString("login"),
                               senha = resultadoQueryPessoa.getString("seha"),
                               tipo = resultadoQueryPessoa.getString("tipo");
                        
                        int id_endereco = resultadoQueryPessoa.getInt("id_endereco");
                        Date data_nasc = resultadoQueryPessoa.getDate("data_nasc");
                        
                        Gerente gerente = new Gerente(nome, login, senha, tipo, cpf, data_nasc.toLocalDate(), id_categoria, id_setor, dia_pagamento, bonificacao, data_inicio.toLocalDate(), bonificacao_gerente, id_endereco);
                        return gerente;
                    }
                }
            }
        } catch (SQLException SQLError) {
            System.err.println("Ocorreu um erro durante a busca no Banco de Dados: " + SQLError);
            return null;
        } catch (Exception geralError) {
            System.err.println("Ocorreu um erro geral: " + geralError);
            return null;
        }
    }

    public boolean deleteGerente(String cpf){
        try{
            conexao.conect();
            String codigoDelete = "delete from Gerente where cpf = "+ cpf;
            int resultado = conexao.executaSql(codigoDelete);
            if(resultado != 1){
                System.out.println("Você teve sucesso em deletar o gerente");
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
    public boolean insertGerente(Gerente gerente){
        try {
            conexao.conect();
            String sqlInsertGerente = "insert into public.Gerente(bonificacao_gerente, cpf)\n"
            +"values("+gerente.getBonificacao_gerente()+" , \'"+gerente.getCpf()+"\')";
            int resultado = conexao.executaSql(sqlInsertGerente);
            return (resultado != 0);
        } catch (SQLException e) {
            System.err.println("Houve um erro durante a inserção no banco de dados: "+e);
            return false;
        }catch(Exception e){
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
                    
                case "bonificacao_gerente":
                    sqlUpdate = "Update Gerente set bonificacao_gerente = " + dado + " where cpf = " + cpf;
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