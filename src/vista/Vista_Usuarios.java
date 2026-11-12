package vista;

import controlador.Controlador_Usuario;
import java.util.Scanner;
import modelo.Usuario;

public class Vista_Usuarios {
    //instancias
    public Controlador_Usuario contUsuarios;
    private Scanner leerDatos;
    
    //Metodos
    public Vista_Usuarios() {
        contUsuarios = new Controlador_Usuario();
        leerDatos = new Scanner(System.in);
        insertarUsuariosDefecto();
    }//fin vista usuarios

    public void insertarUsuariosDefecto() {
        contUsuarios.insertar(new Usuario(1, "Daniela", "Lopez", 300123456, "daniela.lopez@email.com", 1, "admin123", "Gerente General", 4500000, "Completo", "Almacén Central", "Admin1"));
        contUsuarios.insertar(new Usuario(2, "Ema", "Girardo", 310987654, "ema.girardo@email.com", 2, "ema2026", "Operario", 1800000, "Mañana", "Almacén Norte", "Admin1"));
        contUsuarios.insertar(new Usuario(3, "Carlos", "Pérez", 320111223, "carlos.perez@email.com", 2, "carlos123", "Operario", 1800000, "Tarde", "Almacén Pacífico", "Admin4"));
        contUsuarios.insertar(new Usuario(4, "Ana", "Gómez", 315444556, "ana.gomez@email.com", 1, "ana321", "Supervisora", 2800000, "Mañana", "Almacén Caribe", "Admin6"));
        contUsuarios.insertar(new Usuario(5, "Roberto", "Silva", 312333445, "roberto.silva@email.com", 2, "rober789", "Logística", 2000000, "Noche", "Almacén Sur", "Admin18"));
        contUsuarios.insertar(new Usuario(6, "Laura", "Restrepo", 318555667, "laura.restrepo@email.com", 1, "laura456", "Supervisora", 2800000, "Tarde", "Almacén Oriente", "Admin11"));
        contUsuarios.insertar(new Usuario(7, "Diego", "Morales", 319777889, "diego.morales@email.com", 2, "diego999", "Operario", 1800000, "Mañana", "Almacén Andino", "Admin1"));
        contUsuarios.insertar(new Usuario(8, "Sofía", "Vargas", 311222334, "sofia.vargas@email.com", 2, "sofia111", "Operario", 1800000, "Tarde", "Almacén Eje Cafetero", "Admin9"));
        contUsuarios.insertar(new Usuario(9, "Andrés", "Castro", 313444888, "andres.castro@email.com", 2, "andres555", "Inventarios", 2100000, "Mañana", "Almacén Santander", "Admin1"));
        contUsuarios.insertar(new Usuario(10, "Valentina", "Torres", 314666999, "valentina.torres@email.com", 1, "valen777", "Gerente Zonal", 3500000, "Completo", "Almacén Costa", "Admin1"));
    }//fin datos por defecto

