package dao.usuarios;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.usuarios.Estagiario;
import sistema.Conexao;

public class DAOEstagiario{
    private Conexao conexao;
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

                String sqlQueryPessoa = "Select * from Pessoa where cpf = "+cpf;
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
            System.err.println("Erro no banco de dados:" +sqlError);            
            return null; 
        } 
        catch (Exception geralError){
            System.err.println("Erro no código:" +geralError);            
            return null;
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