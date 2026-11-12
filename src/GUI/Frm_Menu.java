/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author nhigtus
 */
public class Frm_Menu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Frm_Menu.class.getName());

   
    public Frm_Menu() {
        initComponents();
        setLocationRelativeTo(null);   // centra la ventana
        aplicarRolAlMenu();            // estado inicial según el rol elegido
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        comboRol = new javax.swing.JComboBox<>();
        ROL = new javax.swing.JLabel();
        btnAdministrarProductos = new javax.swing.JButton();
        btnAdministrarAlmacenes = new javax.swing.JButton();
        btnAdministrarUbicaciones = new javax.swing.JButton();
        btnAdministrarMovimientos = new javax.swing.JButton();
        btnAdministrarUsuarios = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Panel.setToolTipText("");

        Titulo.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        Titulo.setText("MENU PRINCIPAL");

        comboRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Operario", "Administrador" }));
        comboRol.addActionListener(this::comboRolActionPerformed);

        ROL.setText("Elija un Rol");

        btnAdministrarProductos.setText("Administrar Productos");
        btnAdministrarProductos.addActionListener(this::btnAdministrarProductosActionPerformed);

        btnAdministrarAlmacenes.setText("Administrar Almacenes");
        btnAdministrarAlmacenes.addActionListener(this::btnAdministrarAlmacenesActionPerformed);

        btnAdministrarUbicaciones.setText("Administrar Ubicaciones");
        btnAdministrarUbicaciones.addActionListener(this::btnAdministrarUbicacionesActionPerformed);

        btnAdministrarMovimientos.setText("Administrar Movimientos");
        btnAdministrarMovimientos.addActionListener(this::btnAdministrarMovimientosActionPerformed);

        btnAdministrarUsuarios.setText("Administrar Usuarios");
        btnAdministrarUsuarios.addActionListener(this::btnAdministrarUsuariosActionPerformed);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(Titulo))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(ROL)
                        .addGap(144, 144, 144)
                        .addComponent(comboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(btnAdministrarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(btnAdministrarAlmacenes, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(btnAdministrarUbicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(btnAdministrarMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(btnAdministrarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Titulo)
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ROL))
                .addGap(18, 18, 18)
                .addComponent(btnAdministrarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdministrarAlmacenes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdministrarUbicaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdministrarMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdministrarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRolActionPerformed
        aplicarRolAlMenu();
    }//GEN-LAST:event_comboRolActionPerformed

    private void btnAdministrarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarProductosActionPerformed
        abrir(new Frm_Productos());
    }//GEN-LAST:event_btnAdministrarProductosActionPerformed

    private void btnAdministrarAlmacenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarAlmacenesActionPerformed
        abrir(new Frm_Almacenes());
    }//GEN-LAST:event_btnAdministrarAlmacenesActionPerformed

    private void btnAdministrarUbicacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarUbicacionesActionPerformed
        abrir(new Frm_Ubicacion_Corporativa());
    }//GEN-LAST:event_btnAdministrarUbicacionesActionPerformed

    private void btnAdministrarMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarMovimientosActionPerformed
        abrir(new Frm_Movimientos());
    }//GEN-LAST:event_btnAdministrarMovimientosActionPerformed

    private void btnAdministrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarUsuariosActionPerformed
        abrir(new Frm_Usuarios());
    }//GEN-LAST:event_btnAdministrarUsuariosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Frm_Menu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JLabel ROL;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btnAdministrarAlmacenes;
    private javax.swing.JButton btnAdministrarMovimientos;
    private javax.swing.JButton btnAdministrarProductos;
    private javax.swing.JButton btnAdministrarUbicaciones;
    private javax.swing.JButton btnAdministrarUsuarios;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> comboRol;
    // End of variables declaration//GEN-END:variables
// Devuelve el rol elegido en el combo
private String rolActual() {
    return String.valueOf(comboRol.getSelectedItem());
}

// Solo el administrador puede entrar a Usuarios
private void aplicarRolAlMenu() {
    btnAdministrarUsuarios.setEnabled(rolActual().equals("Administrador"));
}

// Abre una ventana, oculta el menú y lo vuelve a mostrar al cerrarla
private void abrir(javax.swing.JFrame f) {
    f.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);   // cerrar NO termina el programa
    aplicarRolAVentana(f.getContentPane());
    f.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosed(java.awt.event.WindowEvent e) {
            setVisible(true);
        }
    });
    setVisible(false);
    f.setVisible(true);
}

// Recorre los componentes de la ventana y deshabilita botones según el rol
private void aplicarRolAVentana(java.awt.Container c) {
    String rol = rolActual();
    for (java.awt.Component comp : c.getComponents()) {
        if (comp instanceof javax.swing.JButton) {
            javax.swing.JButton b = (javax.swing.JButton) comp;
            String t = b.getText() == null ? "" : b.getText().toLowerCase();
            boolean escribe = t.contains("insert") || t.contains("agreg") || t.contains("guard")
                    || t.contains("actualiz") || t.contains("modific");
            boolean borra = t.contains("elimin") || t.contains("borr");
            if (rol.equals("Gerente") && (escribe || borra)) b.setEnabled(false);
            if (rol.equals("Operario") && borra) b.setEnabled(false);
        }
        if (comp instanceof java.awt.Container) {
            aplicarRolAVentana((java.awt.Container) comp);
        }
    }
}
}
