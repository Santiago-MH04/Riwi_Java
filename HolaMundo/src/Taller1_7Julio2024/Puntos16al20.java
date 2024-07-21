package Taller1_7Julio2024;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.Scanner;

public class Puntos16al20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Es transversal a todos los puntos

        System.out.println("-----  Punto 16  -----");
            System.out.print("Ingrese la contraseña: ");
            String contraseña = sc.nextLine();
                //Invocar un método para verificar la contraseña
            boolean esSegura = validatePassword(contraseña);
            System.out.println("La contraseña es segura: " + ((esSegura)?"sí":"no") );
        sc.nextLine();

        System.out.println("-----  Punto 17  -----");
                //Recibir un caracter por parte del usuario
            System.out.print("Ingrese un caracter: ");
            char caracter = sc.next().charAt(0);
            if (consonante(caracter)) {
                System.out.println("El caracter es una consonante.");
            } else if (vocal(caracter)) {
                System.out.println("El caracter es una vocal.");
            } else {
                System.out.println("El caracter es un caracter especial.");
            }
        sc.nextLine();

        System.out.println("-----  Punto 18  -----");
                //Pedir una opción al usuario, guardándola en minúscula
            System.out.println("Elige: piedra, papel o tijera");
            String user = sc.nextLine().toLowerCase();
                //Crear un arreglo con las opciones de la máquina
            String[] opciones = {"piedra", "papel", "tijera"};
                //Escoger una opción aleatoria de la máquina
            Random random = new Random();
                //A partir del número aleatorio creado, elegir la opción aleatoria de la máquina
            String bot = opciones[random.nextInt(opciones.length)];
            System.out.println("La computadora eligió: " + bot);
                //Verificar qué opción ha ganado, y comunicarlo al usuario
            if (user.equals(bot)) {
                System.out.println("¡Es un empate!");
            } else if (ganador(bot,user)) {
                System.out.println("¡Ganaste!");
            } else {
                System.out.println("Perdiste. ¡Intenta de nuevo!");
            }
        sc.nextLine();

        System.out.println("-----  Punto 19  -----");
            System.out.println("Ingrese su año de nacimiento (YYYY):");
                int year = sc.nextInt();
            System.out.println("Ingrese su mes de nacimiento (MM):");
                int month = sc.nextInt();
            System.out.println("Ingrese su día de nacimiento (DD):");
                int day = sc.nextInt();
                //Crear una fecha con esta información
            LocalDate fechaNacimiento = LocalDate.of(year, month, day);
            System.out.println(fechaNacimiento);
                //Obtener la fecha actual
            LocalDate fechaActual = LocalDate.now();
                //Calcular la edad con la clase period
                //El método between devuelve el tiempo transcurrido
            Period años = Period.between(fechaNacimiento, fechaActual);
                //Obtener años cumplidos
            int edad = años.getYears();
                //Determinar si es mayor de edad
            boolean esMayorDeEdad = edad >= 18;
                //Veredicto
            System.out.println("Usted tiene " + edad + " años.");
            if (esMayorDeEdad) {
                System.out.println("Usted es mayor de edad.");
            } else {
                System.out.println("Usted es menor de edad.");
            }
        sc.nextLine();

        System.out.println("-----  Punto 20  -----");

        sc.nextLine();

        sc.close(); //Para cerrar el recurso
    }

    public static boolean validatePassword (String password){
            //Verificar el tamaño
        if (password.length() < 8){
            return false;
        }
            //Declarar variables bandera
        boolean mayus = false;
        boolean minus = false;
        boolean carEspecial = false;
            //Recorrer la contraseña caracter por caracter y verificar las condiciones
        RecorrerClave:
        for (char i : password.toCharArray()){
                //Las condiciones se satisfacen al cumplirse al menos una vez
                    //Verificar todas las condiciones
            if (mayus && minus && carEspecial) {
                return true;
            }
            if (Character.isUpperCase(i)){
                mayus = true;
                continue RecorrerClave;
            } else if (Character.isLowerCase(i)) {
                minus = true;
                continue RecorrerClave;
            } else if (!Character.isLetterOrDigit(i)) {
                carEspecial = true;
                continue RecorrerClave;
            }
        }
        return false;
    }
        //Método que verifica que se trate de una vocal
    public static boolean vocal(char i) {
        i = Character.toLowerCase(i);  //normalizar el caracter
            //Arrojar el resultado en caso de que sí
        return i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u';
    }

        //Verificar que sea consonante, si verificamos antes que no es vocal
    public static boolean consonante(char i) {
        i = Character.toLowerCase(i); //normalizar el caracter
            //Ver que sea una consonante si es una letra del alfabeto latino, no vocálica
        return (i >= 'a' && i <= 'z') && !vocal(i);
    }

        //El método ganador verifica únicamente las opciones donde el usuario b gane
    public static boolean ganador(String a, String b){
        return (b.equals("piedra") && a.equals("tijera")) || (b.equals("papel") && a.equals("piedra")) || (b.equals("tijera") && a.equals("papel"));
    }
}
