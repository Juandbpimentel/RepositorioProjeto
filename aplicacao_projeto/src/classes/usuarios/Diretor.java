package classes.usuarios;

import classes.local.Endereco;
import classes.sistema.Conexao;
import interfaces.alterDB.DiretorAlterDB;
import interfaces.gui.DiretorGUI;

import java.time.LocalDate;

public class Diretor extends Pessoa implements DiretorGUI, DiretorAlterDB {
    
    public Diretor() {
    }

    public Diretor(String nome, String login, String senha, String tipo, String cpf, LocalDate dataNasc, Endereco endereco, Conexao conexao) {
        super(nome, login, senha, tipo, cpf, dataNasc, endereco, conexao);
    }

    /**
 * GUI
 */
    @Override
    public void administrarFuncionarios() {

    }

    @Override
    public void administrarEstagiarios() {

    }

    @Override
    public void consultarFuncionarios() {

    }

    @Override
    public void consultarEstagiarios() {

    }

/**
 * Alteração banco de dados
 */

    @Override
    public void adicionarSetores() {

    }

    @Override
    public void alterarNomeSetor() {

    }

    @Override
    public void alterarOrcamentoSetor() {

    }

    @Override
    public void demitirFuncionario() {

    }

    @Override
    public void bonificarFuncionario() {

    }

    @Override
    public void admitirFuncionario() {

    }

    @Override
    public void admitirEstagiario() {

    }

    @Override
    public void dispensarEstagiario() {

    }

    @Override
    public void trocarEstagiarioSetor() {

    }
}
