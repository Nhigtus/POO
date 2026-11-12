/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


package GUI;
import controlador.Controlador_Almacenes;
import modelo.Almacenes;
import vista.Vista_Almacenes;
import javax.swing.JOptionPane; 
import javax.swing.table.DefaultTableModel; 
import controlador.Controlador_Zona;
import modelo.Zona;
import controlador.Controlador_Productos;
import modelo.Producto;
import java.util.ArrayList;

/**
 *
 * @author nhigtus
 */
public class Frm_Almacenes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Frm_Almacenes.class.getName());
    private Controlador_Almacenes cont = new Controlador_Almacenes();
    private DefaultTableModel modeloTabla; 
    private static boolean inicializado = false;
    private Controlador_Zona contZona = new Controlador_Zona();
    private DefaultTableModel modeloZonas;
    private DefaultTableModel modeloProductosZona;
    private javax.swing.JTable tblProductosZona;
    private javax.swing.JComboBox<String> cmbProductoZona;
    private javax.swing.JButton btnAgregarProductoZona;
    private javax.swing.JButton btnQuitarProductoZona;
    /**
     * Creates new form Frm_Almacenes
     */
    public Frm_Almacenes() {
        initComponents();
        if (!inicializado) {
            new vista.Vista_Ubicacion_Corporativa();   // las ciudades deben existir antes de enlazar los almacenes
            new Vista_Almacenes();
            new vista.Vista_Productos();     // datos base para asignar productos a las zonas
            inicializado = true;
            }
        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Ciudad", "Gerente", "País"}, 0){
        @Override
        public boolean isCellEditable(int fila, int col) {
            return false;
            }
        };
        
        table.setModel(modeloTabla); 
        table.setFillsViewportHeight(true);
        cargarTabla();
        modeloZonas = new DefaultTableModel(
    new String[]{"ID", "Código de área", "Capacidad", "Ocupación"}, 0
) {
    @Override
    public boolean isCellEditable(int fila, int columna) {
        return false;
    }
};

jTable1.setModel(modeloZonas);
jTable1.setFillsViewportHeight(true);

// Crea la tabla, el combo y los botones de productos dentro del panel
construirPanelProductos();
modeloProductosZona = new DefaultTableModel(new String[]{"ID", "Nombre", "Stock", "Detalle"}, 0) {
    @Override
    public boolean isCellEditable(int fila, int columna) {
        return false;
    }
};
tblProductosZona.setModel(modeloProductosZona);

// Detectar cuando se selecciona otro almacén
cmbalmacenes.addActionListener(e -> cargarTablaZonas());

// Detectar cuando se selecciona una zona de la tabla
jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTable1MouseClicked(evt);
    }
});

// El combo de zona permitirá escribir códigos
txtCodigoarea.removeAllItems();
txtCodigoarea.setEditable(true);

// Refresca productos y zonas al volver a esta ventana (por si se editó un producto)
addWindowFocusListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowGainedFocus(java.awt.event.WindowEvent evt) {
        if (modeloZonas == null) return;
        cargarProductosCombo();
        int fila = jTable1.getSelectedRow();
        int idZona = fila >= 0 ? (int) modeloZonas.getValueAt(fila, 0) : -1;
        cargarTablaZonas();
        if (idZona >= 0) {
            refrescarZonas(idZona);
        }
    }
});

// Cargar productos y almacenes reales
cargarProductosCombo();
cargarAlmacenesCombo();

