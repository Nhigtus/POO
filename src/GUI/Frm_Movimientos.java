package GUI;

import controlador.Controlador_movimiento;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.Movimiento_Logistico;
import vista.Vista_Movimiento_Logistico;

/**
 * Gestión de movimientos logísticos. CRUD + Quicksort por ID + Burbuja por fecha
 * + consulta filtrada por tipo de movimiento.
 */
public class Frm_Movimientos extends JFrame {

    private static boolean inicializado = false;   // datos por defecto una sola vez
    private static final DateTimeFormatter FORMATO =
            DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

    private final Controlador_movimiento cont = new Controlador_movimiento();
    private DefaultTableModel modeloTabla;
    private JTable tabla;

    private JTextField txtId, txtFecha, txtProducto, txtCantidad, txtOperario;
    private JComboBox<String> cmbTipo, cmbFiltro;

    public Frm_Movimientos() {
        initComponents(); // Método autogenerado por NetBeans
        
        if (!inicializado) {
            new Vista_Movimiento_Logistico();   // movimientos por defecto
            inicializado = true;
        }
        setTitle("Gestión de Movimientos Logísticos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        construirInterfazManual();
        limpiar();
        cargarTabla("Todos");
        setSize(950, 600);
        setLocationRelativeTo(null);
    }

    // ------------------------------------------------------------ interfaz
    private void construirInterfazManual() {
        JLabel titulo = new JLabel("GESTIÓN DE MOVIMIENTOS LOGÍSTICOS", SwingConstants.CENTER);
        titulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 20));

        txtId = new JTextField();
        txtFecha = new JTextField();
        txtProducto = new JTextField();
        txtCantidad = new JTextField();
        txtOperario = new JTextField();
        cmbTipo = new JComboBox<>(new String[]{"Entrada", "Salida", "Traslado"});
        cmbFiltro = new JComboBox<>(new String[]{"Todos", "Entrada", "Salida", "Traslado"});

        JPanel panelDatos = new JPanel(new java.awt.GridLayout(3, 4, 10, 8));
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos del movimiento"));
        campo(panelDatos, "ID:", txtId);
        campo(panelDatos, "Fecha (DD/MM/AAAA):", txtFecha);
        campo(panelDatos, "Tipo:", cmbTipo);
        campo(panelDatos, "Producto involucrado:", txtProducto);
        campo(panelDatos, "Cantidad:", txtCantidad);
        campo(panelDatos, "Operario responsable:", txtOperario);

        JButton btnInsertar = new JButton("Insertar");
        JButton btnConsultar = new JButton("Consultar por ID");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnOrdenId = new JButton("Ordenar por ID ↓ (Quicksort)");
        JButton btnOrdenFecha = new JButton("Ordenar por fecha (Burbuja)");
        JButton btnTodos = new JButton("Mostrar todos");

        JPanel panelBotones = new JPanel(new java.awt.GridLayout(2, 4, 8, 8));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelBotones.add(btnInsertar);
        panelBotones.add(btnConsultar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnOrdenId);
        panelBotones.add(btnOrdenFecha);
        panelBotones.add(btnTodos);

        JButton btnFiltrar = new JButton("Filtrar");
        JPanel panelFiltro = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panelFiltro.setBorder(BorderFactory.createTitledBorder("Consulta filtrada por tipo de movimiento"));
        panelFiltro.add(new JLabel("Tipo:"));
        panelFiltro.add(cmbFiltro);
        panelFiltro.add(btnFiltrar);

        modeloTabla = new DefaultTableModel(new String[]{"ID", "Fecha", "Tipo", "Producto", "Cantidad", "Operario"}, 0) {
            @Override
            public boolean isCellEditable(int fila, int col) {
                return false;
            }
        };
        tabla = new JTable(modeloTabla);

        JPanel centroNorte = new JPanel(new java.awt.BorderLayout(5, 5));
        centroNorte.add(panelBotones, java.awt.BorderLayout.NORTH);
        centroNorte.add(panelFiltro, java.awt.BorderLayout.SOUTH);

        JPanel norte = new JPanel(new java.awt.BorderLayout(5, 5));
        norte.add(titulo, java.awt.BorderLayout.NORTH);
        norte.add(panelDatos, java.awt.BorderLayout.CENTER);
        norte.add(centroNorte, java.awt.BorderLayout.SOUTH);

        setLayout(new java.awt.BorderLayout(5, 5));
        add(norte, java.awt.BorderLayout.NORTH);
        add(new JScrollPane(tabla), java.awt.BorderLayout.CENTER);

