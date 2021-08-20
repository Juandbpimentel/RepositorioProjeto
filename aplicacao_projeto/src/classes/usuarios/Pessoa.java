package classes.usuarios;

import classes.sistema.Conexao;
import classes.local.Endereco;
import java.time.LocalDate;

import interfaces.alterDB.PessoaAlterDB;
import interfaces.gui.PessoaGUI;

public class Pessoa implements PessoaGUI, PessoaAlterDB {
    private String nome, login,senha,tipo,cpf;
    private LocalDate dataNasc;
    private Endereco endereco;
    private Conexao conexao;
    
    public Pessoa(){
        this.nome = "admin";
        this.conexao = new Conexao("localhost","5432","BMDSY-Database","postgres","postgres","org.postgresql.Driver");
        this.cpf = "999.999.999-99";
        this.dataNasc = LocalDate.of(1999,9,9);
        this.endereco = new Endereco(1,15,"63780-000","Rua Sete de Setembro","");
        this.login = "admin";
        this.senha = "admin";
        this.tipo = "ADM";
    }

    public Pessoa(String nome, String login, String senha, String tipo, String cpf, LocalDate dataNasc, Endereco endereco, Conexao conexao) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.conexao = conexao;
    }

    public String toString() {
        String saida = "";
        saida = "( nome: "+nome+" )";
        return saida;
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
    
    
    public void mostrarMenu() {
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

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Conexao getConexao() {
		return conexao;
	}

	public void setConexao(Conexao conexao) {
		this.conexao = conexao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setIdEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void teste(){
        System.out.println("Deu errado ;-;");
    }

/**
 * GUI
 */
    @Override
    public void consultarDadosPessoais() {

    }

    @Override
    public void consultarLogs() {

    }

/**
 * AlterDB
 */
    @Override
    public void alterarDadosPessoais() {

    }
}