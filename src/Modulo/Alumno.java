package Modulo;

/**
 *
 * @author Cristian Xool
 * 
 * Clase objeto que describe los atributos de los alumnos.
 * 
 */
public class Alumno {

    public Alumno(String matricula, String nombre, String apellidos) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Alumno() {
        
    }

    public void SetNombre(String nombre) {
        this.nombre = nombre;
    }

    public void SetApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void SetMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String GetNombre() {
        return nombre;
    }

    public String GetApellidos() {
        return apellidos;
    }

    public String GetMatricula() {
        return matricula;
    }
    
    private String matricula;
    private String nombre; 
    private String apellidos; 
    
}
