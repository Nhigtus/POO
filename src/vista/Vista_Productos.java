package vista;

import controlador.Controlador_Productos;
import java.util.Scanner;
import modelo.Producto;
import modelo.ProductoPerecedero;

public class Vista_Productos {
    public Controlador_Productos contProductos;
    private Scanner leerDatos;

    public Vista_Productos() {
        contProductos = new Controlador_Productos();
        leerDatos = new Scanner(System.in);
        insertarProductoDefecto();
    }//Fin controlador vacio
    
    //Metodos
    public void insertarProductoDefecto() {
        contProductos.insertar(new ProductoPerecedero(1, "BOC_Novela", "Bendicion Oficial Del Cielo", "Tapa Dura", 120000, 20, "Panini", "Perecedero", "31/12/2026")); //PRODUCTO QUE USA LA CLASE HIJA
        contProductos.insertar(new Producto(8, "Manga_Jujutsu", "Jujutsu Kaisen Vol 1", "Tapa Blanda", 45000, 15, "Panini", "No Perecedero"));
        contProductos.insertar(new Producto(4, "Comic_Batman", "Batman Year One", "Tapa Dura", 85000, 10, "ECC", "No Perecedero"));
        contProductos.insertar(new ProductoPerecedero(11, "BOC_Novela", "Bendicion_Oficial_Del_Cielo", "Tapa Dura", 120000, 20, "Panini", "Perecedero", "30/06/2027"));// IGUAL
        contProductos.insertar(new Producto(11, "BOC_Novela", "Bendicion_Oficial_Del_Cielo", "Tapa Dura", 120000, 20, "Panini", "Perecedero"));
        contProductos.insertar(new Producto(40, "NVL_SAO", "Sword Art Online Vol 01", "Tapa Blanda", 65000, 8, "Planeta", "No Perecedero"));
        contProductos.insertar(new Producto(5, "ANM_Figura", "Figura Nendoroid Luffy", "Coleccionable", 210000, 5, "Good Smile", "No Perecedero"));
        contProductos.insertar(new Producto(6, "MNG_Chainsaw", "Chainsaw Man Vol 01", "Tapa Blanda", 48000, 12, "Ivrea", "No Perecedero"));
        contProductos.insertar(new Producto(7, "CMC_Spider", "Spider-Man Blue", "Tapa Dura", 95000, 11, "Panini", "No Perecedero"));
        contProductos.insertar(new Producto(18, "NVL_Omniscient", "Omniscient Reader Viewpoint", "Tapa Dura", 130000, 6, "Izanook", "No Perecedero"));
    }//Fin de insertar 10 productos defecto

    public void consultarUnProducto(){
        Producto pp = new Producto();
        System.out.println("Digite el ID del producto");
        boolean verif = false;
        do{
            if(leerDatos.hasNextInt()){
                pp.setId(leerDatos.nextInt());
                verif = true;
            }
            else{
                System.out.println("Solo se permite valores numericos, verifique el ID ingresado");
                leerDatos.next();
            }
        } while(!verif); //fin while verif
        leerDatos.nextLine();
        
        pp = (Producto)contProductos.consultarUno(pp);
        if(pp != null)
            System.out.println(pp.toString());
        else
            System.out.println("Producto no encontrado");
    }//Fin de consultar un producto
    
    public void borrarProducto(Producto pp) {
        boolean eliminado = contProductos.delete(pp);
        if (eliminado) {
            System.out.println("Producto eliminado exitosamente.");
            contProductos.consultarTodos(); // Muestra la lista actualizada
        } else {
            System.out.println("No se encontró ningún producto con ese ID.");
        }
    }//fin borrar 
    
