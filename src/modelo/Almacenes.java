package modelo;
import java.util.ArrayList;

public class Almacenes implements Comparable<Almacenes> {
    //Atributos
    private int id_almacen;
    private String nombre_almacen;
    private String ciudad_almacen;
    private String gerente_asignado;
    private ArrayList<Zona> zonas = new ArrayList<Zona>();
    
    public Almacenes(int id_almacen, String nombre_almacen, String ciudad_almacen, String gerente_asignado) {
        this.id_almacen = id_almacen;
        this.nombre_almacen = nombre_almacen;
        this.ciudad_almacen = ciudad_almacen;
        this.gerente_asignado = gerente_asignado;
    }//Constructor completo
    
    public Almacenes() {
    }//constructor vacio
    
    //Metodos
    public int getId_almacen() {
        return id_almacen;
    }
    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    public String getNombre_almacen() {
        return nombre_almacen;
    }
    public void setNombre_almacen(String nombre_almacen) {
        this.nombre_almacen = nombre_almacen;
    }

    public String getCiudad_almacen() {
        return ciudad_almacen;
    }
    public void setCiudad_almacen(String ciudad_almacen) {
        this.ciudad_almacen = ciudad_almacen;
    }

    public String getGerente_asignado() {
        return gerente_asignado;
    }
    public void setGerente_asignado(String gerente_asignado) {
        this.gerente_asignado = gerente_asignado;
    }//Fin setter y getter

    @Override
    public String toString() {
        return "Almacenes{" + "id_almacen=" + id_almacen + ", nombre_almacen=" + nombre_almacen + ", ciudad_almacen=" + ciudad_almacen + ", gerente_asignado=" + gerente_asignado + '}';
    }//Fin toString

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Almacenes other = (Almacenes) obj;
        return this.id_almacen == other.id_almacen;
    }//Fin equals

    @Override
    public int compareTo(Almacenes o) {
        return Integer.compare(this.id_almacen, o.id_almacen);
    }//fin compareto
    
    public ArrayList<Zona> getZonas() {
    return zonas;
}

    public void agregarZona(Zona zona) {

    if (zona != null && !zonas.contains(zona)) {
        zonas.add(zona);
        zona.setAlmacen(this);
        }
    }

    public boolean eliminarZona(Zona zona) {
        return zonas.remove(zona);
    }
}
