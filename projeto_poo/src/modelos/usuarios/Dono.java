package modelos.usuarios;


import modelos.empresa.Empresa;
import views.sistema.Dono.MenuDono;
import views.sistema.Dono.MenuDono_AdmEmpresa;
import views.sistema.Dono.ConsultarFuncionario.MenuDono_AdmFuncionario;
import interfaces.alterDB.DonoAlterDB;
import interfaces.gui.DonoGUI;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;
import views.sistema.Dono.MenuDono_AdmDiretor;
import views.sistema.Dono.MenuDono_AdmSetor;
import views.sistema.Dono.ConsultarEstagiario.MenuDono_AdmEstagiario;
import views.sistema.menulogin.viewMenuLogin;


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
    public void administrarDiretores() {
        MenuDono_AdmDiretor menu = new MenuDono_AdmDiretor(this); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void administrarFuncionarios() {
        MenuDono_AdmFuncionario menu = new MenuDono_AdmFuncionario(this); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void administrarEstagiarios() {
        MenuDono_AdmEstagiario menu = new MenuDono_AdmEstagiario(this); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void administrarEmpresa() {
        MenuDono_AdmEmpresa menu = new MenuDono_AdmEmpresa(this); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void administrarSetores() {
        MenuDono_AdmSetor menu = new MenuDono_AdmSetor(this); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void mostrarMenu() {
        MenuDono menu = new MenuDono(this); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    @Override
    public void alterarOrcamentoEmpresa() {
        // TODO Auto-generated method stub
        
    }

}
