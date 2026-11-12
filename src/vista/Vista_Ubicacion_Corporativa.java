package vista;

import controlador.Controlador_UbicacionCorporativa;
import java.util.Scanner;
import modelo.Ubicacion_Corporativa;

import java.util.Scanner;
import modelo.Ubicacion_Corporativa;


public class Vista_Ubicacion_Corporativa {
    //Atributos
    public Controlador_UbicacionCorporativa ubiCorporativa;
    private Scanner leerDatos;
    
    //Constructor
    public Vista_Ubicacion_Corporativa() {
        ubiCorporativa = new Controlador_UbicacionCorporativa();
        leerDatos = new Scanner(System.in);
        insertar_Productos_Defecto();
    }
    
    //Metodos
    public void insertar_Productos_Defecto() {
        ubiCorporativa.insertar(new Ubicacion_Corporativa(1, "Colombia", 19, "Bogotá", "Sede Principal"));
        ubiCorporativa.insertar(new Ubicacion_Corporativa(1, "Colombia", 35, "Medellín", "Sucursal Norte"));
        ubiCorporativa.insertar(new Ubicacion_Corporativa(1, "Colombia", 2, "Manizales", "Sucursal sur"));
        ubiCorporativa.insertar(new Ubicacion_Corporativa(1, "Colombia", 90, "Cali", "Centro de Distribución"));
        ubiCorporativa.insertar(new Ubicacion_Corporativa(1, "Colombia", 14, "Barranquilla", "Sucursal este"));
        ubiCorporativa.insertar(new Ubicacion_Corporativa(1, "Colombia", 50, "Bucaramanga", "Sucursal oriente"));
        ubiCorporativa.insertar(new Ubicacion_Corporativa(1, "Colombia", 51, "Cúcuta", "Sucursal frontera"));
        ubiCorporativa.insertar(new Ubicacion_Corporativa(1, "Colombia", 52, "Pereira", "Sucursal eje cafetero"));
        ubiCorporativa.insertar(new Ubicacion_Corporativa(1, "Colombia", 53, "Cartagena", "Sucursal caribe"));
        ubiCorporativa.insertar(new Ubicacion_Corporativa(1, "Colombia", 54, "Santa Marta", "Sucursal costa"));
        ubiCorporativa.insertar(new Ubicacion_Corporativa(3, "México", 101, "CDMX", "Sede Regional"));
        ubiCorporativa.insertar(new Ubicacion_Corporativa(4, "Corea", 301, "Seul", "Distribuidor"));
        ubiCorporativa.insertar(new Ubicacion_Corporativa(4, "Corea", 320, "Busan", "Distribuidor"));
        ubiCorporativa.insertar(new Ubicacion_Corporativa(6, "China", 401, "Pekin", "Distribuidor"));
        ubiCorporativa.insertar(new Ubicacion_Corporativa(8, "Japon", 801, "Tokio", "Distribuidor"));
        ubiCorporativa.insertar(new Ubicacion_Corporativa(9, "Taiwan", 902, "Taipei", "Distribuidor"));
        ubiCorporativa.insertar(new Ubicacion_Corporativa(10, "India", 105, "Nueva Delhi", "Distribuidor"));
    }// fin datodo insertar por defecto

    
    public void consultar_una_ubicacion_Pais(){
        Ubicacion_Corporativa ubicacionPais = new Ubicacion_Corporativa();
        boolean verif = false;
        do{
            System.out.println("Ingrese el ID del pais a consultar");
            if(leerDatos.hasNextInt()){             
                ubicacionPais.setIdPais(leerDatos.nextInt());
                
                Ubicacion_Corporativa encontrada = (Ubicacion_Corporativa) ubiCorporativa.consultarUno(ubicacionPais);
                if(encontrada != null)
                    System.out.println(ubicacionPais.toString());
                else
                    System.out.println("Este Pais no fue encontrado");               
                verif = true;
            }
            else{
                System.out.println("Solo se permiten valores numericos, verifique su opcion");
                leerDatos.next(); //limpiamos biffer
            }
        }while(verif != true); //fin while de verificacion ID pais
    }// Fin de consultar un Pais
    
