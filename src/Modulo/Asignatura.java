package Modulo;

/**
 *
 * @author Cristian Xool
 * 
 * Clase objeto que describre los atributos de las asignaturas.
 * 
 */
public class Asignatura {
    
    private String nombre;
    private String clave;

    public Asignatura(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }
    
    public Asignatura(){
        this.nombre = "";
        this.clave = "";
    }
    public void SetNombre(String nombre) {
        this.nombre = nombre;
    }

    public void SetClave(String clave) {
        this.clave = clave;
    }

    public String GetNombre() {
        return nombre;
    }

    public String GetClave() {
        return clave;
    }    
}
