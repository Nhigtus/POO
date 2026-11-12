package vista;

import controlador.Controlador_Almacenes;
import java.util.Scanner;
import modelo.Almacenes;

public class Vista_Almacenes {
    //Instancias
   public Controlador_Almacenes contAlmacenes;
    private Scanner leerDatos;
    
    //Metodos
    public Vista_Almacenes() {
        contAlmacenes = new Controlador_Almacenes();
        leerDatos = new Scanner(System.in);
        insertarAlmacenesDefecto();
    }

    public void insertarAlmacenesDefecto() {
        contAlmacenes.insertar(new Almacenes(101, "Almacén Central", "Bogotá", "Carlos Mendoza"));
        contAlmacenes.insertar(new Almacenes(102, "Almacén Norte", "Medellín", "Ana Gómez"));
        contAlmacenes.insertar(new Almacenes(103, "Almacén Pacífico", "Cali", "Roberto Silva"));
        contAlmacenes.insertar(new Almacenes(104, "Almacén Caribe", "Barranquilla", "Laura Restrepo"));
        contAlmacenes.insertar(new Almacenes(105, "Almacén Sur", "Bucaramanga", "Mariana López"));
        contAlmacenes.insertar(new Almacenes(106, "Almacén Oriente", "Cúcuta", "Diego Morales"));
        contAlmacenes.insertar(new Almacenes(107, "Almacén Andino", "Pereira", "Sofía Vargas"));
        contAlmacenes.insertar(new Almacenes(108, "Almacén Eje Cafetero", "Manizales", "Andrés Castro"));
        contAlmacenes.insertar(new Almacenes(109, "Almacén Santander", "Cartagena", "Valentina Torres"));
        contAlmacenes.insertar(new Almacenes(110, "Almacén Costa", "Santa Marta", "Felipe Gómez"));
    }//Fin datos defecto

    public void consultarUnAlmacen() {
        System.out.println("--- Consultar Almacén ---");
        System.out.print("Digite el ID del Almacén: ");
        int id = leerDatos.nextInt();
        leerDatos.nextLine(); // Limpieza de buffer

        Almacenes alAux = new Almacenes();
        alAux.setId_almacen(id);

        Almacenes encontrado = (Almacenes) contAlmacenes.consultarUno(alAux);

        if (encontrado != null) {
            System.out.println(encontrado.toString());
        } else {
            System.out.println("Almacén no encontrado.");
        }
    }//Fin consultar un almacen

public void insertarAlmacenes() {
        System.out.println("--- Insertar Nuevo Almacén ---");
        System.out.println("Digite el ID del almacén que desea agregar:");
        Almacenes nuevo = new Almacenes();
        
        while (true) {
            if (leerDatos.hasNextInt()) {
                nuevo.setId_almacen(leerDatos.nextInt());
                break;
            } else {
                System.out.println("Debe ingresar un valor entero válido para el ID.");
                leerDatos.next();
            }
        }

        Almacenes existente = (Almacenes) contAlmacenes.consultarUno(nuevo);
        if (existente != null) {
            System.out.println("Error: Ya existe un almacén registrado con el ID " + nuevo.getId_almacen() + " (" + existente.getNombre_almacen() + ").");
            return;
        }
        System.out.println("El ID está disponible. Digite los datos del almacén:");
        leerDatos.nextLine(); // Limpiar el buffer tras leer el ID

        System.out.print("Nombre del almacén: ");
        nuevo.setNombre_almacen(leerDatos.nextLine());

        System.out.print("Ciudad del almacén: ");
        nuevo.setCiudad_almacen(leerDatos.nextLine());

        System.out.print("Gerente asignado: ");
        nuevo.setGerente_asignado(leerDatos.nextLine());

        if (contAlmacenes.insertar(nuevo)) {
            System.out.println("Almacén registrado con éxito.");
        } else {
            System.out.println("No se pudo insertar el almacén.");
        }
    } // Fin insertar almacén

