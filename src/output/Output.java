package output;

import model.Alumno;
import model.Asignatura;

import java.util.List;

public class Output {
    public void mostrarMenu() {
        System.out.println("\n=== Sistema de Gestión de Alumnos ===");
        System.out.println("1. Alta de Alumnos");
        System.out.println("2. Baja de Alumno");
        System.out.println("3. Modificar Nota");
        System.out.println("4. Mostrar Listado");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarListaEstudiante(List<Alumno> alumnos) {
        if (alumnos.isEmpty()) {
            System.out.println("\nNo hay Alumnos registrados en el sistema.");
            return;
        }

        System.out.println("\n=== Listado de Alumnos ===");
        System.out.printf("%-5s\t%-20s\t%-25s\t%-25s%n", "Id", "Nombre Completo", "Asignatura 1 (nota)", "Asignatura2 (nota)");
        System.out.println("--------------------------------------------------------------------------------");
        for (Alumno alumno : alumnos) {
            String materia1 = alumno.getAsignaturas().size() > 0 ? alumno.getAsignaturas().get(0).toString() : "N/A";
            String materia2 = alumno.getAsignaturas().size() > 1 ? alumno.getAsignaturas().get(1).toString() : "N/A";
            System.out.printf("%-5s\t%-20s\t%-25s\t%-25s%n",
                    alumno.getId(),
                    alumno.getNombreCompleto(),
                    materia1,
                    materia2);
        }
    }

    public void mensajeError(String mensaje) {
        System.out.println("Error: " + mensaje);
    }

    public void mensajeExito(String mensaje) {
        System.out.println(mensaje);
    }
}
