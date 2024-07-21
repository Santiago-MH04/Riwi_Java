package Taller2_11Julio2024.Punto2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Factura {
        //Atributos de Factura
    private List<Producto> Productos;
    private LocalDate fecha;

        //Constructores de Factura
    public Factura() {
        this.Productos = new ArrayList<>();
    }

    //Asignadores de atributos de Factura (setters)
    //Lectores de atributos de Factura (getters)

        //Métodos de Factura
    public void addProducto(Producto producto) {
        this.Productos.add(producto);
    }
    public void removeProducto(Producto producto) {
        this.Productos.remove(producto);
    }
    public void imprimirFactura(){
        AtomicInteger subtotal = new AtomicInteger();
        double descuentos = 0d;
        System.out.println("Bienvenidos a su tienda favorita");
        System.out.println(this.fecha + "\n");
        this.Productos.forEach(p -> {
            subtotal.addAndGet(p.getImporte());
        });
        this.Productos.forEach(System.out::println);
            //Descuentos
        if(subtotal.get() < 200) {
            descuentos += 0d;
        } else if (subtotal.get() >= 200 && subtotal.get() < 300) {
            descuentos = (subtotal.get()*0.1);
        } else if(subtotal.get() >= 300 && subtotal.get() < 500) {
            descuentos = (subtotal.get()*0.15);
        } else if(subtotal.get() >= 500 && subtotal.get() < 1000) {
            descuentos = (subtotal.get()*0.20);
        } else if(subtotal.get() >= 1000) {
            descuentos = (subtotal.get()*0.25);
        }
        System.out.println("Subtotal: " + subtotal.get());
        System.out.println("Descuentos: " + descuentos);
        System.out.println("Total: " + (subtotal.get() - descuentos));
    }
}
