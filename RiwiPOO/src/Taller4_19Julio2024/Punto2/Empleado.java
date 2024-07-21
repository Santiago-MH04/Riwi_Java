package Taller4_19Julio2024.Punto2;

import java.time.LocalDate;

public abstract class Empleado extends Persona{
        //Atributos de Empleado
    private String id;
        private static int lastID = 0;  //Para generar IDs de empleados de manera autoincremental
    private double salary;
    private String Contrato;
    
        //Constructores de Empleado
    public Empleado() {
    }
    public Empleado(LocalDate dob, String name, double salary) {
        super(dob, name);
        this.id = String.valueOf(++lastID);
        this.salary = salary;
    }

        //Asignadores de atributos de Empleado (setters)
    public void setId(String id) {
        this.id = id;
    }   //Puede ser autoincremental o asignado
        public void setSalary(double salary) {
        this.salary = salary;
    }

        //Lectores de atributos de Empleado (getters)
    public String getId() {
        return this.id;
    }
        public double getSalary() {
            return this.salary;
        }

        //Métodos de Empleado
    public abstract String definirContrato();

    @Override
    public String toString() {
        return super.toString() + ". ID empleado: " + this.id + ". Salario: USD$" + this.salary;
    }
}