   public void insertarProductos() {
        System.out.println("--- Insertar Nuevo Producto ---");
        System.out.println("Digite el ID del producto que desea agregar:");
        Producto nuevo = new Producto();
        
        boolean verif = false;
        do{          
            if(leerDatos.hasNextInt()){
                nuevo.setId(leerDatos.nextInt());
                verif = true;
            }
            else{
                System.out.println("Solo se aceptan valores numericos, verifique el ID");
                leerDatos.next();
            }
        } while(!verif); //fin while Verif
        leerDatos.nextLine();

        Producto existente = (Producto) contProductos.consultarUno(nuevo);
        if (existente != null) {
            System.out.println("Error: Ya existe un producto registrado con el ID " + nuevo.getId() + " (" + existente.getNombre() + ").");
            return;
        }
        System.out.println("El ID está disponible. Digite los datos del producto:");

        boolean salir = false;
        do {
            System.out.print("Precio: ");
            // Usar hasNextFloat() para que coincida con nextFloat()
            if (leerDatos.hasNextFloat()) { 
                nuevo.setPrecio_unitario(leerDatos.nextFloat());
                salir = true;
            } else {
                System.out.println("Debe ingresar un valor numerico para el precio.");
                leerDatos.next(); // limpiamos el buffer
            }
        } while (!salir); //fin while Verif
        leerDatos.nextLine();
        
        salir = false;
        do {
            System.out.print("Stock: "); 
            if (leerDatos.hasNextInt()) {
                nuevo.setStock_actual(leerDatos.nextInt());
                salir = true;
            } else {
                System.out.println("Debe ingresar valores numericos para el stock.");
                leerDatos.next(); // limpiamos el buffer
            }
        } while (!salir); //Fin while verif
        leerDatos.nextLine(); // limpia el \n que dejó nextInt() del stock, antes del primer nextLine()

        System.out.print("SKU: ");
        nuevo.setCodigoSKU(leerDatos.nextLine());

        System.out.print("Nombre: ");
        nuevo.setNombre(leerDatos.nextLine());

        System.out.print("Descripción: ");
        nuevo.setDescripción(leerDatos.nextLine());

        System.out.print("Proveedor: ");
        nuevo.setProveedor(leerDatos.nextLine());

        System.out.print("Tipo (Perecedero / No Perecedero): ");
        nuevo.setTipo(leerDatos.nextLine());

        // Inserción a través del controlador
        if (contProductos.insertar(nuevo)) {
            System.out.println("¡Producto registrado con éxito!");
        } else {
            System.out.println("Error: No se pudo insertar el producto.");
        }
    }//Fin insertar producto
    
    private void actualizar(){
        Producto pp = new Producto();       
        boolean verif = false;
        do{
            System.out.println("Digite el id del Producto que desea Actualizar");
            if(leerDatos.hasNextInt()){
                pp.setId(leerDatos.nextInt());
                verif = true;
            }
            else{
                System.out.println("Solo son validos valores numericos, verifique su ID");
                leerDatos.next();
            }
        } while(!verif); //fin while verif 
        leerDatos.nextLine();
        
        pp = (Producto)contProductos.consultarUno(pp);
        
        if (pp != null) {
            System.out.println(pp.toString());
            System.out.println("1. Modificar nombre del prodcuto");
            System.out.println("2. Modificar descripcion del prodcuto");
            System.out.println("3. Modificar stock del prodcuto");
            int var = leerDatos.nextInt();
            
            switch (var) {
                case 1:
                    System.out.println("Digite el nombre nuevo");
                    pp.setNombre(leerDatos.next());
                    break;
                case 2:
                    System.out.println("Digite la nueva descripcion");
                    pp.setDescripción(leerDatos.next());
                    break;
                case 3:               
                    verif = false;
                    do{
                        System.out.println("Digite el nuevo stock");
                        if(leerDatos.hasNextInt()){
                            pp.setStock_actual(leerDatos.nextInt());
                            verif = true;
                        }
                        else{
                            System.out.println("Solo se permiten valores numericos, verifique su cantidad de stock");
                            leerDatos.next();
                        }
                    } while(!verif); //fin while verif
                    break;             
            }//Fin switch de actualizar
            contProductos.update(pp);
            contProductos.consultarTodos();
        } else {
            System.out.println("Producto no encontrado.");
        }
    }//Fin actualizar
    
    public void menuVistaProducto(){
        System.out.println("+----- Digite su opción en el siguiente menu -----+");
        System.out.println("1. Insertar productos");
        System.out.println("2. Consultar Todos los productos");
        System.out.println("3. Consultar Un producto");
        System.out.println("4. Ordenar Ascendente productos");
        System.out.println("5. Ordenar Descendente productos");
        System.out.println("6. Actualizar productos");
        System.out.println("7. Borrar productos");
        System.out.println("+-----------------------------------------------+");
        int opc = leerDatos.nextInt();
            switch(opc){
                case 1:
                    insertarProductos();
                    break;
                case 2:
                    contProductos.consultarTodos();
                    break;
                case 3:
                    consultarUnProducto();
                    break;
                case 4:
                    System.out.println("--- Productos ordenados ascendentemente por Stock Actual ---");
                    contProductos.ordenar();
                    contProductos.consultarTodos();
                    break;
                case 5:
                    System.out.println("--- Productos ordenados descendentemente por Stock Actual ---");
                    contProductos.ordenar(1);
                    contProductos.consultarTodos();
                    break;
                case 6:
                    actualizar();
                    break;
                case 7:         
                    System.out.println("Para eliminar un producto primero consúltelo.");
                    System.out.println("Ingrese el ID del producto:");
                    Producto aux = new Producto();
                    aux.setId(leerDatos.nextInt());
                    Producto encontrado = (Producto)contProductos.consultarUno(aux);

                    if (encontrado == null) {
                        System.out.println("Producto no encontrado.");
                    } else {
                        System.out.println("Producto a eliminar: " + encontrado.getNombre());
                        borrarProducto(encontrado);
                    }
                    break;
                default:
                    break;
            }//Fin switch
    }//Fin clase Menu Vista Productos  
}//Fin de la clase vista productos