package dao.usuarios;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.usuarios.Estagiario;
import modelos.usuarios.Pessoa;
import sistema.Conexao;

public class DAOEstagiario{
    private Conexao conexao;
    public ArrayList<Estagiario> ReadAll(){
        try {
            ArrayList<Estagiario> arrayEstagiario = new ArrayList<Estagiario>();
            conexao.conect();

            String codBusca = "Select * from Estagiario";
            ResultSet result = conexao.executaQuery(codBusca);

            while(result.next()){
                String cpf;
                int categoria, setor, diaPagamento, tempoEstagio;
                Date inicioEstagio; 
                
                cpf = result.getString("cpf");
                categoria = result.getInt("id_categoria");
                setor = result.getInt("id_setor");
                diaPagamento= result.getInt("diaPagamento");
                tempoEstagio = result.getInt("tempoEstagio");
                inicioEstagio = result.getDate("inicioEstagio");

                String codBusca_pessoa = "Select * from Pessoa where cpf = "+cpf;
                ResultSet result_pessoa = conexao.executaQuery(codBusca_pessoa);
                String nome ="", login = "", senha = "", tipo = "";
                Date data_nasc= new Date(System.currentTimeMillis());
                int id_endereco = 0;
                Boolean achou = false;

                if(result_pessoa.next()){
                    achou = true;
                    nome = result_pessoa.getString("nome");
                    login = result_pessoa.getString("login");
                    senha = result_pessoa.getString("senha");
                    tipo = result_pessoa.getString("tipo");
                    data_nasc = result_pessoa.getDate("data_nasc");
                    id_endereco = result_pessoa.getInt("id_endereco");
                }

                if(achou){
                    throw new NullPointerException();
                }

                Estagiario estagiario = new Estagiario(nome, login, senha, tipo, cpf, data_nasc.toLocalDate(), inicioEstagio.toLocalDate(), tempoEstagio, diaPagamento); 
                arrayEstagiario.add(estagiario);
            }

            return arrayEstagiario;
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
}