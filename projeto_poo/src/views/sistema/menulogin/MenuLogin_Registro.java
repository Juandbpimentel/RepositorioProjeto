/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.sistema.menulogin;

import dao.empresa.DAOEmpresa;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import modelos.empresa.Empresa;
import sistema.Conexao;
import views.sistema.Diretor.CadDiretor;
import views.sistema.Dono.CadDono;
import views.sistema.Empresa.CadEmpresa;
import views.sistema.Estagiario.CadEstagiario;
import views.sistema.Funcionario.CadFuncionario;
import views.sistema.Gerente.CadGerente;

/**
 *
 * @author Ana Beatriz
 */
public class MenuLogin_Registro extends javax.swing.JFrame {
    
    /**
     * Creates new form MenuLogin_Regisro
     */
    public MenuLogin_Registro() {
        initComponents();
        populaComboEmpresa();
        DefaultComboBoxModel<String>  modelo = new DefaultComboBoxModel<String>(new String[] {"Funcionário","Estagiario","Gerente","Dono","Diretor"});
        comboboxTipo.setModel(modelo);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboboxTipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        comboboxEmpresa = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Poppins", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Menu Registro");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setText("Selecione o tipo:");

        comboboxTipo.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        comboboxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Tipo" }));
        comboboxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxTipoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setText("Selecione empresa:");

        comboboxEmpresa.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        comboboxEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma Empresa" }));
        comboboxEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxEmpresaActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton2.setText("Confirmar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        backButton.setText("Voltar");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(backButton)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addComponent(comboboxEmpresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(backButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboboxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String [] campos = comboboxEmpresa.getSelectedItem().toString().split(",");
        
        switch(comboboxTipo.getSelectedItem().toString()){
            case "Funcionário":
                System.out.println("Funcionário");
                System.out.println(campos[0]+campos[1]);
                CadFuncionario cadFuncionario = new CadFuncionario();

                cadFuncionario.setVisible(true);
                cadFuncionario.pack();
                cadFuncionario.setLocationRelativeTo(null);
                cadFuncionario.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);

                super.dispose();
                break;
            
            case "Gerente":
                System.out.println("Gerente");
                System.out.println(campos[0]+campos[1]);
                CadGerente cadGerente = new CadGerente();

                cadGerente.setVisible(true);
                cadGerente.pack();
                cadGerente.setLocationRelativeTo(null);
                cadGerente.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);

                super.dispose();
                break;
            case "Estagiario":
                System.out.println("Estagiario");
                System.out.println(campos[0]+campos[1]);
                CadEstagiario cadEstagiario = new CadEstagiario();

                cadEstagiario.setVisible(true);
                cadEstagiario.pack();
                cadEstagiario.setLocationRelativeTo(null);
                cadEstagiario.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
                super.dispose();
                break;
            case "Dono":
                System.out.println("Dono");
                System.out.println(campos[0]+campos[1]);
                CadDono cadDono = new CadDono();

                cadDono.setVisible(true);
                cadDono.pack();
                cadDono.setLocationRelativeTo(null);
                cadDono.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
                super.dispose();
                break;
            case "Diretor":
                System.out.println("Diretor");
                System.out.println(campos[0]+campos[1]);
                CadDiretor cadDiretor = new CadDiretor();

                cadDiretor.setVisible(true);
                cadDiretor.pack();
                cadDiretor.setLocationRelativeTo(null);
                cadDiretor.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
                super.dispose();
                break;
            default:
                
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        
        viewMenuLogin telaLogin = new viewMenuLogin();

        telaLogin.setVisible(true);
        telaLogin.pack();
        telaLogin.setLocationRelativeTo(null);
        telaLogin.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);

        super.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void comboboxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxTipoActionPerformed
        
    }//GEN-LAST:event_comboboxTipoActionPerformed

    private void comboboxEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxEmpresaActionPerformed
        populaComboEmpresa();

        
    }//GEN-LAST:event_comboboxEmpresaActionPerformed
    
    private void populaComboEmpresa(){
        Conexao conexao = new Conexao();
        conexao.conect();
        ArrayList<Empresa> empresas = new DAOEmpresa().readAll();
        
        if(!empresas.isEmpty()){
            for (Empresa empresa : empresas) {
                for(int i = 0 ; i < comboboxEmpresa.getItemCount(); i++){
                    if(!comboboxEmpresa.getItemAt(i).equals(empresa.getNome()+","+empresa.getCnpj())){
                        comboboxEmpresa.addItem(empresa.getNome()+","+empresa.getCnpj());
                    }
                }
                
            }
        }
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuLogin_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuLogin_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuLogin_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuLogin_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuLogin_Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> comboboxEmpresa;
    private javax.swing.JComboBox<String> comboboxTipo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
