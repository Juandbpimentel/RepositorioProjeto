package modelos.usuarios;


import modelos.empresa.Empresa;

import interfaces.alterDB.DonoAlterDB;
import interfaces.gui.DonoGUI;

import java.time.LocalDate;
import java.util.ArrayList;


public class Dono extends Pessoa implements DonoGUI,DonoAlterDB {
    private ArrayList<Empresa> empresas;


    public Dono( String nome, 
                 String login, 
                 String senha, 
                 String tipo, 
                 String cpf, 
                 LocalDate dataNasc, 
                 int id_endereco) {
        super(nome, login, senha, tipo, cpf, dataNasc, id_endereco);

    }



    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(ArrayList<Empresa> empresas) {
        this.empresas = empresas;
    }
/*
    GUI
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

/*
    AlterDB
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



    @Override
    public void alterarDadosSetor() {
        
    }

    @Override
    public void mostrarMenu() {
        views.sistema.Dono. menu = new MenuGerente(); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
