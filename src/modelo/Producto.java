package modelo;


public class Producto implements Comparable<Producto>{
    //Atributos
    private int id;
    private String codigoSKU;
    private String nombre;
    private String descripción;
    private float precio_unitario;
    private int stock_actual;
    private String proveedor;
    private String tipo; //[Perecedero, Frágil, Electrónico]
    
    //constructor 
    public Producto(int id, String codigoSKU, String nombre, String descripción, float precio_unitario, int stock_actual, String proveedor, String tipo) {
        this.id = id;
        this.codigoSKU = codigoSKU;
        this.nombre = nombre;
        this.descripción = descripción;
        this.precio_unitario = precio_unitario;
        this.stock_actual = stock_actual;
        this.proveedor = proveedor;
        this.tipo = tipo;
    }
    //hay que definir el costructor vacio, ya que si se define uno entonces se pierde el vacio
    public Producto() { 
    }//constructor vacio

    
    // get y set
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getCodigoSKU() {
        return codigoSKU;
    }
    public void setCodigoSKU(String codigoSKU) {
        this.codigoSKU = codigoSKU;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return descripción;
    }
    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }
    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getStock_actual() {
        return stock_actual;
    }
    public void setStock_actual(int stock_actual) {
        this.stock_actual = stock_actual;
    }

    public String getProveedor() {
        return proveedor;
    }
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getInfoAdicional() {
    return "-";
    }
    
  // Metodo to string
    @Override
    public String toString() {
        return "Producto{" +
               "id=" + id +
               ", codigoSKU='" + codigoSKU + '\'' +
               ", nombre='" + nombre + '\'' +
               ", descripción='" + descripción + '\'' +
               ", precio_unitario=" + precio_unitario +
               ", stock_actual=" + stock_actual +
               ", proveedor='" + proveedor + '\'' +
               ", tipo='" + tipo + '\'' +
               '}';
    }
    
  // metodo equal
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Producto)) {
            return false;
        }
        final Producto other = (Producto) obj;
        return this.id == other.id;
    }

    @Override
    public int compareTo(Producto o) { //dos ordenamientos por entiidad
        if(this.id == o.id)
            return 0;
        else if(this.id > o.id)
            return 100;
        else
            return -100;
    }//fin compareTo STOCK    
}