    public void consultar_una_ubicacion_ciudad(){
        Ubicacion_Corporativa ubicacionCiudad = new Ubicacion_Corporativa();
        System.out.println("Ingrese el id dde la ciudad a consultar");
        boolean verif = false;
        do{
            if(leerDatos.hasNextInt()){
                ubicacionCiudad.setIdCiudad(leerDatos.nextInt());
                ubicacionCiudad = (Ubicacion_Corporativa)ubiCorporativa.consultarUno(ubicacionCiudad);
                if(ubicacionCiudad != null)
                    System.out.println(ubicacionCiudad.toString());
                else
                    System.out.println("Esta ciudad no fue encontrada");
                verif = true;
            }
        }while(verif != true);//Fin while verificacion del ID de ciudad
    }//Fin de consultar una ciudad
    
    public void borrar_ubicacion(Ubicacion_Corporativa ubi){
        boolean eliminado = ubiCorporativa.delete(ubi);
        if (eliminado) {
            System.out.println("Ubicacion fue eliminado exitosamente.");
            ubiCorporativa.consultarTodos(); // Muestra la lista actualizada
        } 
        else 
            System.out.println("No se encontro ningún producto con ese ID.");
    }//fin borrar por ID de la ciudad
    
    public void incertar_Ubicacion(){
        Ubicacion_Corporativa nuevaUbicacion = new Ubicacion_Corporativa();
        System.out.println("+---- Insertar Ubicacion ----+");
        
        boolean verif = false;
        while(verif != true){           
            System.out.println("1.Insertar Pais");
            System.out.println("2.Insertar Ciudad");
            int opc = leerDatos.nextInt();            
            switch (opc){               
                case 1: 
                    //Datos por consola del nuevo Pais
                    do{
                        System.out.println("Ingrese el ID del Pais");
                        if(leerDatos.hasNextInt()){
                            nuevaUbicacion.setIdPais(leerDatos.nextInt());
                            verif = true;
                        }
                        else{
                            System.out.println("Solo se permiten valores numericos, verifique su ID");
                            leerDatos.next();
                        }
                    }while(verif != true); //fin while verficar del ID del pais
                    leerDatos.nextLine(); //Limpiamos para que no se quede pegado y continue
                    
                    System.out.println("Ingrese el nombre del Pais");
                    nuevaUbicacion.setNombrePais(leerDatos.nextLine());
                    
                    //Datos por consola de la nueva ciudad
                    verif = false;
                    do{
                        System.out.println("Inserte el ID ciudad que pertenece a este Pais");
                        if(leerDatos.hasNextInt()){
                            nuevaUbicacion.setIdCiudad(leerDatos.nextInt());
                            verif = true;
                        }
                        else{
                            System.out.println("Solo se permiten valores numericos, verifique su ID ciudad");
                            leerDatos.next();
                        }
                    }while(verif != true); //fin while verificacion ID ciudad
                    leerDatos.nextLine(); //Limpiamos para que no se quede pegado
                    
                    System.out.println("Inserte el nombre de la ciudad");
                    nuevaUbicacion.setNombreCiudad(leerDatos.nextLine());
                        
                    System.out.println("Ingrese la referencia al Pais");
                    nuevaUbicacion.setReferenciaPais(leerDatos.nextLine());
                    
                    ubiCorporativa.insertar(nuevaUbicacion);
                    System.out.println("Pais agregado");                  
                    verif = true;
                    break;
                
                case 2:
                    Ubicacion_Corporativa nuevaCiudad = new Ubicacion_Corporativa();
                    System.out.println("--- Insertar Ciudad ---");
                    
                    //Pedida de datos por consola para Pais
                    verif = false;
                    do{
                       System.out.print("Ingrese el ID del País: ");
                        if (leerDatos.hasNextInt()) {
                            nuevaCiudad.setIdPais(leerDatos.nextInt());
                            verif = true;
                        } else {
                            System.out.println("Solo se permiten valores numéricos.");
                            leerDatos.next();
                        } 
                    }while(verif != true); //fin while verficacion del ID pais
                    leerDatos.nextLine(); //Limpiamos para que no se quede pegado
                    
                    System.out.print("Ingrese el nombre del País: ");
                    nuevaCiudad.setNombrePais(leerDatos.nextLine());

                    System.out.print("Ingrese la referencia del País: ");
                    nuevaCiudad.setReferenciaPais(leerDatos.nextLine());
                    
                    //Pedida de datos por consola para ciudad
                    verif = false;
                    do{
                        System.out.print("Ingrese el ID de la Ciudad: ");                       
                        if (leerDatos.hasNextInt()) { 
                            int idIngresado = leerDatos.nextInt();
                            if (existeCiudad(idIngresado)) {
                                System.out.println("El ID de la ciudad " + idIngresado + " ya existe. Intente con otro.");
                            } else {
                                nuevaCiudad.setIdCiudad(idIngresado);
                                verif = true;
                            }
                        } else {
                            System.out.println("Solo se permiten valores numericos.");
                            leerDatos.next();
                        }
                    }while(verif != true); //Fin de verifcacion y validacion del ID de ciudad
                    leerDatos.nextLine();//Limpiamos para que no se quede pegado
                    
                    System.out.print("Ingrese el nombre de la Ciudad: ");
                    nuevaCiudad.setNombreCiudad(leerDatos.nextLine());

                    System.out.println("Ingrese referencia a pais");
                    nuevaCiudad.setReferenciaPais(leerDatos.nextLine()); 
                    
                    ubiCorporativa.insertar(nuevaCiudad);
                    System.out.println("Ciudad agregada");
                    verif = true; 
                    break;
            } //Fin switch                 
        } //Fin while para insertar
    } // Fin insertar ubicacion

