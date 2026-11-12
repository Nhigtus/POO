package controlador;
import java.util.ArrayList;
import java.util.Collections;
import modelo.Usuario;

public class Controlador_Usuario implements ICRUD{
    public static ArrayList<Usuario> arregloUsuarios = new ArrayList<Usuario>();

    @Override
    public boolean insertar(Object obj) {
         Usuario pp = (Usuario)obj;
        if(arregloUsuarios.isEmpty())
        {
            arregloUsuarios.add(pp);
            return true;
        }
        else if(!arregloUsuarios.contains(pp))
        {
            arregloUsuarios.add(pp);
            return true;
        }
        else
            return false;
    }//fin insertar

    @Override
    public void consultarTodos() {
        for(int i=0; i<arregloUsuarios.size();i++)
        {
            System.out.println(arregloUsuarios.get(i).toString());
        }
    }//fin consultar todos

    @Override
    public Object consultarUno(Object obj) {
          int pos = buscarIndice(((Usuario) obj).getId());
    if (pos >= 0) return arregloUsuarios.get(pos);
    return null;
    }//fin consultar uno 

    @Override
    public void ordenar(int descendente) {
        if (descendente == 1){
            int n = arregloUsuarios.size();
            for(int i = 0; i < n - 1; i++){
                for(int j = 0; j < n - i -1; j++){
                    if(arregloUsuarios.get(j).getId()< arregloUsuarios.get(j + 1).getId()){
                        Usuario auxilar = arregloUsuarios.get(j);
                        arregloUsuarios.set(j, arregloUsuarios.get(j + 1));
                        arregloUsuarios.set(j + 1, auxilar);
                    }//fin if
                }// fin for j
            }// fin for i
        }// fin if  
    }//fin ordenar 

    @Override
    public void ordenar() {
        Collections.sort(arregloUsuarios);
    }//fin ordenar

    @Override
    public Object update(Object obj) {  
        Usuario pp = (Usuario) obj;
    int pos = buscarIndice(pp.getId());
    if (pos < 0) return null;
    arregloUsuarios.set(pos, pp);
    return pp;
    }//fin actualizar 

    @Override
    public boolean delete(Object obj) {
    int pos = buscarIndice(((Usuario) obj).getId());
    if (pos < 0) return false;
    arregloUsuarios.remove(pos);
    return true;
    }//fin eliminar

    // ---------- QUICKSORT por ID, descendente ----------
@Override
public void ordenarPorId() {
    quicksort(0, arregloUsuarios.size() - 1);
}

private void quicksort(int ini, int fin) {
    if (ini >= fin) return;
    int pivote = arregloUsuarios.get(fin).getId();
    int i = ini - 1;
    for (int j = ini; j < fin; j++) {
        if (arregloUsuarios.get(j).getId() >= pivote) {
            i++;
            Usuario aux = arregloUsuarios.get(i);
            arregloUsuarios.set(i, arregloUsuarios.get(j));
            arregloUsuarios.set(j, aux);
        }
    }
    Usuario aux = arregloUsuarios.get(i + 1);
    arregloUsuarios.set(i + 1, arregloUsuarios.get(fin));
    arregloUsuarios.set(fin, aux);
    quicksort(ini, i);
    quicksort(i + 2, fin);
}

// ---------- MERGESORT por apellido ----------
public void ordenarPorNombre() {
    mergesort(arregloUsuarios);
}

private void mergesort(ArrayList<Usuario> l) {
    if (l.size() <= 1) return;
    int mid = l.size() / 2;
    ArrayList<Usuario> izq = new ArrayList<Usuario>(l.subList(0, mid));
    ArrayList<Usuario> der = new ArrayList<Usuario>(l.subList(mid, l.size()));
    mergesort(izq);
    mergesort(der);
    int i = 0, j = 0, k = 0;
    while (i < izq.size() && j < der.size()) {
        if (izq.get(i).getApellido().compareToIgnoreCase(der.get(j).getApellido()) <= 0) {
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

// ---------- BÚSQUEDA BINARIA por ID (lista descendente) ----------
private boolean estaOrdenadoDesc() {
    for (int i = 0; i < arregloUsuarios.size() - 1; i++) {
        if (arregloUsuarios.get(i).getId() < arregloUsuarios.get(i + 1).getId())
            return false;
    }
    return true;
}

@Override
public int buscarIndice(int id) {
    if (!estaOrdenadoDesc()) ordenarPorId();   // la binaria exige lista ordenada
    int ini = 0, fin = arregloUsuarios.size() - 1;
    while (ini <= fin) {
        int mid = (ini + fin) / 2;
        int midId = arregloUsuarios.get(mid).getId();
        if (midId == id) return mid;
        if (midId > id) ini = mid + 1;   // descendente: lo menor queda a la derecha
        else fin = mid - 1;
    }
    return -1;
}
}

    
    
    

