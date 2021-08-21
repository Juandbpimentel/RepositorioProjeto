package Java.classes.usuarios;

import Java.classes.local.Endereco;
import Java.classes.sistema.Conexao;
import Java.classes.usuarios.pessoa.Pessoa;
import Java.interfaces.alterDB.DiretorAlterDB;
import Java.interfaces.gui.DiretorGUI;

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
    public void administrarSetores() {

    }

    @Override
    public void consultarFuncionarios() {

    }

    @Override
    public void consultarEstagiarios() {

    }

    @Override
    public void consultarSetores() {

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
