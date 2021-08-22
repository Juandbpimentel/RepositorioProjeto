package modelos.usuarios;

import modelos.lugar.Endereco;
import sistema.Conexao;

import java.time.LocalDate;

import interfaces.alterDB.PessoaAlterDB;
import interfaces.gui.PessoaGUI;

public class Pessoa implements PessoaGUI, PessoaAlterDB {
    private String nome, login,senha,tipo,cpf;
    private LocalDate data_nasc;
    private Endereco endereco;
    private int id_endereco;
    private Conexao conexao;

    public Pessoa(String nome, String login, String senha, String tipo, String cpf, LocalDate data_nasc, int id_endereco) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.cpf = cpf;
        this.data_nasc = data_nasc;
        this.id_endereco = id_endereco;
        //this.endereco = endereco;
        //this.conexao = conexao;
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
		return data_nasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.data_nasc = dataNasc;
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

    @Override
    public void mostrarMenu() {

    }

/**
 * AlterDB
 */
    @Override
    public void alterarDadosPessoais() {

    }
}