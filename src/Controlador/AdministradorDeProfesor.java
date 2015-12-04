package Controlador;

import ConexionBD.DAOProfesor;
import Modulo.Profesor;
import java.sql.SQLException;
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

    public static void Registrar(Profesor unProfesor){
        
        String nombreProfesor = unProfesor.GetNombre();
        String apellidosProfesor = unProfesor.GetApellidos();
        String claveProfesor = unProfesor.GetClave();
        
        unProfesor = new Profesor(nombreProfesor, apellidosProfesor, claveProfesor);
        DAOProfesor.ConsultaRegistro(unProfesor);  
    }
    
    public static void Modificar(Profesor unProfesor){
       
        
            String claveProfesor = unProfesor.GetClave();
            String nuevoNombre = unProfesor.GetNombre();
            String nuevosApellidos = unProfesor.GetApellidos();
            
            unProfesor = new Profesor(claveProfesor, nuevoNombre, nuevosApellidos);
            DAOProfesor.ConsultaModificar(unProfesor);
    }

    public static void Eliminar(String claveProfesor){
        
        String unaClave = claveProfesor;
        DAOProfesor.ConsultaEliminar(claveProfesor);
    }
    
    public static ArrayList<Profesor> ObtenerLista() throws SQLException{
        
        ArrayList<Profesor> lista = DAOProfesor.ObtenerLista();
        
    return lista;
   }
}
