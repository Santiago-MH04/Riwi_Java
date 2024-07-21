package Taller4_19Julio2024.Punto2;

import java.time.LocalDate;

public class EmpleadoPermanente extends Empleado{
        //Atributos de EmpleadoPermanente
    private static final String CONTRATO_INDEFINIDO = "indefinido, se termina de manera unilateral o bilateral.";

        //Constructores de EmpleadoPermanente
    public EmpleadoPermanente() {
    }
    public EmpleadoPermanente(LocalDate dob, String name, double salary) {
        super(dob, name, salary);
    }

        //Asignadores de atributos de EmpleadoPermanente (setters)
    @Override
    public void setId(String id) {
        super.setId(id);
    }
        @Override
        public void setName(String name) {
            super.setName(name);
        }

        //Lectores de atributos de EmpleadoPermanente (getters)
    /*Se van a instanciar*/

        //Métodos de EmpleadoPermanente
    @Override
    public String definirContrato() {
        return "Carácter: este contrato es a término " + CONTRATO_INDEFINIDO;
    }
    @Override
    public String toString(){
        return super.toString().concat("\n").concat(this.definirContrato());
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        } else if(obj instanceof EmpleadoPermanente){
            EmpleadoPermanente perm = (EmpleadoPermanente) obj;
            return this.getId().equals(perm.getId()) && this.getName().equals(perm.getName()) && this.getSalary() == perm.getSalary();
        } else {
            return false;
        }
    }
}
