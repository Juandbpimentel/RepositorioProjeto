package dao.usuarios;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.usuarios.Pessoa;
import sistema.Conexao;

public class DAOPessoa{
    private Conexao conexao;
    public ArrayList<Pessoa> ReadAll(){
        try {
            ArrayList<Pessoa> arrayPessoas = new ArrayList<Pessoa>();
            conexao.conect();
            String sql = "SELECT * FROM Pessoa";
            ResultSet result = conexao.executaQuery(sql);
            while(result.next()){
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
            Conexao conexao = new Conexao();
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
            conexao = new Conexao();
            int resultado;
            String sqlUpdate;

            switch (opt) {
                case "nome":
                    sqlUpdate = "Update Pessoa set nome = " + dado + " where cpf = " + cpf;
                    resultado = conexao.executaSql(sqlUpdate);
                    break;
    
                case "login":
                    sqlUpdate = "Update Pessoa set login = " + dado + " where cpf = " + cpf;
                    resultado = conexao.executaSql(sqlUpdate);
                    break;
                case "senha":
                    sqlUpdate = "Update Pessoa set senha = " + dado + " where cpf = " + cpf;
                    resultado = conexao.executaSql(sqlUpdate);
                    break;
                case "tipo":
                    sqlUpdate = "Update Pessoa set tipo = " + dado + " where cpf = " + cpf;
                    resultado = conexao.executaSql(sqlUpdate);
                    break;
                case "cpf":
                    sqlUpdate = "Update Pessoa set cpf = " + dado + " where cpf = " + cpf;
                    resultado = conexao.executaSql(sqlUpdate);
                    break;
                case "data_nasc":
                    sqlUpdate = "Update Pessoa set data_nasc = " + dado + " where cpf = " + cpf;
                    resultado = conexao.executaSql(sqlUpdate);
                    break;
                case "endereco":
                    sqlUpdate = "Update Pessoa set endereco = " + dado + " where cpf = " + cpf;
                    resultado = conexao.executaSql(sqlUpdate);
                    break;
                case "id_endereco":
                    sqlUpdate = "Update Pessoa set id_endereco = " + dado + " where cpf = " + cpf;
                    resultado = conexao.executaSql(sqlUpdate);
                    break;
                default:
                    throw new Exception("Valor não encontrado");
            }

            conexao.disconect();
            return (resultado != 0)?true:false;

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
                int idendereco = resultadoQueryPessoa.getInt("id_endereco");
                Date data = resultadoQueryPessoa.getDate("data_nasc");
                Pessoa pessoa = new Pessoa(nome,login,senha,tipo,cpf,data.toLocalDate(),idendereco);
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