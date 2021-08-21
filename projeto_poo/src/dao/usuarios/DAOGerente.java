package dao.usuarios;

import java.sql.SQLException;
import java.util.ArrayList;
import modelos.sistema.Conexao;
import modelos.usuarios.Gerente;

public class daoGerente {
    private Conexao conexao;

    public ArrayList<Gerente> readAll(){
        conexao = new Conexao();
        conexao.conect();
        try {
            
        } catch (SQLException e) {
            System.err.println("Erro no banco de dados:" +e);            
            return null;
        }

        catch ()
    }

    
    
}
