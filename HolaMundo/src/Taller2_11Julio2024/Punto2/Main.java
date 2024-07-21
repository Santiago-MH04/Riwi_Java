package Taller2_11Julio2024.Punto2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            //Elementos necesarios del menú
        boolean hastaAcá = true;
        Scanner sc = new Scanner(System.in);
            //Instancias necesarias
        Factura miFactura = new Factura();
        do {
            System.out.println("Bienvenido a nuestro menú. A continuación, seleccione la opción que desea: \n " +
                    "1. Añadir producto a la bolsa \n" +
                    "2. Agregar producto a la tienda \n" +
                    "3. Imprimir factura \n" +
                    "4. Salir");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> {
                    System.out.println("¿Quieres añadir: \n" +
                            "1. Un paquete de arepas \n" +
                            "2. Una bolsa de leche \n" +
                            "3. Un cuarto de chocolate \n" +
                            "4.Un paquete de avena");
                    int opcion = sc.nextInt();
                    sc.nextLine();
                    Producto producto = new Producto();
                    if (opcion == 1) {
                        producto.setTienda(Tienda.AREPAS);
                    } else if (opcion == 2) {
                        producto.setTienda(Tienda.LECHE);
                    } else if (opcion == 3) {
                        producto.setTienda(Tienda.CHOCOLATE);
                    } else if (opcion == 4) {
                        producto.setTienda(Tienda.AVENA);
                    }
                    System.out.println("¿Qué cantidad de dicho producto quieres conseguir?: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();
                    producto.setCantidad(cantidad);
                    miFactura.addProducto(producto);
                    System.out.println("HolaMundo");
                }
                case 2 -> crearProducto();
                case 3 -> miFactura.imprimirFactura();
                case 4 -> hastaAcá = false;
                default -> System.out.println("Opción inválida. Sigue intentando");
            }
            sc.nextLine();
        } while (hastaAcá);
        sc.close();
    }

    public static Producto crearProducto(){
        Producto producto = new Producto();
        Scanner sc = new Scanner(System.in);
        System.out.println();
        sc.close();
        return producto;
    }
}
