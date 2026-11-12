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
public class Pais {
    
    private int id;
    private String nombre;
    private ArrayList<Ubicacion_Corporativa> ciudades;   // las ciudades que componen al país

    public Pais(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.ciudades = new ArrayList<Ubicacion_Corporativa>();
    }

    public Pais() {
        this(0, "");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Ubicacion_Corporativa> getCiudades() {
        return ciudades;
    }

    public void agregarCiudad(Ubicacion_Corporativa c) {
        if (!ciudades.contains(c)) {
            ciudades.add(c);
        }
    }

    public void quitarCiudad(Ubicacion_Corporativa c) {
        ciudades.remove(c);
    }

    @Override
    public String toString() {
        return "Pais{" + "id=" + id + ", nombre=" + nombre + ", ciudades=" + ciudades.size() + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pais)) {
            return false;
        }
        return this.id == ((Pais) obj).id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
    
}
