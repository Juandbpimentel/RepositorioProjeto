package Java.classes.sistema;


import Java.classes.usuarios.pessoa.Pessoa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuLogin extends Application {
    double x,y = 0;
    private static Pessoa usuario;

    public static void main(String[] args) {
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

    public static Pessoa getUsuario() {
        return usuario;
    }

    public static void setUsuario(Pessoa usuario) {
        MenuLogin.usuario = usuario;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuLogin.class.getResource("menuLoginGUI.fxml"));
        Parent root = fxmlLoader.load();
        //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/resources/Java/classes/menuPrincipalPessoa.fxml")));
        //System.out.print(Objects.requireNonNull(getClass().getResource("/resources/Java/classes/menuPrincipalPessoa.fxml")));

        Scene scene = new Scene(root);

        root.setOnMousePressed(evt->{
            x = evt.getSceneX();
            y = evt.getSceneY();
        });

        root.setOnMouseDragged(evt->{
            stage.setX(evt.getSceneX());
            stage.setY(evt.getSceneY());
        });

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.hide();
        stage.show();

    }

}
