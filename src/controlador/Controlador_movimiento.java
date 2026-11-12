package controlador;

import java.util.ArrayList;
import java.util.Collections;
import modelo.Movimiento_Logistico;

public class Controlador_movimiento implements ICRUD {
    public static ArrayList<Movimiento_Logistico> arregloMovimiento = new ArrayList<Movimiento_Logistico>();
    public static Iterable<Movimiento_Logistico> arregloMovimientos;

    @Override
    public boolean insertar(Object obj) {
         Movimiento_Logistico pp = (Movimiento_Logistico)obj;
        if(arregloMovimiento.isEmpty())
        {
            arregloMovimiento.add(pp);
            return true;
        }
        else if(!arregloMovimiento.contains(pp))
        {
            arregloMovimiento.add(pp);
            return true;
        }
        else
            return false;
    }// fin insertar
    
    @Override
    public void consultarTodos() {
        //recorrido por indice
        for(int i=0; i<arregloMovimiento.size();i++)
        {
            System.out.println(arregloMovimiento.get(i).toString());
        }
        
    }// fin consultar todos 
  
    @Override
    public Object consultarUno(Object obj) {
         int pos = buscarIndice(((Movimiento_Logistico) obj).getId_logistica());
    if (pos >= 0) return arregloMovimiento.get(pos);
    return null;
        
    } // fin consultar uno

    @Override
    public void ordenar(int descendente) {
        if (descendente == 1){
            int n = arregloMovimiento.size();
            for(int i = 0; i < n - 1; i++){
                for(int j = 0; j < n - i -1; j++){
                    if(arregloMovimiento.get(j).getId_logistica()< arregloMovimiento.get(j + 1).getId_logistica()){
                        Movimiento_Logistico auxilar = arregloMovimiento.get(j);
                        arregloMovimiento.set(j, arregloMovimiento.get(j + 1));
                        arregloMovimiento.set(j + 1, auxilar);
                    }//fin if
                }// fin for j
            }// fin for i
        }// fin if  
    }// fin ordenar descendente burbuja

    @Override
    public void ordenar() {
        Collections.sort(arregloMovimiento);
    }//fin ordenar

    @Override
    public Object update(Object obj) {
         Movimiento_Logistico pp = (Movimiento_Logistico) obj;
    int pos = buscarIndice(pp.getId_logistica());
    if (pos < 0) return null;
    arregloMovimiento.set(pos, pp);
    return pp;
    }//fin actualizar

    @Override
    public boolean delete(Object obj) {
         int pos = buscarIndice(((Movimiento_Logistico) obj).getId_logistica());
    if (pos < 0) return false;
    arregloMovimiento.remove(pos);
    return true;
    }//fin borrar
  // ---------- QUICKSORT por id_logistica, descendente ----------
@Override
public void ordenarPorId() {
    quicksort(0, arregloMovimiento.size() - 1);
}

private void quicksort(int ini, int fin) {
    if (ini >= fin) return;
    int pivote = arregloMovimiento.get(fin).getId_logistica();
    int i = ini - 1;
    for (int j = ini; j < fin; j++) {
        if (arregloMovimiento.get(j).getId_logistica() >= pivote) {
            i++;
            Movimiento_Logistico aux = arregloMovimiento.get(i);
            arregloMovimiento.set(i, arregloMovimiento.get(j));
            arregloMovimiento.set(j, aux);
        }
    }
    Movimiento_Logistico aux = arregloMovimiento.get(i + 1);
    arregloMovimiento.set(i + 1, arregloMovimiento.get(fin));
    arregloMovimiento.set(fin, aux);
    quicksort(ini, i);
    quicksort(i + 2, fin);
}

// ---------- BÚSQUEDA BINARIA por id_logistica (lista descendente) ----------
private boolean estaOrdenadoDesc() {
    for (int i = 0; i < arregloMovimiento.size() - 1; i++) {
        if (arregloMovimiento.get(i).getId_logistica() < arregloMovimiento.get(i + 1).getId_logistica())
            return false;
    }
    return true;
}

@Override
public int buscarIndice(int id) {
    if (!estaOrdenadoDesc()) ordenarPorId();
    int ini = 0, fin = arregloMovimiento.size() - 1;
    while (ini <= fin) {
        int mid = (ini + fin) / 2;
        int midId = arregloMovimiento.get(mid).getId_logistica();
        if (midId == id) return mid;
        if (midId > id) ini = mid + 1;
        else fin = mid - 1;
    }
    return -1;
    }

    // Convierte "DD/MM/AAAA" a un número AAAAMMDD para poder compararlo
private int fechaANumero(String f) {
    try {
        String[] p = f.split("/");
        return Integer.parseInt(p[2]) * 10000 + Integer.parseInt(p[1]) * 100 + Integer.parseInt(p[0]);
    } catch (Exception e) {
        return 0;   // fecha mal escrita: queda de primera, no revienta el programa
    }
}

// ---------- BURBUJA por fecha, ascendente (más antigua primero) ----------
public void ordenarPorFecha() {
    int n = arregloMovimiento.size();
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (fechaANumero(arregloMovimiento.get(j).getFecha()) > fechaANumero(arregloMovimiento.get(j + 1).getFecha())) {
                Movimiento_Logistico aux = arregloMovimiento.get(j);
                arregloMovimiento.set(j, arregloMovimiento.get(j + 1));
                arregloMovimiento.set(j + 1, aux);
            }
        }
    }
}
}
