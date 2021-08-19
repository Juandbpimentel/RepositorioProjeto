package classes.usuarios;


import classes.empresa.Empresa;
import classes.local.Endereco;
import classes.sistema.Conexao;
import interfaces.alterDB.DonoAlterDB;
import interfaces.gui.DonoGUI;

import java.time.LocalDate;
import java.util.Collection;


public class Dono extends Pessoa implements DonoGUI,DonoAlterDB {

    public Dono(Collection<Empresa> empresas) {
        this.empresas = empresas;
    }

    public Dono(String nome, String login, String senha, String tipo, String cpf, LocalDate dataNasc, Endereco endereco, Conexao conexao, Collection<Empresa> empresas) {
        super(nome, login, senha, tipo, cpf, dataNasc, endereco, conexao);
        this.empresas = empresas;
    }



    public Collection<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Collection<Empresa> empresas) {
        this.empresas = empresas;
    }

    Collection<Empresa> empresas;
/**
 * GUI
 */
    @Override
    public void administrarEmpresa() {

    }

    @Override
    public void alterarDadosEmpresa() {

    }

    @Override
    public void administrarDiretores() {

    }

    @Override
    public void consultarEstagiarios() {

    }

    @Override
    public void administrarFuncionarios() {

    }

    @Override
    public void administrarEstagiarios() {

    }

    @Override
    public void consultarFuncionarios() {

    }

/**
 * AlterDB
 */
    @Override
    public void admitirDiretor() {

    }

    @Override
    public void demitirDiretor() {

    }

    @Override
    public void alterarNomeEmpresa() {

    }

    @Override
    public void alterarOrcamentoEmpresa() {

    }

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
