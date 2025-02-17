package create;

import model.Asignatura;
import model.Alumno;
import input.Input;
import output.Output;

import java.util.List;

public class CrearAlumno {
    private List<Alumno> alumnos;
    private Input input;
    private Output output;

    public CrearAlumno(List<Alumno> alumnos, Input input, Output output) {
        this.alumnos = alumnos;
        this.input = input;
        this.output = output;
    }

    public void crearAlumnos() {
        System.out.println("\n=== Registro de Alumnos ===");
        for (int i = 0; i < 2; i++) {
            System.out.println("\nIntroduciendo datos del alumno " + (i + 1));

            int id = input.leerId(alumnos);
            String nombreCompleto = input.leerNombreCompleto();
            int edad = input.leerEdad();
            String fechaNacimiento = input.leerFechaNacimiento();

            Alumno alumno = new Alumno(id, nombreCompleto, edad, fechaNacimiento);

            System.out.println("\nAhora ingrese las 2 asignaturas del alumno:");
            for (int j = 0; j < 2; j++) {
                Asignatura asignatura = input.leerAsignatura(j + 1);
                alumno.agregarAsignatura(asignatura);
            }

            alumnos.add(alumno);
            output.mensajeExito("\nAlumno registrado correctamente");
        }
    }
}
