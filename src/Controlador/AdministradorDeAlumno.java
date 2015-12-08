package Controlador;

import ManejoDatos.DAOAlumno;
import ManejoDatos.DAOGrupoEscolar;
import Modulo.Alumno;
import java.util.ArrayList;




/**
 *
 * @author Cristian Xool
 * 
 * Controlador para las clases de tipo alumno. Permite crear
 * nuevos alumnos en el sistema, modificar existentes en la base de datos 
 * y eliminar los registros de la base de datos.
 * 
 */
public class AdministradorDeAlumno {
    
    public static String Registrar(Alumno unAlumno){
        
        if(FueExitoso( DAOAlumno.Guardar(unAlumno) )){
            return "Alumno guardado!";
        }else{
            return "Error al registrar alumno.";
        }
        
    }
    
    public static String Modificar(Alumno unAlumno){
        
        if(FueExitoso( DAOAlumno.Actualizar(unAlumno) ) ){
            return "Alumno modificado!";
        }else{
            return "Error al modificar alumno.";
        }
        
    }

    public static String Eliminar(String matricula){
     
        if(FueExitoso( DAOAlumno.Borrar(matricula) ) ){
            return "Alumno eliminado!";
        }else{
            return "Error al eliminar alumno.";
        }
    }

    public static ArrayList<Alumno> ObtenerLista(){
        
        ArrayList<Alumno> lista = DAOAlumno.GenerarLista();
        return lista;
        
    }
    
    public static void InscribirAlumno(String clave, String matricula){
        DAOAlumno.GuardarRelacion(clave, matricula);
        
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
