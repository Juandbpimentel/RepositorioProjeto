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
                    sqlUpdate = "Update Categoria set nome = " + dado + " where cpf = " + cpf;
                    resultado = conexao.executaSql(sqlUpdate);
                    break;
    
                case "login":
                    sqlUpdate = "Update Categoria set login = " + dado + " where cpf = " + cpf;
                    resultado = conexao.executaSql(sqlUpdate);
                    break;
                case "senha":
                    sqlUpdate = "Update Categoria set senha = " + dado + " where cpf = " + cpf;
                    resultado = conexao.executaSql(sqlUpdate);
                    break;
                case "tipo":
                case "cpf":
                case "data_nasc":
                case "endereco":
                case "id_endereco":

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
}