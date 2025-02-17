package update;

import model.Alumno;
import input.Input;
import output.Output;
import read.LeerAlumno;

import java.util.List;

public class ActualizarAlumno {
    private List<Alumno> alumnos;
    private Input input;
    private Output output;
    private LeerAlumno leerAlumno;

    public ActualizarAlumno(List<Alumno> alumnos, Input input, Output output, LeerAlumno leerAlumno) {
        this.alumnos = alumnos;
        this.input = input;
        this.output = output;
        this.leerAlumno = leerAlumno;
    }

    public void actualizadorNotaAlumno() {
        if (!leerAlumno.hayAlumnos()) {
            output.mensajeError("No hay alumnos registrados en el sistema");
            return;
        }
        System.out.println("\n=== Modificación de Nota ===");
        leerAlumno.mostrarTodosAlumnos();

            int id = input.LeerIdAlumno();
            for (Alumno alumno : alumnos) {
                if (alumno.getId() == id) {
                    double nuevaNota = input.leerNuevaNota();
                    alumno.actualizarPrimeraAsignaturaNota(nuevaNota);
                    output.mensajeExito("Nota actualizada correctamente");
                    return;
                }
            }
            output.mensajeError("Alumno no encontrado");
    }
}
