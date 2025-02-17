package delete;

import model.Alumno;
import input.Input;
import output.Output;
import read.LeerAlumno;

import java.util.List;

public class BorrarAlumno {
    private List<Alumno> alumnos;
    private Output output;
    private Input input;
    private LeerAlumno leerAlumno;

    public BorrarAlumno(List<Alumno> alumnos, Input input, Output output, LeerAlumno leerAlumno) {
        this.alumnos = alumnos;
        this.output = output;
        this.input = input;
        this.leerAlumno = leerAlumno;
    }

    public void borrarAlumno() {
        if (!leerAlumno.hayAlumnos()) {
            output.mensajeError("No Hay alumnos registrados en el sistema");
            return;
        }

        System.out.println("\n=== Baja de Alumno ===");
        leerAlumno.mostrarTodosAlumnos();

        int id = input.LeerIdAlumno();
        boolean borrar = alumnos.removeIf(alumno -> alumno.getId() == id);

        if (borrar) {
            output.mensajeExito("Alumno eliminado correctamente");
        } else {
            output.mensajeError("No se encontró ningun alumno con ese ID");
        }
    }
}
