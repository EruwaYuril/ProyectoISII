package Controlador;

import ManejoDatos.DAOProfesor;
import Modulo.Profesor;
import java.util.ArrayList;


/**
 *
 * @author Cristian Xool
 * 
 * Controlador para las clases de tipo profesor. Permite crear
 * nuevos profesores en el sistema, modificar existentes en la base de datos 
 * y eliminar los registros de la base de datos.
 * 
 */
public class AdministradorDeProfesor {

   public static String Registrar(Profesor unProfesor){
        
        if(FueExitoso( DAOProfesor.Guardar(unProfesor))){
            return "Profesor guardado!";
        }else{
            return "Error al registrar profesor.";
        }
        
    }
    
    public static String Modificar(Profesor unProfesor){
        
        if(FueExitoso( DAOProfesor.Actualizar(unProfesor))){
            return "Profesor modificado!";
        }else{
            return "Error al modificar profesor.";
        }
        
    }

    public static String Eliminar(String claveProfesor){
     
        if(FueExitoso( DAOProfesor.Borrar(claveProfesor))){
            return "Profesor eliminado!";
        }else{
            return "Error al eliminar profesor.";
        }
    }
    
    public static ArrayList<Profesor> ObtenerLista() {
        
        ArrayList<Profesor> lista = DAOProfesor.GenerarLista();
        
    return lista;
   }
    
    private static final int EXITO = 0;
    
    private static boolean FueExitoso(int estado){
        if(estado == EXITO){
            return true;
        }else{
            return false;
        }
    }
}
