package Taller4_19Julio2024.Punto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Inventory {
        //Atributos de Inventory
    private List<Product> products;

        //Constructores de Inventory
    public Inventory() {
        this.products = new ArrayList<Product>();
    }

    //Asignadores de atributos de Inventory (setters)

        //Lectores de atributos de Inventory (getters)
    public List<Product> getProducts() {
        return this.products;
    }

        //Métodos de Inventory
    public Inventory addProduct(Product p) {
        this.products.add(p);
        System.out.println("Product " + p.getName() + " successfully added to the inventory");
        return this;
    }
    public void updateDiscount(SpecificProduct p, double newDiscount) {
        if(this.products.contains(p) && p != null) {
            this.products.remove(p);
            p.setDiscount(newDiscount);
            this.products.add(p);
        }
    }
    public void removeProduct(Product p) {
        if(this.products.contains(p)) {
            this.products.remove(p);
        } else {
            System.out.println("Product " + p.getName() + " does not exist in the inventory");
        }
    }
    public Optional<Product> getProductByName(String name) {
        return this.products.stream()
                .filter(p -> p.getName().contains(name))
                .findAny();
    }
    public void listInventory() {
        this.products.forEach(System.out::println);
    }
}
