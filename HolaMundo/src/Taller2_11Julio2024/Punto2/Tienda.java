package Taller2_11Julio2024.Punto2;

public enum Tienda {
        //Atributos de Tienda
    AREPAS ("Arepas el fogón paisa", 2000),
    LECHE ("Leche Colanta deslactosada", 3500),
    CHOCOLATE ("Chocolate Tesalia con clavos y canela", 4500),
    AVENA ("Avena don Pancho", 5000);

    private final String nombre;
    private int precio;
        //Constructores de Tienda
    Tienda(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //Asignadores de atributos de Tienda (setters)
        //Lectores de atributos de Tienda (getters)
    public String getNombre() {
        return this.nombre;
    }
        public int getPrecio() {
            return this.precio;
        }

        //Métodos de Tienda
    @Override
    public String toString() {
        return "Nombre: " + this.nombre +
                ". Precio: $" + this.precio;
    }
}
