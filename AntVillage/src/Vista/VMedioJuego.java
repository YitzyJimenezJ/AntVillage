
package Vista;

import Control.Juego;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Image;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.CENTER;
/**
 *
 * @author 
 */
public class VMedioJuego extends javax.swing.JFrame {

    /**
     * Creates new form VMedioJuego
     */
    private ArrayList<JButton> listaBotones = new ArrayList<>();
    private int cantidad_nodos;
    private int cantidad_alimento;
    public JLabel vistaHormigaAzul;
    public JLabel vistaHormigaVerde;
    public JLabel vistaAlimento;
    private Juego juego;
    public JButton btnAlimentar;
    
    public VMedioJuego( int nodos, int alimentos ) {
        initComponents();
        this.txtnodos.setText(String.valueOf(nodos));
        this.txtAlimentoTotal.setText(String.valueOf(alimentos));
        this.setBackground(Color.black);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.cantidad_nodos = nodos;
        this.cantidad_alimento = alimentos;
        crearBtnAlimentar();
        alimentoInFrame();
    }
    private void crearBtnAlimentar(){
        this.btnAlimentar = new JButton();
        this.btnAlimentar.setVisible(false);
        this.btnAlimentar .setHorizontalAlignment(CENTER);//coloca el cursor en el centro 
        this.btnAlimentar .setBounds(190,121, 100, 30);
        this.btnAlimentar .setText("Alimento");
        this.btnAlimentar .setBackground(Color.GREEN);
        this.datosPanel.add(this.btnAlimentar);
        
    }
    public void setimagenesHormigas(int x, int y ){
        ImageIcon imagenAzul = new ImageIcon(getClass().
                getResource("/Imagenes/hormigaAzul.png"));
        ImageIcon imagenVerde = new ImageIcon(getClass().
                getResource("/Imagenes/hormigaVerde.png"));
        vistaHormigaAzul = new JLabel();
        vistaHormigaVerde = new JLabel();
        
        vistaHormigaAzul.setBounds(x+5, y-20, 30, 30);
        vistaHormigaVerde.setBounds(x+5,y-20, 30, 30);
        
        vistaHormigaAzul.setIcon(new ImageIcon(imagenAzul.getImage().
                getScaledInstance(vistaHormigaAzul.getWidth(),
                        vistaHormigaAzul.getHeight(), Image.SCALE_SMOOTH)));
        vistaHormigaVerde.setIcon(new ImageIcon(imagenVerde.getImage().
                getScaledInstance(vistaHormigaVerde.getWidth(), 
                        vistaHormigaVerde.getHeight(), Image.SCALE_SMOOTH)));
        
        this.gamePanel.add(vistaHormigaAzul);
        this.gamePanel.add(vistaHormigaVerde);
     
    } 
    /* =========================================================================
   
        INTERACCIONES DE LOS ALIMENTOS
    
     =========================================================================*/
    public void alimentoInFrame(){
        ImageIcon alimento = new ImageIcon(getClass().getResource("/Imagenes/hoja.png"));
        vistaAlimento = new JLabel();
        this.vistaAlimento.setBounds(0, 0, 30,30);
        this.vistaAlimento.setVisible(false);
        vistaAlimento.setIcon(new ImageIcon(alimento.getImage().
                getScaledInstance(vistaAlimento.getWidth(), 
                        vistaAlimento.getHeight(), Image.SCALE_SMOOTH)));
        this.gamePanel.add(vistaAlimento);
    }
    public void mostrarAlimento(){
        this.vistaAlimento.setVisible(true);
    }
    public void ocultarAlimento(){
        this.vistaAlimento.setVisible(false);
    }
    public void posAlimento(int x, int y){
        this.vistaAlimento.setBounds(x+5, y-15, 30,30);
    }
  /* =========================================================================
   
       Getter
    
     =========================================================================*/
    public JPanel getGamePanel() {
        return gamePanel;
    }

    public int getCantidad_nodos() {
        return cantidad_nodos;
    }
    public void moverHormiga(JLabel imagenHormiga, int x, int y){
        imagenHormiga.setBounds(x, y, 30,30);
    }
    
