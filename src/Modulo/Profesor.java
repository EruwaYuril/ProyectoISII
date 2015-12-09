package Modulo;

/**
 *
 * @author Cristian Xool
 * 
 * Clase objeto que descrire los atributos de los profesores.
 * 
 */
public class Profesor {

    public Profesor(String clave, String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.clave = clave;
    }
    
    public Profesor(){
        
    }

    public void SetNombre(String nombre) {
        this.nombre = nombre;
    }

    public void SetApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void SetClave(String clave) {
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
    
    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
     
    private String clave;
    private String nombre; 
    private String apellidos; 
}
