package Taller4_19Julio2024.Punto2;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
        //Atributos de Persona
    private String name;
    private LocalDate dateOfBirth;

        //Constructores de Persona
    public Persona() {
    }
    public Persona(LocalDate date, String name) {
        this.dateOfBirth = date;
        this.name = name;
    }

        //Asignadores de atributos de Persona (setters)
    public void setName(String name) {
        this.name = name;
    }

        //Lectores de atributos de Persona (getters)
    public int getAge() {
        LocalDate now = LocalDate.now();
        Period timeElapsed = Period.between(this.dateOfBirth, now);
        return timeElapsed.getYears();
    }
        public String getName() {
            return name;
        }

        //Métodos de Persona
    @Override
    public String toString() {
        return "Nombre: " + this.name + ". Edad: " + this.getAge() + " años";
    }
}
