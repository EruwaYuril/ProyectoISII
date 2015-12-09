package Controlador;

import ManejoDatos.ValidadorDeEstado;
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
        
        if(ValidadorDeEstado.Exito(DAOAsignatura.Guardar(unaAsignatura))){
            return "Asignatura registrada!";
        }else{
            return "Error al registrar asignatura.";
        }
        
    }
    
    public static String Modificar(Asignatura unaAsignatura){
        
        if(ValidadorDeEstado.Exito(DAOAsignatura.Actualizar(unaAsignatura))){
            return "Asignatura modificada!";
        }else{
            return "Error al modificar asignatura.";
        }
        
    }

    public static String Eliminar(String claveAsignatura){
     
        if(ValidadorDeEstado.Exito(DAOAsignatura.Borrar(claveAsignatura))){
            return "Asignatura eliminada!";
        }else{
            return "Error al eliminar asignatura.";
        }
        
    }
    
    public static ArrayList<Asignatura> ObtenerLista() {
        
        ArrayList<Asignatura> lista = DAOAsignatura.GenerarLista();
        return lista;
   }
    
}
