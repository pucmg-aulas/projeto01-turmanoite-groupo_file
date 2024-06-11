package main.java.view;

import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class AdicionarMesaView extends javax.swing.JFrame {

        public AdicionarMesaView() {
                initComponents();
        }

        public JToggleButton getBtnCancelar() {
                return btnCancelar;
        }

        public void setBtnCancelar(JToggleButton btnCancelar) {
                this.btnCancelar = btnCancelar;
        }

        public JToggleButton getBtnSalvar() {
                return btnSalvar;
        }

        public void setBtnSalvar(JToggleButton btnSalvar) {
                this.btnSalvar = btnSalvar;
        }

        public JTextField getTxtQuantCadeirasMesa() {
                return txtQuantCadeirasMesa;
        }

        public void setTxtQuantCadeirasMesa(JTextField txtQuantCadeirasMesa) {
                this.txtQuantCadeirasMesa = txtQuantCadeirasMesa;
        }

        private void initComponents() {

                jPanel3 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                txtQuantCadeirasMesa = new javax.swing.JTextField();
                btnSalvar = new javax.swing.JToggleButton();
                btnCancelar = new javax.swing.JToggleButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setText("Quantidade de Cadeiras");

                btnSalvar.setText("Salvar");

                btnCancelar.setText("Cancelar");

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(txtQuantCadeirasMesa)
                                                                                .addGroup(jPanel3Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel3Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel1))
                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel3Layout.createSequentialGroup()
                                                                                                                .addGap(0, 112, Short.MAX_VALUE)
                                                                                                                .addComponent(btnCancelar)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(btnSalvar)))
                                                                .addContainerGap()));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtQuantCadeirasMesa,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btnSalvar)
                                                                                .addComponent(btnCancelar))
                                                                .addContainerGap()));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));

                pack();
        }

        private javax.swing.JToggleButton btnCancelar;
        private javax.swing.JToggleButton btnSalvar;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JTextField txtQuantCadeirasMesa;
}