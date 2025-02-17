package input;

import model.Alumno;
import model.Asignatura;

import java.util.Scanner;
import java.util.List;

public class Input {
    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public int leerId(List<Alumno> alumnoExistente) {
        int id;
        boolean esValido;

        do {
            System.out.print("ID único: ");
            String input = "";
            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
            } else {
                return -1;
            }
            id = -1;
            esValido = false;

            if (!input.matches("\\d+")) {
                System.out.println("El ID debe ser un número positivo");
                continue;
            }

            id = Integer.parseInt(input);
            if (id <= 0) {
                System.out.println("El ID ya existe, por favor ingrese in ID único");
                continue;
            }

            final int finalId = id;
            if (alumnoExistente.stream().anyMatch(s -> s.getId() == finalId)) {
                System.out.println("Error: El ID ya esxiste, ingrese un ID único");
                continue;
            }

            esValido = true;
        } while (!esValido);

        return id;
    }

    public String leerNombreCompleto() {
        System.out.print("Nombre Completo: ");
        String nombreCompleto = scanner.nextLine();
        if (nombreCompleto.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío");
            return leerNombreCompleto();
        }
        return nombreCompleto;
    }

    public int leerEdad() {
        int edad;
        boolean esEdadValida;

        do {
            System.out.print("Edad: ");
            String input = "";
            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
            } else {
                return -1;
            }
            edad = -1;
            esEdadValida = false;

            if (!input.matches("\\d+")) {
                System.out.println("Ingrese un número válido");
                continue;
            }

            edad = Integer.parseInt(input);
            if (edad <= 16 || edad > 90) {
                System.out.println("La edad debe estar entre 16 y 90 años");
                continue;
            }

            esEdadValida = true;
        } while (!esEdadValida);

        return edad;
    }

    public String leerFechaNacimiento() {
        System.out.println("Fecha de Nacimiento:");
        System.out.print("Día (1-31): ");
        int dia = Integer.parseInt(scanner.nextLine());
        System.out.print("Mes (1-12): ");
        int mes = Integer.parseInt(scanner.nextLine());
        System.out.print("Año (AAAA): ");
        int anio = Integer.parseInt(scanner.nextLine());

        if (dia < 1 || dia > 31 || mes < 1 || mes > 12) {
            System.out.println("Fecha inválida");
        }
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }

    public Asignatura leerAsignatura(int numeroAsignatura) {
        String nombreAsignatura = "";
        double nota = -1;
        boolean esAsignaturaValida;

        do {
            System.out.printf("Nombre de la asignatura %d: ", numeroAsignatura);
            if (scanner.hasNextLine()) {
                nombreAsignatura = scanner.nextLine();
            } else {
                return null;
            }

            if (nombreAsignatura.trim().isEmpty()) {
                System.out.println("Nombre de la asignatura no puede estar vacío");
                esAsignaturaValida = false;
                continue;
            }
            System.out.printf("Nota de la primera evaluacionpara %s (0-10): ", nombreAsignatura);
            String notaInput = "";
            if (scanner.hasNextLine()) {
                notaInput = scanner.nextLine();
            } else {
                return null;
            }

            if (!notaInput.matches("\\d*\\.?\\d+")) {
                System.out.println("Ingrese un número válido");
                esAsignaturaValida = false;
                continue;
            }

            nota = Double.parseDouble(notaInput);
            if (nota < 0 || nota > 10) {
                System.out.println("La nota debe estar entre 0 y 10");
                esAsignaturaValida = false;
                continue;
            }

            esAsignaturaValida = true;
        } while (!esAsignaturaValida);

        return new Asignatura(nombreAsignatura, nota);
    }

    public int LeerIdAlumno() {
        System.out.print("\nIntroduce el ID del alumno: ");
        String in = "";
        if (scanner.hasNextLine()) {
            in = scanner.nextLine();
        }
        if (!in.matches("\\d+")) {
            System.out.println("Ingrese un numero válido");
            return LeerIdAlumno();
        }
        return Integer.parseInt(in);
    }

    public double leerNuevaNota() {
        double nuevaNota = -1;
        boolean esNotaValida;
        do {
            System.out.print("Introcude la nueva nota para la primera asignatura (0-10): ");
            String input = scanner.nextLine();
            esNotaValida = input.matches("\\d*\\.?\\d+");

            if (!esNotaValida) {
                System.out.println("Ingrese un número válido");
                continue;
            }

            nuevaNota = Double.parseDouble(input);
            if (nuevaNota < 0 || nuevaNota > 10) {
                System.out.println("La nota debe estar entre 0 y 10");
                esNotaValida = false;
            } else {
                esNotaValida = true;
            }
        } while (!esNotaValida);
        return nuevaNota;
    }
}