package modelos.usuarios;

import interfaces.alterDB.DiretorAlterDB;
import interfaces.gui.DiretorGUI;

import java.time.LocalDate;

public class Diretor extends Pessoa implements DiretorGUI, DiretorAlterDB {
    private String cnpj_empresa;
    private int id_categoria;
    
    public Diretor (String nome, 
                    String login, 
                    String senha, 
                    String tipo, 
                    String cpf, 
                    LocalDate dataNasc, 
                    String cnpj_empresa, 
                    int id_categoria, 
                    int id_endereco) {
        super(nome, login, senha, tipo, cpf, dataNasc, id_endereco);
        this.cnpj_empresa = cnpj_empresa;
        this.id_categoria = id_categoria;
    }

    public String getCnpj_empresa() {
        return cnpj_empresa;
    }

    public void wa(String cnpj_empresa) {
        this.cnpj_empresa = cnpj_empresa;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
/*
     GUI
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

/*
    Alteração banco de dados
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

    @Override
    public void alterarDadosSetor() {
        
    }
}
