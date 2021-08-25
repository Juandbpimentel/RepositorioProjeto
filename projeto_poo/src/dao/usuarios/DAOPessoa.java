package dao.usuarios;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.usuarios.Diretor;
import modelos.usuarios.Dono;
import modelos.usuarios.Estagiario;
import modelos.usuarios.Funcionario;
import modelos.usuarios.Gerente;
import modelos.usuarios.Pessoa;
import sistema.Conexao;

public class DAOPessoa{
    private Conexao conexao;

    public DAOPessoa(){
        this.conexao = new Conexao();
    }
    public ArrayList<Pessoa> ReadAll(){
        try {
            ArrayList<Pessoa> arrayPessoas = new ArrayList<Pessoa>();
            conexao.conect();
            String sql = "SELECT * FROM Pessoa";
            ResultSet result = conexao.executaQuery(sql);
            if (!result.next()) {
                throw new NullPointerException("Não foi possível achar nenhuma Pessoa");
            }else{
                do{
                    String nome, cpf, login, senha, tipo;
                    int id_endereco;
                    Date data_nasc;

                    nome = result.getString("nome");
                    data_nasc = result.getDate("data_nasc");
                    cpf = result.getString("cpf");
                    login = result.getString("login");
                    senha = result.getString("senha");
                    tipo = result.getString("tipo");
                    id_endereco = result.getInt("id_endereco");
                    Pessoa pessoa = new Pessoa(nome,login,senha,tipo,cpf,data_nasc.toLocalDate(),id_endereco);
                    arrayPessoas.add(pessoa);
                }while(result.next());
            }

            return arrayPessoas;
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
    public boolean deletePessoa(String cpf){
        try{
            conexao.conect();
            String codigoDelete = "delete from pessoa where cpf = "+ cpf;
            int resultado = conexao.executaSql(codigoDelete);
            if(resultado != 1){
                System.out.println("Você teve sucesso em deletar o pessoa");
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

    public boolean updatePessoa(String opt, int cpf ,String dado){
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


    public Pessoa readOnePessoa(String cpf){
        try {
            conexao.conect();
            String sqlQueryPessoa = "SELECT * FROM PESSOA WHERE cpf = \'"+cpf+"\'";
            ResultSet resultadoQueryPessoa = conexao.executaQuery(sqlQueryPessoa);
            if (!resultadoQueryPessoa.next()) {
                throw new NullPointerException("A pessoa que você está procurando não foi encontrado, retornou nulo");
            }else{
                String nome = resultadoQueryPessoa.getString("nome"), login = resultadoQueryPessoa.getString("login"), senha = resultadoQueryPessoa.getString("senha"), tipo = resultadoQueryPessoa.getString("tipo");
                int id_endereco = resultadoQueryPessoa.getInt("id_endereco");
                Date data_nasc = resultadoQueryPessoa.getDate("data_nasc");
                Pessoa pessoa = new Pessoa(nome,login,senha,tipo,cpf,data_nasc.toLocalDate(),id_endereco);
                return pessoa;
            }
        } catch (SQLException SQLError) {
            System.err.println("Ocorreu um erro durante a busca no Banco de Dados: " + SQLError);
            return null;
        } catch (Exception geralError) {
            System.err.println("Ocorreu um erro geral: " + geralError);
            return null;
        }
    }
    
    public Pessoa readOnePessoa(String entryLogin, String entrySenha){
        try {
            conexao.conect();
            String sqlQueryPessoa = "SELECT * FROM PESSOA WHERE login = \'"+entryLogin+"\'";
            ResultSet resultadoQueryPessoa = conexao.executaQuery(sqlQueryPessoa);
            if (!resultadoQueryPessoa.next()) {
                throw new NullPointerException("A pessoa que você está procurando não foi encontrado, retornou nulo");
            }else{
                if (entryLogin.equals(resultadoQueryPessoa.getString("senha")) ) {
                    throw new Exception("A senha digitada está incorreta");
                }
                String nome = resultadoQueryPessoa.getString("nome"), 
                       login = resultadoQueryPessoa.getString("login"), 
                       senha = resultadoQueryPessoa.getString("senha"), 
                       tipo = resultadoQueryPessoa.getString("tipo"), 
                       cpf = resultadoQueryPessoa.getString("cpf");
                int id_endereco = resultadoQueryPessoa.getInt("id_endereco");
                Date data_nasc = resultadoQueryPessoa.getDate("data_nasc");

                switch (resultadoQueryPessoa.getString("tipo")) {//"Tipo"
                    case "FUN":
                        String sqlQueryFuncionario = "Select * From Funcionario Where cpf = \'"+cpf+"\'";
                        ResultSet resultadoQueryFuncionario = conexao.executaQuery(sqlQueryFuncionario);
                
                        if(!resultadoQueryFuncionario.next()){
                            throw new NullPointerException("Não foi possível encontrar o funcionário com este cpf");            
                        } else{
                            int id_setor = resultadoQueryFuncionario.getInt("id_setor"), 
                                        dia_pagamento = resultadoQueryFuncionario.getInt("dia_pagamento"), 
                                        id_categoria = resultadoQueryFuncionario.getInt("id_categoria");
                            double bonificacao = resultadoQueryFuncionario.getDouble("bonificacao");

                            Date data_inicio = resultadoQueryFuncionario.getDate("data_inicio");
                            Funcionario funcionario = new Funcionario(nome, login, senha, tipo, cpf, data_nasc.toLocalDate(), id_endereco, bonificacao,id_categoria, id_setor, dia_pagamento, data_inicio.toLocalDate());
                            return funcionario;
                        }
                    case "GER":
                        String codBusca = "Select * from Gerente";
                        ResultSet resultado = conexao.executaQuery(codBusca);
            
                        if (!resultado.next()) {
                            throw new NullPointerException("Não foi possível achar nenhuma Gerente");
                        }else{
                            Double bonificacao_gerente = 0.0;
                            bonificacao_gerente = resultado.getDouble("bonificacao_gerente");


                            String sqlQueryFuncionarioGerente = "Select * From Funcionario Where cpf = \'"+cpf+"\'";
                            ResultSet resultadoQueryFuncionarioGerente = conexao.executaQuery(sqlQueryFuncionarioGerente);
                    
                            if(!resultadoQueryFuncionarioGerente.next()){
                                throw new NullPointerException("Não foi possível encontrar o funcionário com este cpf");            
                            } else{
                                int id_setor = resultadoQueryFuncionarioGerente.getInt("id_setor"), 
                                            dia_pagamento = resultadoQueryFuncionarioGerente.getInt("dia_pagamento"), 
                                            id_categoria = resultadoQueryFuncionarioGerente.getInt("id_categoria");
                                double bonificacao = resultadoQueryFuncionarioGerente.getDouble("bonificacao");
                                Date data_inicio = resultadoQueryFuncionarioGerente.getDate("data_inicio");
                                Gerente gerente = new Gerente(nome, login, senha, tipo, cpf, data_nasc.toLocalDate(), id_categoria, id_setor, dia_pagamento, bonificacao, data_inicio.toLocalDate(), bonificacao_gerente, id_endereco);
                                return gerente;
                            }
                        }
                    case "EST":
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
                            Estagiario estagiario = new Estagiario(nome, login, senha, tipo, cpf, data_nasc.toLocalDate(), inicio_estagio.toLocalDate(), tempo_estagio, dia_pagamento, id_categoria, id_setor, id_endereco);
                            return estagiario;
                        }
                    case "DIR":
                        String sqlQueryDiretor = "Select * from DIRETOR where cpf = \'"+cpf+"\'";
                        ResultSet resultadoQueryDiretor = conexao.executaQuery(sqlQueryDiretor);
                        if(!resultadoQueryDiretor.next()){
                            throw new NullPointerException("O Diretor que você está procurando não foi encontrado, retornou nulo");
                        }else{ 
                            String cnpj_empresa = resultadoQueryDiretor.getString("cnpj_empresa");
                            int id_categoria = resultadoQueryDiretor.getInt("id_categoria");
                            return new Diretor(nome, login, senha, tipo, cpf, data_nasc.toLocalDate(), cnpj_empresa, id_categoria, id_endereco);
                        }
                    case "DON":
                        return new Dono(nome, login, senha, tipo, cpf, data_nasc.toLocalDate(), id_endereco);
                
                    default:
                        Pessoa pessoa = new Pessoa(nome,login,senha,tipo,cpf,data_nasc.toLocalDate(),id_endereco);
                        return pessoa;
                }
            }
        } catch (SQLException SQLError) {
            System.err.println("Usuário não encontrado ou Senha digitada incorretamente: " + SQLError);
            return null;
        } catch (Exception geralError) {
            System.err.println("Ocorreu um erro geral: " + geralError);
            return null;
        }
    }

    public boolean insertPessoa(Pessoa pessoa){
        try{
            conexao.conect();
            String sqlInsertPessoa = "insert into public.Pessoa(nome, data_nasc, cpf, login, senha, tipo, id_endereco)\n"
            +"values (\'"+pessoa.getNome()+"\' , \'"+pessoa.getData_nasc()+"\' , \'"+pessoa.getCpf()+"\' , \'"+pessoa.getLogin()+"\' , \'"+pessoa.getSenha()+"\' , \'"+pessoa.getTipo()+"\' , "+pessoa.getId_endereco()+")";
            int resultado = conexao.executaSql(sqlInsertPessoa);
            return (resultado != 0);
        }catch (SQLException e) {
            System.err.println("Houve um erro durante a inserção no banco de dados: "+e);
            return false;
        }catch(Exception e){
            System.err.println("Houve um erro geral: "+e);
            return false;
        }
    }
}