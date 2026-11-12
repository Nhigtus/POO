package controlador;
import java.util.ArrayList;
import java.util.Collections;
import modelo.Producto;

public class Controlador_Productos implements ICRUD{
    public static ArrayList<Producto> arregloProductos = new ArrayList<Producto>();
    
    @Override
    public boolean insertar(Object obj) {
        Producto pp = (Producto)obj;
        if(arregloProductos.isEmpty())
        {
            arregloProductos.add(pp);
            return true;
        }
        else if(!arregloProductos.contains(pp))
        {
            arregloProductos.add(pp);
            return true;
        }
        else
            return false;
    }//Fin insertar

    @Override
    public void consultarTodos() {
        //recorrido por indice
        for(int i=0; i<arregloProductos.size();i++)
        {
            System.out.println(arregloProductos.get(i).toString());
        }
        //For each
        //for(Producto p: arregloProductos)
        //{
        //    System.out.println(p.toString());
        //}
    }//Fin consultar todos
//==============================================================================
    // consultar uno modificado
    @Override
    public Object consultarUno(Object obj) {
       int pos = buscarIndice(((Producto) obj).getId());
    if (pos >= 0) return arregloProductos.get(pos);
    return null;
    }//fin consultar uno
//==============================================================================
    
    
    @Override
    public void ordenar(int decendente) {
        if (decendente == 1){
            int n = arregloProductos.size();
            for(int i = 0; i < n - 1; i++){
                for(int j = 0; j < n - i -1; j++){
                    if(arregloProductos.get(j).getStock_actual() < arregloProductos.get(j + 1).getStock_actual()){
                        Producto auxilar = arregloProductos.get(j);
                        arregloProductos.set(j, arregloProductos.get(j + 1));
                        arregloProductos.set(j + 1, auxilar);
                    }//fin if
                }// fin for j
            }// fin for i
        }// fin if  
    }//fin ordenar

    @Override
    public void ordenar() {
        Collections.sort(arregloProductos);
    }//fin ordenar
    
    
//==============================================================================
   // update modificado
    @Override
    public Object update(Object obj) {
         Producto pp = (Producto) obj;
    int pos = buscarIndice(pp.getId());
    if (pos < 0) return null;
    arregloProductos.set(pos, pp);
    Controlador_Zona.reemplazarProductoEnTodas(pp);   // las zonas guardan la versión nueva
    return pp;
    }//fin actualizar
//==============================================================================
   //delete modificado
    @Override
    public boolean delete(Object obj) {
         int pos = buscarIndice(((Producto) obj).getId());
    if (pos < 0) return false;
    Controlador_Zona.quitarProductoDeTodas(arregloProductos.get(pos));   // se retira de las zonas
    arregloProductos.remove(pos);
    
    return true;
    }//fin eliminar
    
//==============================================================================
    // quicksort por id
    
    @Override
    public void ordenarPorId() {
        quicksort(0, arregloProductos.size() - 1);
    }
    private void quicksort(int ini, int fin) {
    if (ini >= fin) return;
    int pivote = arregloProductos.get(fin).getId();
    int i = ini - 1;
    for (int j = ini; j < fin; j++) {
        if (arregloProductos.get(j).getId() >= pivote) {
            i++;
            Producto aux = arregloProductos.get(i);
            arregloProductos.set(i, arregloProductos.get(j));
            arregloProductos.set(j, aux);
        }
    }
    Producto aux = arregloProductos.get(i + 1);
    arregloProductos.set(i + 1, arregloProductos.get(fin));
    arregloProductos.set(fin, aux);
    quicksort(ini, i);
    quicksort(i + 2, fin);
}
//==============================================================================
    //mergesort por nombre
    public void ordenarPorNombre() {
    mergesort(arregloProductos);
}
    private void mergesort(ArrayList<Producto> l) {
    if (l.size() <= 1) return;
    int mid = l.size() / 2;
    ArrayList<Producto> izq = new ArrayList<Producto>(l.subList(0, mid));
    ArrayList<Producto> der = new ArrayList<Producto>(l.subList(mid, l.size()));
    mergesort(izq);
    mergesort(der);
    int i = 0, j = 0, k = 0;
    while (i < izq.size() && j < der.size()) {
        if (izq.get(i).getNombre().compareToIgnoreCase(der.get(j).getNombre()) <= 0) {
            l.set(k, izq.get(i));
            i++;
        } else {
            l.set(k, der.get(j));
            j++;
        }
        k++;
    }
    while (i < izq.size()) { l.set(k, izq.get(i)); i++; k++; }
    while (j < der.size()) { l.set(k, der.get(j)); j++; k++; }
}
//==============================================================================
   // busqueda binaria -> si esta ordenada
    
    private boolean estaOrdenadoDesc() {
    for (int i = 0; i < arregloProductos.size() - 1; i++) {
        if (arregloProductos.get(i).getId() < arregloProductos.get(i + 1).getId())
            return false;
    }
    return true;
}
    
// =============================================================================
    // busqueda por indice binaria
    @Override
    public int buscarIndice(int id) {
        if (!estaOrdenadoDesc()) ordenarPorId();   // la binaria exige lista ordenada
    int ini = 0, fin = arregloProductos.size() - 1;
    while (ini <= fin) {
        int mid = (ini + fin) / 2;
        int midId = arregloProductos.get(mid).getId();
        if (midId == id) return mid;
        if (midId > id) ini = mid + 1;   // descendente: lo menor queda a la derecha
        else fin = mid - 1;
    }
    return -1;
    }
}