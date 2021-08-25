package modelos.usuarios;

import modelos.lugar.Endereco;
import views.sistema.Pessoa.MenuPessoa;

import java.time.LocalDate;

import javax.swing.JFrame;

import interfaces.alterDB.PessoaAlterDB;
import interfaces.gui.PessoaGUI;
import views.sistema.Pessoa.MenuPessoa_AlterarDados;
import views.sistema.Endereco.MenuEndereco_Cadastro;

public class Pessoa implements PessoaGUI, PessoaAlterDB {
    protected String nome;
    protected String login;
    protected String senha;
    protected String tipo;
    protected String cpf;
    protected LocalDate data_nasc;
    protected int id_endereco;
    protected Endereco endereco;

    public Pessoa(String nome, 
    			  String login, 
    			  String senha, 
    			  String tipo, 
    			  String cpf, LocalDate data_nasc, int id_endereco) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.cpf = cpf;
        this.data_nasc = data_nasc;
        this.id_endereco = id_endereco;
    }

    public LocalDate getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(LocalDate data_nasc) {
        this.data_nasc = data_nasc;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }
    
    public int getId_endereco() {
        return id_endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


/*
  GUI
*/
    @Override
    public void consultarDadosPessoais() {
        MenuPessoa_AlterarDados consultarDados = new MenuPessoa_AlterarDados(this);
        
        consultarDados.setVisible(true);
        consultarDados.pack();
        consultarDados.setLocationRelativeTo(null);
        consultarDados.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
            
    }

    @Override
    public void consultarLogs() {

    }

    @Override
    public void mostrarMenu() {
        MenuPessoa menu = new MenuPessoa(this); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void criarNovoEndereco(){
        MenuEndereco_Cadastro enderecoCadastro = new MenuEndereco_Cadastro(this);
        
        enderecoCadastro.setVisible(true);
        enderecoCadastro.pack();
        enderecoCadastro.setLocationRelativeTo(null);
        enderecoCadastro.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
    }
/*
  AlterDB
*/
    @Override
    public boolean alterarDadosPessoais() {
        return true;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "( nome : \'"+nome+"\' , login: \'"+login+"\' , "+senha+"\' , "+tipo+"\' , "+cpf+"\' , "+data_nasc+"\' , "+id_endereco+"\' )";
        
        /*
            protected String nome;
            protected String login;
            protected String senha;
            protected String tipo;
            protected String cpf;
            protected LocalDate data_nasc;
            protected int id_endereco;
            protected Endereco endereco;
        */
    }
}