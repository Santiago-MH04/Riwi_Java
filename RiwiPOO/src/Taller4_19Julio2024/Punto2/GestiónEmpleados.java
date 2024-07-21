package Taller4_19Julio2024.Punto2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestiónEmpleados {
        //Atributos de GestiónEmpleados
    List<Empleado> empleados;

        //Constructores de GestiónEmpleados
    public GestiónEmpleados() {
        this.empleados = new ArrayList<>();
    }

    //Asignadores de atributos de GestiónEmpleados (setters)
    //Lectores de atributos de GestiónEmpleados (getters)
    public List<Empleado> getEmpleados() {
        return this.empleados;
    }
            //Métodos de GestiónEmpleados
    public void addEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
    }
    public void removeEmpleado(Empleado empleado) {
        this.empleados.remove(empleado);
    }
    public void listarEmpleados() {
        this.empleados.forEach(System.out::println);
    }
    public Optional<Empleado> buscarEmpleado(String id) {
        if(this.empleados.isEmpty()) {
            return Optional.empty();
        }
        return this.empleados.stream()
                .filter(empleado -> empleado.getId().equals(id))
                .findFirst();
    }
}
