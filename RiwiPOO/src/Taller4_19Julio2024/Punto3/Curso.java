package Taller4_19Julio2024.Punto3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.StringTemplate.STR;

public class Curso {
        //Atributos de Curso
    private String codigo;
    private String nombre;
    private List<Estudiante> estudiantes;

    private static int id = 2024;   //Elegí el 2024 porque ajá

        //Constructores de Curso
    public Curso() {
        ++id;
        this.codigo = Integer.toHexString(id);  //Para la generación de un código para el curso
        this.estudiantes = new ArrayList<>();
    }
    public Curso(String nombre) {
        this();
        this.nombre = nombre;
    }

        //Asignadores de atributos de Curso (setters)
    public void setCodigo(String codigo) {
        this.codigo = codigo;   //Se genera automáticamente, pero si el usuario le desea asignar uno manualmente, no problemo
    }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        //Lectores de atributos de Curso (getters)
    public String getCodigo() {
        return this.codigo;
    }
        public String getNombre() {
            return this.nombre;
        }
            public List<Estudiante> getEstudiantes() {
                return this.estudiantes;
            }

        //Métodos de Curso

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(codigo, curso.codigo) && Objects.equals(nombre, curso.nombre);
    }

    @Override
    public String toString() {
        return STR."[Código: \{this.codigo}\{'\n'}Nombre asignatura: \{this.nombre}\{'\n'}Este curso tiene \{this.getEstudiantes().size()} estudiantes matriculados]";
    }
    public Curso addEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
        return this;
    }
    public void removeEstudiante(Estudiante estudiante) {
        this.estudiantes.remove(estudiante);    //Se hizo necesaria la implementación del método equals
    }

    public String listarEstudiantes() {
        return this.estudiantes.stream()
                .map(Estudiante::toString)
                /*.map(e -> e.getNombre() + " " + e.getEmail())*/   //Ejemplo de prueba
                .reduce("Estudiantes matriculados en "+ this.getNombre() + ": ", (a, b) -> a + "\n" + b);
    }
}
