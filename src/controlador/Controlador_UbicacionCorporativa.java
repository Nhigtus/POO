package controlador;
import java.util.ArrayList;
import java.util.Collections;
import modelo.Ubicacion_Corporativa;

public class Controlador_UbicacionCorporativa implements ICRUD{
   public static ArrayList<Ubicacion_Corporativa> arregloUC = new ArrayList<Ubicacion_Corporativa>();

    @Override
    public boolean insertar(Object obj) {
        Ubicacion_Corporativa uc = (Ubicacion_Corporativa)obj;
        if (arregloUC.isEmpty()) {
            arregloUC.add(uc);
            return true;
        } else if (!arregloUC.contains(uc)) { // Utiliza el equals() definido en la clase modelo
            arregloUC.add(uc);
            enlazarPais(uc);
            return true;
        } else {
            return false;
        }
    }//Fin insertar

    @Override
    public void consultarTodos() {
        if (arregloUC.isEmpty()) {
            System.out.println("No hay ubicaciones registradas.");
            return;
        }
        for (int i = 0; i < arregloUC.size(); i++) {
            System.out.println(arregloUC.get(i).toString());
        }
    }//Fin consulta todos
    
//==============================================================================
    // consultar uno
    @Override
public Object consultarUno(Object obj) {
    int pos = buscarIndice(((Ubicacion_Corporativa) obj).getIdCiudad());
    if (pos >= 0) return arregloUC.get(pos);
    return null;
}
//==============================================================================
    @Override
    public void ordenar(int descendente) {
        if (descendente == 1) {
            int n = arregloUC.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arregloUC.get(j).getIdCiudad() < arregloUC.get(j + 1).getIdCiudad()) {
                        Ubicacion_Corporativa aux = arregloUC.get(j);
                        arregloUC.set(j, arregloUC.get(j + 1));
                        arregloUC.set(j + 1, aux);
                    }//Fin If
                }//Fin for J
            }//Fin for i
        }// Fin if
    }// fin ordenar descendente

    @Override
    public void ordenar() {
        Collections.sort(arregloUC);
    }// fin ordenar
//==============================================================================
    //update
    
    @Override
public Object update(Object obj) {
    Ubicacion_Corporativa uc = (Ubicacion_Corporativa) obj;
    int pos = buscarIndice(uc.getIdCiudad());
    if (pos < 0) return null;
    Ubicacion_Corporativa anterior = arregloUC.get(pos);
    anterior.getPais().quitarCiudad(anterior);   // la ciudad vieja sale de su país
    arregloUC.set(pos, uc);
    enlazarPais(uc);                             // la nueva se une al país que corresponda

    return uc;
}
//==============================================================================
    //delete   
@Override
public boolean delete(Object obj) {
    int pos = buscarIndice(((Ubicacion_Corporativa) obj).getIdCiudad());
    if (pos < 0) return false;
    Ubicacion_Corporativa borrada = arregloUC.get(pos);
    borrada.getPais().quitarCiudad(borrada);     // la ciudad sale de la lista de su país
    arregloUC.remove(pos);
    return true;
}
//==============================================================================
 // ---------- QUICKSORT por idCiudad, descendente ----------
@Override
public void ordenarPorId() {
    quicksort(0, arregloUC.size() - 1);
}

private void quicksort(int ini, int fin) {
    if (ini >= fin) return;
    int pivote = arregloUC.get(fin).getIdCiudad();
    int i = ini - 1;
    for (int j = ini; j < fin; j++) {
        if (arregloUC.get(j).getIdCiudad() >= pivote) {
            i++;
            Ubicacion_Corporativa aux = arregloUC.get(i);
            arregloUC.set(i, arregloUC.get(j));
            arregloUC.set(j, aux);
        }
    }
    Ubicacion_Corporativa aux = arregloUC.get(i + 1);
    arregloUC.set(i + 1, arregloUC.get(fin));
    arregloUC.set(fin, aux);
    quicksort(ini, i);
    quicksort(i + 2, fin);
}

// ---------- BÚSQUEDA BINARIA por idCiudad (lista descendente) ----------
private boolean estaOrdenadoDesc() {
    for (int i = 0; i < arregloUC.size() - 1; i++) {
        if (arregloUC.get(i).getIdCiudad() < arregloUC.get(i + 1).getIdCiudad())
            return false;
    }
    return true;
}

@Override
public int buscarIndice(int id) {
    if (!estaOrdenadoDesc()) ordenarPorId();
    int ini = 0, fin = arregloUC.size() - 1;
    while (ini <= fin) {
        int mid = (ini + fin) / 2;
        int midId = arregloUC.get(mid).getIdCiudad();
        if (midId == id) return mid;
        if (midId > id) ini = mid + 1;
        else fin = mid - 1;
    }
    return -1;
        } 
        private void enlazarPais(Ubicacion_Corporativa uc) {
    for (Ubicacion_Corporativa otra : arregloUC) {
        if (otra != uc && otra.getIdPais() == uc.getIdPais()) {
            uc.setPais(otra.getPais());
            return;
            }
        }
    }
}