    public void consultarUnUsuario() {
        System.out.println("--- Consultar Usuario ---");
        Usuario pp = new Usuario();
        boolean verif = false;
        do {
            System.out.print("Digite el ID del usuario: ");
            if (leerDatos.hasNextInt()) {
                pp.setId(leerDatos.nextInt());
                verif = true;
            } else {
                System.out.println("Solo se permiten valores numéricos, verifique el ID ingresado.");
                leerDatos.next();
            }
        } while (!verif);
        leerDatos.nextLine();

        pp = (Usuario) contUsuarios.consultarUno(pp);
        if (pp != null) {
            System.out.println(pp.toString());
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }//Fin consultr un usuario

    public void borrarUsuario(Usuario pp) {
        boolean eliminado = contUsuarios.delete(pp);
        if (eliminado) {
            System.out.println("Usuario eliminado exitosamente.");
            contUsuarios.consultarTodos();
        } else {
            System.out.println("No se encontró ningún usuario con ese ID.");
        }
    }//Fin borrar usuario

    public void insertarUsuarios() {
        System.out.println("--- Insertar Nuevo Usuario ---");
        System.out.print("Digite el ID del usuario que desea agregar: ");
        Usuario nuevo = new Usuario();

        boolean verif = false;
        do {
            if (leerDatos.hasNextInt()) {
                nuevo.setId(leerDatos.nextInt());
                verif = true;
            } else {
                System.out.println("Solo se aceptan valores numéricos, verifique el ID.");
                leerDatos.next();
            }
        } while (!verif);
        leerDatos.nextLine();

        Usuario existente = (Usuario) contUsuarios.consultarUno(nuevo);
        if (existente != null) {
            System.out.println("Error: Ya existe un usuario registrado con el ID " + nuevo.getId() + " (" + existente.getNombre() + ").");
            return;
        }
        System.out.println("El ID está disponible. Digite los datos del usuario:");

        System.out.print("Nombre: ");
        nuevo.setNombre(leerDatos.nextLine());

        System.out.print("Apellido: ");
        nuevo.setApellido(leerDatos.nextLine());

        System.out.print("Correo: ");
        nuevo.setCorreo(leerDatos.nextLine());

        if (contUsuarios.insertar(nuevo)) {
            System.out.println("¡Usuario registrado con éxito!");
        } else {
            System.out.println("Error: No se pudo insertar el usuario.");
        }
    }//Fin insertar usuario

    private void actualizar() {
        Usuario pp = new Usuario();
        boolean verif = false;
        do {
            System.out.print("Digite el ID del usuario que desea actualizar: ");
            if (leerDatos.hasNextInt()) {
                pp.setId(leerDatos.nextInt());
                verif = true;
            } else {
                System.out.println("Solo son válidos valores numéricos, verifique su ID.");
                leerDatos.next();
            }
        } while (!verif);
        leerDatos.nextLine();

        pp = (Usuario) contUsuarios.consultarUno(pp);

        if (pp != null) {
            System.out.println("Usuario encontrado: " + pp.toString());
            System.out.println("1. Modificar nombre");
            System.out.println("2. Modificar apellido");
            System.out.println("3. Modificar correo");
            System.out.print("Seleccione una opción: ");
            
            int var = leerDatos.nextInt();
            leerDatos.nextLine();

            switch (var) {
                case 1:
                    System.out.print("Digite el nuevo nombre: ");
                    pp.setNombre(leerDatos.nextLine());
                    break;
                case 2:
                    System.out.print("Digite el nuevo apellido: ");
                    pp.setApellido(leerDatos.nextLine());
                    break;
                case 3:
                    System.out.print("Digite el nuevo correo: ");
                    pp.setCorreo(leerDatos.nextLine());
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }
            contUsuarios.update(pp);
            System.out.println("--- Usuario Actualizado con Éxito ---");
            contUsuarios.consultarTodos();
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }//Fin actualizar

    public void menuVistaUsuario() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n+----- MENÚ ADMINISTRAR USUARIOS -----+");
            System.out.println("1. Insertar usuario");
            System.out.println("2. Consultar todos los usuarios");
            System.out.println("3. Consultar un usuario");
            System.out.println("4. Ordenar Ascendente (por ID - Sort)");
            System.out.println("5. Ordenar Descendente (por ID - Burbuja)");
            System.out.println("6. Actualizar usuario");
            System.out.println("7. Borrar usuario");
            System.out.println("8. Volver / Salir");
            System.out.println("+-------------------------------------+");
            System.out.print("Elige una opción: ");

            if (!leerDatos.hasNextInt()) {
                System.out.println("Opción inválida.");
                leerDatos.next();
                continue;
            }

            int opc = leerDatos.nextInt();
            leerDatos.nextLine();

            switch (opc) {
                case 1:
                    insertarUsuarios();
                    break;
                case 2:
                    System.out.println("\n--- Lista de Usuarios ---");
                    contUsuarios.consultarTodos();
                    break;
                case 3:
                    consultarUnUsuario();
                    break;
                case 4:
                    System.out.println("--- Usuarios ordenados ascendentemente ---");
                    contUsuarios.ordenar();
                    contUsuarios.consultarTodos();
                    break;
                case 5:
                    System.out.println("--- Usuarios ordenados descendentemente ---");
                    contUsuarios.ordenar(1);
                    contUsuarios.consultarTodos();
                    break;
                case 6:
                    actualizar();
                    break;
                case 7:
                    System.out.println("Para eliminar un usuario primero consúltelo.");
                    System.out.print("Ingrese el ID del usuario: ");
                    Usuario aux = new Usuario();
                    aux.setId(leerDatos.nextInt());
                    leerDatos.nextLine();
                    Usuario encontrado = (Usuario) contUsuarios.consultarUno(aux);

                    if (encontrado == null) {
                        System.out.println("Usuario no encontrado.");
                    } else {
                        System.out.println("Usuario a eliminar: " + encontrado.getNombre() + " " + encontrado.getApellido());
                        borrarUsuario(encontrado);
                    }
                    break;
                case 8:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }//fin switch
        }//fin while
    }//Fin menu
}
    

