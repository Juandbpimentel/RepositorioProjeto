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
import java.time.LocalDate;
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
    private Dono dono;
    private Setor setor;
    /**
     * Creates new form FrameTest
     */
    public CadFuncionario(String cpf, int id) {
        
        if(cpf != null && id != -1){
            this.dono = new DAODono().readOneDono(cpf);
            String idstr = "" + id;
            this.setor = new DAOSetor().readOnSetor("id",idstr);
            initComponents();
            populaComboCategoria();
            populaComboEndereco();
        }else{
            initComponents();
            populaComboCategoria();
            System.out.println("Categoria deu certo");
            populaComboEndereco();
            System.out.println("Endereco deu certo");
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
        dataNascimentoField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dataInicioField = new javax.swing.JTextField();
        diaPAgamentoField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        loginField = new javax.swing.JTextField();
        senhaField = new javax.swing.JTextField();
        comboBoxCategoria = new javax.swing.JComboBox<>();
        comboBoxEndereco = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        errorLabelCpf = new javax.swing.JLabel();
        errorLabelDataNasc = new javax.swing.JLabel();
        errorLabelLogin = new javax.swing.JLabel();
        errorLabelDataInicio = new javax.swing.JLabel();
        errorLabelNome = new javax.swing.JLabel();
        errorLabelSenha = new javax.swing.JLabel();
        errorLabelDiaPagamento = new javax.swing.JLabel();
        errorLabelEndereco = new javax.swing.JLabel();
        errorLabelCategoria = new javax.swing.JLabel();

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

        dataNascimentoField.setToolTipText("");
        dataNascimentoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataNascimentoFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setText("Data de Nascimento:");

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setText("Categoria:");

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
        comboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCategoriaActionPerformed(evt);
            }
        });

        comboBoxEndereco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Endereco" }));
        comboBoxEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEnderecoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setText("Endereço:");

        jToggleButton1.setText("Cadastrar Novo Endereço");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(diaPAgamentoField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicioField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(senhaField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginField))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeField))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxEndereco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(finalizarField)
                        .addGap(50, 50, 50)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpfField))
                    .addComponent(errorLabelDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabelCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabelLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabelDataInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabelSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabelDiaPagamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabelCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataNascimentoField)))
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel2)
                .addGap(174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(backbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cpfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorLabelCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataNascimentoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(errorLabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(senhaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(dataInicioField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(errorLabelDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diaPAgamentoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelDiaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(5, 5, 5)
                .addComponent(errorLabelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalizarField)
                    .addComponent(jButton3)
                    .addComponent(jToggleButton1))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeFieldActionPerformed

    private void cpfFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfFieldActionPerformed

    private void dataNascimentoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataNascimentoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataNascimentoFieldActionPerformed

    private void backbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbuttonActionPerformed
        
        switch (dono.getTipo()) {
            case "DIR":
                Diretor diretor = new DAODiretor().readOneDiretor(dono.getCpf());
                diretor.administrarFuncionarios();
                this.dispose();
                break;

            case "DON":
                String id = setor.getId()+"";
                dono.administrarFuncionarios(id);
                this.dispose();
                break;

            case "GER":
                Gerente gerente = new DAOGerente().readOneGerente(dono.getCpf());
                gerente.administrarFuncionarios();
                this.dispose();
                break;
        }
        
    }//GEN-LAST:event_backbuttonActionPerformed


    private void populaComboCategoria(){
        
        
        if(setor == null){
            System.err.println("O ArrayList de categoria Não foi criado com sucesso");
            comboBoxCategoria.removeAllItems();
            comboBoxCategoria.addItem("Ainda não há nenhuma categoria criada");
            return;
        }
        
        ArrayList<Categoria> categorias = new DAOCategoria().readAll();
        comboBoxCategoria.removeAllItems();
        
        if(!categorias.isEmpty()){
            comboBoxCategoria.addItem("Selecione uma categoria");
            for (Categoria categoria : categorias) {
                if(categoria.getCnpj_empresa().equals(setor.getCnpj_empresa())){
                    comboBoxCategoria.addItem(categoria.getNome()+","+categoria.getId()); 
                }
            }
        }else{
            comboBoxCategoria.addItem("Ainda não há nenhuma categoria criada");
        }
    }

    private void populaComboEndereco(){
        ArrayList<Endereco> enderecos = new DAOEndereco().readAll();
        
        if(enderecos == null){
            System.err.println("O ArrayList de enderecos Não foi criado com sucesso");
            
            comboBoxEndereco.removeAllItems();
            comboBoxEndereco.addItem("Ainda não há nenhum endereco criado");
            return;
        }
        
        comboBoxEndereco.removeAllItems();
        
        if(!enderecos.isEmpty()){
            comboBoxEndereco.addItem("Selecione um endereço");
            for (Endereco endereco : enderecos) {
                comboBoxEndereco.addItem(endereco.getRua()+","+endereco.getId());  
            }
        }else{
            comboBoxEndereco.addItem("Ainda não há nenhum endereco criado");
        }
    }



    private void loginFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginFieldActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        nomeField.setText("");
        cpfField.setText("");
        loginField.setText("");
        senhaField.setText("");
        dataNascimentoField.setText("");
        dataInicioField.setText("");
        diaPAgamentoField.setText("");
        comboBoxEndereco.setSelectedIndex(0);
        comboBoxCategoria.setSelectedIndex(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.dono.criarNovoEndereco("CadFuncionario",setor.getId());
        this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void finalizarFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarFieldActionPerformed
       boolean erroNome = false, erroCpf= false, erroDataNasc= false,erroDiaPagemento = false, erroCategoria = false, erroDataInicio = false,erroEndereco= false, erroLogin= false, erroSenha= false;

        if(nomeField.getText().length() == 0){
            errorLabelNome.setText("O campo nome não pode estar vazio");
            erroNome = true;
        }else{
            errorLabelNome.setText("");
        }
        
        if(diaPAgamentoField.getText().length() == 0){
            errorLabelNome.setText("O campo Dia do Pagamento não pode estar vazio");
            erroDiaPagemento = true;
        }else{
            errorLabelNome.setText("");
        }

        if(senhaField.getText().length() == 0){
            errorLabelSenha.setText("O campo senha não pode estar vazio");
            erroCpf = true;
        }else{
            errorLabelSenha.setText("");
        }

        if(loginField.getText().length() == 0){
            errorLabelLogin.setText("O campo login não pode estar vazio");
            erroLogin = true;
        }else{
            errorLabelLogin.setText("");
        }

        if(cpfField.getText().length() == 0){
            errorLabelCpf.setText("O campo cpf não pode estar vazio");
            erroCpf = true;
        }else{
            if( !(cpfField.getText().contains(".") && (cpfField.getText().contains("-"))) ){
                errorLabelCpf.setText("O campo cpf está no formato errado");
                erroCpf = true;
            }else{
                errorLabelCpf.setText("");
            }
        }
        
        if(comboBoxEndereco.getSelectedItem().equals("Selecione um endereço") || comboBoxEndereco.getSelectedItem().equals("Ainda não há nenhum endereco criado")){
            errorLabelEndereco.setText("Você precisa selecionar ou cadastrar um novo endereço");
            erroEndereco = true;
        }else{
            errorLabelEndereco.setText("Você precisa selecionar ou cadastrar um novo endereco");
        }
        
        if(comboBoxCategoria.getSelectedItem().equals("Selecione uma categoria") || comboBoxEndereco.getSelectedItem().equals("Ainda não há nenhuma categoria criada")){
            errorLabelCategoria.setText("Você precisa selecionar ou cadastrar uma nova categoria");
            erroCategoria = true;
        }else{
            errorLabelEndereco.setText("");
        }
        
        erroDataNasc = checaErroDataNasc();
        erroDataInicio = checaErroDataInicio();
        
        
        if(erroNome|| erroCpf||erroDiaPagemento|| erroDataNasc|| erroEndereco|| erroDataInicio || erroEndereco|| erroLogin|| erroSenha){
            System.out.println("Deu erro e não rodou");
            return;
        }
        String nome = nomeField.getText(), login = loginField.getText(),data_nascStr = dataNascimentoField.getText(), data_inicioStr = dataInicioField.getText(), senha = senhaField.getText() , cpf = cpfField.getText();
        
        String[] enderecoSplit = comboBoxEndereco.getSelectedItem().toString().split(",");
        String[] categoriaSplit = comboBoxCategoria.getSelectedItem().toString().split(",");
        
        
        int id_endereco  = Integer.parseInt(enderecoSplit[1]),
            id_categoria = Integer.parseInt(categoriaSplit[1]),
            dia_pagamento = Integer.parseInt(diaPAgamentoField.getText());
            System.out.println(id_categoria);
        if(data_nascStr.contains("/")){
            
            String[] data_nascVet = data_nascStr.split("/");
            String[] data_inicioVet = data_inicioStr.split("/");
            
            LocalDate data_nasc = LocalDate.of(Integer.parseInt(data_nascVet[2]), Integer.parseInt(data_nascVet[1]), Integer.parseInt(data_nascVet[0]));
            LocalDate data_inicio = LocalDate.of(Integer.parseInt(data_inicioVet[2]), Integer.parseInt(data_inicioVet[1]), Integer.parseInt(data_inicioVet[0]));
            
            Pessoa pessoaAux = new Pessoa(nome, login, senha, "FUN", cpf, data_nasc , id_endereco );
            if(new DAOPessoa().insertPessoa(pessoaAux)){
                
                if(new DAOFuncionario().insertFuncionario(new Funcionario(nome, login, senha, "FUN", cpf, data_nasc, id_endereco, 0, id_categoria, setor.getId(), dia_pagamento, data_inicio))){
                    String id = setor.getId()+"";
                    dono.administrarFuncionarios(id);
                    this.dispose();
                }    
            }
        }else{
            
            String[] data_nascVet = data_nascStr.split("-");
            String[] data_inicioVet = data_inicioStr.split("-");
            
            LocalDate data_nasc = LocalDate.of(Integer.parseInt(data_nascVet[2]), Integer.parseInt(data_nascVet[1]), Integer.parseInt(data_nascVet[0]));
            LocalDate data_inicio = LocalDate.of(Integer.parseInt(data_inicioVet[2]), Integer.parseInt(data_inicioVet[1]), Integer.parseInt(data_inicioVet[0]));
            
            Pessoa pessoaAux = new Pessoa(nome, login, senha, "FUN", cpf, data_nasc , id_endereco );
            if(new DAOPessoa().insertPessoa(pessoaAux)){
                
                if(new DAOFuncionario().insertFuncionario(new Funcionario(nome, login, senha, "FUN", cpf, data_nasc, id_endereco, 0, id_categoria, setor.getId(), dia_pagamento, data_inicio))){
                    String id = setor.getId()+"";
                    dono.administrarFuncionarios(id);
                    this.dispose();
                }
                
            }
        }
    }//GEN-LAST:event_finalizarFieldActionPerformed
    
    
    private boolean checaErroDataNasc(){
        boolean erroDataNasc = false;
        if(dataNascimentoField.getText().length() == 0){
            errorLabelDataNasc.setText("O campo data de nascimento não pode estar vazio");
            erroDataNasc = true;
        }else{
            try{
                if(!(dataNascimentoField.getText().contains("/") || dataNascimentoField.getText().contains("-"))){
                    errorLabelDataNasc.setText("Data escrita no formato incorreto");
                    erroDataNasc = true;
                } else if(dataNascimentoField.getText().contains("/")){
                    String [] dataAux = dataNascimentoField.getText().split("/");
                    if(Integer.parseInt(dataAux[0])<=0 || Integer.parseInt(dataAux[1])<=0||Integer.parseInt(dataAux[2])<=0){
                        errorLabelDataNasc.setText("Datas não podem ter valores iguais ou menores que zero");
                        erroDataNasc = true;
                    }else{
                        errorLabelDataNasc.setText("");
                    }
                } else if(dataNascimentoField.getText().contains("-")){
                    String [] dataAux = dataNascimentoField.getText().split("-");
                    if(Integer.parseInt(dataAux[0])<=0 || Integer.parseInt(dataAux[1])<=0||Integer.parseInt(dataAux[2])<=0){
                        errorLabelDataNasc.setText("Datas não podem ter valores iguais ou menores que zero");
                        erroDataNasc = true;
                    }else{
                        errorLabelDataNasc.setText("");
                    }
                }
            }catch(Exception e){
                System.err.print("Houve um erro na inserção da data: "+e);
                errorLabelDataNasc.setText("Não é permitida a inserção de palavras em datas");
            }
        }
        return erroDataNasc;
    }
    
    private boolean checaErroDataInicio(){
        boolean erroDataInicio = false;
        if(dataInicioField.getText().length() == 0){
            errorLabelDataInicio.setText("O campo data de nascimento não pode estar vazio");
            erroDataInicio = true;
        }else{
            try{
                if(!(dataInicioField.getText().contains("/") || dataInicioField.getText().contains("-"))){
                    errorLabelDataInicio.setText("Data escrita no formato incorreto");
                    erroDataInicio = true;
                } else if(dataInicioField.getText().contains("/")){
                    String [] dataAux = dataInicioField.getText().split("/");
                    if(Integer.parseInt(dataAux[0])<=0 || Integer.parseInt(dataAux[1])<=0||Integer.parseInt(dataAux[2])<=0){
                        errorLabelDataInicio.setText("Datas não podem ter valores iguais ou menores que zero");
                        erroDataInicio = true;
                    }else{
                        errorLabelDataInicio.setText("");
                    }
                } else if(dataInicioField.getText().contains("-")){
                    String [] dataAux = dataInicioField.getText().split("-");
                    if(Integer.parseInt(dataAux[0])<=0 || Integer.parseInt(dataAux[1])<=0||Integer.parseInt(dataAux[2])<=0){
                        errorLabelDataInicio.setText("Datas não podem ter valores iguais ou menores que zero");
                        erroDataInicio = true;
                    }else{
                        errorLabelDataInicio.setText("");
                    }
                }
            }catch(Exception e){
                System.err.print("Houve um erro na inserção da data: "+e);
                errorLabelDataInicio.setText("Não é permitida a inserção de palavras em datas");
            }
        }
        return erroDataInicio;
    }
    
    private void diaPAgamentoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaPAgamentoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diaPAgamentoFieldActionPerformed

    private void comboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCategoriaActionPerformed

    private void comboBoxEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxEnderecoActionPerformed

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
                new CadFuncionario(null,-1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbutton;
    private javax.swing.JComboBox<String> comboBoxCategoria;
    private javax.swing.JComboBox<String> comboBoxEndereco;
    private javax.swing.JTextField cpfField;
    private javax.swing.JTextField dataInicioField;
    private javax.swing.JTextField dataNascimentoField;
    private javax.swing.JTextField diaPAgamentoField;
    private javax.swing.JLabel errorLabelCategoria;
    private javax.swing.JLabel errorLabelCpf;
    private javax.swing.JLabel errorLabelDataInicio;
    private javax.swing.JLabel errorLabelDataNasc;
    private javax.swing.JLabel errorLabelDiaPagamento;
    private javax.swing.JLabel errorLabelEndereco;
    private javax.swing.JLabel errorLabelLogin;
    private javax.swing.JLabel errorLabelNome;
    private javax.swing.JLabel errorLabelSenha;
    private javax.swing.JButton finalizarField;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField loginField;
    private javax.swing.JTextField nomeField;
    private javax.swing.JTextField senhaField;
    // End of variables declaration//GEN-END:variables
}
