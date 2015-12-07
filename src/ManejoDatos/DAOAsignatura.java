/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoDatos;

import Modulo.Asignatura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian Xool
 */
public class DAOAsignatura {
     public static int Guardar(Asignatura unaAsignatura){
        
        String nombreAsignatura = unaAsignatura.GetNombre();
        String claveAsignatura = unaAsignatura.GetClave();
     
        Connection miConexion = ConexionBD.ObtenerConexion(); 
        try{
            PreparedStatement psd = miConexion.prepareStatement("INSERT INTO "+
                    "asignaturas (claveAsignatura, nombreAsignatura) "+
                    "VALUES (?, ?)");
            psd.setString(1, claveAsignatura);
            psd.setString(2, nombreAsignatura);
            psd.executeUpdate();
            System.out.println("Asignatura: " + claveAsignatura + " " + nombreAsignatura + 
                    " " + ", registrado.");
            return 0;
          
        }catch(SQLException ex){
            System.err.println("Error al registrar alumno. " + ex);
            return -1;
        }
    }
    
    public static int Actualizar(Asignatura unaAsignatura){
       
        Connection miConexion = ConexionBD.ObtenerConexion();
        Asignatura nuevosDatos = unaAsignatura;
        try{
            String clave = unaAsignatura.GetClave();
            String nuevoNombre = unaAsignatura.GetNombre();
            Statement consulta = miConexion.createStatement();
            
            if(!nuevoNombre.equals("")){
                consulta.executeUpdate("UPDATE asignaturas SET nombreAsignatura = '" + nuevoNombre +
                        "' WHERE claveAsignatura = " + clave + ";");
                System.out.println("Asignaturas del registro con clave " + clave +
                        " actualizado.");
            }else{
                System.err.println("Datos para modificar alumno incorrectos.");
                return 1;
            }
            
            return 0;
            
        }catch(SQLException ex){
            System.err.println("Error al modificar alumno. " + ex);
            return -1;
        }
        
    }

    public static int Borrar(String claveAsignatura){
        Connection miConexion = ConexionBD.ObtenerConexion();
        String unaClave = claveAsignatura;
        
        try{
            Statement consulta = miConexion.createStatement();
            consulta.executeUpdate("DELETE FROM asignaturas WHERE claveAsignatura = " + unaClave + ";");
            System.out.println("Asignatura con clave [" + unaClave + "] eliminado.");
            return 0;
        }catch(SQLException ex){
            System.err.println("Error al eliminar alumno. " + ex);
            return -1;
        }
    }
    
    public static ArrayList<Asignatura> GenerarLista() {
        Connection miConexion = ConexionBD.ObtenerConexion();
      
        ArrayList<Asignatura> lista = new ArrayList<>();
        try{
            PreparedStatement consulta = miConexion.prepareStatement("SELECT claveAsignatura, nombreAsignatura FROM asignaturas");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                lista.add(new Asignatura(resultado.getString("claveAsignatura"), resultado.getString("nombreAsignatura")));
            }
        }catch(SQLException ex){
            System.err.println("Error al generar lista de alumnos. " + ex);
            JOptionPane.showMessageDialog(null, "Error al generar la lista de alumnos.",
                    "Error Lista", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
   }
}
