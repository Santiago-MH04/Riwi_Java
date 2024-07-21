package Taller2_11Julio2024;

public class Puntos7y8 {
    public static void main(String[] args) {
            //Se instancia la matriz
        int[][] m1 = new int[3][3];

        //Crear una matriz de ejemplo
            //Fila 1
        m1[0][0] = 1;
        m1[0][1] = 2;
        m1[0][2] = 3;
            //Fila 2
        m1[1][0] = 4;
        m1[1][1] = 5;
        m1[1][2] = 6;
            //Fila 3
        m1[2][0] = 7;
        m1[2][1] = 8;
        m1[2][2] = 9;

            //Transponer la matriz
        int[][] traspuesta = transponer(m1);
            System.out.println("Matriz original");
        imprimirMatriz(m1);
            System.out.println();
            System.out.println("Matriz transpuesta");
        imprimirMatriz(traspuesta);
        comparar(traspuesta,m1);
    }

    public static int[][] transponer(int[][] m1) {
        int filas = m1.length;
        int columnas = m1[0].length;
        int[][] transpuesta = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = m1[i][j];
            }
        }
        return transpuesta;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }

    public static void comparar(int[][] traspuesta, int[][] matriz){
        boolean status = true;
        for (int i = 0; i<matriz.length;i++){
            for (int j = 0; j<matriz[0].length;j++){
                if (!(matriz[i][j]==traspuesta[i][j])){
                    status = false;
                }
            }
        }
        if (status){
            System.out.println("La matriz es simétrica");
        } else{
            System.out.println("La matriz no es simétrica");
        }
    }
}
