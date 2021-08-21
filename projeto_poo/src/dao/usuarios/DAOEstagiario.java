package dao.usuarios;

import java.sql.ResultSet;
import java.util.ArrayList;

import modelos.usuarios.Estagiario;
import modelos.usuarios.Pessoa;
import sistema.Conexao;

public class DAOEstagiario{
    private Conexao conexao;
    public ArrayList<Estagiario> ReadAll(){
        try {
            ArrayList<Estagiario> estagiario = new ArrayList<Estagiario>();
            conexao.conect();
            String sql = "SELECT * FROM Estagiario";
            ResultSet result = conexao.executaQuery(sql);
            while(result.next()){

            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}