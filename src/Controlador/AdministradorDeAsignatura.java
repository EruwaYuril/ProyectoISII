package Controlador;

import ConexionBD.DAOAsignatura;
import Modulo.Asignatura;
import java.sql.SQLException;
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
   
   public static void Registrar(Asignatura unaAsignatura){
        
        String nombreAsignatura = unaAsignatura.GetNombre();
        String claveAsignatura = unaAsignatura.GetClave();
     
        unaAsignatura = new Asignatura(nombreAsignatura, claveAsignatura);
        DAOAsignatura.ConsultaRegistro(unaAsignatura);
    }
    
    public static void Modificar(Asignatura unaAsignatura){
       
            String clave = unaAsignatura.GetClave();
            String nuevoNombre = unaAsignatura.GetNombre();
            
            unaAsignatura = new Asignatura(clave, nuevoNombre);
            DAOAsignatura.ConsultaModificar(unaAsignatura);
        
    }

    public static void Eliminar(String claveAsignatura){
        
        String unaClave = claveAsignatura;
        
        DAOAsignatura.ConsultaEliminar(claveAsignatura);
    }
    
    public ArrayList<Asignatura> ObtenerLista() throws SQLException{
        
      
        ArrayList<Asignatura> lista = DAOAsignatura.ObtenerLista();
        
    return lista;
   }
}
