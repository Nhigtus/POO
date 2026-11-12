/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author nhigtus
 */
public class Sesion {
        public static int idUsuario = 0;
    public static String nombre = "";
    public static String rol = "";   // "Administrador", "Gerente" u "Operario"
 
    public static boolean esAdmin() {
        return rol.equals("Administrador");
    }
 
    public static boolean puedeEscribir() {   // insertar y actualizar
        return rol.equals("Administrador") || rol.equals("Operario");
    }
 
    public static boolean puedeBorrar() {
        return rol.equals("Administrador");
    }
 
    // Convierte el cargo del usuario en uno de los 3 roles del sistema
    public static String rolDeCargo(String cargo) {
        if (cargo == null) return "Operario";
        String c = cargo.trim().toLowerCase();
        if (c.equals("administrador")) return "Administrador";
        if (c.startsWith("gerente")) return "Gerente";
        return "Operario";
    }
 
    public static void limpiar() {
        idUsuario = 0;
        nombre = "";
        rol = "";
    }

    
}