    private VMedioJuego() { ///es obligatorio poner este constructor sobre cargado aunque no se use
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void agregarBoton(JButton btnNuevo){
        listaBotones.add(btnNuevo);
        this.gamePanel.add(btnNuevo);
        this.gamePanel.repaint();
    }
    public void addBoton_to_DatosPanel(JButton nuevoBoton){
        this.datosPanel.add(nuevoBoton);
        datosPanel.updateUI();
    }
    public void removeBoton_to_DatosPanel(JButton nuevoBoton){
        this.datosPanel.remove(nuevoBoton);
     
        datosPanel.updateUI();
    }

    public JTextArea getTxaDetalles() {
        return txaDetalles;
    }

    public JTextField getTxtNodoPresionado() {
        return txtNodoPresionado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneltotal = new javax.swing.JPanel();
        gamePanel = new javax.swing.JPanel();
        btnIniciar = new javax.swing.JButton();
        panelInfo = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        blueTeamPanel = new javax.swing.JPanel();
        lblBlueTeam = new javax.swing.JLabel();
        lblAlimentoAzules = new javax.swing.JLabel();
        txtAA = new javax.swing.JTextField();
        greenTeamPanel = new javax.swing.JPanel();
        lblGreenTeam = new javax.swing.JLabel();
        lblAlimentoVerdes = new javax.swing.JLabel();
        txtAV = new javax.swing.JTextField();
        datosPanel = new javax.swing.JPanel();
        lblfoodToWin = new javax.swing.JLabel();
        txtAlimentoTotal = new javax.swing.JTextField();
        lblDatos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtnodos = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        btnIfnfo = new javax.swing.JButton();
        lblNodoPresionado = new javax.swing.JLabel();
        txtNodoPresionado = new javax.swing.JTextField();
        jspDetalle = new javax.swing.JScrollPane();
        txaDetalles = new javax.swing.JTextArea();
        lblArcos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setName("AntVillage"); // NOI18N

        paneltotal.setBackground(new java.awt.Color(255, 255, 255));
        paneltotal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gamePanel.setBackground(new java.awt.Color(204, 143, 55));
        gamePanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        btnIniciar.setBackground(new java.awt.Color(153, 204, 0));
        btnIniciar.setFont(new java.awt.Font("Rockwell Nova Extra Bold", 0, 24)); // NOI18N
        btnIniciar.setText("Iniciar Juego");
        btnIniciar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
                .addContainerGap(259, Short.MAX_VALUE)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        paneltotal.add(gamePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 700, 520));

        panelInfo.setBackground(new java.awt.Color(0, 0, 0));
        panelInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("FINALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelInfo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        blueTeamPanel.setBackground(new java.awt.Color(0, 204, 204));
        blueTeamPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        lblBlueTeam.setFont(new java.awt.Font("Verdana Pro Black", 0, 18)); // NOI18N
        lblBlueTeam.setText("Blue team");

        lblAlimentoAzules.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAlimentoAzules.setText("Alimento recolectado:");

        txtAA.setEditable(false);
        txtAA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAA.setText("0");
        txtAA.setFocusable(false);

        javax.swing.GroupLayout blueTeamPanelLayout = new javax.swing.GroupLayout(blueTeamPanel);
        blueTeamPanel.setLayout(blueTeamPanelLayout);
        blueTeamPanelLayout.setHorizontalGroup(
            blueTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blueTeamPanelLayout.createSequentialGroup()
                .addGroup(blueTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(blueTeamPanelLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(lblBlueTeam))
                    .addGroup(blueTeamPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblAlimentoAzules)
                        .addGap(18, 18, 18)
                        .addComponent(txtAA, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        blueTeamPanelLayout.setVerticalGroup(
            blueTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blueTeamPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBlueTeam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(blueTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAlimentoAzules))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelInfo.add(blueTeamPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 77, 302, -1));

        greenTeamPanel.setBackground(new java.awt.Color(153, 255, 102));
        greenTeamPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        lblGreenTeam.setFont(new java.awt.Font("Verdana Pro Black", 0, 18)); // NOI18N
        lblGreenTeam.setText("Green team");

        lblAlimentoVerdes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAlimentoVerdes.setText("Alimento recolectado:");

        txtAV.setEditable(false);
        txtAV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAV.setText("0");
        txtAV.setFocusable(false);

        javax.swing.GroupLayout greenTeamPanelLayout = new javax.swing.GroupLayout(greenTeamPanel);
        greenTeamPanel.setLayout(greenTeamPanelLayout);
        greenTeamPanelLayout.setHorizontalGroup(
            greenTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(greenTeamPanelLayout.createSequentialGroup()
                .addGroup(greenTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(greenTeamPanelLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(lblGreenTeam))
                    .addGroup(greenTeamPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblAlimentoVerdes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAV, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        greenTeamPanelLayout.setVerticalGroup(
            greenTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(greenTeamPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGreenTeam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(greenTeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlimentoVerdes)
                    .addComponent(txtAV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelInfo.add(greenTeamPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 302, -1));

        datosPanel.setBackground(new java.awt.Color(204, 204, 0));
        datosPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        lblfoodToWin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblfoodToWin.setText("Cantidad de alimento para ganar:");

        txtAlimentoTotal.setEditable(false);
        txtAlimentoTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAlimentoTotal.setFocusable(false);

        lblDatos.setFont(new java.awt.Font("Verdana Pro Black", 0, 18)); // NOI18N
        lblDatos.setText("Información");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Cantidad de nodos: ");

        txtnodos.setEditable(false);
        txtnodos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnodos.setFocusable(false);

        jButton3.setBackground(new java.awt.Color(255, 255, 51));
        jButton3.setText("Ayuda");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnIfnfo.setBackground(new java.awt.Color(51, 153, 255));
        btnIfnfo.setText("Info");
        btnIfnfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIfnfoActionPerformed(evt);
            }
        });

        lblNodoPresionado.setText("Nodo:");

        txtNodoPresionado.setEditable(false);
        txtNodoPresionado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNodoPresionado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNodoPresionado.setFocusable(false);

        txaDetalles.setEditable(false);
        txaDetalles.setBackground(new java.awt.Color(255, 255, 255));
        txaDetalles.setColumns(10);
        txaDetalles.setRows(5);
        txaDetalles.setFocusable(false);
        jspDetalle.setViewportView(txaDetalles);

        lblArcos.setText("Arcos:");

        javax.swing.GroupLayout datosPanelLayout = new javax.swing.GroupLayout(datosPanel);
        datosPanel.setLayout(datosPanelLayout);
        datosPanelLayout.setHorizontalGroup(
            datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosPanelLayout.createSequentialGroup()
                .addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(datosPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtnodos, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(datosPanelLayout.createSequentialGroup()
                                .addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(datosPanelLayout.createSequentialGroup()
                                        .addComponent(lblfoodToWin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAlimentoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(datosPanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(datosPanelLayout.createSequentialGroup()
                                                .addComponent(lblNodoPresionado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtNodoPresionado, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(datosPanelLayout.createSequentialGroup()
                                                .addComponent(lblArcos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jspDetalle)))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(datosPanelLayout.createSequentialGroup()
                        .addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(datosPanelLayout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(lblDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(datosPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnIfnfo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        datosPanelLayout.setVerticalGroup(
            datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblfoodToWin)
                    .addComponent(txtAlimentoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNodoPresionado)
                    .addComponent(txtNodoPresionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblArcos)
                    .addComponent(jspDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(datosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(btnIfnfo))
                .addGap(18, 18, 18))
        );

        panelInfo.add(datosPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 166, -1, -1));

        paneltotal.add(panelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 310, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneltotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        VInicio ventanaInicio = new VInicio();
        ventanaInicio.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnIfnfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIfnfoActionPerformed
        JOptionPane.showMessageDialog(this, "Integrantes:\n- name carnet"
                + "\n- name carnet"
                + "\n- name carnet \nRepositorio: https://github.com/YitzyJimenezJ/AntVillage.git");
    }//GEN-LAST:event_btnIfnfoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       JOptionPane.showMessageDialog(this, "Detalles:\n-Selecciona un nodo/botón "
               + "para ver los detalles del mismo, además podrás colocar el \n"
               + "alimento en esa posición; si no hay alimento entonces el \n"
               + "programa eligirá un nodo aleatoriamente\n");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        this.btnIniciar.setVisible(false);
        juego = new Juego(this, this.cantidad_alimento);
    }//GEN-LAST:event_btnIniciarActionPerformed
   
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
            java.util.logging.Logger.getLogger(VMedioJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VMedioJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VMedioJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VMedioJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VMedioJuego().setVisible(true);
            }
        });
    }
    public void dibujarLinea(Graphics g, int xInicio, int yInicio, int xDestino, int yDestino, Color color){
        g.setColor(color);
        g.drawLine(xInicio, yInicio, xDestino, yDestino);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel blueTeamPanel;
    private javax.swing.JButton btnIfnfo;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JPanel datosPanel;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JPanel greenTeamPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jspDetalle;
    private javax.swing.JLabel lblAlimentoAzules;
    private javax.swing.JLabel lblAlimentoVerdes;
    private javax.swing.JLabel lblArcos;
    private javax.swing.JLabel lblBlueTeam;
    private javax.swing.JLabel lblDatos;
    private javax.swing.JLabel lblGreenTeam;
    private javax.swing.JLabel lblNodoPresionado;
    private javax.swing.JLabel lblfoodToWin;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel paneltotal;
    private javax.swing.JTextArea txaDetalles;
    private javax.swing.JTextField txtAA;
    private javax.swing.JTextField txtAV;
    private javax.swing.JTextField txtAlimentoTotal;
    private javax.swing.JTextField txtNodoPresionado;
    private javax.swing.JTextField txtnodos;
    // End of variables declaration//GEN-END:variables
}
