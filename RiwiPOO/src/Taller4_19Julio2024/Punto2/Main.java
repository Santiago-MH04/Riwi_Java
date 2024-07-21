package Taller4_19Julio2024.Punto2;

import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
            //Crear unos cuantos empleados
        Empleado ingeniero = new EmpleadoPermanente(LocalDate.of(1980, 06, 24), "Pepito Pérez", 13000D);
        Empleado operario = new EmpleadoPermanente(LocalDate.of(1965, 12, 19), "Fulanito de Tal", 4000D);
        Empleado practicante = new EmpleadoTemporal(LocalDate.of(1997, 04, 04), "Quesocolo Torombolo", 2500D);
        Empleado secretaria = new EmpleadoTemporal(LocalDate.of(1994, 04, 28), "Anita la Huerfanita", 3000D);

            //Crear una instancia de GestiónEmpleados
        GestiónEmpleados Empresa = new GestiónEmpleados();

            //Añadir los empleados a la lista
        Empresa.addEmpleado(ingeniero);
        Empresa.addEmpleado(operario);
        Empresa.addEmpleado(practicante);
        Empresa.addEmpleado(secretaria);

            //Listar los empleados
        System.out.println("---------- Lista de empleados ----------");
        Empresa.listarEmpleados();
        System.out.println();

            //Modificar el salario de algunos de ellos
        practicante.setSalary(3500D);
        operario.setSalary(6000D);
                //Listar los empleados
        System.out.println("---------- Lista de empleados después de cambiar algunos salarios ----------");
        Empresa.listarEmpleados();
        System.out.println();

            //Buscar algún empleado
        /*String idBuscar = operario.getId();*/ //De aquí supe que el id del operario es 2, como hay cuatro empleados, el id 5 no existe, vamos a buscar los dos
        String IDBuscar1 = "2";
        String IDBuscar2 = "5";
        Optional<Empleado> busquemosEmpleado1 = Empresa.buscarEmpleado(IDBuscar1);
        Optional<Empleado> busquemosEmpleado2 = Empresa.buscarEmpleado(IDBuscar2);
                //Este lo debe encontrar
        if(busquemosEmpleado1.isPresent()){
            System.out.println(busquemosEmpleado1.get());
        } else if(!busquemosEmpleado1.isPresent()){
            System.out.println("El empleado con id" + IDBuscar1 + " no existe en nuestros registros");
        }
                //Este no lo debe encontrar
        if(busquemosEmpleado2.isPresent()){
            System.out.println(busquemosEmpleado2.get());
        } else if(!busquemosEmpleado2.isPresent()){
            System.out.println("El empleado con id" + IDBuscar2 + " no existe en nuestros registros");
        }
        System.out.println();

            //Eliminar un empleado
        Empresa.removeEmpleado(ingeniero);
                //Listar los empleados
        System.out.println("---------- Lista de empleados después de que se jubilara el ingeniero ----------");
        Empresa.listarEmpleados();
        System.out.println();
    }
}
