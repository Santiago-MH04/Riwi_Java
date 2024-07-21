package Taller4_19Julio2024.Punto2;

import java.time.LocalDate;

public class EmpleadoTemporal extends Empleado{
        //Atributos de EmpleadoTemporal
    private static final String CONTRATO_TEMPORAL = "6 meses, que incluyen un período de prueba de 2 meses";

        //Constructores de EmpleadoTemporal
    public EmpleadoTemporal() {
    }
    public EmpleadoTemporal(LocalDate dob, String name, double salary) {
        super(dob, name, salary);
    }

        //Asignadores de atributos de EmpleadoTemporal (setters)
    @Override
    public void setId(String id) {
        super.setId(id);
    }
        @Override
        public void setName(String name) {
            super.setName(name);
        }

        //Lectores de atributos de EmpleadoTemporal (getters)
    /*Se van a instanciar*/

        //Métodos de EmpleadoTemporal
    @Override
    public String definirContrato() {
        return "Carácter: este contrato dura " + CONTRATO_TEMPORAL;
    }
    @Override
    public String toString(){
        return super.toString().concat("\n").concat(this.definirContrato());
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        } else if(obj instanceof EmpleadoTemporal){
            EmpleadoTemporal temp = (EmpleadoTemporal) obj;
            return this.getId().equals(temp.getId()) && this.getName().equals(temp.getName()) && this.getSalary() == temp.getSalary();
        } else {
            return false;
        }
    }
}
