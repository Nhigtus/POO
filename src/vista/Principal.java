package vista;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        //Atributos
        boolean continuar = true;
        
        //Instancias
        Scanner leerDatos = new Scanner(System.in);
        
        while(continuar){
            System.out.println("+----- Digite su opción en el siguiente menu -----+");
            System.out.println("1. Administrar Productos.");
            System.out.println("2. Administrar Usuarios.");
            System.out.println("3. Administrar Almacen.");
            System.out.println("4. Administrar Ubicacion.");
            System.out.println("5. Administrar Movimientos Logisticos.");
            System.out.println("+-------------------------------------------------+");
            int opc = leerDatos.nextInt();
            switch (opc){
                case 1:
                    Vista_Productos vistapp = new Vista_Productos();
                    vistapp.menuVistaProducto();
                    break;
                    
                case 2:
                    Vista_Usuarios vis = new Vista_Usuarios();
                    vis.menuVistaUsuario();
                    
                    break;
                    
                case 3: 
                    Vista_Almacenes k = new Vista_Almacenes();
                    k.menuVistaAlmacenes();
                
                case 4:
                    Vista_Ubicacion_Corporativa nuevaUbicacion = new Vista_Ubicacion_Corporativa();
                    nuevaUbicacion.menuVistaUbicacionCorporativa();
                    break;
                    
                case 5:
                    Vista_Movimiento_Logistico a = new Vista_Movimiento_Logistico();
                    a.menuVistaMovimiento();
                    break;
           
            }//Fin Siwtch
            String salida = "N";
            System.out.println("Quiere salir? s/si o n/N" );
            salida = leerDatos.next();
            if(salida.compareToIgnoreCase("s") == 0)
                continuar = false;
        }//Fin while      
    }//Fin clase Menu
}//Fin clase principal