    public void actualizarAlmacen() {
        System.out.println("--- Actualizar Almacén ---");
        System.out.print("Digite el ID del Almacén a modificar: ");
        int id = leerDatos.nextInt();
        leerDatos.nextLine(); // Limpieza de buffer

        Almacenes alAux = new Almacenes();
        alAux.setId_almacen(id);

        Almacenes encontrado = (Almacenes) contAlmacenes.consultarUno(alAux);

        if (encontrado == null) {
            System.out.println("Almacén no encontrado.");
            return;
        }

        System.out.println("Almacén encontrado: " + encontrado.toString());
        System.out.println("1. Modificar Nombre");
        System.out.println("2. Modificar Ciudad");
        System.out.println("3. Modificar Gerente Asignado");
        System.out.print("Seleccione una opción: ");
        int opcion = leerDatos.nextInt();
        leerDatos.nextLine(); // Limpieza de buffer

        switch (opcion) {
            case 1:
                System.out.print("Digite el nuevo nombre: ");
                encontrado.setNombre_almacen(leerDatos.nextLine());
                break;
            case 2:
                System.out.print("Digite la nueva ciudad: ");
                encontrado.setCiudad_almacen(leerDatos.nextLine());
                break;
            case 3:
                System.out.print("Digite el nuevo gerente: ");
                encontrado.setGerente_asignado(leerDatos.nextLine());
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        Almacenes actualizado = (Almacenes) contAlmacenes.update(encontrado);
        if (actualizado != null) {
            System.out.println("--- Almacén Actualizado con Éxito ---");
            contAlmacenes.consultarTodos();
        } else {
            System.out.println("No se pudo actualizar el almacén.");
        }
    }//Fin actualizar

    public void borrarAlmacen() {
        System.out.println("--- Eliminar Almacén ---");
        System.out.print("Digite el ID del Almacén a eliminar: ");
        int id = leerDatos.nextInt();
        leerDatos.nextLine(); // Limpieza de buffer

        Almacenes alAux = new Almacenes();
        alAux.setId_almacen(id);

        Almacenes encontrado = (Almacenes) contAlmacenes.consultarUno(alAux);

        if (encontrado == null) {
            System.out.println("Almacén no encontrado.");
        } else {
            boolean eliminado = contAlmacenes.delete(encontrado);
            if (eliminado) {
                System.out.println("Almacén eliminado exitosamente.");
                contAlmacenes.consultarTodos();
            } else {
                System.out.println("Error al eliminar el almacén.");
            }
        }
    }//Fin borrar un almacen

    public void menuVistaAlmacenes() {
        System.out.println("\n+----- MENÚ DE ALMACENES -----+");
        System.out.println("1. Insertar Almacén");
        System.out.println("2. Consultar Todos los Almacenes");
        System.out.println("3. Consultar un Almacén");
        System.out.println("4. Ordenar Ascendente (por ID - Sort)");
        System.out.println("5. Ordenar Descendente (por ID - Burbuja)");
        System.out.println("6. Actualizar Almacén");
        System.out.println("7. Borrar Almacén");
        System.out.println("+----------------------------+");
        System.out.print("Opción: ");

        if (!leerDatos.hasNextInt()) {
            System.out.println("Opción inválida.");
            leerDatos.next();
            return;
        }

        int opc = leerDatos.nextInt();
        leerDatos.nextLine(); // Limpieza de buffer

        switch (opc) {
            case 1:
                insertarAlmacenes();
                break;
            case 2:
                contAlmacenes.consultarTodos();
                break;
            case 3:
                consultarUnAlmacen();
                break;
            case 4:
                System.out.println("--- Almacenes ordenados ascendentemente---");
                contAlmacenes.ordenar();
                contAlmacenes.consultarTodos();
                break;
            case 5:
                System.out.println("--- Almacenes ordenados descendentemente---");
                contAlmacenes.ordenar(1);
                contAlmacenes.consultarTodos();
                break;
            case 6:
                actualizarAlmacen();
                break;
            case 7:
                borrarAlmacen();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }//Fin switch
    }//Fin menu 
}
