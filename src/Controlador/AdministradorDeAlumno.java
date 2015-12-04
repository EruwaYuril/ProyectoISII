package Controlador;

import ConexionBD.DAOAlumno;
import Modulo.Alumno;
import java.sql.SQLException;
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
        
        if(DAOAlumno.ConsultaRegistro(unAlumno) == 0){
            return "Alumno guardado!";
        }else{
            return "Error al registrar alumno.";
        }
        
    }
    
    public static String Modificar(Alumno unAlumno){
        int numResultado = DAOAlumno.ConsultaModificar(unAlumno);
        if(numResultado == 0){
            return "Alumno modificado!";
        }else if(numResultado == 1){
            return "Datos introducidos incorrectos.";
        }
        else{
            return "Error al modificar alumno.";
        }
        
    }

    public static String Eliminar(String matricula){
     
        if(DAOAlumno.ConsultaEliminar(matricula) == 0){
            return "Alumno eliminado!";
        }else{
            return "Error al eliminar alumno.";
        }
    }

    public static ArrayList<Alumno> ObtenerLista(){
        
        ArrayList<Alumno> lista = DAOAlumno.GenerarLista();
        return lista;
    }
    
    
}
