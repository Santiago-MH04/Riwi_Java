package Taller1_7Julio2024;

import java.util.Scanner;
    //Favor comentar el resto de los puntos mientras ejecuta alguno, para no saturarse de recursos
public class Puntos1al5 {   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Es transversal a todos los puntos
        System.out.println("-----  Punto 1  -----");
                System.out.println("Ingresa el primer número que desees operar");
            double number1 = sc.nextDouble();
                sc.nextLine();
                System.out.println("Ingresa el segundo número que desees operar");
            double number2 = sc.nextDouble();
                sc.nextLine();
            System.out.println("La suma de los números " + number1 + " y " + number2 + " es = " + (number1 + number2));
            System.out.println("La resta de los números " + number1 + " y " + number2 + " es = " + (number1 - number2));
            System.out.println("La multiplicación de los números " + number1 + " y " + number2 + " es = " + (number1 * number2));
            System.out.println("La división de los números " + number1 + " y " + number2 + " es = " + (number1 / number2));

        System.out.println("-----  Punto 2  -----");
            System.out.println("Ingrese su edad");
            int age = sc.nextInt();
            if (age < 18){
                System.out.println("Usted es menor de edad");
            }else{
                System.out.println("Usted es mayor de edad");
            }
            sc.nextLine();

        System.out.println("-----  Punto 3  -----");
            double mi = 1.60934;
            System.out.println("Ingrese la distancia recorrida, en kilómetros");
            double km = sc.nextDouble();
            System.out.println("Usted recorrió el equivalente a " + (km / mi) + " millas");
            sc.nextLine();

        System.out.println("-----  Punto 4  -----");
            System.out.println("Ingrese su peso en kg");
            double weight = sc.nextDouble();
            sc.nextLine();
            System.out.println("Ingrese su estatura en metros");
            double height = sc.nextDouble();
            System.out.println("Su IMC es de " + (weight / Math.pow(height, 2d)));
            sc.nextLine();

        System.out.println("-----  Punto 5  -----");
            System.out.println("Ingrese un número: ");
            double number = sc.nextDouble();

            if (number < 0) {
                if (number % 2 == 0) {
                    System.out.println("El número " + number + "es negativo par");
                } else {
                    System.out.println("El número " + number + "es negativo impar");
                }
            } else if (number > 0) {
                if (number % 2 == 0) {
                    System.out.println("El número " + number + "es positivo par");
                } else {
                    System.out.println("El número " + number + "es positivo impar");
                }
            } else {
                System.out.println("El número es 0");
            }
            sc.nextLine();

        sc.close(); //Para cerrar el recurso
    }
}


