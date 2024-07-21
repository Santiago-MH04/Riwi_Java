package Taller4_19Julio2024.Punto3;

public class main {
    public static void main(String[] args) {
            //Crear una instancia de GestiónCursos
        GestiónCursos Escuela = new GestiónCursos();

            //Crear unos cuantos cursos, para agregarlos a la oferta de la escuela
        Curso finanzas = new Curso("Finanzas");
        Curso música = new Curso("Música");
        Curso gimnasia = new Curso("Gimnasia");
        Curso cocina = new Curso("Cocina");
            //Crear un curso al que no se va a matricular ningún estudiante
        Curso origami = new Curso("Origami");
            //Crear un curso, pero que no va a ofertar la escuela
        Curso carpintería = new Curso("Carpintería");

            //Crear unos cuantos estudiantes
        Estudiante student1 = new Estudiante("Pepito Pérez", "pepito.perez@escuela.edu.co");
        Estudiante student2 = new Estudiante("Fulanito de Tal", "fulanito.tal@escuela.edu.co");
        Estudiante student3 = new Estudiante("Dora la Exploradora", "dora.exploradora@escuela.edu.co");
        Estudiante student4 = new Estudiante("Anita la Huerfanita", "anita.huerfanita@escuela.edu.co");

            //Inscribir los cursos a la escuela
        Escuela.addCurso(finanzas).addCurso(música).addCurso(gimnasia).addCurso(cocina).addCurso(origami);

            //Matricular a cada estudiante en dos cursos, porque ajá, la verdad
                //A student1
        Escuela.matricularEstudiante(student1, finanzas);
        Escuela.matricularEstudiante(student1, cocina);
                //A student2
        Escuela.matricularEstudiante(student2, música);
        Escuela.matricularEstudiante(student2, gimnasia);
                //A student3
        Escuela.matricularEstudiante(student3, finanzas);
        Escuela.matricularEstudiante(student3, gimnasia);
                //A student4
        Escuela.matricularEstudiante(student4, música);
        Escuela.matricularEstudiante(student4, cocina);

            //Listar los cursos de la escuela, donde muestre que los cursos de carpintería y origami no están ofertados ni matriculados, respectivamente
        Escuela.listarCurso(finanzas);
            System.out.println();
        Escuela.listarCurso(música);
            System.out.println();
        Escuela.listarCurso(gimnasia);
            System.out.println();
        Escuela.listarCurso(cocina);
            System.out.println();
                //En estos dos cursos va a decir que no tienen ningún estudiante, y que no están ofertados, respectivamente
        Escuela.listarCurso(origami);
            System.out.println();
        Escuela.listarCurso(carpintería);

            //Listar los estudiantes por curso antes de dar de baja a alguno de ellos
        System.out.println("Antes de dar de baja a algún estudiante");
        Escuela.listarEstudiantes(finanzas);
            System.out.println();
        Escuela.listarEstudiantes(música);
            System.out.println();
        Escuela.listarEstudiantes(gimnasia);
            System.out.println();
        Escuela.listarEstudiantes(cocina);

            //Listar los estudiantes por curso después de dar de baja a alguno de ellos
        System.out.println("Después de dar de baja a algún estudiante");
        Escuela.removerEstudiante(student1, finanzas);
        Escuela.listarEstudiantes(finanzas);
            System.out.println();
        Escuela.removerEstudiante(student2, música);
        Escuela.listarEstudiantes(música);
            System.out.println();
        Escuela.removerEstudiante(student3, gimnasia);
        Escuela.listarEstudiantes(gimnasia);
            System.out.println();
        Escuela.removerEstudiante(student4, cocina);
        Escuela.listarEstudiantes(cocina);
    }
}
