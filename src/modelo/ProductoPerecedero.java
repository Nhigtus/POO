/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author nhigtus
 */
public class ProductoPerecedero extends Producto {
    private String fechaCaducidad;   // formato DD/MM/AAAA

    // Constructor completo: reutiliza el de la clase padre con super(...)
    public ProductoPerecedero(int id, String codigoSKU, String nombre, String descripción,
            float precio_unitario, int stock_actual, String proveedor, String tipo, String fechaCaducidad) {
        super(id, codigoSKU, nombre, descripción, precio_unitario, stock_actual, proveedor, tipo);
        this.fechaCaducidad = fechaCaducidad;
    }

    // Constructor sobrecargado: el tipo siempre es "Perecedero"
    public ProductoPerecedero(int id, String codigoSKU, String nombre, String descripción,
            float precio_unitario, int stock_actual, String proveedor, String fechaCaducidad) {
        this(id, codigoSKU, nombre, descripción, precio_unitario, stock_actual, proveedor, "Perecedero", fechaCaducidad);
    }

    public ProductoPerecedero() {
        super();
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    // POLIMORFISMO: mismo método que Producto, comportamiento distinto
    @Override
    public String getInfoAdicional() {
        return "Caduca: " + fechaCaducidad;
    }

    @Override
    public String toString() {
        return super.toString() + " | fechaCaducidad=" + fechaCaducidad;
    }
    
}
