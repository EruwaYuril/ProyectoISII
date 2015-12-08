package Controlador;

import ManejoDatos.DAOAsignatura;
import Modulo.Asignatura;
import java.util.ArrayList;


/**
 *
 * @author Cristian Xool
 * 
 * Controlador para las clases de tipo asignatura. Permite crear
 * nuevas asignaturas en el sistema, modificar existentes en la base de datos 
 * y eliminar los registros de la base de datos.
 * 
 */
public class AdministradorDeAsignatura {
   
   public static String Registrar(Asignatura unaAsignatura){
        
        if(FueExitoso( DAOAsignatura.Guardar(unaAsignatura))){
            return "Asignatura guardado!";
        }else{
            return "Error al registrar asignatura.";
        }
        
    }
    
    public static String Modificar(Asignatura unaAsignatura){
        
        if(FueExitoso( DAOAsignatura.Actualizar(unaAsignatura))){
            return "Asignatura modificado!";
        }else{
            return "Error al modificar asignatura.";
        }
        
    }

    public static String Eliminar(String claveAsignatura){
     
        if(FueExitoso( DAOAsignatura.Borrar(claveAsignatura))){
            return "Asignatura eliminado!";
        }else{
            return "Error al eliminar asignatura.";
        }
    }
    
    public static ArrayList<Asignatura> ObtenerLista() {
        
        ArrayList<Asignatura> lista = DAOAsignatura.GenerarLista();
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
