/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;

/**
 *
 * @author nhigtus
 */
public class Zona implements Comparable<Zona> {
    private int id_zona;
    private String codigo_area;
    private int capacidad_maxima;
    private Almacenes almacen;
    private ArrayList<Producto> productos;

    // Constructor
    public Zona(int id_zona, String codigo_area, int capacidad_maxima) {
        this.id_zona = id_zona;
        this.codigo_area = codigo_area;
        this.capacidad_maxima = capacidad_maxima;
        this.productos = new ArrayList<Producto>();
    }

    // Constructor vacio
    public Zona() {
        this.productos = new ArrayList<Producto>();
    }

    // Getters y setters
    public int getId_zona() {
        return id_zona;
    }

    public void setId_zona(int id_zona) {
        this.id_zona = id_zona;
    }

    public String getCodigo_area() {
        return codigo_area;
    }

    public void setCodigo_area(String codigo_area) {
        this.codigo_area = codigo_area;
    }

    public int getCapacidad_maxima() {
        return capacidad_maxima;
    }

    public void setCapacidad_maxima(int capacidad_maxima) {
        this.capacidad_maxima = capacidad_maxima;
    }

    public Almacenes getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacenes almacen) {
        this.almacen = almacen;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    // Calcular unidades ocupadas
    public int calcularOcupacion() {
        int total = 0;

        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getStock_actual();
        }

        return total;
    }

    // Calcular espacio disponible
    public int calcularEspacioDisponible() {
        return capacidad_maxima - calcularOcupacion();
    }

    // Agregar producto sin superar la capacidad
    public boolean agregarProducto(Producto producto) {

        if (producto == null || productos.contains(producto)) {
            return false;
        }

        if (producto.getStock_actual() < 0) {
            return false;
        }

        if (calcularOcupacion() + producto.getStock_actual() > capacidad_maxima) {
            return false;
        }

        productos.add(producto);
        return true;
    }

    // Retirar producto de la zona
    public boolean retirarProducto(Producto producto) {
        return productos.remove(producto);
    }
    public void reemplazarProducto(Producto nuevo) {
    int pos = productos.indexOf(nuevo);   // equals de Producto compara por id
    if (pos >= 0) {
        productos.set(pos, nuevo);
    }
}

@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (!(obj instanceof Zona)) {
        return false;
    }
    return this.id_zona == ((Zona) obj).id_zona;
}

@Override
public int hashCode() {
    return Integer.hashCode(id_zona);
}

@Override
public int compareTo(Zona o) {
    return Integer.compare(this.id_zona, o.id_zona);
}
    @Override
    public String toString() {
        return "Zona{" +
                "id_zona=" + id_zona +
                ", codigo_area=" + codigo_area +
                ", capacidad_maxima=" + capacidad_maxima +
                ", ocupacion=" + calcularOcupacion() +
                '}';
    }
    
}
