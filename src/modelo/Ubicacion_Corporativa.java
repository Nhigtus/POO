package modelo;

import java.util.ArrayList;

/**
 * Ciudad de la ubicación corporativa. ASOCIACIÓN con Pais: cada ciudad pertenece a un país
 * (el país es quien la contiene: ver Pais.getCiudades()).
 */
public class Ubicacion_Corporativa implements Comparable<Ubicacion_Corporativa>{
    private Pais pais;               // relación con el país
    private ArrayList<Almacenes> almacenes = new ArrayList<Almacenes>();   // AGREGACIÓN: almacenes de esta ciudad
    //ciudad
    private int idCiudad;
    private String nombreCiudad;
    private String referenciaPais;

    //constructores
    // crea internamente el Pais y se une a él
    public Ubicacion_Corporativa(int idPais, String nombrePais, int idCiudad, String nombreCiudad, String referenciaPais) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.referenciaPais = referenciaPais;
        setPais(new Pais(idPais, nombrePais));
    }

    // Sobrecargado: recibe el objeto Pais ya creado
    public Ubicacion_Corporativa(Pais pais, int idCiudad, String nombreCiudad, String referenciaPais) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.referenciaPais = referenciaPais;
        setPais(pais);
    }

    public Ubicacion_Corporativa() {
        setPais(new Pais());
    }//vacio

    //Metodos
    public Pais getPais() {
        return pais;
    }

    
    public void setPais(Pais nuevo) {
        if (this.pais != null) {
            this.pais.quitarCiudad(this);
        }
        this.pais = nuevo;
        if (nuevo != null) {
            nuevo.agregarCiudad(this);
        }
    }

    // delegan en el objeto Pais
    public int getIdPais() {
        return pais.getId();
    }

    public void setIdPais(int idPais) {
        pais.setId(idPais);
    }

    public String getNombrePais() {
        return pais.getNombre();
    }

    public void setNombrePais(String nombrePais) {
        pais.setNombre(nombrePais);
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getReferenciaPais() {
        return referenciaPais;
    }

    public void setReferenciaPais(String referenciaPais) {
        this.referenciaPais = referenciaPais;
    }//Fin getter y setter

    // ----- agregación con Almacenes: la ciudad agrupa almacenes, pero ellos existen por sí solos -----
    public ArrayList<Almacenes> getAlmacenes() {
        return almacenes;
    }

    public void agregarAlmacen(Almacenes a) {
        if (a != null && !almacenes.contains(a)) {
            almacenes.add(a);
        }
    }

    public void quitarAlmacen(Almacenes a) {
        almacenes.remove(a);
    }

    //tostring
    @Override
    public String toString() {
        return "UbicacionCorporativa{" + "idPais=" + getIdPais() + ", nombrePais=" + getNombrePais() + ", idCiudad=" + idCiudad + ", nombreCiudad=" + nombreCiudad + ", referenciaPais=" + referenciaPais + '}';
    }

    //Equals de pais
    @Override
    public boolean equals(Object obj) { //no repetir id de ciudad
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ubicacion_Corporativa other = (Ubicacion_Corporativa) obj;
        return this.idCiudad == other.idCiudad;
    }

    @Override
    public int compareTo(Ubicacion_Corporativa o) {
        int r = Integer.compare(this.getIdPais(), o.getIdPais());   // primero por país
        if (r != 0) return r;
        return Integer.compare(this.idCiudad, o.idCiudad); // desempate por ciudad
    }//fin compareto

    @Override
    public int hashCode() {
        return Integer.hashCode(idCiudad);
    }
}