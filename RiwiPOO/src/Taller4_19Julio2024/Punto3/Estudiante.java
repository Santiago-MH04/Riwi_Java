package Taller4_19Julio2024.Punto3;

import java.util.Objects;

public class Estudiante {
        //Atributos de Estudiante
    private static int id;
    private String nombre;
    private String email;

        //Constructores de Estudiante
    public Estudiante() {
        this.id = ++this.id; //Para la generación autoincremental de ids
    }

    public Estudiante(String nombre, String email) {
        this();
        this.nombre = nombre;
        this.email = email;
    }

        //Asignadores de atributos de Estudiante (setters)
    public static void setId(int id) {
        Estudiante.id = id;
    }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
            public void setEmail(String email) {
                this.email = email;
            }

        //Lectores de atributos de Estudiante (getters)
    public static int getId() {
        return id;
    }   //Así, y no con this, debido a que es un atributo estático
        public String getNombre() {
            return this.nombre;
        }
            public String getEmail() {
                return this.email;
            }

        //Métodos de Estudiante
    @Override
    public String toString() {
        return "Estudiante -> " +
                "ID: " + this.nombre +
                ". Nombre: " + this.nombre +
                ". Correo: " + this. email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(email, that.email);
    }
}
