package Taller4_19Julio2024.Punto1;

import java.util.Objects;

public class SpecificProduct extends Product {
        //Atributos de SpecificProduct
    private String brand;
    private String category;

    private static double discount = 20d;

        //Constructores de SpecificProduct
    public SpecificProduct(String name, double price) {
        super(name, price);
    }

    public SpecificProduct(String name, double price, String brand, String category) {
        this(name, price);
        this.brand = brand;
        this.category = category;
    }

        //Asignadores de atributos de SpecificProduct (setters)
    public void setBrand(String brand) {
        this.brand = brand;
    }
        public void setCategory(String category) {
            this.category = category;
        }
            public static void setDiscount(double discount) {
                SpecificProduct.discount = discount;
            }

    //Lectores de atributos de SpecificProduct (getters)
    public String getBrand() {
        return this.brand;
    }
        public String getCategory() {
            return this.category;
        }
            public static double getDiscount() {
                return discount;
            }

        //Métodos de SpecificProduct
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpecificProduct that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(brand, that.brand) && Objects.equals(category, that.category);
    }
    @Override
    public String toString() {
        return super.toString() + Promo(SpecificProduct.discount);
    }
    @Override
    public String Promo(double discount) {
        double newPrice = this.getPrice() * (1 - (discount/100));
        return "\nIf you purchase more than three units, the unit will cost €" + newPrice + " each";
    }
}
