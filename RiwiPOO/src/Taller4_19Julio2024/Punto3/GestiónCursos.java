package Taller4_19Julio2024.Punto3;

import java.util.ArrayList;
import java.util.List;

public class GestiónCursos {
        //Atributos de GestiónCursos
    private List<Curso> cursos;

        //Constructores de GestiónCursos
    public GestiónCursos() {
        this.cursos = new ArrayList<>();
    }

    //Asignadores de atributos de GestiónCursos (setters)
        //Lectores de atributos de GestiónCursos (getters)
    public List<Curso> getCursos() {
        return this.cursos;
    }

        //Métodos de GestiónCursos
    public GestiónCursos addCurso(Curso c) {
        this.cursos.add(c);
        return this;
    }

    public void removeCurso(Curso curso) {
        this.cursos.remove(curso);
    }

    public void matricularEstudiante(Estudiante e, Curso c) {
        if(this.cursos.contains(c) && !c.getEstudiantes().contains(e)) {
            c.addEstudiante(e);
            System.out.println("El estudiante " + e.getNombre() + " ha sido registrado en el curso " + c.getNombre());
        } else {
            System.out.println("El estudiante " + e.getNombre() + " ya se encuentra registrado en el curso " + c.getNombre());
        }
    }

    public void removerEstudiante(Estudiante e, Curso c) {
        if(this.cursos.contains(c) && c.getEstudiantes().contains(e)) {
            c.removeEstudiante(e);
            System.out.println("El estudiante " + e.getNombre() + " ha sido dado de baja del curso " + c.getNombre());
        } else {
            System.out.println("El estudiante " + e.getNombre() + " no estaba registrado en el curso " + c.getNombre());
        }
    }

    public void listarCurso(Curso c) {
        if(this.cursos.contains(c) && c.getEstudiantes().size() > 0) {
            System.out.println(c);
        } else if(!this.cursos.contains(c) && c.getEstudiantes().size() == 0) {
            System.out.println("El curso " + c.getNombre() + " no tiene ningún estudiante matriculado");
        } else if (!this.cursos.contains(c)) {
            System.out.println("El curso " + c.getNombre() + " no está registrado en esta escuela");
        }
    }

    public void listarEstudiantes(Curso c) {
        if(this.cursos.contains(c) && c.getEstudiantes().size() > 0) {
            System.out.println(c.listarEstudiantes());
        } else if(!this.cursos.contains(c) && c.getEstudiantes().size() == 0) {
            System.out.println("El curso " + c.getNombre() + " no tiene ningún estudiante matriculado");
        } else if (!this.cursos.contains(c)) {
            System.out.println("El curso " + c.getNombre() + " no está registrado en esta escuela");
        }
    }

}
