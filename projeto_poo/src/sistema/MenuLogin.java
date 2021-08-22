package sistema;


import modelos.usuarios.Pessoa;

public class MenuLogin{
    double x,y = 0;
    private static Pessoa usuario;

    public static void main(String[] args) {
        System.out.println("Deu certo main");
        Conexao conexao = new Conexao();
        conexao.startDatabase();
        sleep(200);
        conexao.createTables();
    }

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

}
