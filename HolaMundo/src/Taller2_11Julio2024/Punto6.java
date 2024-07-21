package Taller2_11Julio2024;

import java.util.Scanner;

public class Punto6 {
    public static void main (String[] args){
        String[] nombres = {"Condorito", "Mafalda","Olafo","Garfield"};

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un nombre");
        String nombre = sc.nextLine().toLowerCase();

        boolean encontrado = false;
        int indice = 0;

        for (int i = 0; i < nombres.length; i++){
            if (nombres[i].equals(nombre)){
                encontrado = true;
                indice = i;
                break;
            }
        }

        if (encontrado){
            System.out.println("El nombre " + nombre + " se encontró en la" + + indice + "° posición " );
        } else {
            System.out.println("El nombre " + nombre + " no se encontró");
        }

        sc.close();
    }
}
