package vista;

import modelo.Movimiento_Logistico;
import controlador.Controlador_movimiento;
import java.util.Scanner;

public class Vista_Movimiento_Logistico {
    public Controlador_movimiento contMovimiento;
    private Scanner leerDatos;

    public Vista_Movimiento_Logistico() {
        contMovimiento = new Controlador_movimiento();
        leerDatos = new Scanner(System.in);
        insertarMovimientosDefecto();
    }

    private void insertarMovimientosDefecto() {
        contMovimiento.insertar(new Movimiento_Logistico(10000, "12/09/2026", "Entrada", "Bendicion Oficial Del Cielo", 2, "Daniela"));
        contMovimiento.insertar(new Movimiento_Logistico(10001, "13/09/2026", "Salida", "Jujutsu Kaisen Vol 1", 1, "Gojo"));
        contMovimiento.insertar(new Movimiento_Logistico(10002, "14/09/2026", "Entrada", "Batman Year One", 3, "Bruce Wayne"));
        contMovimiento.insertar(new Movimiento_Logistico(10005, "15/09/2026", "Entrada", "Reverent Insanity", 5, "Fang yuan"));
        contMovimiento.insertar(new Movimiento_Logistico(10006, "16/09/2026", "Salida", "LOTM", 10, "Klein Morrety"));
        contMovimiento.insertar(new Movimiento_Logistico(10007, "17/09/2026", "Entrada", "Shadow Slave", 11, "Sunny"));
        contMovimiento.insertar(new Movimiento_Logistico(10008, "19/09/2026", "Entrada", "Monte Hua", 19, "Chung Myung"));
        contMovimiento.insertar(new Movimiento_Logistico(10009, "20/09/2026", "Salida", "Spiderman", 7, "Petter Parker"));
        contMovimiento.insertar(new Movimiento_Logistico(10010, "19/09/2026", "Salida", "Chainsaw man", 1, "Chung Myung"));
    }//Fin datos por defecto

    public void consultarUnMovimiento() {
        System.out.println("Digite el ID del Movimiento");
        Movimiento_Logistico pp = new Movimiento_Logistico();
        pp.setId_logistica(leerDatos.nextInt());
        pp = (Movimiento_Logistico) contMovimiento.consultarUno(pp);
        if (pp != null)
            System.out.println(pp.toString());
        else
            System.out.println("Movimiento no encontrado");
    }//Fin consultar un movimiento

    public void borrarMovimiento(Movimiento_Logistico pp) {
        boolean eliminado = contMovimiento.delete(pp);
        if (eliminado) {
            System.out.println("Movimiento eliminado exitosamente.");
            contMovimiento.consultarTodos();
        } else {
            System.out.println("No se encontró ningún Movimiento con ese ID.");
        }
    }//Fin borrar un movimiento

    public void insertarMovimientoManual() {
        System.out.println("--- Insertar Nuevo Movimiento ---");
        System.out.println("Digite el ID del movimiento que desea agregar:");
        Movimiento_Logistico nuevo = new Movimiento_Logistico();
        nuevo.setId_logistica(leerDatos.nextInt());
        leerDatos.nextLine();

        Movimiento_Logistico existente = (Movimiento_Logistico) contMovimiento.consultarUno(nuevo);
        if (existente != null) {
            System.out.println("Error: Ya existe un movimiento registrado con el ID " + nuevo.getId_logistica());
            return;
        }
        System.out.println("El ID está disponible. Digite los datos del Movimiento:");

        System.out.print("Fecha: ");
        nuevo.setFecha(leerDatos.nextLine());

        boolean salir = false;
        do {
            System.out.print("Cantidad: ");
            if (leerDatos.hasNextInt()) {
                nuevo.setCantidad(leerDatos.nextInt());
                salir = true;
            } else {
                System.out.println("Debe ingresar un valor numérico para la cantidad.");
                leerDatos.next();
            }
        } while (!salir);
        leerDatos.nextLine();

        System.out.print("Tipo de Movimiento (Entrada/Salida/Traslado): ");
        nuevo.setTipo_movimiento(leerDatos.nextLine());

        System.out.print("Producto Involucrado: ");
        nuevo.setProducto_involucrado(leerDatos.nextLine());

        System.out.print("Operario Responsable: ");
        nuevo.setOperario_responsable(leerDatos.nextLine());

        if (contMovimiento.insertar(nuevo)) {
            System.out.println("¡Movimiento registrado con éxito!");
        } else {
            System.out.println("Error: No se pudo insertar el Movimiento.");
        }
    }//Fin insertar un movimiento

    private void actualizar() {
        System.out.println("Digite el id del Movimiento que desea Actualizar");
        Movimiento_Logistico pp = new Movimiento_Logistico();
        pp.setId_logistica(leerDatos.nextInt());
        leerDatos.nextLine();
        pp = (Movimiento_Logistico) contMovimiento.consultarUno(pp);

        if (pp == null) {
            System.out.println("Movimiento no encontrado.");
            return;
        }
        System.out.println(pp.toString());
        System.out.println("1. Modificar cantidad");
        System.out.println("2. Modificar tipo de movimiento");
        System.out.println("3. Modificar operario responsable");
        int var = leerDatos.nextInt();
        leerDatos.nextLine();
        switch (var) {
            case 1:
                System.out.print("Digite la nueva cantidad: ");
                pp.setCantidad(leerDatos.nextInt());
                break;
            case 2:
                System.out.print("Digite el nuevo tipo de movimiento: ");
                pp.setTipo_movimiento(leerDatos.nextLine());
                break;
            case 3:
                System.out.print("Digite el nuevo operario responsable: ");
                pp.setOperario_responsable(leerDatos.nextLine());
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
        contMovimiento.update(pp);
        contMovimiento.consultarTodos();
    }//Fin actualizar

    public void menuVistaMovimiento() {
        System.out.println("+----- Digite su opción en el siguiente menu -----+");
        System.out.println("1. Insertar movimiento");
        System.out.println("2. Consultar Todos los movimientos");
        System.out.println("3. Consultar Un movimiento");
        System.out.println("4. Ordenar Ascendente movimientos");
        System.out.println("5. Ordenar Descendente movimientos");
        System.out.println("6. Actualizar movimiento");
        System.out.println("7. Borrar movimiento");
        System.out.println("+-----------------------------------------------+");
        int opc = leerDatos.nextInt();
        switch (opc) {
            case 1:
                insertarMovimientoManual();
                break;
            case 2:
                contMovimiento.consultarTodos();
                break;
            case 3:
                consultarUnMovimiento();
                break;
            case 4:
                contMovimiento.ordenar();
                contMovimiento.consultarTodos();
                break;
            case 5:
                contMovimiento.ordenar(1);
                contMovimiento.consultarTodos();
                break;
            case 6:
                actualizar();
                break;
            case 7:
                System.out.println("Para eliminar un movimiento primero consúltelo.");
                System.out.println("Ingrese el ID del movimiento:");
                Movimiento_Logistico aux = new Movimiento_Logistico();
                aux.setId_logistica(leerDatos.nextInt());
                Movimiento_Logistico encontrado = (Movimiento_Logistico) contMovimiento.consultarUno(aux);

                if (encontrado == null) {
                    System.out.println("Movimiento no encontrado.");
                } else {
                    System.out.println("Movimiento a eliminar: id " + encontrado.getId_logistica());
                    borrarMovimiento(encontrado);
                }
                break;
            default:
                break;
        }//Fn switch
    }//Fin menu
}