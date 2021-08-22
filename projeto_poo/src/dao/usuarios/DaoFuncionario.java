package dao.usuarios;

import sistema.Conexao;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.usuarios.Funcionario;

public class DAOFuncionario {
    private Conexao conexao;

    public ArrayList<Funcionario> readAll(){
        try {
            ArrayList<Funcionario> arrayFuncionario = new ArrayList<Funcionario>();
            conexao = new Conexao();
            conexao.conect();

            String codBusca = "Select * from funcionario";
            ResultSet resultado = conexao.executaQuery(codBusca);
            
            while(resultado.next()){
                int id_categoria, id_setor, dia_pag;
                Double bonificacao;
                String cpf;

                id_categoria = resultado.getInt("id_categoria");
                id_setor = resultado.getInt("id_setor");
                dia_pag = resultado.getInt("dia_pag");
                bonificacao = resultado.getDouble("bonificacao");
                cpf = resultado.getString("cpf");
                
                String busca_pessoa = "Select * from pessoa where cpf = " +cpf;
                ResultSet result_pessoa = conexao.executaQuery(busca_pessoa);
                
                String nome = "", login = "", senha = "", tipo = "";
                int id_endereco = 0;
                Date data_nasc = new Date(System.currentTimeMillis());
                Boolean achou = false;

                if(result_pessoa.next()){
                    achou = true;
                    nome = result_pessoa.getString("nome");
                    login = result_pessoa.getString("login");
                    senha = result_pessoa.getString("senha");
                    tipo = result_pessoa.getString("tipo");
                    id_endereco = result_pessoa.getInt("id_endereco");
                    data_nasc = result_pessoa.getDate("data_nasc");
                }

                if(achou){
                    throw new NullPointerException();
                }

                Funcionario funcionario = new Funcionario(nome, login, senha, tipo, cpf, LocalDate.of(data_nasc.getYear(), data_nasc.getDay(), data_nasc.getMonth()), bonificacao); 
                arrayFuncionario.add(funcionario); 
            }
        
            return arrayFuncionario;
        } 
        catch(SQLException SQLError){
            System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
            return null;
        }
        catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            return null;
        }
    }
}