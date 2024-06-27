package main;


import controller.*;

import javax.swing.JMenuItem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template


/**
 *
 * @author danil
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
       
        this.setVisible(true);
      
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        novoClienteMenuBtn = new javax.swing.JMenuItem();
        exitMenuBtn = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        viewMesasMenuBtn = new javax.swing.JMenuItem();
        btnAtender = new javax.swing.JMenuItem();
        viewFilaDeEsperaBtn = new javax.swing.JMenuItem();
        viewCardapioMenuBtn = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        addCarroMenuBtn = new javax.swing.JMenuItem();
        btnAddItem = new javax.swing.JMenuItem();
        viewFaturamentoBtn = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Prints\\File.png")); // NOI18N

        jMenu1.setText("Novo");

        novoClienteMenuBtn.setText("Novo Cliente");
        novoClienteMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewNovoClienteBtnMenuActionPerformed(evt);
            }
        });
        jMenu1.add(novoClienteMenuBtn);

        exitMenuBtn.setText("Exit");
        exitMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuBtnActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenuBtn);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ações");

        viewMesasMenuBtn.setText("Mesas");
        viewMesasMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewMesasMenuBtnActionPerformed(evt);
            }
        });
        jMenu2.add(viewMesasMenuBtn);

        btnAtender.setText("Atender");
        btnAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtenderActionPerformed(evt);
            }
        });
        jMenu2.add(btnAtender);

        viewFilaDeEsperaBtn.setText("Fila de Espera");
        viewFilaDeEsperaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewFilaEsperaBtnMenuActionPerformed(evt);
            }
        });
        jMenu2.add(viewFilaDeEsperaBtn);

        viewCardapioMenuBtn.setText("Cardapio");
        viewCardapioMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCardapioMenuBtnActionPerformed(evt);
            }
        });
        jMenu2.add(viewCardapioMenuBtn);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Configuração");

        addCarroMenuBtn.setText("Add Mesa");
        addCarroMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCarroMenuBtnActionPerformed(evt);
            }
        });
        jMenu3.add(addCarroMenuBtn);

        btnAddItem.setText("Add Item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemMenuBtnActionPerformed(evt);
            }
        });
        jMenu3.add(btnAddItem);

        viewFaturamentoBtn.setText("Faturamento");
        viewFaturamentoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewFaturamentoBtnMenuActionPerformed(evt);
            }
        });
        jMenu3.add(viewFaturamentoBtn);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addCarroMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        new AddMesaController();
    }                                               

    private void addItemMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCarroMenuBtnActionPerformed
        // TODO add your handling code here:
        new AddItemController();
    }//GEN-LAST:event_addCarroMenuBtnActionPerformed

    private void exitMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuBtnActionPerformed

        this.dispose();
        
    }//GEN-LAST:event_exitMenuBtnActionPerformed

    private void viewMesasMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        new MesasController();
    }                                                

    private void viewCardapioMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewMesasMenuBtnActionPerformed
        new  ListarCardapioController();
    }//GEN-LAST:event_viewMesasMenuBtnActionPerformed


    private void viewNovoClienteBtnMenuActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        new AddClienteController();
    }                                                   

    private void viewFilaEsperaBtnMenuActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        new FilaDeEsperaController();
    }    
    private void viewFaturamentoBtnMenuActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        new ListarFaturamentoController();
    }    

    private void btnAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtenderActionPerformed
        new ClientesController();
    }//GEN-LAST:event_btnAtenderActionPerformed


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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    public JMenuItem getViewFaturamentoBtn() {
        return viewFaturamentoBtn;
    }

    public void setViewFaturamentoBtn(JMenuItem viewFaturamentoBtn) {
        this.viewFaturamentoBtn = viewFaturamentoBtn;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addCarroMenuBtn;
    private javax.swing.JMenuItem btnAddItem;
    private javax.swing.JMenuItem btnAtender;
    private javax.swing.JMenuItem exitMenuBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem novoClienteMenuBtn;
    private javax.swing.JMenuItem viewCardapioMenuBtn;
    private javax.swing.JMenuItem viewFaturamentoBtn;
    private javax.swing.JMenuItem viewFilaDeEsperaBtn;
    private javax.swing.JMenuItem viewMesasMenuBtn;
    // End of variables declaration//GEN-END:variables

    public JMenuItem getBtnAddItem() {
        return btnAddItem;
    }

    public void setBtnAddItem(JMenuItem btnAddItem) {
        this.btnAddItem = btnAddItem;
    }

    public JMenuItem getViewFilaDeEsperaBtn() {
        return viewFilaDeEsperaBtn;
    }

    public void setViewFilaDeEsperaBtn(JMenuItem viewFilaDeEsperaBtn) {
        this.viewFilaDeEsperaBtn = viewFilaDeEsperaBtn;
    }

    public JMenuItem getBtnAtender() {
        return btnAtender;
    }

    public void setBtnAtender(JMenuItem btnAtender) {
        this.btnAtender = btnAtender;
    }
}
