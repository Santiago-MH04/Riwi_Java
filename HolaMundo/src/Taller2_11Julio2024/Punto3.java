package Taller2_11Julio2024;

import java.util.Arrays;
import java.util.Scanner;

public class Punto3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a su calculadora de notas restante favorita.\n Por favor ingrese las notas como números del (1 al 100) de las materias que tenga, separadas por espacios, e indicando con punto los decimales: ");
        String notasS = sc.nextLine();
        sc.nextLine();

        String[] notas = new String[8];
        notas = notasS.split(" ");
        double[] notasDouble = new double[notas.length];

        for (int i = 0; i < notas.length; i++) {
            notasDouble[i] = Double.parseDouble(notas[i]);
        }
        double mediaExistentes = (Arrays.stream(notasDouble).sum() / notas.length);
        double mediaRestantes = 76 - mediaExistentes;
        System.out.println("Debe obtener una media de " + mediaRestantes + " en las notas que le restan para aprobar el semestre");
        if ((mediaExistentes + mediaRestantes) < 76){
            System.out.println("Felicidades, ha aprobado el curso");
        } else {
            System.out.println("Nos vemos el próximo semestre, no le atinaste a nada");
        }
        sc.close();
    }
}
