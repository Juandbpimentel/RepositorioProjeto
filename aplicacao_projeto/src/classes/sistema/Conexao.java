package classes.sistema;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Conexao {
    private String local,porta,banco,usuario,senha,url,driverJDBC = "org.postgresql.Driver";
    private Connection conexao;
    private Statement statement;
   
    public Conexao(String local, String porta, String banco,String usuario,String senha,String driverJDBC){
        setLocal(local);
        setPorta(porta);
        setBanco(banco);
        setUrl(getLocal(),getPorta(),getBanco());
        configUsuario(usuario, senha);
        setDriverJDBC(driverJDBC);
    }
    //Método para gerar conexão com o banco de dados
    public void conect() {
        
        try {
            Class.forName(getDriverJDBC());
            this.conexao = DriverManager.getConnection(getUrl(),getUsuario(),getSenha());
            setStatement(conexao.createStatement());
            System.out.println("\n<<<  Conexão Bem Sucedida  >>>\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconect(){
        try {
            getConexao().close();
            System.out.println("\n<<<  Conexao Encerrada  >>>\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executaSql(String sql){
        try {
        	conect();
            getStatement().executeUpdate(sql);
            System.out.println("\n<<<  Comando executado com sucesso  >>>\n");
            disconect();
        } catch (Exception e) {
        	System.out.print("Houve um erro na execução do codigo sql, o erro foi o seguinte: \n[");
            e.printStackTrace();
            System.out.println("]");
            disconect();
            return;
        }
    }

    public ResultSet executaQuery(String query){
        try {
        	conect();
            ResultSet result = getStatement().executeQuery(query);
            disconect();
            return result;
        } catch (Exception e) {
            System.out.print("Houve um erro na busca, o erro foi o seguinte: \n[");
            e.printStackTrace();
            System.out.println("]");
            disconect();
            return null;
        }
    }



    private void configUsuario(String usuario, String senha){
        setUsuario(usuario);
        setSenha(senha);
    }


    //Metódos de segurança Banco
    public void setBanco(String banco) {
        this.banco = banco;
    }
    public String getBanco() {
        return banco;
    }
    
    //Metódos de segurança Local
    public void setLocal(String local) {
        this.local = local;
    }
    
    public String getLocal() {
        return local;
    }

    //Metódos de segurança Porta
    public String getPorta() {
        return porta;
    }
    public void setPorta(String porta) {
        this.porta = porta;
    }
    
    //Metódos de segurança Senha
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getSenha() {
        return senha;
    }

    //Metódos de segurança usuario
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getUsuario() {
        return usuario;
    }
    //Metodo de Segurança URL
    public void setUrl(String local, String porta, String banco) {
        this.url = "jdbc:postgresql://"+local+":"+porta+"/"+banco+"";
    }
    public String getUrl() {
        return url;
    }
    
    
    //Metodo de Segurança Driver JDBC
    public void setDriverJDBC(String driverJDBC) {
        this.driverJDBC = driverJDBC;
    }
    public String getDriverJDBC() {
        return driverJDBC;
    }

    //Metodos de segurança Conexão 
    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    public Connection getConexao() {
        return conexao;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    public Statement getStatement() {
        return statement;
    }


}
