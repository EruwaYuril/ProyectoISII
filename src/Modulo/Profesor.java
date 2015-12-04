package Modulo;

/**
 *
 * @author Cristian Xool
 * 
 * Clase objeto que descrire los atributos de los profesores.
 * 
 */
public class Profesor {
    
    private String nombre; 
    private String apellidos; 
    private String clave;

    public Profesor(String nombre, String apellidos, String clave) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.clave = clave;
    }

    public void SetNombre(String nombre) {
        this.nombre = nombre;
    }

    public void SetApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void SetClaveProfesor(String clave) {
        this.clave = clave;
    }

    public String GetNombre() {
        return nombre;
    }

    public String GetApellidos() {
        return apellidos;
    }

    public String GetClave() {
        return clave;
    }
}
