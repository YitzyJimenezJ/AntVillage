/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import Control.archivos;
import Modelo.NodoHistorico;
import javax.swing.JOptionPane;


public class VhistoricoPartidas extends javax.swing.JDialog {

    /**
     * Creates new form historicoPartidas
     */
    public NodoHistorico historicoActual;
    public archivos manejoXML;
    public VhistoricoPartidas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.manejoXML = new archivos();
        this.manejoXML.leerXML();
         historicoActual = manejoXML.listapartidas.primero;
        if (manejoXML.cantiArchivos >0 && historicoActual!= null){
       
        lblNumPartida.setText("Partida #: "+String.valueOf(historicoActual.partida));
        txtnodos.setText(String.valueOf(historicoActual.getCantidadNodos()));
        txtalimentos.setText(String.valueOf(historicoActual.getCantidadAlimento()));
        txtverdes.setText(String.valueOf(historicoActual.getRecolectadoVerdes()));
        txtAzules.setText(String.valueOf(historicoActual.getRecolectadoAzules()));
        }else{ // en el caso que no haya una partida registrada obliga al usuario a volver
            lblNumPartida.setText("Partida #: N/D");
            txtnodos.setText("N/D");
            txtalimentos.setText("N/D");
            txtverdes.setText("N/D");
            txtAzules.setText("N/D");
            JOptionPane.showMessageDialog(null, "No hay partidas registradas");
            btnEliminar.setEnabled(false);
            btnSiguiente.setEnabled(false);
            btnAnterior.setEnabled(false);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondoBase = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        txtnodos = new javax.swing.JTextField();
        txtalimentos = new javax.swing.JTextField();
        txtAzules = new javax.swing.JTextField();
        txtverdes = new javax.swing.JTextField();
        jPanelFondoTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblNumPartida = new javax.swing.JLabel();
        lblCazules = new javax.swing.JLabel();
        lblCnodos = new javax.swing.JLabel();
        lblCalimento = new javax.swing.JLabel();
        lblRVerdes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelFondoBase.setBackground(new java.awt.Color(159, 6, 46));

        btnEliminar.setBackground(new java.awt.Color(204, 204, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar partida");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(0, 204, 204));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnSiguiente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnAnterior.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        txtnodos.setEditable(false);
        txtnodos.setBackground(new java.awt.Color(255, 255, 255));
        txtnodos.setFont(new java.awt.Font("Verdana Pro", 1, 14)); // NOI18N
        txtnodos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnodos.setFocusable(false);

        txtalimentos.setEditable(false);
        txtalimentos.setBackground(new java.awt.Color(255, 255, 255));
        txtalimentos.setFont(new java.awt.Font("Verdana Pro", 1, 14)); // NOI18N
        txtalimentos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtalimentos.setFocusable(false);
        txtalimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtalimentosActionPerformed(evt);
            }
        });

