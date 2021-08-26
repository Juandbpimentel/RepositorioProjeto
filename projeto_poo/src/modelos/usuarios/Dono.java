package modelos.usuarios;

import interfaces.alterDB.DonoAlterDB;
import interfaces.gui.DonoGUI;

import java.time.LocalDate;

import javax.swing.JFrame;

import views.sistema.dono.MenuDono;
import views.sistema.dono.MenuDono_AdmDiretor;
import views.sistema.dono.MenuDono_AdmEmpresa;
import views.sistema.dono.MenuDono_AdmEstagiario;
import views.sistema.dono.MenuDono_AdmFuncionario;
import views.sistema.dono.MenuDono_AdmSetor;
import views.sistema.estagiario.CadEstagiario;
import views.sistema.funcionario.CadFuncionario;


public class Dono extends Pessoa implements DonoGUI,DonoAlterDB {

    public Dono( String nome, 
                 String login, 
                 String senha, 
                 String tipo, 
                 String cpf, 
                 LocalDate dataNasc, 
                 int id_endereco) {
        super(nome, login, senha, tipo, cpf, dataNasc, id_endereco);

    }


    //NÂO CRIAR MAIS
    @Override
    public void demitirDiretor() {
        
    }
    
    @Override
    public void alterarNomeEmpresa() {
        
    }
    
    
    
    @Override
    public void alterarNomeSetor() {
        
    }
    
    @Override
    public void alterarOrcamentoSetor() {
        
    }
    
    
    @Override
    public void bonificarFuncionario() {
        
    }
    @Override
    public void alterarOrcamentoEmpresa() {
        
    }
    
    @Override
    public void demitirFuncionario() {
        
    }
    
    @Override
    public void dispensarEstagiario() {

    }

    @Override
    public void trocarEstagiarioSetor() {
        //não criar mais!!!!!!!!!!!!!
    }

    //CRIAR ESSES
    
    @Override
    public void adicionarSetores() {
        
    }
    
    @Override
    public void admitirDiretor() {

    }

    @Override
    public void admitirFuncionario() {
        CadFuncionario menu = new CadFuncionario(this.cpf); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void admitirEstagiario() {
        CadEstagiario menu = new CadEstagiario(this.cpf); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    

    

    @Override
    public void administrarDiretores() {
        MenuDono_AdmDiretor menu = new MenuDono_AdmDiretor(this.cpf); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void administrarFuncionarios() {
        MenuDono_AdmFuncionario menu = new MenuDono_AdmFuncionario(this.cpf); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void administrarEstagiarios() {
        MenuDono_AdmEstagiario menu = new MenuDono_AdmEstagiario(this.cpf); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void administrarEmpresa() {
        MenuDono_AdmEmpresa menu = new MenuDono_AdmEmpresa(this.cpf); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void administrarSetores() {
        MenuDono_AdmSetor menu = new MenuDono_AdmSetor(this.cpf); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void mostrarMenu() {
        MenuDono menu = new MenuDono(this.cpf); 
        
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void consultarDadosPessoais(){

    }
    
    @Override
    public void consultarLogs(){

    }
    
    @Override
    public void criarNovoEndereco(){

    }





}
