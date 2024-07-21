package Taller3_16Julio2024;

import java.util.Scanner;

public class EjercicioEmpleadosMatrizTridimensional {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //------------------------Creación de la matriz--------------------------------------
            System.out.println("Ingrese la cantidad de empleados del taller");
            int empleados = scanner.nextInt();
            scanner.nextLine(); //Refrescar el scanner

            System.out.println("Ingrese la cantidad de trabajos");
            int trabajos = scanner.nextInt();
            scanner.nextLine();

                //Crear cinco columnas, tiro ingenieril
            String[][][] data = new String[empleados][2][5];

            if (trabajos > empleados){
                return;
            }

        //---------------Poblar la matriz---------------------------------

        for (int i = 0; i< trabajos;i++) {
            System.out.println("Ingrese el nombre del " + (i + 1) + "° empleado");
            String empleado = scanner.nextLine();

                //Ingresar el empleado en la fila de carros y motos
            data[i][0][0] = empleado;
            data[i][1][0] = empleado;

            System.out.print("Ingrese el tipo de vehículo (moto/carro): ");
            String tipo = scanner.nextLine().toLowerCase();
            int type = tipo.equals("moto") ? 0 : 1;

            System.out.print("Ingrese la marca: ");
            String brand = scanner.nextLine().toLowerCase();

            System.out.print("Ingrese el modelo: ");
            String model = scanner.nextLine().toLowerCase();

            System.out.print("Ingrese el año: ");
            String year = scanner.nextLine().toLowerCase();

            System.out.print("Ingrese el estado (pendiente/ en reparación/ reparado): ");
            String status = scanner.nextLine().toLowerCase();

                //Ingresar los datos en la matriz
            data[i][type][1] = brand;
            data[i][type][2] = model;
            data[i][type][3] = year;
            data[i][type][4] = status;
        }

        //--------------------Menú----------------------------
        boolean menu = true;
        do{
            System.out.println("Ingrese una opcion");
            System.out.println("1. listar  2. ver por estado  3. buscar  4. modificar  5. salir");
            int op = scanner.nextInt();

            switch (op){
                case 1 -> listar(trabajos, data);
                case 2 -> unidades(trabajos, data);
                case 3 -> buscar(trabajos, data);
                case 4-> modificar(trabajos, data);
                case 5 -> menu = false;
                default -> System.out.println("Ingrese una opcion valida");
            }
        }   while (menu);
    }

            //Método que lista los vehículos
        public static void listar(int trabajos, String[][][] data){
            System.out.println("Lista de automotores");
            for (int i = 0; i < trabajos; i++){
                for (int j = 0; j < 2; j++){
                    if (data[i][j][1] != null){
                        System.out.println("Mecánico: "+data[i][j][0]);
                        System.out.println("Tipo: " + (j == 0 ? "moto" : "carro"));
                        System.out.println("Marca: " + data[i][j][1]);
                        System.out.println("Modelo: " + data[i][j][2]);
                        System.out.println("Año: " + data[i][j][3]);
                        System.out.println("Estado: "+data[i][j][4]);
                    }
                }
            }
        }

            //Método que cuenta la cantidad de vehículos en cada estada
        public static void unidades(int trabajos, String[][][] data) {
            int pendiente = 0;
            int reparacion = 0;
            int reparado = 0;

            System.out.println("Contador de automotores");
            for (int i = 0; i < trabajos; i++) {
                for (int j = 0; j < 2; j++) {
                    if (data[i][j][1] != null) {
                        if (data[i][j][4].equals("pendiente")) {
                            pendiente++;
                        } else if (data[i][j][4].equals("en reparacion")) {
                            reparacion++;
                        } else {
                            reparado++;
                        }
                    }
                }
            }
            System.out.println("Pendientes: " + pendiente + ". En reparación: " + reparacion + ". Reparados: " + reparado);
        }

            //Método para obtener un vehículo en particular
        public static void buscar(int trabajos, String[][][] data){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Buscar vehículo por marca y modelo");
            System.out.print("Ingrese la marca del vehículo a buscar: ");
            String marcaBuscar = scanner.nextLine().toLowerCase();
            System.out.print("Ingrese el modelo del vehículo a buscar: ");
            String modeloBuscar = scanner.nextLine().toLowerCase();
            boolean estado = false;

            for (int i = 0; i<trabajos; i++) {
                for (int j = 0; j < 2; j++) {
                    if (data[i][j][1] != null) {
                        if (data[i][j][1].equals(marcaBuscar) && data[i][j][2].equals(modeloBuscar)){
                            estado = true;
                        }
                    }
                }
            }
            if (estado){
                System.out.println("Vehículo hallado");
            }else {
                System.out.println("Vehículo no hallado");
            }
        }

            //Método para modificar algún registro
        public static void modificar(int trabajos, String[][][] data){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Modificar el estado de algún vehículo");
            System.out.print("Ingrese la marca del vehículo: ");
            String marcaBuscar1 = scanner.nextLine().toLowerCase();
            System.out.print("Ingrese el modelo del vehículo: ");
            String modeloBuscar1 = scanner.nextLine().toLowerCase();
            System.out.println("Ingrese el nuevo estado (pendiente/ en reparación/ reparado): ");
            String newStatus = scanner.nextLine();

            for (int i = 0; i < trabajos; i++) {
                for (int j = 0; j < 2; j++) {
                    if (data[i][j][1] != null) {
                        if (data[i][j][1].equals(marcaBuscar1) && data[i][j][2].equals(modeloBuscar1)){
                            data[i][j][4] = newStatus;
                        } else {
                            System.out.println("Vehiculo no encontrado");
                        }
                    }
                }
            }
        }
    }