    private boolean existeCiudad(int idCiudad) {
        for (Ubicacion_Corporativa u : Controlador_UbicacionCorporativa.arregloUC) {
            if (u.getIdCiudad() == idCiudad) 
            return true;         
        }
        return false;
    }//fin de buscar ciudad existente
    

    public void actualizarUbicacion() {
        Ubicacion_Corporativa actualizarUbicacion = new Ubicacion_Corporativa();
        System.out.println("\n+---- Actualizar Ubicacion ----+");
        
        //Verificaciones de que lo que se desea actualizar exista
        boolean verif = false;
        do{
            System.out.print("Digite el ID de la Ciudad que desea actualizar: ");
            if(leerDatos.hasNextInt()){
               actualizarUbicacion.setIdCiudad(leerDatos.nextInt());
               verif = true;
            }
            else{
                System.out.println("Debe ingresar un valor numerico, verifique su ID");
                leerDatos.next();
            }
        }while(verif != true);//Fin while de verficacion ID de la ciudad
        leerDatos.nextLine();
        
        Ubicacion_Corporativa ubicacionEncontrada = (Ubicacion_Corporativa)ubiCorporativa.consultarUno(actualizarUbicacion);
        if (ubicacionEncontrada == null) {
            System.out.println("No se encontro ninguna ubicación con el ID de ciudad ");
            return;
        }

        System.out.println("\nUbicacion encontrada:");
        System.out.println(ubicacionEncontrada.toString());
        
        //Pedida por consola los datos para actualizar
        boolean continuar = true;
        while(continuar){
            System.out.println("\n1. Modificar Nombre del Pais");
            System.out.println("2. Modificar Nombre de la Ciudad");
            System.out.println("3. Modificar Referencia del Pais");
            System.out.print("Seleccione una opcion: ");
            int opc = leerDatos.nextInt();
            switch(opc){
                case 1:
                System.out.print("Digite el nuevo nombre del pais: ");
                ubicacionEncontrada.setNombrePais(leerDatos.nextLine());
                break;
                
                case 2:
                    System.out.print("Digite el nuevo nombre de la ciudad: ");
                    ubicacionEncontrada.setNombreCiudad(leerDatos.nextLine());
                    break;
                    
                case 3:
                    System.out.print("Digite la nueva referencia del pais: ");
                    ubicacionEncontrada.setReferenciaPais(leerDatos.nextLine());
                    break;
            }//fin switch
            String salida = "N";
            System.out.println("Quiere salir? s/si o n/N" );
            salida = leerDatos.next();
            if(salida.compareToIgnoreCase("s") == 0)
                continuar = false;
        }//fin while
        leerDatos.nextLine();
    }//Fin de actualizar ubicacion

