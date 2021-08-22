package sistema;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    public Conexao(){
        //"localhost","5432","BMDSY-Database","postgres","postgres","org.postgresql.Driver"
        setLocal("localhost");
        setPorta("5432");
        setBanco("BMDSY-Database");
        setUrl(getLocal(),getPorta(),getBanco());
        configUsuario("postgres", "postgres");
        setDriverJDBC("org.postgresql.Driver");
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



    public boolean startDatabase(){
        try{
            Conexao conexao = new Conexao("localhost", "5432", "postgres", "postgres", "postgres", "org.postgresql.Driver");
            conexao.conect();
            String codigoSql = "";
            BufferedReader leitorArquivoBanco = new BufferedReader(
                                            new FileReader("src/resources/textos/codigoSqlStartDB.txt")
                                                                );
            StringBuilder sb = new StringBuilder();
            String linha;
            while ((linha = leitorArquivoBanco.readLine()) != null){
                sb.append(linha).append("\n");
            }
            codigoSql = sb.toString();
            conexao.executaSql(codigoSql);
            sleep(5000);
            conexao.disconect();
            conexao = new Conexao();
            conexao.conect(); 
            
            sb = new StringBuilder();
            linha = "";
            codigoSql = "";
            
            BufferedReader leitorArquivoTabelas = new BufferedReader(
                                            new FileReader("src/resources/textos/codigoSqlCreateTables.txt")
                                            );

            while ((linha = leitorArquivoBanco.readLine()) != null){
                sb.append(linha).append("\n");
            }

            codigoSql = sb.toString();
            conexao.executaSql(codigoSql);
            leitorArquivoBanco.close();
            leitorArquivoTabelas.close();
            return true;
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            return false;
        }
        
    }


    @SuppressWarnings("unused")
	private static void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }


}
