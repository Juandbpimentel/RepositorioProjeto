package Java.classes.sistema;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

import Java.classes.empresa.Categoria;
import Java.classes.local.Endereco;


import Java.classes.usuarios.Estagiario;
import Java.classes.usuarios.Funcionario;
import Java.classes.usuarios.Pessoa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuLogin extends Application {
    private static Pessoa usuario;

    public static void main(String[] args) {
    //    fazerLogin();
    //    usuario.mostrarMenu();
        launch();
    }

    /*  public static void main(String[] args) {
        Pessoa usuario = new Estagiario("Margooooos", "MarretaDeJapa", "40028922","FUN","999.999.999-99",LocalDate.of(2002, 10, 17),new Endereco(1,15,"63780000","Rua MAjor Ventura",""), new Conexao("localhost","5432","BMDSY-Database","postgres","postgres","org.postgresql.Driver"), Timestamp.valueOf("2001-11-13 00:00:00"),6,10,new Categoria(1,6,"Programador","É um escravo para os outros funcionarios",800.0));
        usuario.teste();
        Estagiario estagiario = (Estagiario) usuario;

        System.out.println(new Timestamp(System.currentTimeMillis()));

        Conexao conexao = new Conexao("localhost","5432","BMDSY-Database","postgres","postgres","org.postgresql.Driver");

        usuario = new Pessoa("Margooooos", "MarretaDeJapa","40028922","FUN" ,"999.999.999-99", LocalDate.of(2002, 10, 17),new Endereco(1,15,"63780000","Rua Major Ventura",""),new Conexao("localhost","5432","BMDSY-Database","postgres","postgres","org.postgresql.Driver"));



        String sqlCode = "insert into pessoa(nome,data_nasc,cpf,login,senha,tipo,id_endereco)\n"+
                "values('"+usuario.getNome()+"','"+usuario.getDataNasc()+"','"+usuario.getCpf()+"','"+usuario.getLogin()+"','"+usuario.getSenha()+"','"+usuario.getTipo()+"'," + usuario.getEndereco().getId() + ");";

        conexao.executaSql(sqlCode);

        sqlCode = "select * from pessoa";

        ResultSet resultado = conexao.executaQuery(sqlCode);
        try {
            while(resultado.next()){
                System.out.println("Nome: "+ resultado.getString("nome")+" | Cpf: " + resultado.getString("cpf") +" | DataNasc: "+LocalDate.parse(resultado.getString("data_nasc")) + " | Mensagem :");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        conexao.executaSql("delete from pessoa where cpf = '999.999.999-99'");
    }
    */


    @SuppressWarnings("unused")
	private static void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public static void fazerLogin(){
        Conexao conexao = new Conexao("localhost", "5432", "ProjetoPOO-FBD","postgres", "postgres", "org.postgresql.Driver");
        conexao.conect();
        String login="",senha="";
        Scanner in = new Scanner(System.in);
        System.out.print("Digite o login: ");
        login = in.nextLine();
        System.out.print("Digite o login: ");
        senha = in.nextLine();

        ResultSet resultado = conexao.executaQuery("select * from pessoa"
                                                  + "where login = "+login+" and senha = "+senha+";");
        try {
            if(resultado.next()){
                String tipo = resultado.getString("tipo"),
                       cpf  = resultado.getString("cpf"),
                       nome = resultado.getString("nome");
                int idEndereco = resultado.getInt("Endereco");
                Timestamp dataNasc = new Timestamp(System.currentTimeMillis());
                switch (tipo) {
                    case "FUN":
                        conexao.disconect();
                        in.close();
                        usuario = new Funcionario();
                        break;
                    case "GER":

                        break;
                    case "EST":

                        break;
                    case "DON":

                        break;
                    case "DIR":

                        break;
                    case "ADM":

                        break;
                    case "DEM":

                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        in.close();
        usuario = new Pessoa();
        
    }

    public static Pessoa getUsuario() {
        return usuario;
    }

    public static void setUsuario(Pessoa usuario) {
        MenuLogin.usuario = usuario;
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("));
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
