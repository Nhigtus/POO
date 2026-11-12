package controlador;

public interface ICRUD {
    public boolean insertar(Object obj); //C
    public void consultarTodos();        //R
    public Object consultarUno(Object obj);//R
    public void ordenar(int descendente);//R
    public void ordenar(); //R
    public Object update(Object obj);//U
    public boolean delete(Object obj);//D  
    
    public void ordenarPorId();       // Quicksort  (Almacenes: Collections.sort asc)
    public int buscarIndice(int id);  // búsqueda binaria
}
