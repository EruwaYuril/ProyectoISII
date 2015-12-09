package Modulo;

/**
 *
 * @author Cristian Xool
 * 
 * Clase objeto que describre los atributos de las asignaturas.
 * 
 */
public class Asignatura {

    public Asignatura(String clave, String nombre) {
        this.clave = clave;
        this.nombre = nombre;   
    }
    
    public Asignatura(){
        
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
    
    @Override
    public String toString() {
        return nombre;
    }
    
    private String clave;
    private String nombre;

}
