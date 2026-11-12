/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import controlador.Controlador_Usuario;
import modelo.Usuario;
import vista.Vista_Usuarios;
import javax.swing.JOptionPane; 
import javax.swing.table.DefaultTableModel; 
/**
 *
 * @author nhigtus
 */
public class Frm_Usuarios extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Frm_Usuarios.class.getName());
    private Controlador_Usuario cont = new Controlador_Usuario();
    private DefaultTableModel modeloTabla; 
    private static boolean inicializado = false;

    
    public Frm_Usuarios() {
        initComponents();
    if (!inicializado) {
        new Vista_Usuarios();
        inicializado = true;
    }
    modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Apellido", "Teléfono", "Correo",
            "Nivel", "Cargo", "Salario", "Turno", "Almacén", "Administrador"}, 0) {
        @Override
        public boolean isCellEditable(int fila, int col) {
            return false;
        }
    };
    Table.setModel(modeloTabla);
    cargarTabla();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TITULO = new javax.swing.JLabel();
        PanelDatosdeUsuarios = new javax.swing.JPanel();
        ID = new javax.swing.JLabel();
        Apellido = new javax.swing.JLabel();
        Correo = new javax.swing.JLabel();
        Contraseña = new javax.swing.JLabel();
        Salario = new javax.swing.JLabel();
        AlmacenAsignado = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        textApellido = new javax.swing.JTextField();
        textCorreo = new javax.swing.JTextField();
        textContraseña = new javax.swing.JTextField();
        textSalario = new javax.swing.JTextField();
        textAlmacenAsignado = new javax.swing.JTextField();
        Nombre = new javax.swing.JLabel();
        Telefono = new javax.swing.JLabel();
        Nivel = new javax.swing.JLabel();
        Cargo = new javax.swing.JLabel();
        Turno = new javax.swing.JLabel();
        Administrador = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        textTelefono = new javax.swing.JTextField();
        textNivel = new javax.swing.JTextField();
        comboCargo = new javax.swing.JComboBox<>();
        comboTurno = new javax.swing.JComboBox<>();
        textAdministrador = new javax.swing.JTextField();
        panelOpciones = new javax.swing.JPanel();
        btnInsertar = new javax.swing.JButton();
        btnConsultarID = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnOrdenarQuickSort = new javax.swing.JButton();
        btnOrdenarMergeSort = new javax.swing.JButton();
        btnMostrarTodos = new javax.swing.JButton();
        panelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TITULO.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        TITULO.setText("GESTION DE USUARIOS ");

        PanelDatosdeUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Usuarios"));

        ID.setText("ID:");

        Apellido.setText("Apellido:");

        Correo.setText("Correo:");

        Contraseña.setText("Contraseña:");

        Salario.setText("Salario:");

        AlmacenAsignado.setText("Almacen Asignado:");

        Nombre.setText("Nombre:");

        Telefono.setText("Telefono:");

        Nivel.setText("Nivel:");

        Cargo.setText("Cargo:");

        Turno.setText("Turno:");

        Administrador.setText("Administrador:");

        comboCargo.setEditable(true);
        comboCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Operario", "Gerente", "Administrador" }));
        comboCargo.addActionListener(this::comboCargoActionPerformed);

        comboTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "Noche" }));

        javax.swing.GroupLayout PanelDatosdeUsuariosLayout = new javax.swing.GroupLayout(PanelDatosdeUsuarios);
        PanelDatosdeUsuarios.setLayout(PanelDatosdeUsuariosLayout);
        PanelDatosdeUsuariosLayout.setHorizontalGroup(
            PanelDatosdeUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosdeUsuariosLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(PanelDatosdeUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ID)
                    .addComponent(Apellido)
                    .addComponent(Correo)
                    .addComponent(Contraseña)
                    .addComponent(Salario)
                    .addComponent(AlmacenAsignado))
                .addGap(33, 33, 33)
                .addGroup(PanelDatosdeUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textID, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(textApellido)
                    .addComponent(textCorreo)
                    .addComponent(textContraseña)
                    .addComponent(textSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textAlmacenAsignado))
                .addGap(46, 46, 46)
                .addGroup(PanelDatosdeUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nombre)
                    .addComponent(Telefono)
                    .addComponent(Nivel)
                    .addComponent(Cargo)
                    .addComponent(Turno)
                    .addComponent(Administrador))
                .addGap(78, 78, 78)
                .addGroup(PanelDatosdeUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(textTelefono)
                    .addComponent(comboCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textAdministrador)
                    .addComponent(textNivel))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        PanelDatosdeUsuariosLayout.setVerticalGroup(
            PanelDatosdeUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosdeUsuariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelDatosdeUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelDatosdeUsuariosLayout.createSequentialGroup()
                        .addGroup(PanelDatosdeUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ID)
                            .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nombre)
                            .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelDatosdeUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Apellido)
                            .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Telefono)
                            .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelDatosdeUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Correo)
                            .addComponent(textCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nivel)
                            .addComponent(textNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(PanelDatosdeUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Contraseña)
                            .addGroup(PanelDatosdeUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Cargo)
                                .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3))
                    .addComponent(textContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosdeUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salario)
                    .addComponent(textSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Turno)
                    .addComponent(comboTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelDatosdeUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AlmacenAsignado)
                    .addComponent(textAlmacenAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Administrador)
                    .addComponent(textAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93))
        );

        panelOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(this::btnInsertarActionPerformed);

        btnConsultarID.setText("Consultar por ID");
        btnConsultarID.addActionListener(this::btnConsultarIDActionPerformed);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        btnOrdenarQuickSort.setText("Ordenar por id Quick Sort");
        btnOrdenarQuickSort.addActionListener(this::btnOrdenarQuickSortActionPerformed);

        btnOrdenarMergeSort.setText("Ordernar por apellido Merge Sort");
        btnOrdenarMergeSort.addActionListener(this::btnOrdenarMergeSortActionPerformed);

        btnMostrarTodos.setText("Mostrar Todos");
        btnMostrarTodos.addActionListener(this::btnMostrarTodosActionPerformed);

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInsertar)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar)
                    .addComponent(btnConsultarID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar)
                    .addComponent(btnOrdenarQuickSort)
                    .addComponent(btnOrdenarMergeSort)
                    .addComponent(btnMostrarTodos))
                .addGap(26, 26, 26))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultarID)
                    .addComponent(btnOrdenarQuickSort))
                .addGap(18, 18, 18)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnOrdenarMergeSort))
                .addGap(18, 18, 18)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnMostrarTodos))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Table);

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1083, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(493, 493, 493)
                .addComponent(TITULO)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PanelDatosdeUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(228, 228, 228))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(TITULO)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelDatosdeUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        Usuario a = leerFormulario();
    if (a == null) return;
    if (cont.consultarUno(a) != null) {
        aviso("Ya existe un usuario con ese ID.");
        return;
    }
    if (cont.insertar(a)) {
        JOptionPane.showMessageDialog(this, "Usuario registrado.");
        cargarTabla();
        limpiar();
    } else {
        aviso("No se pudo insertar el almacén.");
    }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed
