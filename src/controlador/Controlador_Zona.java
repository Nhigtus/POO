/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.ArrayList;
import modelo.Zona;
import modelo.Almacenes;
import modelo.Producto;

/**
 *
 * @author nhigtus
 */
public class Controlador_Zona implements ICRUD {
    
    public static ArrayList<Zona> arregloZonas = new ArrayList<Zona>();

    // Registrar zona
    @Override
    public boolean insertar(Object obj) {

        Zona zona = (Zona) obj;

        if (zona == null || zona.getAlmacen() == null) {
            return false;
        }

        if (buscarIndice(zona.getId_zona()) >= 0) {
            return false;
        }

        arregloZonas.add(zona);
        zona.getAlmacen().agregarZona(zona);

        return true;
    }

    // Consultar todas las zonas
    @Override
    public void consultarTodos() {

        for (int i = 0; i < arregloZonas.size(); i++) {
            System.out.println(arregloZonas.get(i).toString());
        }
    }

    // Consultar una zona por ID
    @Override
    public Object consultarUno(Object obj) {

        Zona zona = (Zona) obj;
        int pos = buscarIndice(zona.getId_zona());

        if (pos >= 0) {
            return arregloZonas.get(pos);
        }

        return null;
    }

    // // ---------- QUICKSORT por id, descendente ----------
    @Override
    public void ordenar(int descendente) {
        if (descendente == 1) {
            quicksort(0, arregloZonas.size() - 1);
        } else {
            ordenar();
        }
    }
    
    private void quicksort(int ini, int fin) {
    if (ini >= fin) return;
    int pivote = arregloZonas.get(fin).getId_zona();
    int i = ini - 1;
    for (int j = ini; j < fin; j++) {
        if (arregloZonas.get(j).getId_zona() >= pivote) {
            i++;
            Zona aux = arregloZonas.get(i);
            arregloZonas.set(i, arregloZonas.get(j));
            arregloZonas.set(j, aux);
        }
    }
    Zona aux = arregloZonas.get(i + 1);
    arregloZonas.set(i + 1, arregloZonas.get(fin));
    arregloZonas.set(fin, aux);
    quicksort(ini, i);
    quicksort(i + 2, fin);
}

    // Ordenar por ID ascendente
    @Override
    public void ordenar() {

        for (int i = 0; i < arregloZonas.size() - 1; i++) {

            for (int j = 0; j < arregloZonas.size() - i - 1; j++) {

                if (arregloZonas.get(j).getId_zona()
                        > arregloZonas.get(j + 1).getId_zona()) {

                    Zona auxiliar = arregloZonas.get(j);

                    arregloZonas.set(j, arregloZonas.get(j + 1));
                    arregloZonas.set(j + 1, auxiliar);
                }
            }
        }
    }

    // Actualizar zona
    @Override
    public Object update(Object obj) {

        Zona zona = (Zona) obj;
        int pos = buscarIndice(zona.getId_zona());

        if (pos < 0) {
            return null;
        }

        Zona existente = arregloZonas.get(pos);

        existente.setCodigo_area(zona.getCodigo_area());
        existente.setCapacidad_maxima(zona.getCapacidad_maxima());

        return existente;
    }

    // Eliminar zona
    @Override
    public boolean delete(Object obj) {

        Zona zona = (Zona) obj;
        int pos = buscarIndice(zona.getId_zona());

        if (pos < 0) {
            return false;
        }

        Zona existente = arregloZonas.get(pos);

        Almacenes almacen = existente.getAlmacen();

        if (almacen != null) {
            almacen.eliminarZona(existente);
        }

        arregloZonas.remove(pos);

        return true;
    }

    // Ordenar por ID
    @Override
    public void ordenarPorId() {
        quicksort(0, arregloZonas.size() - 1);
    }

    // Buscar posición por ID
    @Override
    public int buscarIndice(int id) {

        
        if (!estaOrdenadoDesc()) ordenarPorId();
    int ini = 0, fin = arregloZonas.size() - 1;
    while (ini <= fin) {
        int mid = (ini + fin) / 2;
        int midId = arregloZonas.get(mid).getId_zona();
        if (midId == id) return mid;
        if (midId > id) ini = mid + 1;
        else fin = mid - 1;
    }
    return -1;
    }
    // ---------- BÚSQUEDA BINARIA por id (lista descendente) ----------
    private boolean estaOrdenadoDesc() {
    for (int i = 0; i < arregloZonas.size() - 1; i++) {
        if (arregloZonas.get(i).getId_zona() < arregloZonas.get(i + 1).getId_zona())
            return false;
    }
    return true;
}
    // ---------- DEPENDENCIAS entre entidades ----------
// Composición: si se elimina un almacén, desaparecen sus zonas
public static void eliminarZonasDeAlmacen(Almacenes almacen) {
    for (int i = arregloZonas.size() - 1; i >= 0; i--) {
        Almacenes dueño = arregloZonas.get(i).getAlmacen();
        if (dueño != null && dueño.equals(almacen)) {
            arregloZonas.remove(i);
        }
    }
    almacen.getZonas().clear();
}

// Agregación: si se elimina un producto del sistema, se retira de todas las zonas
public static void quitarProductoDeTodas(Producto producto) {
    for (Zona z : arregloZonas) {
        z.retirarProducto(producto);
    }
}

// Si un producto se actualiza, las zonas deben guardar la versión nueva
public static void reemplazarProductoEnTodas(Producto nuevo) {
    for (Zona z : arregloZonas) {
        z.reemplazarProducto(nuevo);
    }
}
    
}
