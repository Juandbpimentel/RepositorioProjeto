/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.sistema.dono;

import javax.swing.JFrame;

import dao.usuarios.DAODono;
import dao.empresa.DAOEmpresa;
import dao.usuarios.DAOFuncionario;
import javax.swing.table.DefaultTableModel;
import modelos.usuarios.Dono;
import modelos.usuarios.Funcionario;
import modelos.usuarios.Pessoa;
import modelos.empresa.Empresa;
import views.sistema.categoria.CadastrarCategoria;
import views.sistema.dono.MenuDono;

/**
 *
 * @author sarah
 */
public class MenuDono_AdmEmpresa extends javax.swing.JFrame {
    private Dono dono;
    private Empresa empresa;
    /**
     * Creates new form AlterarDadosEmpresaDono
     */
    public MenuDono_AdmEmpresa(String cpf) {
        if(cpf != null){
            this.dono = new DAODono().readOneDono(cpf);
            initComponents();
            iniciaTabela();
        }else{
            initComponents();
        }
    }
    
    public void iniciaTabela(){
        
        Empresa resultado = new DAOEmpresa().readOnEmpresa();

        DefaultTableModel testetabela = (DefaultTableModel) tabelaDados.getModel();
        Object[] colunas = {"nome","orcamento"};
        final Object[] entrada = new Object[4];
        entrada[0] = resultado.getNome(); 
        entrada[1] = resultado.getOrcamento();
        if(testetabela.getRowCount() > 0){
            testetabela.removeRow(testetabela.getRowCount()-1);
        }
        testetabela.setColumnIdentifiers(colunas);
        testetabela.addRow(entrada);
        tabelaDados.setModel(testetabela);
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
        nomeAlterButton = new javax.swing.JButton();
        orcamentoAlterButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        nomeEmpresaTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        orcamentoTextField = new javax.swing.JTextField();
        salvarButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        criarCatButton = new javax.swing.JButton();
        admSetoresButton = new javax.swing.JButton();
        admDiretoresButton = new javax.swing.JButton();
        errorMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Poppins", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Alterar Dados - Empresa");

        nomeAlterButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        nomeAlterButton.setText("Alterar Nome da Empresa");
        nomeAlterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeAlterButtonActionPerformed(evt);
            }
        });

        orcamentoAlterButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        orcamentoAlterButton.setText("Alterar Orçamento da Empresa");
        orcamentoAlterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orcamentoAlterButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        backButton.setText("Voltar");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        tabelaDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome da Empresa", "Orçamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaDados);

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setText("Nome da Empresa:");

        nomeEmpresaTextField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setText("Orçamento:");

        orcamentoTextField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        orcamentoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orcamentoTextFieldActionPerformed(evt);
            }
        });

        salvarButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        salvarButton.setText("Salvar");
        salvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarButtonActionPerformed(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        clearButton.setText("Limpar");

        deleteButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        deleteButton.setText("Excluir Empresa");

        jCheckBox1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jCheckBox1.setText("Selecione para comfirmar");

        criarCatButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        criarCatButton.setText("Criar Categoria");
        criarCatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarCatButtonActionPerformed(evt);
            }
        });

        admSetoresButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        admSetoresButton.setText("Administrar Setores");
        admSetoresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admSetoresButtonActionPerformed(evt);
            }
        });

        admDiretoresButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        admDiretoresButton.setText("Administrar Diretores");
        admDiretoresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admDiretoresButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(232, 232, 232)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(admDiretoresButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(admSetoresButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(115, 115, 115))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(deleteButton)
                                        .addGap(159, 159, 159))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(criarCatButton)
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(salvarButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(clearButton))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(1, 1, 1)
                                            .addComponent(orcamentoTextField))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(nomeEmpresaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeAlterButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orcamentoAlterButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeEmpresaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeAlterButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(orcamentoAlterButton)
                    .addComponent(orcamentoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(criarCatButton)
                            .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(admSetoresButton)
                            .addComponent(deleteButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(admDiretoresButton)
                            .addComponent(jCheckBox1))
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salvarButton)
                            .addComponent(clearButton))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeAlterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeAlterButtonActionPerformed
        boolean error = false;
        String nome = nomeEmpresaTextField.getText();
        
        if(nome.length() == 0){
            errorMessage.setText("O campo nome da empresa não pode estar vazio");
            error = true;
        }
        
        if(!error){
            errorMessage.setText("");
        }
        
        if(error){
            return;
        }
        
        DAOEmpresa daoEmpresa = new DAOEmpresa();
        daoEmpresa.updateEmpresa("nome", this.empresa.getCnpj(), nome);
        
        this.empresa = daoEmpresa.readOnEmpresa(this.empresa.getCnpj());
        
        iniciaTabela();
    }//GEN-LAST:event_nomeAlterButtonActionPerformed

    private void salvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salvarButtonActionPerformed

    private void criarCatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarCatButtonActionPerformed
        CadastrarCategoria menuCadCategoria = new CadastrarCategoria( dono.getCpf());
        menuCadCategoria.setVisible(true);
        menuCadCategoria.pack();
        menuCadCategoria.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_criarCatButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        dono.mostrarMenu();

        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void admSetoresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admSetoresButtonActionPerformed
        dono.administrarSetores();
        
        this.dispose();
    }//GEN-LAST:event_admSetoresButtonActionPerformed

    private void admDiretoresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admDiretoresButtonActionPerformed
        dono.administrarDiretores();
        this.dispose();
    }//GEN-LAST:event_admDiretoresButtonActionPerformed

    private void orcamentoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orcamentoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orcamentoTextFieldActionPerformed

    private void orcamentoAlterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orcamentoAlterButtonActionPerformed
        
    }//GEN-LAST:event_orcamentoAlterButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MenuDono_AdmEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuDono_AdmEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuDono_AdmEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDono_AdmEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuDono_AdmEmpresa(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admDiretoresButton;
    private javax.swing.JButton admSetoresButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton criarCatButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nomeAlterButton;
    private javax.swing.JTextField nomeEmpresaTextField;
    private javax.swing.JButton orcamentoAlterButton;
    private javax.swing.JTextField orcamentoTextField;
    private javax.swing.JButton salvarButton;
    private javax.swing.JTable tabelaDados;
    // End of variables declaration//GEN-END:variables
}
