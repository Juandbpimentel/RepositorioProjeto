package views.sistema.funcionario;

import dao.empresa.DAOCategoria;
import dao.empresa.DAOEmpresa;
import dao.empresa.DAOSetor;
import dao.lugar.DAOEndereco;
import dao.usuarios.DAODiretor;
import dao.usuarios.DAODono;
import dao.usuarios.DAOFuncionario;
import dao.usuarios.DAOGerente;
import dao.usuarios.DAOPessoa;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import modelos.empresa.Categoria;
import modelos.empresa.Empresa;
import modelos.empresa.Setor;
import modelos.lugar.Endereco;

import modelos.usuarios.Diretor;
import modelos.usuarios.Dono;
import modelos.usuarios.Funcionario;
import modelos.usuarios.Gerente;
import modelos.usuarios.Pessoa;
import sistema.Conexao;
import views.sistema.endereco.MenuEndereco_Cadastro;
import views.sistema.menulogin.MenuLogin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ana Beatriz
 */
public class CadFuncionario extends javax.swing.JFrame {
    private Pessoa pessoa;
    /**
     * Creates new form FrameTest
     */
    public CadFuncionario(String cpf) {
        if(cpf != null){
            this.pessoa = new DAOPessoa().readOnePessoa(cpf);
            initComponents();
            populaComboCategoria();
            populaComboEmpresa();
            populaComboEndereco();
            populaComboSetor();
        }else{
            initComponents();
        }
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
        nomeField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        backbutton = new javax.swing.JButton();
        finalizarField = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cpfField = new javax.swing.JTextField();
        dataNAscimento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dataInicioField = new javax.swing.JTextField();
        diaPAgamentoField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        loginField = new javax.swing.JTextField();
        senhaField = new javax.swing.JTextField();
        comboBoxCategoria = new javax.swing.JComboBox<>();
        comboboxSetor = new javax.swing.JComboBox<>();
        comboBoxEndereco = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        comboboxEmpresa = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 0, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(51, 0, 51));
        jLabel2.setFont(new java.awt.Font("Poppins", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("Cadastro de Novo Funcionário");

        nomeField.setToolTipText("");
        nomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setText("Nome:");

        backbutton.setText("voltar");
        backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbuttonActionPerformed(evt);
            }
        });

        finalizarField.setText("Finalizar");
        finalizarField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarFieldActionPerformed(evt);
            }
        });

        jButton3.setText("Limpar Cadastro");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setText("CPF:");

        cpfField.setToolTipText("");
        cpfField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfFieldActionPerformed(evt);
            }
        });

        dataNAscimento.setToolTipText("");
        dataNAscimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataNAscimentoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setText("Data de Nascimento:");

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setText("Categoria:");

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel12.setText("Setor:");

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel13.setText("Data de Início:");

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel14.setText("Dia do Pagamento:");

        diaPAgamentoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaPAgamentoFieldActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel15.setText("Login:");

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel16.setText("Senha:");

        loginField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginFieldActionPerformed(evt);
            }
        });

        comboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma Categoria" }));
        comboBoxCategoria.setToolTipText("");

        comboboxSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Setor" }));

        comboBoxEndereco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Endereco" }));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setText("Endereço:");

        jToggleButton1.setText("Cadastrar Novo Endereço");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        comboboxEmpresa.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        comboboxEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma Empresa" }));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel7.setText("Selecione empresa:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxEndereco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(senhaField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboboxEmpresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataNAscimento))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomeField, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(45, 45, 45))
                            .addComponent(cpfField))
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboboxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jToggleButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(finalizarField)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton3))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(diaPAgamentoField, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dataInicioField, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(backbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataNAscimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(senhaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboboxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboboxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel13))
                    .addComponent(dataInicioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diaPAgamentoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalizarField)
                    .addComponent(jButton3)
                    .addComponent(jToggleButton1))
                .addGap(86, 86, 86))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeFieldActionPerformed

    private void cpfFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfFieldActionPerformed

    private void dataNAscimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataNAscimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataNAscimentoActionPerformed

    private void backbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbuttonActionPerformed
        
        switch (pessoa.getTipo()) {
            case "DIR":
                Diretor diretor = new DAODiretor().readOneDiretor(pessoa.getCpf());
                diretor.administrarFuncionarios();
                this.dispose();
                break;

            case "DON":
                Dono dono = new DAODono().readOneDono(pessoa.getCpf());
                dono.administrarFuncionarios();
                this.dispose();
                break;

            case "GER":
                Gerente gerente = new DAOGerente().readOneGerente(pessoa.getCpf());
                gerente.administrarFuncionarios();
                this.dispose();
                break;
            case "ADM":
                pessoa.administrarFuncionarios();
                this.dispose();
                break;
        }
        
    }//GEN-LAST:event_backbuttonActionPerformed


    private void populaComboCategoria(){
        Conexao conexao = new Conexao();
        conexao.conect();
        ArrayList<Categoria> categorias = new DAOCategoria().readAll();
        
        if(!categorias.isEmpty()){
            for (Categoria categoria : categorias) {
                comboBoxCategoria.addItem(categoria.getNome()+","+categoria.getId()); 
            }
        }
    }
    
    private void populaComboEmpresa(){
        Conexao conexao = new Conexao();
        conexao.conect();
        ArrayList<Empresa> empresas = new DAOEmpresa().readAll();
        
        if(!empresas.isEmpty()){
            for (Empresa empresa : empresas) {
                comboboxEmpresa.addItem(empresa.getNome()+","+empresa.getCnpj());
            }
        }
    }

    private void populaComboEndereco(){
        Conexao conexao = new Conexao();
        conexao.conect();
        ArrayList<Endereco> enderecos = new DAOEndereco().readAll();
        
        if(!enderecos.isEmpty()){
            for (Endereco endereco : enderecos) {
                comboBoxEndereco.addItem(endereco.getRua()+","+endereco.getId());                
            }
        }
    }

    private void populaComboSetor(){
        Conexao conexao = new Conexao();
        conexao.conect();
        ArrayList<Setor> setores = new DAOSetor().readAll();
        
        if(!setores.isEmpty()){
            for (Setor setor : setores) {
                comboboxSetor.addItem(setor.getNome()+","+setor.getId());  
            }
        }
    }



    private void loginFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginFieldActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        MenuEndereco_Cadastro enderecoCadastro = new MenuEndereco_Cadastro(this.pessoa.getCpf());
        
        enderecoCadastro.setVisible(true);
        enderecoCadastro.pack();
        enderecoCadastro.setLocationRelativeTo(null);
        enderecoCadastro.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void finalizarFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarFieldActionPerformed
        try{
            if(nomeField.getText() == null){
            }
            if(cpfField.getText() == null){

            }
            if(dataNAscimento.getText() == null){
            }
            if(comboBoxEndereco.getSelectedItem().toString() == null){

            }
            if(loginField.getText() == null){
            }
            if(senhaField.getText() == null){

            }
            if(comboBoxCategoria.getSelectedItem().toString() == null){
            }
            if(comboboxEmpresa.getSelectedItem().toString() == null){
            }
            if(comboboxSetor.getSelectedItem().toString() == null){
            }
            if(dataInicioField.getText() == null){

            }if(diaPAgamentoField.getText() == null){

            }
            SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date1=formatter1.parse(dataNAscimento.getText());  
            java.util.Date date2=formatter1.parse(dataInicioField.getText());  
            Pessoa pessoaAux = new Pessoa(nomeField.getText(), loginField.getText(), senhaField.getText(), "FUN", cpfField.getText(), (new Date(date1.getTime()).toLocalDate()), Integer.parseInt(comboBoxEndereco.getSelectedItem().toString().split(",")[1]));
            new DAOPessoa().insertPessoa(pessoaAux);

            Funcionario funcionario = new Funcionario(nomeField.getText(), 
                                                      loginField.getText(), 
                                                      senhaField.getText(), 
                                                      "FUN", 
                                                      cpfField.getText(), 
                                                      (new Date(date1.getTime()).toLocalDate()), 
                                                      Integer.parseInt(comboBoxEndereco.getSelectedItem().toString().split(",")[1]), 
                                                      (double)0,Integer.parseInt((comboBoxCategoria.getSelectedItem().toString().split(",")[1])), 
                                                      Integer.parseInt(comboboxSetor.getSelectedItem().toString().split(",")[1]), Integer.parseInt(diaPAgamentoField.getText()), (new Date(date2.getTime()).toLocalDate()));
            new DAOFuncionario().insertFuncionario(funcionario);
            System.out.println("Deu certo");
            MenuLogin telalogin = new MenuLogin();
            telalogin.setVisible(true);
            telalogin.pack();
            telalogin.setLocationRelativeTo(null);
            this.dispose();
        }catch(Exception e){
            System.out.println("Deu erro");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_finalizarFieldActionPerformed

    private void diaPAgamentoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaPAgamentoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diaPAgamentoFieldActionPerformed

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
            java.util.logging.Logger.getLogger(CadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadFuncionario(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbutton;
    private javax.swing.JComboBox<String> comboBoxCategoria;
    private javax.swing.JComboBox<String> comboBoxEndereco;
    private javax.swing.JComboBox<String> comboboxEmpresa;
    private javax.swing.JComboBox<String> comboboxSetor;
    private javax.swing.JTextField cpfField;
    private javax.swing.JTextField dataInicioField;
    private javax.swing.JTextField dataNAscimento;
    private javax.swing.JTextField diaPAgamentoField;
    private javax.swing.JButton finalizarField;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField loginField;
    private javax.swing.JTextField nomeField;
    private javax.swing.JTextField senhaField;
    // End of variables declaration//GEN-END:variables
}
