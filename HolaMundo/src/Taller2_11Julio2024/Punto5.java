package Taller2_11Julio2024;

import java.util.Scanner;

public class Punto5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a nuestro buscador de palabras. Por favor ingrese la frase deseada, sin signos de puntuación en ella: ");
        String frase = sc.nextLine().toLowerCase();
        String[] palabras = frase.split(" ");
        System.out.println("Ahora, dinos, qué palabra quieres buscar");
        String palabra = sc.nextLine();
        int cuenta = 0;
        for(int i = 0; i < palabras.length; i++) {
            if(palabras[i].equals(palabra)) {
                cuenta++;
            }
        }
        System.out.println("La palabra " + palabra + " se encuentra en la frase " + cuenta + " veces");
        sc.close();
    }
}
