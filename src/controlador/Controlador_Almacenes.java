package controlador;

import java.util.ArrayList;
import java.util.Collections;
import modelo.Almacenes;
import modelo.Ubicacion_Corporativa;

public class Controlador_Almacenes implements ICRUD {
  public static ArrayList<Almacenes> arregloAlmacenes = new ArrayList<Almacenes>();
    
    @Override
    public boolean insertar(Object obj) {
        Almacenes al = (Almacenes)obj;
        if(arregloAlmacenes.isEmpty())
        {
            arregloAlmacenes.add(al);
            enlazarCiudad(al);
            return true;
        }
        else if(!arregloAlmacenes.contains(al))
        {
            arregloAlmacenes.add(al);
            enlazarCiudad(al);
            return true;
        }
        else
            return false;
    }//Fin insertar

    @Override
    public void consultarTodos() {
        //recorrido por indice
        for(int i=0; i<arregloAlmacenes.size();i++)
        {
            System.out.println(arregloAlmacenes.get(i).toString());
        }
        //For each
        //for(Producto p: arregloProductos)
        //{
        //    System.out.println(p.toString());
        //}
    }//Fin consultar todos

    @Override
    public Object consultarUno(Object obj) {
       int pos = buscarIndice(((Almacenes) obj).getId_almacen());
    if (pos >= 0) return arregloAlmacenes.get(pos);
    return null;
    }//fin consultar uno 

    @Override
    public void ordenar(int decendente) { // ordenar por que ??? lo hice con id -------------------------------
        if (decendente == 1){
            int n = arregloAlmacenes.size();
            for(int i = 0; i < n - 1; i++){
                for(int j = 0; j < n - i -1; j++){
                    if(arregloAlmacenes.get(j).getId_almacen() < arregloAlmacenes.get(j + 1).getId_almacen()){
                        Almacenes auxilar = arregloAlmacenes.get(j);
                        arregloAlmacenes.set(j, arregloAlmacenes.get(j + 1));
                        arregloAlmacenes.set(j + 1, auxilar);
                    }//fin if
                }// fin for j
            }// fin for i
        }// fin if  
    }//fin ordenar

    @Override
    public void ordenar() {
        Collections.sort(arregloAlmacenes);
    }//fin ordenar

    @Override
    public Object update(Object obj) {
        
    Almacenes al = (Almacenes) obj;

    int pos = buscarIndice(al.getId_almacen());

    if (pos < 0) {
        return null;
    }

    Almacenes existente = arregloAlmacenes.get(pos);

    existente.setNombre_almacen(al.getNombre_almacen());
    existente.setCiudad_almacen(al.getCiudad_almacen());
    enlazarCiudad(existente);
    existente.setGerente_asignado(al.getGerente_asignado());

    return existente;
       
    }//fin actualizar

    @Override
    public boolean delete(Object obj) {
        int pos = buscarIndice(((Almacenes) obj).getId_almacen());
    if (pos < 0) return false;
    Almacenes existente = arregloAlmacenes.get(pos);
    Controlador_Zona.eliminarZonasDeAlmacen(existente);   // sin almacén no hay zonas
    existente.setCiudad(null);                            // la ciudad deja de tenerlo en su lista
    arregloAlmacenes.remove(pos);
    return true;
    }//fin eliminar

    @Override
    public void ordenarPorId() {
         Collections.sort(arregloAlmacenes);
    }

    @Override
    public int buscarIndice(int id) {
         Collections.sort(arregloAlmacenes);
    return Collections.binarySearch(arregloAlmacenes, new Almacenes(id, "", "", ""));
    }

    // ---------- relación Ciudad -> Almacén ----------
    // Busca entre las ubicaciones registradas la ciudad con el nombre del almacén y los vincula
    private void enlazarCiudad(Almacenes al) {
        String nombre = al.getCiudad_almacen();
        if (nombre == null || al.getCiudad() != null) return;   // ya está vinculado
        for (Ubicacion_Corporativa u : Controlador_UbicacionCorporativa.arregloUC) {
            if (sinTildes(u.getNombreCiudad()).equals(sinTildes(nombre))) {
                al.setCiudad(u);
                return;
            }
        }
    }

    // Se llama cuando se registra una ciudad nueva: vincula los almacenes que estaban esperándola
    public static void enlazarCiudadesPendientes() {
        Controlador_Almacenes c = new Controlador_Almacenes();
        for (Almacenes a : arregloAlmacenes) {
            c.enlazarCiudad(a);
        }
    }

    // Para comparar "Bogota" con "Bogotá" sin importar tildes ni mayúsculas
    private static String sinTildes(String t) {
        String n = java.text.Normalizer.normalize(t.trim(), java.text.Normalizer.Form.NFD);
        return n.replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toLowerCase();
    }
}
