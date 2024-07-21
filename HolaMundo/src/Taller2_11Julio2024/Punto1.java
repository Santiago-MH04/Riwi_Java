package Taller2_11Julio2024;

import java.util.Scanner;

import static java.lang.StringTemplate.STR;

public class Punto1 {
    public static void main(String[] args) {
        boolean seDetiene = true;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("Buenos días, ¿qué operación quieres hacer con nuestro menú (escoge un número)?:\n" +
                    "1. Suma " +  "\n" +
                    "2. Resta " + "\n" +
                    "3. Multiplicación " + "\n" +
                    "4. División" + "\n" +
                    "5. Salir");
            int opcion = sc.nextInt();
            sc.nextLine(); //Para refrescar al Scanner
            System.out.println("Ahora, dame el primer número entero para operar: ");
            int num1 = sc.nextInt();
            sc.nextLine(); //Para refrescar al Scanner
            System.out.println("Ahora, dame el segundo número entero para operar: ");
            int num2 = sc.nextInt();
            sc.nextLine(); //Para refrescar al Scanner

            if(opcion == 5){
                seDetiene = false;
            }
            switch(opcion){
                case 1 -> System.out.println("El resultado de la suma es " + (num1 + num2));
                case 2 -> System.out.println("El resultado de la resta es " + (num1 - num2));
                case 3 -> System.out.println("El resultado de la multiplicación es " + (num1 * num2));
                case 4 -> System.out.println("El resultado de la división es " + (num1 / num2));
                default -> System.out.println("Ha escogido una opción inválida");
            }

            String Santis = "Santiaguito";
            String Saludo = STR."Hola \{Santis}";   //Qué chévere eso de las plantillas
            System.out.println(Saludo);
            sc.close();
        } while(seDetiene);
    }
}