        txtAzules.setEditable(false);
        txtAzules.setBackground(new java.awt.Color(255, 255, 255));
        txtAzules.setFont(new java.awt.Font("Verdana Pro", 1, 14)); // NOI18N
        txtAzules.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAzules.setFocusable(false);
        txtAzules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAzulesActionPerformed(evt);
            }
        });

        txtverdes.setEditable(false);
        txtverdes.setBackground(new java.awt.Color(255, 255, 255));
        txtverdes.setFont(new java.awt.Font("Verdana Pro", 1, 14)); // NOI18N
        txtverdes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtverdes.setFocusable(false);
        txtverdes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtverdesActionPerformed(evt);
            }
        });

        jPanelFondoTitulo.setBackground(new java.awt.Color(102, 0, 0));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Histórico de partidas");

        javax.swing.GroupLayout jPanelFondoTituloLayout = new javax.swing.GroupLayout(jPanelFondoTitulo);
        jPanelFondoTitulo.setLayout(jPanelFondoTituloLayout);
        jPanelFondoTituloLayout.setHorizontalGroup(
            jPanelFondoTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoTituloLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );
        jPanelFondoTituloLayout.setVerticalGroup(
            jPanelFondoTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoTituloLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitulo)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        lblNumPartida.setFont(new java.awt.Font("Pyunji R", 0, 24)); // NOI18N
        lblNumPartida.setForeground(new java.awt.Color(255, 255, 255));
        lblNumPartida.setText("Partida #: ");

        lblCazules.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCazules.setForeground(new java.awt.Color(255, 255, 255));
        lblCazules.setText("Recolectados equipo azul");

        lblCnodos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCnodos.setForeground(new java.awt.Color(255, 255, 255));
        lblCnodos.setText("C:antidad de nodos:");

        lblCalimento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCalimento.setForeground(new java.awt.Color(255, 255, 255));
        lblCalimento.setText("Cantidad de alimento:");

        lblRVerdes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRVerdes.setForeground(new java.awt.Color(255, 255, 255));
        lblRVerdes.setText("Recolectados equipo verde");

        javax.swing.GroupLayout jPanelFondoBaseLayout = new javax.swing.GroupLayout(jPanelFondoBase);
        jPanelFondoBase.setLayout(jPanelFondoBaseLayout);
        jPanelFondoBaseLayout.setHorizontalGroup(
            jPanelFondoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoBaseLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addGap(14, 14, 14))
            .addComponent(jPanelFondoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoBaseLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanelFondoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoBaseLayout.createSequentialGroup()
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoBaseLayout.createSequentialGroup()
                        .addGroup(jPanelFondoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelFondoBaseLayout.createSequentialGroup()
                                .addGroup(jPanelFondoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRVerdes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoBaseLayout.createSequentialGroup()
                                        .addGroup(jPanelFondoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblCalimento, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblCnodos, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(12, 12, 12)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanelFondoBaseLayout.createSequentialGroup()
                                .addComponent(lblCazules)
                                .addGap(26, 26, 26)))
                        .addGroup(jPanelFondoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnodos, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txtAzules)
                            .addComponent(txtverdes)
                            .addComponent(txtalimentos))))
                .addGap(108, 108, 108))
            .addGroup(jPanelFondoBaseLayout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(lblNumPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelFondoBaseLayout.setVerticalGroup(
            jPanelFondoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoBaseLayout.createSequentialGroup()
                .addComponent(jPanelFondoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblNumPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanelFondoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCnodos))
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtalimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCalimento))
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtverdes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRVerdes))
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAzules, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCazules))
                .addGap(32, 32, 32)
                .addGroup(jPanelFondoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanelFondoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondoBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondoBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtverdesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtverdesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtverdesActionPerformed

    private void txtalimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalimentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalimentosActionPerformed

    private void txtAzulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAzulesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAzulesActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        manejoXML.borrarPartida(historicoActual.partida);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        historicoActual = historicoActual.getSiguiente();
        lblNumPartida.setText("Partida #: "+String.valueOf(historicoActual.partida));
        txtnodos.setText(String.valueOf(historicoActual.getCantidadNodos()));
        txtalimentos.setText(String.valueOf(historicoActual.getCantidadAlimento()));
        txtverdes.setText(String.valueOf(historicoActual.getRecolectadoVerdes()));
        txtAzules.setText(String.valueOf(historicoActual.getRecolectadoAzules()));
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        historicoActual = historicoActual.getAnterior();
        lblNumPartida.setText("Partida #: "+String.valueOf(historicoActual.partida));
        txtnodos.setText(String.valueOf(historicoActual.getCantidadNodos()));
        txtalimentos.setText(String.valueOf(historicoActual.getCantidadAlimento()));
        txtverdes.setText(String.valueOf(historicoActual.getRecolectadoVerdes()));
        txtAzules.setText(String.valueOf(historicoActual.getRecolectadoAzules()));
    }//GEN-LAST:event_btnAnteriorActionPerformed

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
            java.util.logging.Logger.getLogger(VhistoricoPartidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VhistoricoPartidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VhistoricoPartidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VhistoricoPartidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VhistoricoPartidas dialog = new VhistoricoPartidas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanelFondoBase;
    private javax.swing.JPanel jPanelFondoTitulo;
    private javax.swing.JLabel lblCalimento;
    private javax.swing.JLabel lblCazules;
    private javax.swing.JLabel lblCnodos;
    private javax.swing.JLabel lblNumPartida;
    private javax.swing.JLabel lblRVerdes;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtAzules;
    private javax.swing.JTextField txtalimentos;
    private javax.swing.JTextField txtnodos;
    private javax.swing.JTextField txtverdes;
    // End of variables declaration//GEN-END:variables
}
