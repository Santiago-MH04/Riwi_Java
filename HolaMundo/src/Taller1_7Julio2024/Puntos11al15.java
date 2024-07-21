package Taller1_7Julio2024;

import java.util.Scanner;

public class Puntos11al15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Es transversal a todos los puntos

        System.out.println("-----  Punto 11  -----");
        System.out.print("Ingresa el primer número: ");
        int num1 = sc.nextInt();
        System.out.print("Ingresa el segundo número: ");
        int num2 = sc.nextInt();
        System.out.print("Ingresa el tercer número: ");
        int num3 = sc.nextInt();
            // Ordenamiento usando operador ternario
        System.out.println("Los números ordenados de menor a mayor son: " +
                ((num1 < num2) ? ((num1 < num3) ? num1 : num3) : ((num2 < num3) ? num2 : num3)) + ", " +
                ((num1 > num2) ? ((num1 < num3) ? num1 : num3) : ((num2 < num3) ? num2 : num3)) + ", " +
                ((num1 > num2) ? ((num1 > num3) ? num1 : num3) : ((num2 > num3) ? num2 : num3)));
        sc.nextLine();

        System.out.println("-----  Punto 12  -----");
            int month = 0;
            int day = 0;
            do{
                System.out.print("Ingresa tu mes de nacimiento (1-12): ");
                month = sc.nextInt();
                System.out.print("Ingresa tu día de nacimiento (1-31): ");
                day = sc.nextInt();
            } while (!((month > 0 && month <= 12) && (day > 0 && day <= 31)));
            String star = null;
            BuscandoSignos:
                switch (month) {
                    case 1:
                        if (day <= 19) {
                            star = "Capricornio";
                        } else {
                            star = "Acuario";
                        }
                        break BuscandoSignos;
                    case 2:
                        if (day <= 18) {
                            star = "Acuario";
                        } else {
                            star = "Piscis";
                        }
                        break BuscandoSignos;
                    case 3:
                        if (day <= 20) {
                            star = "Piscis";
                        } else {
                            star = "Aries";
                        }
                        break BuscandoSignos;
                    case 4:
                        if (day <= 19) {
                            star = "Aries";
                        } else {
                            star = "Tauro";
                        }
                        break BuscandoSignos;
                    case 5:
                        if (day <= 20) {
                            star = "Tauro";
                        } else {
                            star = "Géminis";
                        }
                        break BuscandoSignos;
                    case 6:
                        if (day <= 20) {
                            star = "Géminis";
                        } else {
                            star = "Cáncer";
                        }
                        break BuscandoSignos;
                    case 7:
                        if (day <= 22) {
                            star = "Cáncer";
                        } else {
                            star = "Leo";
                        }
                        break BuscandoSignos;
                    case 8:
                        if (day <= 22) {
                            star = "Leo";
                        } else {
                            star = "Virgo";
                        }
                        break BuscandoSignos;
                    case 9:
                        if (day <= 22) {
                            star = "Virgo";
                        } else {
                            star = "Libra";
                        }
                        break BuscandoSignos;
                    case 10:
                        if (day <= 22) {
                            star = "Libra";
                        } else {
                            star = "Escorpio";
                        }
                        break BuscandoSignos;
                    case 11:
                        if (day <= 21) {
                            star = "Escorpio";
                        } else {
                            star = "Sagitario";
                        }
                        break BuscandoSignos;
                    case 12:
                        if (day <= 21) {
                            star = "Sagitario";
                        } else {
                            star = "Capricornio";
                        }
                        break BuscandoSignos;
                    /*default:
                        star = "Mes inválido";*/    //En este caso particular, no es necesaria la opción por defecto
                }
            System.out.println("Su signo del zodiaco es: " + star.toLowerCase());
        sc.nextLine();

        System.out.println("-----  Punto 13  -----");
            double km = 1300d;
            double tarifaBase = 5000d;
            System.out.println("Ingrese el recorrido del viaje, en kilómetros");
            double distancia = sc.nextDouble();
            sc.nextLine();
        System.out.println("El precio del viaje es de: $" + (tarifaBase + (km * distancia)));
        sc.nextLine();

        System.out.println("-----  Punto 14  -----");
            System.out.println("Ingrese 1 para transformar grados Celsius a grados Fahrenheit o 2 para transformar grados Fahrenheit a grados Celsius");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> {
                    System.out.println("Ingrese la temperatura en °C: ");
                    double C = sc.nextDouble();
                    sc.nextLine();
                    System.out.println(C + "°C = " + ((C * (9/5)) + 32) + " °F");
                }
                case 2 -> {
                    System.out.println("Ingrese la temperatura en °F: ");
                    double F = sc.nextDouble();
                    sc.nextLine();
                    System.out.println(F + "°F = " + (F - 32) * (5/9) + " °C");
                }
            }
        sc.nextLine();

        System.out.println("-----  Punto 15  -----");
            var status = "";
            int nota = 0;
            System.out.println("Ingrese la nota de su examen (0-100)");
            nota = sc.nextInt();
            sc.nextLine();
            do {
                if (nota >= 90 && nota <= 100) {
                    status = "A";
                } else if (nota <= 89 && nota >= 80) {
                    status = "B";
                } else if (nota <= 79 && nota >= 70) {
                    status = "C";
                } else if (nota <= 69 && nota >= 60) {
                    status = "D";
                } else if (nota <= 59 && nota >= 50) {
                    status = "E";
                } else {
                    status = "F";
                }
            } while (nota < 100 && nota >= 0);
            System.out.println("STATUS: " + status);
        sc.nextLine();

        sc.close(); //Para cerrar el recurso
    }
}
