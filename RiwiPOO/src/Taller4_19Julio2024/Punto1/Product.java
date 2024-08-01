package Taller4_19Julio2024.Punto1;

import java.util.Objects;

public abstract class Product {
        //Atributos de Producto
    private static int last_id;

    private int id;
    private String name;
    private double price;

        //Constructores de Producto
    public Product() {
        this.id = ++last_id;  //El chiste es que el ID sea autogenerado
    }
    public Product(String name, double price) {
        this();
        this.name = name;
        this.price = price;
    }

        //Asignadores de atributos de Producto (setters)
    public void setName(String name) {
        this.name = name;
    }
        public void setPrice(double price) {
            this.price = price;
        }

        //Lectores de atributos de Producto (getters)
    public int getId() {
        return this.id;
    }
        public String getName() {
            return this.name;
        }
            public double getPrice() {
                return this.price;
            }

        //Métodos de Producto
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return (this.id == product.id) && Double.compare(this.price, product.price) == 0 && Objects.equals(this.name, product.name);
    }
    @Override
    public String toString() {
        return "Product -> " +
                "ID: " + id +
                ". Name: " + this.name +
                ". Price: €" + this.price;
    }
    public abstract String Promo(double discount);
}
