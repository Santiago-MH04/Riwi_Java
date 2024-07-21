package Taller1_7Julio2024;

import java.util.Scanner;

public class Puntos6al10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Es transversal a todos los puntos

        System.out.println("-----  Punto 6  -----");
            System.out.println("Ingrese el número de un mes, para conocer su nombre: ");
            int month = sc.nextInt();
            switch (month) {
                case 1 -> System.out.println("El " + month +  "° mes se llama enero");
                case 2 -> System.out.println("El " + month +  "° mes se llama febrero");
                case 3 -> System.out.println("El " + month +  "° mes se llama marzo");
                case 4 -> System.out.println("El " + month +  "° mes se llama abril");
                case 5 -> System.out.println("El " + month +  "° mes se llama mayo");
                case 6 -> System.out.println("El " + month +  "° mes se llama junio");
                case 7 -> System.out.println("El " + month +  "° mes se llama julio");
                case 8 -> System.out.println("El " + month +  "° mes se llama agosto");
                case 9 -> System.out.println("El " + month +  "° mes se llama septiembre");
                case 10 -> System.out.println("El " + month +  "° mes se llama octubre");
                case 11 -> System.out.println("El " + month +  "° mes se llama noviembre");
                case 12 -> System.out.println("El " + month +  "° mes se llama diciembre");
                default -> System.out.println("Mes inválido");
            }
        sc.nextLine();

        System.out.println("-----  Punto 7  -----");
            System.out.println("Ingrese una opción: \n" +
                    "1. Suma \n" +
                    "2. Resta \n" +
                    "3. Multiplicación \n" +
                    "4. División");
            int option = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese el primer número");
            int n1 = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese el segundo número");
            int n2 = sc.nextInt();
            switch (option){
                case 1 -> System.out.println("El resultado de la suma es " + (n1 + n2));
                case 2 -> System.out.println("El resultado de la resta es " + (n1 - n2));
                case 3 -> System.out.println("El resultado de la multiplicación es " + (n1 * n2));
                case 4 -> System.out.println("El resultado de la división es " + (n1 / n2));
                default -> System.out.println("Ingrese una opción válida");
            }
        sc.nextLine();

        System.out.println("-----  Punto 8  -----");
            System.out.println("Ingrese las calificaciones");
            System.out.println("Primera materia");
            double cal1 = sc.nextDouble();
            sc.nextLine();
            System.out.println("Segunda materia");
            double cal2 = sc.nextDouble();
            sc.nextLine();
            System.out.println("Tercera materia");
            double cal3 = sc.nextDouble();
            sc.nextLine();
            double prom = ((cal1 + cal2 + cal3) / 3);
            if (prom >= 6) {
                System.out.println("El alumno aprobó con un promedio de " + prom);
            } else {
                System.out.println("El alumno reprobó con una nota de " + prom);
            }
        sc.nextLine();

        System.out.println("-----  Punto 9  -----");
            System.out.println("Ingrese un año: ");
            int year = sc.nextInt();
            if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
                System.out.println("El año " + year + " es bisiesto");
            } else {
                System.out.println("El año " + year + " no es bisiesto");
            }
        sc.nextLine();

        System.out.println("-----  Punto 10  -----");
            System.out.println("Ingrese el precio de la cuenta: ");
            double price = sc.nextDouble();
            sc.nextLine();
            System.out.println("Ingrese el % de propina que desea dejar: ");
            double propina = sc.nextDouble();
            double pago = ((propina * price) / 100);
            System.out.println("Debe dejar $" + pago + " de propina");
        sc.nextLine();

        sc.close(); //Para cerrar el recurso
    }
}
