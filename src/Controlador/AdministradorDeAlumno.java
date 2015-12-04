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
    
    public static void Registrar(Alumno unAlumno){
        
        String nombreAlumno = unAlumno.GetNombre();
        String apellidosAlumno = unAlumno.GetApellidos();
        String matricula = unAlumno.GetMatricula();
     
        unAlumno = new Alumno(nombreAlumno,apellidosAlumno, matricula);
         
        DAOAlumno.ConsultaRegistro(unAlumno);
    }
    
    public static void Modificar(Alumno unAlumno){
       
        String matricula, nombreAlumno, apellidosAlumno;
        
        nombreAlumno = unAlumno.GetNombre();
        apellidosAlumno = unAlumno.GetApellidos();
        matricula = unAlumno.GetMatricula();
     
         unAlumno = new Alumno(nombreAlumno,apellidosAlumno, matricula);
         
         DAOAlumno.ConsultaModificar(unAlumno);
            
        
    }

    public static void Eliminar(String matricula){
        
        String unaMatricula = matricula;
        
        DAOAlumno.ConsultaEliminar(unaMatricula);
    }

    public static ArrayList<Alumno> Listar() throws SQLException{
        
        ArrayList<Alumno> lista = DAOAlumno.ObtenerLista();
    return lista;
   }
    
    
}
