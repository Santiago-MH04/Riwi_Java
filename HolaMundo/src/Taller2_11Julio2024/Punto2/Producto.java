package Taller2_11Julio2024.Punto2;

public class Producto {
        //Atributos de Producto
    private Tienda tienda;
    private int cantidad;
    private int importe;

        //Constructores de Producto
    public Producto() {}
    public Producto(Tienda tienda, int cantidad) {
        this.cantidad = cantidad;
    }

        //Asignadores de atributos de Producto (setters)
    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
        public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

        //Lectores de atributos de Producto (getters)
    public Tienda getTienda() {
        return this.tienda;
    }
        public int getCantidad() {
    return cantidad;
}
            public int getImporte() {
                this.importe = (this.getTienda().getPrecio() * this.cantidad);
                return this.importe;
            }

    //Métodos de Producto
    @Override
    public String toString() {
        return this.tienda +
                ". Cantidad: " + this.cantidad +
                ". Total: $" + this.getImporte();
    }
}
