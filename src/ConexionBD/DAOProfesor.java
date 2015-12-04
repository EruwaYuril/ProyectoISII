/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import Modulo.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Cristian Xool
 */
public class DAOProfesor {
     public static void ConsultaRegistro(Profesor unProfesor){
        
        String nombreProfesor = unProfesor.GetNombre();
        String apellidosProfesor = unProfesor.GetApellidos();
        String claveProfesor = unProfesor.GetClave();
     
        Connection miConexion = BaseDatos.ObtenerConexion(); 
        try{
            PreparedStatement psd = miConexion.prepareStatement("INSERT INTO "+
                    "profesores (claveProfesor, nombreProfesor, apellidosProfesor) "+
                    "VALUES (?, ?, ?)");
            psd.setString(1, claveProfesor);
            psd.setString(2, nombreProfesor);
            psd.setString(3, apellidosProfesor);
            psd.executeUpdate();
            System.out.println("Profesor: " + claveProfesor + " " + nombreProfesor + 
                    " " + apellidosProfesor + ", registrado.");
          
        }catch(SQLException ex){
            System.err.println("Error al registrar profesor.");
        }
    }
    
    public static void ConsultaModificar(Profesor unProfesor){
       
        Connection miConexion = BaseDatos.ObtenerConexion();
        Profesor nuevosDatos = unProfesor;
        try{
            String claveProfesor = unProfesor.GetClave();
            String nuevoNombre = unProfesor.GetNombre();
            String nuevosApellidos = unProfesor.GetApellidos();
            Statement consulta = miConexion.createStatement();
            
            if(!nuevoNombre.equals("") && nuevosApellidos.equals("")){
                consulta.executeUpdate("UPDATE profesores SET nombreAlumno = '" + nuevoNombre +
                        "' WHERE claveProfesor = " + claveProfesor + ";");
                System.out.println("Nombre del registro con clave " + claveProfesor +
                        " actualizado.");
            }else if(!nuevosApellidos.equals("") && nuevoNombre.equals("")){
                consulta.executeUpdate("UPDATE profesores SET apellidosProfesor = '" + nuevosApellidos +
                        "' WHERE claveProfesor = " + claveProfesor + ";");
                System.out.println("Apellidos del registro con clave " + claveProfesor +
                        " actualizado.");
            }else if(!nuevoNombre.equals("") && !nuevosApellidos.equals("")){
                consulta.executeUpdate("UPDATE profesores SET nombreProfesor = '" + nuevoNombre +
                        "' WHERE claveProfesor = " + claveProfesor + ";");
                consulta.executeUpdate("UPDATE profesores SET apellidosProfesor = '" + nuevosApellidos +
                        "' WHERE claveProfesor = " + claveProfesor + ";");
                System.out.println("Nombre y apellidos del registro con clave " + claveProfesor +
                        " actualizado.");
            }else{
                System.err.println("Datos para modificar profesor incorrectos.");
            }
            
        }catch(SQLException ex){
            System.err.println("Error al modificar profesor.");
        }
        
    }

    public static void ConsultaEliminar(String claveProfesor){
        Connection miConexion = BaseDatos.ObtenerConexion();
        String unaClave = claveProfesor;
        
        try{
            Statement consulta = miConexion.createStatement();
            consulta.executeUpdate("DELETE FROM profesores WHERE claveProfesor = " + unaClave + ";");
            System.out.println("Profesor con clave [" + unaClave + "] eliminado.");
        }catch(SQLException ex){
            System.err.println("Error al eliminar profesor.");
        }
    }
    
    public static ArrayList<Profesor> ObtenerLista() throws SQLException{
        Connection miConexion = BaseDatos.ObtenerConexion();
      
        ArrayList<Profesor> lista = new ArrayList<>();
        try{
            PreparedStatement consulta = miConexion.prepareStatement("SELECT claveProfesor, nombreProfesor, apellidosProfesor FROM profesores");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                lista.add(new Profesor(resultado.getString("claveProfesor"), resultado.getString("nombreProfesor"), resultado.getString("apellidosProfesor")));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    return lista;
   }
}
