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
            ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
            conexao.conect();
            String sql = "SELECT * FROM Pessoa";
            ResultSet result = conexao.executaQuery(sql);
            while(result.next()){
                String nome, cpf, login, senha, tipo, endereco;
                Date data;
                nome = result.getString("nome");
                data = result.getDate("data_nasc");
                cpf = result.getString("cpf");
                login = result.getString("login");
                senha = result.getString("senha");
                tipo = result.getString("tipo");
                endereco = result.getString("id_endereco");
            }
            return pessoa;
        } catch (SQLException e) {
            System.err.println("Erro no banco de dados:" +e);            
            return null; 
        } catch (Exception e){
            System.err.println("Erro no código:" +e);            
            return null;
        }
    }
}