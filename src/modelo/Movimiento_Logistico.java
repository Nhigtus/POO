package modelo;

public class Movimiento_Logistico implements Comparable<Movimiento_Logistico>{
    //atributos
    private int id_logistica;
    private String fecha; 
    private String tipo_movimiento; //[Entrada, Salida, Traslado]
    private String producto_involucrado;
    private int cantidad;
    private String operario_responsable;

    public Movimiento_Logistico(int id_logistica, String fecha, String tipo_movimiento, String producto_involucrado, int cantidad, String operario_responsable) {
        this.id_logistica = id_logistica;
        this.fecha = fecha;
        this.tipo_movimiento = tipo_movimiento;
        this.producto_involucrado = producto_involucrado;
        this.cantidad = cantidad;
        this.operario_responsable = operario_responsable;
    }//Controlador completo

    public Movimiento_Logistico() {
    }//controlador vacio

    public int getId_logistica() {
        return id_logistica;
    }
    public void setId_logistica(int id_logistica) {
        this.id_logistica = id_logistica;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo_movimiento() {
        return tipo_movimiento;
    }
    public void setTipo_movimiento(String tipo_movimiento) {
        this.tipo_movimiento = tipo_movimiento;
    }

    public String getProducto_involucrado() {
        return producto_involucrado;
    }
    public void setProducto_involucrado(String producto_involucrado) {
        this.producto_involucrado = producto_involucrado;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getOperario_responsable() {
        return operario_responsable;
    }
    public void setOperario_responsable(String operario_responsable) {
        this.operario_responsable = operario_responsable;
    }//fin getter y setter

    //  como no se especifico el equals para esta clase se usa el id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movimiento_Logistico other = (Movimiento_Logistico) obj;
        return this.id_logistica == other.id_logistica;
    }//Fin equals
    
    @Override
    public String toString() {
        return "MovimientoLogistico{" + "id_logistica=" + id_logistica + ", fecha=" + fecha + ", tipo_movimiento=" + tipo_movimiento + ", producto_involucrado=" + producto_involucrado + ", cantidad=" + cantidad + ", operario_responsable=" + operario_responsable + '}';
    }// Fin toString

    @Override
    public int compareTo(Movimiento_Logistico o) {
        return Integer.compare(this.id_logistica, o.id_logistica);
    }//Fin compare to
}


    
    