        btnInsertar.addActionListener(e -> insertar());
        btnConsultar.addActionListener(e -> consultar());
        btnActualizar.addActionListener(e -> actualizar());
        btnEliminar.addActionListener(e -> eliminar());
        btnLimpiar.addActionListener(e -> limpiar());
        btnOrdenId.addActionListener(e -> {
            cont.ordenarPorId();       // Quicksort descendente por ID
            cargarTabla("Todos");
        });
        btnOrdenFecha.addActionListener(e -> {
            cont.ordenarPorFecha();    // Burbuja por fecha
            cargarTabla("Todos");
        });
        btnTodos.addActionListener(e -> cargarTabla("Todos"));
        btnFiltrar.addActionListener(e -> cargarTabla(String.valueOf(cmbFiltro.getSelectedItem())));

        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                llenarDesdeTabla();
            }
        });
    }

    private void campo(JPanel p, String etiqueta, JComponent c) {
        p.add(new JLabel(etiqueta));
        p.add(c);
    }

    // ------------------------------------------------------------ operaciones
    private void insertar() {
        Movimiento_Logistico m = leerFormulario();
        if (m == null) return;
        if (cont.consultarUno(m) != null) {
            aviso("Ya existe un movimiento con ese ID.");
            return;
        }
        if (cont.insertar(m)) {
            info("Movimiento registrado correctamente.");
            cargarTabla("Todos");
            limpiar();
        } else {
            aviso("No se pudo insertar el movimiento.");
        }
    }

    private void consultar() {
        int id = leerId();
        if (id < 0) return;
        Movimiento_Logistico buscado = new Movimiento_Logistico();
        buscado.setId_logistica(id);
        Movimiento_Logistico m = (Movimiento_Logistico) cont.consultarUno(buscado);
        if (m == null) {
            aviso("No se encontró un movimiento con ese ID.");
            return;
        }
        llenarFormulario(m);
    }

    private void actualizar() {
        Movimiento_Logistico m = leerFormulario();
        if (m == null) return;
        if (cont.update(m) == null) {
            aviso("No se encontró un movimiento con ese ID.");
            return;
        }
        info("Movimiento actualizado correctamente.");
        cargarTabla("Todos");
        limpiar();
    }

    private void eliminar() {
        int id = leerId();
        if (id < 0) return;
        Movimiento_Logistico buscado = new Movimiento_Logistico();
        buscado.setId_logistica(id);
        Movimiento_Logistico m = (Movimiento_Logistico) cont.consultarUno(buscado);
        if (m == null) {
            aviso("No se encontró un movimiento con ese ID.");
            return;
        }
        int op = JOptionPane.showConfirmDialog(this, "¿Eliminar el movimiento " + id + "?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            cont.delete(m);
            info("Movimiento eliminado.");
            cargarTabla("Todos");
            limpiar();
        }
    }

    // ------------------------------------------------------------ lectura y validación
    private int leerId() {
        try {
            return Integer.parseInt(txtId.getText().trim());
        } catch (NumberFormatException e) {
            aviso("El ID debe ser un número entero.");
            return -1;
        }
    }

    private Movimiento_Logistico leerFormulario() {
        int id, cantidad;
        try {
            id = Integer.parseInt(txtId.getText().trim());
            if (id < 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            aviso("El ID debe ser un número entero positivo.");
            return null;
        }
        String fecha = txtFecha.getText().trim();
        try {
            LocalDate.parse(fecha, FORMATO);   // valida formato y que la fecha exista
        } catch (DateTimeParseException e) {
            aviso("La fecha debe tener el formato DD/MM/AAAA y ser una fecha real.");
            return null;
        }
        String producto = txtProducto.getText().trim();
        if (producto.isEmpty()) {
            aviso("Digite el producto involucrado.");
            return null;
        }
        try {
            cantidad = Integer.parseInt(txtCantidad.getText().trim());
            if (cantidad <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            aviso("La cantidad debe ser un número entero mayor que 0.");
            return null;
        }
        String operario = txtOperario.getText().trim();
        if (operario.isEmpty()) {
            aviso("Digite el operario responsable.");
            return null;
        }
        return new Movimiento_Logistico(id, fecha, String.valueOf(cmbTipo.getSelectedItem()),
                producto, cantidad, operario);
    }

    // ------------------------------------------------------------ tabla y formulario
    // filtro: "Todos", "Entrada", "Salida" o "Traslado"
    private void cargarTabla(String filtro) {
        modeloTabla.setRowCount(0);
        for (Movimiento_Logistico m : Controlador_movimiento.arregloMovimiento) {
            if (filtro.equals("Todos") || m.getTipo_movimiento().equalsIgnoreCase(filtro)) {
                modeloTabla.addRow(new Object[]{m.getId_logistica(), m.getFecha(), m.getTipo_movimiento(),
                    m.getProducto_involucrado(), m.getCantidad(), m.getOperario_responsable()});
            }
        }
    }

    private void llenarFormulario(Movimiento_Logistico m) {
        txtId.setText(String.valueOf(m.getId_logistica()));
        txtFecha.setText(m.getFecha());
        cmbTipo.setSelectedItem(m.getTipo_movimiento());
        txtProducto.setText(m.getProducto_involucrado());
        txtCantidad.setText(String.valueOf(m.getCantidad()));
        txtOperario.setText(m.getOperario_responsable());
    }

    private void llenarDesdeTabla() {
        int f = tabla.getSelectedRow();
        if (f < 0) return;
        Movimiento_Logistico buscado = new Movimiento_Logistico();
        buscado.setId_logistica((Integer) modeloTabla.getValueAt(f, 0));
        Movimiento_Logistico m = (Movimiento_Logistico) cont.consultarUno(buscado);
        if (m != null) llenarFormulario(m);
    }

    private void limpiar() {
        txtId.setText("");
        txtFecha.setText("");
        txtProducto.setText("");
        txtCantidad.setText("");
        txtOperario.setText(Sesion.nombre);   // por defecto, quien inició sesión
        cmbTipo.setSelectedIndex(0);
        if (tabla != null) tabla.clearSelection();
    }

    private void aviso(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Dato inválido", JOptionPane.WARNING_MESSAGE);
    }

    private void info(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}