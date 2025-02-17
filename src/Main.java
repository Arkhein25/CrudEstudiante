import java.util.ArrayList;
import java.util.Scanner;

import input.Input;
import model.Alumno;
import output.Output;
import create.CrearAlumno;
import read.LeerAlumno;
import update.ActualizarAlumno;
import delete.BorrarAlumno;

public class Main {
    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        Input input = new Input();
        Output output = new Output();

        LeerAlumno leerAlumno = new LeerAlumno(alumnos, output);
        CrearAlumno crearAlumno = new CrearAlumno(alumnos, input, output);
        ActualizarAlumno actualizarAlumno = new ActualizarAlumno(alumnos, input, output, leerAlumno);
        BorrarAlumno borrarAlumno = new BorrarAlumno(alumnos, input, output, leerAlumno);

        Scanner scanner = new Scanner(System.in);
        boolean encurso = true;

        while (encurso) {
            output.mostrarMenu();
            String sc = "";

            if (scanner.hasNextLine()) {
                sc = scanner.nextLine().trim();
            } else {
                break;
            }

            if (sc.isEmpty()) {
                output.mensajeError("Ingrese una opción válida");
                continue;
            }
            if (!sc.matches("\\d+")) {
                output.mensajeError("Ingrese un numero válido");
                continue;
            }
            int opcion = Integer.parseInt(sc);
            switch (opcion) {
                case 1:
                    crearAlumno.crearAlumnos();
                    break;
                case 2:
                    borrarAlumno.borrarAlumno();
                    break;
                case 3:
                    actualizarAlumno.actualizadorNotaAlumno();
                    break;
                case 4:
                    leerAlumno.mostrarTodosAlumnos();
                    break;
                case 5:
                    encurso = false;
                    output.mensajeExito("Gracias por usar el sistema");
                    break;
                default:
                    output.mensajeError("Opcion no válida.");
            }

        }
        scanner.close();
    }
}
