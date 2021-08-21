package modelos.sistema;


import modelos.usuarios.Pessoa;

public class MenuLogin{
    double x,y = 0;
    private static Pessoa usuario;

    public static void main(String[] args) {
        System.out.println("Deu certo main");
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


    /*
    *
    *
    * String login = usuario[0] , password = usuario[1];
        Conexao conexao = new Conexao("localhost","5432","BMDSY-Database","postgres","postgres","org.postgresql.Driver");
        conexao.conect();

        String sqlQuery= "select * from pessoa where login = "+login+"and senha"+password;
        ResultSet resultadoQuery = conexao.executaQuery(sqlQuery);
        int count = 0;
        try {
            while(resultadoQuery.next()){
                String nome = resultadoQuery.getString("nome");

                count++;
            }
            if(count == 0){
                return false;
            }
        }catch (Exception e){

        }
        return false;
    *
    *
    *
    * */

}
