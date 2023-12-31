/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.components;
import static com.mycompany.components.FrameDadosUsuario.user;
import static com.mycompany.model.Users.modifyData;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.model.Products;
import com.mycompany.model.Utils;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 *
 * @author geova
 */
public final class FrameDadosProduto extends javax.swing.JFrame{


    public static int linha1 = 0;
    public static Products prod = null;
    File file = new File("DadosPetShop.xls");
    String categorias [] = {"Rações ", "Higiene e Limpeza", "Medicamento e saúde", "Acessórios"};
    public FrameDadosProduto(Products prodtext, int linha) {
        
        
        initComponents();
       linha1 = linha;
       jList1.setListData(categorias);
        prod = prodtext;
        btnsalvar.setVisible(false);
        txtnomeproduto.setText(prod.getName());
        
        txtprecovenda.setText(String.valueOf(prod.getSaleprice()));
        txtcusto.setText(String.valueOf(prod.getCostprice()));
        txtquantidade.setText(String.valueOf(prod.getQuantity()));

       
        jList1.setSelectedIndex(Listasele());
        
         
       


    }
    
    int Listasele(){
        int num = 0;
        for(int i =0; i <= 3; i++){
            if(prod.getCategory().equals(categorias[i]))
                num = i;
        }
        return num;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnalterar = new javax.swing.JLabel();
        btnexcluir = new javax.swing.JLabel();
        btnsalvar = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcusto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtnomeproduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        Jlabel2 = new javax.swing.JLabel();
        txtquantidade = new javax.swing.JTextField();
        checkativo = new javax.swing.JCheckBox();
        txtprecovenda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Dados do Produto");
        setPreferredSize(new java.awt.Dimension(630, 540));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        btnalterar.setBackground(new java.awt.Color(0, 102, 204));
        btnalterar.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnalterar.setForeground(new java.awt.Color(255, 255, 255));
        btnalterar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnalterar.setText("AlterarProduto");
        btnalterar.setOpaque(true);
        btnalterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnalterarMouseClicked(evt);
            }
        });

        btnexcluir.setBackground(new java.awt.Color(255, 0, 51));
        btnexcluir.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnexcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnexcluir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnexcluir.setText("Excluir Produto");
        btnexcluir.setOpaque(true);
        btnexcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnexcluirMouseClicked(evt);
            }
        });

        btnsalvar.setBackground(new java.awt.Color(0, 153, 51));
        btnsalvar.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnsalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnsalvar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnsalvar.setText("Salvar");
        btnsalvar.setOpaque(true);
        btnsalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsalvarMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Cancelar");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        txtcusto.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 14)); // NOI18N
        txtcusto.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 14)); // NOI18N
        jLabel5.setText("Quantidade");

        txtnomeproduto.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 14)); // NOI18N
        txtnomeproduto.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 14)); // NOI18N
        jLabel6.setText("Custo");

        jLabel12.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 14)); // NOI18N
        jLabel12.setText("Preço de venda");

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel1.setText("Dados do Produto");

        jScrollPane1.setEnabled(false);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setEnabled(false);
        jScrollPane1.setViewportView(jList1);

        Jlabel2.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 14)); // NOI18N
        Jlabel2.setText("Nome do Produto");

        txtquantidade.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 14)); // NOI18N
        txtquantidade.setEnabled(false);

        checkativo.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 14)); // NOI18N
        checkativo.setText("Ativo");
        checkativo.setEnabled(false);
        checkativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkativoActionPerformed(evt);
            }
        });

        txtprecovenda.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 14)); // NOI18N
        txtprecovenda.setEnabled(false);
        txtprecovenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecovendaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 14)); // NOI18N
        jLabel4.setText("Categoria");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtquantidade, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtprecovenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(checkativo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtcusto, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(Jlabel2)))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtnomeproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnsalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnalterar, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(btnexcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnalterar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnexcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(26, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Jlabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnomeproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtprecovenda, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcusto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkativo))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 650, 539);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnalterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnalterarMouseClicked
      btnsalvar.setVisible(true);
      btnexcluir.setVisible(false);
      txtprecovenda.setEnabled(true);
      txtnomeproduto.setEnabled(true);
  
      txtcusto.setEnabled(true);
      txtquantidade.setEnabled(true);
      jList1.setEnabled(true);
      checkativo.setEnabled(true);
      

    }//GEN-LAST:event_btnalterarMouseClicked

    private void btnsalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalvarMouseClicked
        try {
            
          
            Workbook workbook = Workbook.getWorkbook(file);
        
            WritableWorkbook copy = Workbook.createWorkbook(file, workbook);
            WritableSheet produtoSheet = copy.getSheet(2);
           
            // Alterar Nome
           
            
            WritableCell nomeproduto = produtoSheet.getWritableCell(0, linha1);
            WritableCell categoria = produtoSheet.getWritableCell(2, linha1);
            WritableCell quantidade = produtoSheet.getWritableCell(4, linha1);
            WritableCell custoprice = produtoSheet.getWritableCell(5,linha1);
            WritableCell vendapreco = produtoSheet.getWritableCell(6, linha1);
            WritableCell ativo = produtoSheet.getWritableCell(7, linha1);
         
            
            modifyData(nomeproduto, txtnomeproduto.getText());
            modifyData(categoria,jList1.getSelectedValue());
            modifyData(quantidade,txtquantidade.getText());
            modifyData(custoprice,txtcusto.getText());
            modifyData(vendapreco, txtprecovenda.getText());
         
           
            
            if(checkativo.isSelected()){
                modifyData(ativo,"1");
            }
            else{
                modifyData(ativo,"0");
            }
            
            

            copy.write();
            copy.close();
            this.dispose();
            dashboard2 dash = new dashboard2();
            dash.setVisible(true);
            dash.selecttable(2);
            
        } catch (Exception ex) {
            Logger.getLogger(FrameDadosProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }//GEN-LAST:event_btnsalvarMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
       this.dispose();
       dashboard2 dash;
        try {
            dash = new dashboard2();
            dash.setVisible(true);
            dash.selecttable(2);
        } catch (IOException ex) {
            Logger.getLogger(FrameDadosProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(FrameDadosProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      
    }//GEN-LAST:event_jLabel9MouseClicked

    private void btnexcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexcluirMouseClicked
     try {
             prod.excluirUsuario(linha1);
            //prod.excluirProduto();
            System.out.println("Produto Excluído");
            this.dispose();
            dashboard2 dash = new dashboard2();
            dash.setVisible(true);
            dash.selecttable(2);
        } catch (IOException ex) {
            Logger.getLogger(FrameDadosUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(FrameDadosUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnexcluirMouseClicked

    private void checkativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkativoActionPerformed

    private void txtprecovendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecovendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecovendaActionPerformed

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
            java.util.logging.Logger.getLogger(FrameDadosProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameDadosProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameDadosProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameDadosProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new FrameDadosProduto(prod,linha1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jlabel2;
    private javax.swing.JLabel btnalterar;
    private javax.swing.JLabel btnexcluir;
    private javax.swing.JLabel btnsalvar;
    private javax.swing.JCheckBox checkativo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtcusto;
    private javax.swing.JTextField txtnomeproduto;
    private javax.swing.JTextField txtprecovenda;
    private javax.swing.JTextField txtquantidade;
    // End of variables declaration//GEN-END:variables
}
