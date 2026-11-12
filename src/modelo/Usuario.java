package modelo;


import java.util.Objects;

public class Usuario implements Comparable<Usuario> {
    //Atributos
    private int id;
    private String nombre;
    private String apellido;
    private int telefono;
    private String correo;
    private int nivel;
    private String contraseña;
    private String cargo;
    private float salario;
    private String turno;
    private String almacen_asignado;
    private String administrador; 
    
    //Constructores
    public Usuario(int id, String nombre, String apellido, int telefono, String correo, int nivel, String contraseña, String cargo, float salario, String turno, String almacen_asignado, String administrador) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.nivel = nivel;
        this.contraseña = contraseña;
        this.cargo = cargo;
        this.salario = salario;
        this.turno = turno;
        this.almacen_asignado = almacen_asignado;
        this.administrador = administrador;
    }//constructor completo
    
    public Usuario() {
    }//constructor vacio
    
    //Metodos
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

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getAlmacen_asignado() {
        return almacen_asignado;
    }
    public void setAlmacen_asignado(String almacen_asignado) {
        this.almacen_asignado = almacen_asignado;
    }

    public String getAdministrador() {
        return administrador;
    }
    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }//Fin geter y seter

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", correo=" + correo + ", nivel=" + nivel + ", contrase\u00f1a=" + contraseña + ", cargo=" + cargo + ", salario=" + salario + ", turno=" + turno + ", almacen_asignado=" + almacen_asignado + ", administrador=" + administrador + '}';
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.correo, other.correo);
    }//Fin equals

    @Override
    public int compareTo(Usuario o) {
        return this.correo.compareTo(o.getCorreo());
    }//Fin compareto
}//Fin clase