//==============================
    private void btnConsultarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarIDActionPerformed
      
     int id = leerId();
    if (id < 0) return;
    Usuario buscado = new Usuario();
    buscado.setId(id);
    Usuario a = (Usuario) cont.consultarUno(buscado);
    if (a == null) {
        aviso("No se encontró un usuario con ese ID.");
        return;
    }
    llenarFormulario(a);
    }//GEN-LAST:event_btnConsultarIDActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Usuario a = leerFormulario();
        if (a == null) return;
    if (cont.update(a) == null) {
        aviso("No se encontró un usuario con ese ID.");
        return;
    }
    JOptionPane.showMessageDialog(this, "Usuario actualizado.");
    cargarTabla();
    limpiar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int id = leerId();
    if (id < 0) return;
    Usuario buscado = new Usuario();
    buscado.setId(id);
    Usuario a = (Usuario) cont.consultarUno(buscado);
    if (a == null) {
        aviso("No se encontró un almacén con ese ID.");
        return;
    }
    int op = JOptionPane.showConfirmDialog(this, "¿Eliminar " + a.getNombre()+ "?",
            "Confirmar", JOptionPane.YES_NO_OPTION);
    if (op == JOptionPane.YES_OPTION) {
        cont.delete(a);
        cargarTabla();
        limpiar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnOrdenarQuickSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarQuickSortActionPerformed
        
        cont.ordenarPorId();
        cargarTabla();
        //no se si asi esta bien
    }//GEN-LAST:event_btnOrdenarQuickSortActionPerformed

    private void btnOrdenarMergeSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarMergeSortActionPerformed
        
        cont.ordenarPorNombre();
        cargarTabla();
        //no se si asi esta bien
    }//GEN-LAST:event_btnOrdenarMergeSortActionPerformed

    private void btnMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodosActionPerformed
        
        cargarTabla();
        
    }//GEN-LAST:event_btnMostrarTodosActionPerformed

    private void comboCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCargoActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Frm_Usuarios().setVisible(true));
    }
    private void cargarTabla() {
        modeloTabla.setRowCount(0);
    for (Usuario a : Controlador_Usuario.arregloUsuarios) {
        modeloTabla.addRow(new Object[]{a.getId(), a.getNombre(), a.getApellido(), a.getTelefono(),
            a.getCorreo(), a.getNivel(), a.getCargo(), a.getSalario(), a.getTurno(),
            a.getAlmacen_asignado(), a.getAdministrador()});
    }
    
    }
    private void limpiar() {
    textAlmacenAsignado.setText("");
    textApellido.setText("");
    textContraseña.setText("");
    textCorreo.setText("");
    textID.setText("");
    textNivel.setText("");
    textNombre.setText("");
    textSalario.setText("");
    textTelefono.setText("");
    Table.clearSelection();
    }
    
    private Usuario leerFormulario() {
    int id = leerId();
    if (id < 0) return null;
    String nombre = textNombre.getText().trim();
    String apellido = textApellido.getText().trim();
    String correo = textCorreo.getText().trim();
    String contraseña = textContraseña.getText().trim();
    String almacen = textAlmacenAsignado.getText().trim();
    String administrador = textAdministrador.getText().trim();

    if (nombre.isEmpty() || apellido.isEmpty() || textTelefono.getText().trim().isEmpty()
            || correo.isEmpty() || textNivel.getText().trim().isEmpty() || contraseña.isEmpty()
            || textSalario.getText().trim().isEmpty() || almacen.isEmpty() || administrador.isEmpty()) {
        aviso("Complete el formulario por favor");
        return null;
    }
    try {
        int telefono = Integer.parseInt(textTelefono.getText().trim());
        int nivel = Integer.parseInt(textNivel.getText().trim());
        float salario = Float.parseFloat(textSalario.getText().trim());
        String cargo = String.valueOf(comboCargo.getSelectedItem());
        String turno = String.valueOf(comboTurno.getSelectedItem());
        return new Usuario(id, nombre, apellido, telefono, correo, nivel, contraseña,
                cargo, salario, turno, almacen, administrador);
    } catch (NumberFormatException e) {
        aviso("Teléfono, nivel y salario deben ser números.");
        return null;
        }
    }
    
    private void aviso(String msg) {
    JOptionPane.showMessageDialog(this, msg, "Dato inválido", JOptionPane.WARNING_MESSAGE);
    }
    
    private int leerId() {
    try {
        int id = Integer.parseInt(textID.getText().trim());
        if (id < 0) throw new NumberFormatException();
        return id;
    } catch (NumberFormatException e) {
        aviso("El ID debe ser un número entero positivo.");
        return -1;
    }
    
}
    private void llenarFormulario(Usuario a) {
    textID.setText(String.valueOf(a.getId()));
    textNombre.setText(a.getNombre());
    textApellido.setText(a.getApellido());
    textTelefono.setText(String.valueOf(a.getTelefono()));
    textCorreo.setText(a.getCorreo());
    textNivel.setText(String.valueOf(a.getNivel()));
    textContraseña.setText(a.getContraseña());
    textSalario.setText(String.valueOf(a.getSalario()));
    textAlmacenAsignado.setText(a.getAlmacen_asignado());
    textAdministrador.setText(a.getAdministrador());
    comboCargo.setSelectedItem(a.getCargo());
    comboTurno.setSelectedItem(a.getTurno());
}
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Administrador;
    private javax.swing.JLabel AlmacenAsignado;
    private javax.swing.JLabel Apellido;
    private javax.swing.JLabel Cargo;
    private javax.swing.JLabel Contraseña;
    private javax.swing.JLabel Correo;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel Nivel;
    private javax.swing.JLabel Nombre;
    private javax.swing.JPanel PanelDatosdeUsuarios;
    private javax.swing.JLabel Salario;
    private javax.swing.JLabel TITULO;
    private javax.swing.JTable Table;
    private javax.swing.JLabel Telefono;
    private javax.swing.JLabel Turno;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnConsultarID;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMostrarTodos;
    private javax.swing.JButton btnOrdenarMergeSort;
    private javax.swing.JButton btnOrdenarQuickSort;
    private javax.swing.JComboBox<String> comboCargo;
    private javax.swing.JComboBox<String> comboTurno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTextField textAdministrador;
    private javax.swing.JTextField textAlmacenAsignado;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textContraseña;
    private javax.swing.JTextField textCorreo;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textNivel;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textSalario;
    private javax.swing.JTextField textTelefono;
    // End of variables declaration//GEN-END:variables
}
