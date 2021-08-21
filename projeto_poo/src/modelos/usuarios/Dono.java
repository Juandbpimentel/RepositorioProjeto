package modelos.usuarios;


import modelos.empresa.Empresa;
import modelos.lugar.Endereco;
import sistema.Conexao;
import interfaces.alterDB.DonoAlterDB;
import interfaces.gui.DonoGUI;

import java.time.LocalDate;
import java.util.ArrayList;


public class Dono extends Pessoa implements DonoGUI,DonoAlterDB {
    private ArrayList<Empresa> empresas;

    public Dono(ArrayList<Empresa> empresas) {
        this.empresas = empresas;
    }

    public Dono(String nome, String login, String senha, String tipo, String cpf, LocalDate dataNasc, Endereco endereco, Conexao conexao, ArrayList<Empresa> empresas) {
        super(nome, login, senha, tipo, cpf, dataNasc, endereco, conexao);
        this.empresas = empresas;
    }



    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(ArrayList<Empresa> empresas) {
        this.empresas = empresas;
    }
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

    @Override
    public void administrarSetores() {

    }

    @Override
    public void consultarSetores() {

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