    // Método para Eliminar Ubicacion
    public void eliminarUbicacion() {
        Ubicacion_Corporativa eliminarUbicacion = new Ubicacion_Corporativa();       
        System.out.println("\n+---- Eliminar Ubicacion ----+");
        boolean verif = false;
        do{
            System.out.print("Digite el ID de la Ciudad que desea eliminar: ");
            if(leerDatos.hasNextInt()){
               eliminarUbicacion.setIdCiudad(leerDatos.nextInt());
               verif = true;
            }
            else{
                System.out.println("Debe ingresar un valor numerico, verifique su ID");
                leerDatos.next();
            }
        }while(verif != true);
        leerDatos.nextLine();
        
        Ubicacion_Corporativa ubicacionEncontrada = (Ubicacion_Corporativa) ubiCorporativa.consultarUno(eliminarUbicacion);
        if (ubicacionEncontrada == null) {
            System.out.println("No se encontro ninguna ubicación con el ID de ciudad " + eliminarUbicacion.getIdCiudad());
            return;
        }
        
        boolean eliminado = ubiCorporativa.delete(ubicacionEncontrada);
        if (eliminado) {
            System.out.println("Ubicacion  eliminada con exito");
        } else {
            System.out.println("No se pudo eliminar la ubicacion.");
        }
    }//Fin de eliminar ubicacion
    
    public void menuVistaUbicacionCorporativa() {
        System.out.println("+----- Digite su opcion en el siguiente menu -----+");
        System.out.println("1. Insertar ubicacion");
        System.out.println("2. Consultar Todas las ubicaciones");
        System.out.println("3. Consultar Una ubicacion");
        System.out.println("4. Ordenar Ascendente ubicaciones");
        System.out.println("5. Ordenar Descendente ubicaciones");
        System.out.println("6. Actualizar ubicacion");
        System.out.println("7. Borrar ubicacion");
        System.out.println("+-----------------------------------------------+");
        int opc = leerDatos.nextInt();
        switch (opc) {
            case 1:
                incertar_Ubicacion();
                break;
                
            case 2:
                ubiCorporativa.consultarTodos();
                break;
                
            case 3:
                consultar_una_ubicacion_ciudad();
                break;
                
            case 4:
                System.out.println("--- Ubicaciones ordenadas ascendentemente por ID Ciudad ---");
                ubiCorporativa.ordenar();
                ubiCorporativa.consultarTodos();
                break;
                
            case 5:
                System.out.println("--- Ubicaciones ordenadas descendentemente por ID Ciudad ---");
                ubiCorporativa.ordenar(1);
                ubiCorporativa.consultarTodos();
                break;
                
            case 6:
                actualizarUbicacion();
                break;
                
            case 7:
                System.out.println("Para eliminar una ubicacion primero consultela.");
                System.out.println("Ingrese el ID de la ciudad:");
                
                Ubicacion_Corporativa aux = new Ubicacion_Corporativa();
                if (leerDatos.hasNextInt()) {
                    aux.setIdCiudad(leerDatos.nextInt());
                    Ubicacion_Corporativa encontrada = (Ubicacion_Corporativa)ubiCorporativa.consultarUno(aux);
                    if (encontrada == null) {
                        System.out.println("Ubicacion no encontrada.");
                    } else {
                        System.out.println("Ubicacion a eliminar: " + encontrada.getNombreCiudad());
                        borrar_ubicacion(encontrada);
                    }
                } else {
                    System.out.println("ID no valido.");
                    leerDatos.next();
                }
                break;
        }
    }// Fin del menú vista ubicacion corporativa
}//fin clase 