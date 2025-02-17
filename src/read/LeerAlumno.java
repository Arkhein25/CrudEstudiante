package read;
import model.Alumno;
import output.Output;
import java.util.List;

public class LeerAlumno {
    private List<Alumno> alumnos;
    private Output output;

    public LeerAlumno(List<Alumno> alumnos, Output output){
        this.alumnos=alumnos;
        this.output=output;
    }

    public void mostrarTodosAlumnos(){
        output.mostrarListaEstudiante(alumnos);
    }

    public boolean hayAlumnos(){
        return !alumnos.isEmpty();
    }
}