// Deja la ventana en un tamaño usable y reorganiza los paneles
organizarDiseno();
        
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textidAlmacen = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        textCiudad = new javax.swing.JTextField();
        textGerenteAsignado = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Insertar = new javax.swing.JButton();
        ConsultarID = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        MostrarTodo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        scrollTabla = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        Panelzona = new javax.swing.JPanel();
        Zona = new javax.swing.JLabel();
        Area = new javax.swing.JLabel();
        Descripcion = new javax.swing.JLabel();
        txtcapacidad = new javax.swing.JTextField();
        Almacenalquepertenece = new javax.swing.JLabel();
        cmbalmacenes = new javax.swing.JComboBox<>();
        panellistadeproductos = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnInsertarzona = new javax.swing.JButton();
        btnEliminarzona = new javax.swing.JButton();
        btnActualizarzona = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtCodigoarea = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 3, 18)); // NOI18N
        jLabel1.setText("   GESTION DE ALMACENES");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Almacen"));

        jLabel2.setText("Id del Almacen:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Ciudad:");

        jLabel5.setText("Gerente Asignado");

        textidAlmacen.addActionListener(this::textidAlmacenActionPerformed);

        textNombre.addActionListener(this::textNombreActionPerformed);

        textCiudad.addActionListener(this::textCiudadActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textidAlmacen)
                    .addComponent(textNombre)
                    .addComponent(textCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(textGerenteAsignado))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textidAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textGerenteAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(200, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        Insertar.setText("Insertar");
        Insertar.addActionListener(this::InsertarActionPerformed);

        ConsultarID.setText("Consultar ID");
        ConsultarID.addActionListener(this::ConsultarIDActionPerformed);

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(this::ActualizarActionPerformed);

        Limpiar.setText("LImpiar");
        Limpiar.addActionListener(this::LimpiarActionPerformed);

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(this::EliminarActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Insertar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ConsultarID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Insertar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ConsultarID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Limpiar)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenamiento"));

        jButton5.setText("Ordenar por Id");
        jButton5.addActionListener(this::jButton5ActionPerformed);

        MostrarTodo.setText("Mostrar Todos");
        MostrarTodo.addActionListener(this::MostrarTodoActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(MostrarTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(MostrarTodo)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 833, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollTabla.setViewportView(table);

        Zona.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        Zona.setText("Zona");

        Area.setText("Area");

        Descripcion.setText("Capacidad maxima");

        Almacenalquepertenece.setText("Almacen al que pertenece");

        cmbalmacenes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Almacen 1", "Almacen 2", "Almacen 3", "Almacen 4" }));

        javax.swing.GroupLayout panellistadeproductosLayout = new javax.swing.GroupLayout(panellistadeproductos);
        panellistadeproductos.setLayout(panellistadeproductosLayout);
        panellistadeproductosLayout.setHorizontalGroup(
            panellistadeproductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        panellistadeproductosLayout.setVerticalGroup(
            panellistadeproductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        btnInsertarzona.setText("Insertar");
        btnInsertarzona.addActionListener(this::btnInsertarzonaActionPerformed);

        btnEliminarzona.setText("Eliminar");
        btnEliminarzona.addActionListener(this::btnEliminarzonaActionPerformed);

        btnActualizarzona.setText("Actualizar");
        btnActualizarzona.addActionListener(this::btnActualizarzonaActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        txtCodigoarea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Almacen 1", "Almacen 2", "Almacen 3", "Almacen 4" }));

        javax.swing.GroupLayout PanelzonaLayout = new javax.swing.GroupLayout(Panelzona);
        Panelzona.setLayout(PanelzonaLayout);
        PanelzonaLayout.setHorizontalGroup(
            PanelzonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelzonaLayout.createSequentialGroup()
                .addGroup(PanelzonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelzonaLayout.createSequentialGroup()
                        .addGroup(PanelzonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelzonaLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(Area))
                            .addGroup(PanelzonaLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(txtCodigoarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(59, 59, 59)
                        .addGroup(PanelzonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtcapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Descripcion))
                        .addGroup(PanelzonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelzonaLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(cmbalmacenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelzonaLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(Almacenalquepertenece)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addGroup(PanelzonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelzonaLayout.createSequentialGroup()
                                .addGroup(PanelzonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEliminarzona)
                                    .addComponent(btnActualizarzona))
                                .addGap(55, 55, 55)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnInsertarzona)))
                    .addGroup(PanelzonaLayout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(Zona)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panellistadeproductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelzonaLayout.setVerticalGroup(
            PanelzonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelzonaLayout.createSequentialGroup()
                .addGroup(PanelzonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelzonaLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(Zona, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PanelzonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelzonaLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(PanelzonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnInsertarzona, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PanelzonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Area)
                                        .addComponent(Descripcion)
                                        .addComponent(Almacenalquepertenece)))
                                .addGroup(PanelzonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelzonaLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(PanelzonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(PanelzonaLayout.createSequentialGroup()
                                                .addComponent(btnEliminarzona)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnActualizarzona))
                                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(PanelzonaLayout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(panellistadeproductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(PanelzonaLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(PanelzonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtcapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbalmacenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigoarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(PanelzonaLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(255, 255, 255)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 1238, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panelzona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panelzona, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(617, 617, 617)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textidAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textidAlmacenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textidAlmacenActionPerformed

    private void textNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreActionPerformed

    private void textCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCiudadActionPerformed

    private void MostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarTodoActionPerformed
        cargarTabla();
    }//GEN-LAST:event_MostrarTodoActionPerformed

    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarActionPerformed
        Almacenes a = leerFormulario();
    if (a == null) return;
    if (cont.consultarUno(a) != null) {
        aviso("Ya existe un almacén con ese ID.");
        return;
    }
    if (cont.insertar(a)) {
        JOptionPane.showMessageDialog(this, "Almacén registrado.");
        avisarSiSinCiudad(a);
        cargarTabla();
    cargarAlmacenesCombo();
    limpiar();
    } else {
        aviso("No se pudo insertar el almacén.");
        }
    }//GEN-LAST:event_InsertarActionPerformed

    private void ConsultarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarIDActionPerformed
        int id = leerId();
        if (id < 0) return;
    Almacenes buscado = new Almacenes();
    buscado.setId_almacen(id);
    Almacenes a = (Almacenes) cont.consultarUno(buscado);
    if (a == null) {
        aviso("No se encontró un almacén con ese ID.");
        return;
    }
    textidAlmacen.setText(String.valueOf(a.getId_almacen()));
    textNombre.setText(a.getNombre_almacen());
    textCiudad.setText(a.getCiudad_almacen());
    textGerenteAsignado.setText(a.getGerente_asignado());
    }//GEN-LAST:event_ConsultarIDActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        Almacenes a = leerFormulario();
    if (a == null) return;
    if (cont.update(a) == null) {
        aviso("No se encontró un almacén con ese ID.");
        return;
    }
    JOptionPane.showMessageDialog(this, "Almacén actualizado.");
    avisarSiSinCiudad(a);
    cargarTabla();
    cargarAlmacenesCombo();
    limpiar();
    }//GEN-LAST:event_ActualizarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int id = leerId();
    if (id < 0) return;
    Almacenes buscado = new Almacenes();
    buscado.setId_almacen(id);
    Almacenes a = (Almacenes) cont.consultarUno(buscado);
    if (a == null) {
        aviso("No se encontró un almacén con ese ID.");
        return;
    }
    int op = JOptionPane.showConfirmDialog(this,
            "¿Eliminar " + a.getNombre_almacen() + " y sus " + a.getZonas().size() + " zonas?",
            "Confirmar", JOptionPane.YES_NO_OPTION);
    if (op == JOptionPane.YES_OPTION) {
        cont.delete(a);
        cargarTabla();
        cargarAlmacenesCombo();
        limpiar();
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
          limpiar();
    }//GEN-LAST:event_LimpiarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         cont.ordenarPorId();
        cargarTabla();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnInsertarzonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarzonaActionPerformed
        Almacenes almacen = obtenerAlmacenSeleccionado();

    if (almacen == null) {
        aviso("Primero debes registrar y seleccionar un almacén.");
        return;
    }

    String codigo = codigoArea();

    if (codigo.isEmpty()) {
        aviso("Escribe el código de área.");
        return;
    }

    int capacidad;

    try {
        capacidad = Integer.parseInt(txtcapacidad.getText().trim());

        if (capacidad <= 0) {
            aviso("La capacidad debe ser mayor que cero.");
            return;
        }

    } catch (NumberFormatException e) {
        aviso("La capacidad debe ser un número entero.");
        return;
    }

    Zona zona = new Zona(generarIdZona(), codigo, capacidad);
    zona.setAlmacen(almacen);

    if (contZona.insertar(zona)) {

        JOptionPane.showMessageDialog(this, "Zona registrada correctamente.");

        refrescarZonas(zona.getId_zona());
        txtcapacidad.setText("");
        txtCodigoarea.setSelectedItem("");

    } else {
        aviso("No se pudo registrar la zona. Verifica que el ID no esté repetido.");
    }
    }//GEN-LAST:event_btnInsertarzonaActionPerformed

    private void btnActualizarzonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarzonaActionPerformed
         
    Zona actual = zonaSeleccionada();

    if (actual == null) {
        aviso("Selecciona una zona de la tabla.");
        return;
    }

    String codigo = codigoArea();

    int capacidad;

    try {
        capacidad = Integer.parseInt(txtcapacidad.getText().trim());

    } catch (NumberFormatException e) {
        aviso("La capacidad debe ser un número entero.");
        return;
    }

    if (codigo.isEmpty() || capacidad <= 0) {
        aviso("Verifica el código y la capacidad.");
        return;
    }

    if (capacidad < actual.calcularOcupacion()) {
        aviso("La capacidad no puede ser menor que la ocupación actual ("
                + actual.calcularOcupacion() + ").");
        return;
    }

    Zona cambios = new Zona(actual.getId_zona(), codigo, capacidad);

    if (contZona.update(cambios) != null) {

        JOptionPane.showMessageDialog(this, "Zona actualizada.");

        refrescarZonas(actual.getId_zona());

    } else {
        aviso("No se pudo actualizar la zona.");
    }
    }//GEN-LAST:event_btnActualizarzonaActionPerformed

    private void btnEliminarzonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarzonaActionPerformed
         int fila = jTable1.getSelectedRow();

    if (fila < 0) {
        aviso("Selecciona una zona de la tabla.");
        return;
    }

    int id = (int) modeloZonas.getValueAt(fila, 0);

    Zona zona = new Zona();
    zona.setId_zona(id);

    int opcion = JOptionPane.showConfirmDialog(
        this,
        "¿Deseas eliminar esta zona?",
        "Confirmar eliminación",
        JOptionPane.YES_NO_OPTION
    );

    if (opcion == JOptionPane.YES_OPTION) {

        if (contZona.delete(zona)) {

            JOptionPane.showMessageDialog(this, "Zona eliminada.");

            cargarTablaZonas();
            modeloProductosZona.setRowCount(0);

        } else {
            aviso("No se pudo eliminar la zona.");
        }
    }
    }//GEN-LAST:event_btnEliminarzonaActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Frm_Almacenes().setVisible(true));
    }
    
    //=====================
    private int leerId() {
    try {
        int id = Integer.parseInt(textidAlmacen.getText().trim());
        if (id < 0) throw new NumberFormatException();
        return id;
    } catch (NumberFormatException e) {
        aviso("El ID debe ser un número entero positivo.");
        return -1;
    }
}

private Almacenes leerFormulario() {
    int id = leerId();
    if (id < 0) return null;
    String nombre = textNombre.getText().trim();
    String ciudad = textCiudad.getText().trim();
    String gerente = textGerenteAsignado.getText().trim();
    if (nombre.isEmpty() || ciudad.isEmpty() || gerente.isEmpty()) {
        aviso("Complete nombre, ciudad y gerente asignado.");
        return null;
    }
    return new Almacenes(id, nombre, ciudad, gerente);
}

private void cargarTabla() {
    modeloTabla.setRowCount(0);
    for (Almacenes a : Controlador_Almacenes.arregloAlmacenes) {
        modeloTabla.addRow(new Object[]{a.getId_almacen(), a.getNombre_almacen(),
            a.getCiudad_almacen(), a.getGerente_asignado(),
            (a.getCiudad() != null ? a.getCiudad().getNombrePais() : "-")});
    }
}

private void limpiar() {
    textidAlmacen.setText("");
    textNombre.setText("");
    textCiudad.setText("");
    textGerenteAsignado.setText("");
    table.clearSelection();
}

// Avisa si el nombre de la ciudad no coincide con ninguna ciudad registrada en Ubicaciones
private void avisarSiSinCiudad(Almacenes a) {
    Almacenes real = (Almacenes) cont.consultarUno(a);
    if (real != null && real.getCiudad() == null) {
        JOptionPane.showMessageDialog(this,
                "La ciudad \"" + real.getCiudad_almacen() + "\" no está registrada en Ubicaciones.\n"
                + "El almacén quedó guardado, pero sin ciudad vinculada.",
                "Aviso", JOptionPane.WARNING_MESSAGE);
    }
}

private void aviso(String msg) {
    JOptionPane.showMessageDialog(this, msg, "Dato inválido", JOptionPane.WARNING_MESSAGE);
}

// Reorganiza la pantalla para que quepa completa (sin tocar el diseñador)
private void organizarDiseno() {
    // Paneles vacios del formulario original: no se muestran
    jPanel4.setVisible(false);
    jPanel5.setVisible(false);
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    // ----- Panel de zonas: cabecera compacta + tablas lado a lado -----
    Panelzona.removeAll();
    Panelzona.setLayout(new java.awt.BorderLayout(8, 8));

    javax.swing.JPanel cabecera = new javax.swing.JPanel(new java.awt.GridBagLayout());
    cabecera.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la zona"));

    java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
    gbc.insets = new java.awt.Insets(4, 6, 4, 6);
    gbc.anchor = java.awt.GridBagConstraints.WEST;
    gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;

    gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
    cabecera.add(Almacenalquepertenece, gbc);
    gbc.gridx = 1; gbc.weightx = 1;
    cabecera.add(cmbalmacenes, gbc);

    gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
    cabecera.add(Area, gbc);
    gbc.gridx = 1; gbc.weightx = 1;
    cabecera.add(txtCodigoarea, gbc);

    gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
    cabecera.add(Descripcion, gbc);
    gbc.gridx = 1; gbc.weightx = 1;
    cabecera.add(txtcapacidad, gbc);

    javax.swing.JPanel acciones = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 6, 0));
    acciones.add(btnInsertarzona);
    acciones.add(btnActualizarzona);
    acciones.add(btnEliminarzona);
    gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; gbc.weightx = 0;
    cabecera.add(acciones, gbc);

    javax.swing.JPanel norteZona = new javax.swing.JPanel(new java.awt.BorderLayout(8, 8));
    norteZona.add(Zona, java.awt.BorderLayout.WEST);
    norteZona.add(cabecera, java.awt.BorderLayout.CENTER);
    Panelzona.add(norteZona, java.awt.BorderLayout.NORTH);

    jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Zonas del almacén"));
    javax.swing.JPanel centroZona = new javax.swing.JPanel(new java.awt.GridLayout(1, 2, 8, 8));
    centroZona.add(jScrollPane1);
    centroZona.add(panellistadeproductos);
    Panelzona.add(centroZona, java.awt.BorderLayout.CENTER);

    // ----- Parte superior: datos, botones y tabla de almacenes -----
    javax.swing.JPanel datos = new javax.swing.JPanel(new java.awt.BorderLayout(8, 8));
    datos.add(jPanel1, java.awt.BorderLayout.CENTER);

    javax.swing.JPanel botones = new javax.swing.JPanel(new java.awt.GridLayout(2, 1, 8, 8));
    botones.add(jPanel2);
    botones.add(jPanel3);
    datos.add(botones, java.awt.BorderLayout.EAST);

    scrollTabla.setBorder(javax.swing.BorderFactory.createTitledBorder("Almacenes registrados"));
    javax.swing.JPanel superior = new javax.swing.JPanel(new java.awt.BorderLayout(8, 8));
    superior.add(datos, java.awt.BorderLayout.WEST);
    superior.add(scrollTabla, java.awt.BorderLayout.CENTER);

    javax.swing.JSplitPane divisor = new javax.swing.JSplitPane(
            javax.swing.JSplitPane.VERTICAL_SPLIT, superior, Panelzona);
    divisor.setResizeWeight(0.35);
    divisor.setDividerLocation(250);
    divisor.setBorder(null);

    javax.swing.JPanel principal = new javax.swing.JPanel(new java.awt.BorderLayout(8, 8));
    principal.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
    principal.add(jLabel1, java.awt.BorderLayout.NORTH);
    principal.add(divisor, java.awt.BorderLayout.CENTER);

    getContentPane().removeAll();
    getContentPane().setLayout(new java.awt.BorderLayout());
    getContentPane().add(principal, java.awt.BorderLayout.CENTER);
    getContentPane().revalidate();

    java.awt.Dimension pantalla = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setSize(Math.min(1300, pantalla.width - 40), Math.min(700, pantalla.height - 80));
    setMinimumSize(new java.awt.Dimension(980, 600));
    setLocationRelativeTo(null);
}
// Lee lo que el usuario escribió en el combo de código de área (incluso sin pulsar Enter)
private String codigoArea() {
    Object v = txtCodigoarea.getEditor().getItem();
    return v == null ? "" : v.toString().trim();
}

// Construye por código el panel "lista de productos" de la zona
private void construirPanelProductos() {
    cmbProductoZona = new javax.swing.JComboBox<>();
    btnAgregarProductoZona = new javax.swing.JButton("Agregar producto a la zona");
    btnQuitarProductoZona = new javax.swing.JButton("Eliminar producto de la zona");
    tblProductosZona = new javax.swing.JTable();
    tblProductosZona.setFillsViewportHeight(true);

    panellistadeproductos.removeAll();
    panellistadeproductos.setLayout(new java.awt.BorderLayout(5, 5));
    panellistadeproductos.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos de la zona seleccionada"));
    panellistadeproductos.setPreferredSize(new java.awt.Dimension(510, 351));

    javax.swing.JPanel arriba = new javax.swing.JPanel(new java.awt.BorderLayout(5, 5));
    arriba.add(cmbProductoZona, java.awt.BorderLayout.CENTER);
    javax.swing.JPanel botones = new javax.swing.JPanel(new java.awt.GridLayout(1, 2, 5, 5));
    botones.add(btnAgregarProductoZona);
    botones.add(btnQuitarProductoZona);
    arriba.add(botones, java.awt.BorderLayout.SOUTH);

    panellistadeproductos.add(arriba, java.awt.BorderLayout.NORTH);
    panellistadeproductos.add(new javax.swing.JScrollPane(tblProductosZona), java.awt.BorderLayout.CENTER);
    panellistadeproductos.revalidate();

    btnAgregarProductoZona.addActionListener(e -> agregarProductoAZona());
    btnQuitarProductoZona.addActionListener(e -> quitarProductoDeZona());
}

// Cargar almacenes registrados en el combo ("id - nombre")
private void cargarAlmacenesCombo() {
    Almacenes anterior = obtenerAlmacenSeleccionado();   // para conservar la selección

    cmbalmacenes.removeAllItems();

    for (Almacenes a : Controlador_Almacenes.arregloAlmacenes) {
        cmbalmacenes.addItem(a.getId_almacen() + " - " + a.getNombre_almacen());
    }

    if (anterior != null) {
        for (int i = 0; i < cmbalmacenes.getItemCount(); i++) {
            if (cmbalmacenes.getItemAt(i).startsWith(anterior.getId_almacen() + " - ")) {
                cmbalmacenes.setSelectedIndex(i);
                break;
            }
        }
    }
}

// Obtener el almacén seleccionado por ID (no por posición)
private Almacenes obtenerAlmacenSeleccionado() {
    Object item = cmbalmacenes.getSelectedItem();
    if (item == null) return null;

    try {
        int id = Integer.parseInt(item.toString().split(" - ")[0].trim());
        for (Almacenes a : Controlador_Almacenes.arregloAlmacenes) {
            if (a.getId_almacen() == id) return a;
        }
    } catch (NumberFormatException e) {
    }
    return null;
}

// Cargar zonas del almacén seleccionado
private void cargarTablaZonas() {
    modeloZonas.setRowCount(0);
    modeloProductosZona.setRowCount(0);

    Almacenes almacen = obtenerAlmacenSeleccionado();

    if (almacen == null) {
        return;
    }

    for (Zona z : almacen.getZonas()) {
        modeloZonas.addRow(new Object[]{
            z.getId_zona(),
            z.getCodigo_area(),
            z.getCapacidad_maxima(),
            z.calcularOcupacion()
        });
    }
}

private Zona zonaSeleccionada() {
    int fila = jTable1.getSelectedRow();
    if (fila < 0) return null;

    Zona llave = new Zona();
    llave.setId_zona((int) modeloZonas.getValueAt(fila, 0));
    return (Zona) contZona.consultarUno(llave);
}

// Recarga las zonas y deja seleccionada la zona indicada
private void refrescarZonas(int idZona) {
    cargarTablaZonas();

    for (int i = 0; i < modeloZonas.getRowCount(); i++) {
        if ((int) modeloZonas.getValueAt(i, 0) == idZona) {
            jTable1.setRowSelectionInterval(i, i);
            break;
        }
    }
    cargarTablaProductosZona();
}

// Generar ID automático
private int generarIdZona() {

    int mayor = 0;

    for (int i = 0; i < Controlador_Zona.arregloZonas.size(); i++) {

        int id = Controlador_Zona.arregloZonas.get(i).getId_zona();

        if (id > mayor) {
            mayor = id;
        }
    }

    return mayor + 1;
}

private void cmbalmacenesActionPerformed(java.awt.event.ActionEvent evt) {
    cargarTablaZonas();
}

private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
    int fila = jTable1.getSelectedRow();

    if (fila >= 0) {
        txtCodigoarea.setSelectedItem(modeloZonas.getValueAt(fila, 1).toString());
        txtcapacidad.setText(modeloZonas.getValueAt(fila, 2).toString());
        cargarTablaProductosZona();
    }
}

// ---------- productos de la zona (agregación) ----------
private void cargarProductosCombo() {
    cmbProductoZona.removeAllItems();
    for (Producto p : Controlador_Productos.arregloProductos) {
        cmbProductoZona.addItem(p.getId() + " - " + p.getNombre()
                + " (stock " + p.getStock_actual() + ")");
    }
}

private Producto productoSeleccionado() {
    Object item = cmbProductoZona.getSelectedItem();
    if (item == null) return null;

    try {
        int id = Integer.parseInt(item.toString().split(" - ")[0].trim());
        for (Producto p : Controlador_Productos.arregloProductos) {
            if (p.getId() == id) return p;
        }
    } catch (NumberFormatException e) {
    }
    return null;
}

private void cargarTablaProductosZona() {
    modeloProductosZona.setRowCount(0);
    Zona zona = zonaSeleccionada();
    if (zona == null) return;

    for (Producto p : zona.getProductos()) {
        modeloProductosZona.addRow(new Object[]{
            p.getId(),
            p.getNombre(),
            p.getStock_actual(),
            p.getInfoAdicional()
        });
    }
}

private void agregarProductoAZona() {
    Zona zona = zonaSeleccionada();
    if (zona == null) {
        aviso("Selecciona una zona de la tabla.");
        return;
    }

    Producto p = productoSeleccionado();
    if (p == null) {
        aviso("Selecciona un producto.");
        return;
    }

    if (zona.getProductos().contains(p)) {
        aviso("Ese producto ya está en la zona.");
        return;
    }

    if (!zona.agregarProducto(p)) {
        aviso("No cabe en la zona: espacio disponible " + zona.calcularEspacioDisponible()
                + ", el producto ocupa " + p.getStock_actual() + ".");
        return;
    }

    refrescarZonas(zona.getId_zona());
}

private void quitarProductoDeZona() {
    Zona zona = zonaSeleccionada();
    int fila = tblProductosZona.getSelectedRow();

    if (zona == null || fila < 0) {
        aviso("Selecciona una zona y, en la lista de productos, el producto a retirar.");
        return;
    }

    int idProducto = (int) modeloProductosZona.getValueAt(fila, 0);
    for (Producto p : new ArrayList<Producto>(zona.getProductos())) {
        if (p.getId() == idProducto) {
            zona.retirarProducto(p);
        }
    }

    refrescarZonas(zona.getId_zona());
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JLabel Almacenalquepertenece;
    private javax.swing.JLabel Area;
    private javax.swing.JButton ConsultarID;
    private javax.swing.JLabel Descripcion;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Insertar;
    private javax.swing.JButton Limpiar;
    private javax.swing.JButton MostrarTodo;
    private javax.swing.JPanel Panelzona;
    private javax.swing.JLabel Zona;
    private javax.swing.JButton btnActualizarzona;
    private javax.swing.JButton btnEliminarzona;
    private javax.swing.JButton btnInsertarzona;
    private javax.swing.JComboBox<String> cmbalmacenes;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panellistadeproductos;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable table;
    private javax.swing.JTextField textCiudad;
    private javax.swing.JTextField textGerenteAsignado;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textidAlmacen;
    private javax.swing.JComboBox<String> txtCodigoarea;
    private javax.swing.JTextField txtcapacidad;
    // End of variables declaration//GEN-END:variables
}
