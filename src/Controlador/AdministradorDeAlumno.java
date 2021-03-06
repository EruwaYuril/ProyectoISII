package Controlador;

import ManejoDatos.ValidadorDeEstado;
import ManejoDatos.DAOAlumno;
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
        
        if(ValidadorDeEstado.Exito(DAOAlumno.Guardar(unAlumno) )){
            return "Alumno guardado!";
        }else{
            return "Error al registrar alumno.";
        }
        
    }
    
    public static String Modificar(Alumno unAlumno){
        
        if(ValidadorDeEstado.Exito(DAOAlumno.Actualizar(unAlumno) ) ){
            return "Alumno modificado!";
        }else{
            return "Error al modificar alumno.";
        }
        
    }

    public static String Eliminar(String matricula){
     
        if(ValidadorDeEstado.Exito( DAOAlumno.Borrar(matricula) ) ){
            return "Alumno eliminado!";
        }else{
            return "Error al eliminar alumno.";
        }
        
    }

    public static ArrayList<Alumno> ObtenerLista(){
        
        ArrayList<Alumno> lista = DAOAlumno.GenerarLista();
        return lista;
        
    }
    
    public static String InscribirAGrupo(String clave, String matricula){
        if(ValidadorDeEstado.Exito( DAOAlumno.GuardarRelacion(clave, matricula) ) ){
            return "Alumno inscrito!";
        }else{
            return "Error al inscribir alumno.";
        }   
    }
    
    public static String BajaAlumno(String clave, String matricula){
        
        if(ValidadorDeEstado.Exito( DAOAlumno.BorrarRelacion(clave, matricula) ) ){
            return "Alumno dado de baja exitosamente!";
        }else{
            return "Error al dar de baja al alumno.";
        }           
    }
    
}
