package modelos.usuarios;

import modelos.lugar.Endereco;
import sistema.Conexao;
import interfaces.alterDB.DiretorAlterDB;
import interfaces.gui.DiretorGUI;

import java.time.LocalDate;

public class Diretor extends Pessoa implements DiretorGUI, DiretorAlterDB {
    private String cnpj_empresa, id_categoria;
    public Diretor(String nome, String login, String senha, String tipo, String cpf, LocalDate dataNasc, String cnpj_empresa, String id_categoria) {
        super(nome, login, senha, tipo, cpf, dataNasc/*, endereco, conexao*/);
        this.cnpj_empresa = cnpj_empresa;
        this.id_categoria = id_categoria;
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
