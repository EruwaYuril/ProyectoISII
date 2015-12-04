/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import Modulo.Asignatura;
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
public class DAOAsignatura {
     public static void ConsultaRegistro(Asignatura unaAsignatura){
        
        String claveAsignatura, nombreAsignatura;
        
        nombreAsignatura = unaAsignatura.GetNombre();
        claveAsignatura = unaAsignatura.GetClave();
     
        Connection miConexion = BaseDatos.ObtenerConexion(); 
        try{
            PreparedStatement psd = miConexion.prepareStatement("INSERT INTO "+
                    "asignaturas (claveAsignatura, nombreAsignatura) "+
                    "VALUES (?, ?)");
            psd.setString(1, claveAsignatura);
            psd.setString(2, nombreAsignatura);
            psd.executeUpdate();
            System.out.println("Asignatura: " + claveAsignatura + " " + nombreAsignatura + 
                    " " + ", registrado.");
          
        }catch(SQLException ex){
            System.err.println("Error al registrar asignatura.");
        }
    }
    
    public static void ConsultaModificar(Asignatura unaAsignatura){
       
        Connection miConexion = BaseDatos.ObtenerConexion();
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
                System.err.println("Datos para modificar profesor incorrectos.");
            }
            
        }catch(SQLException ex){
            System.err.println("Error al modificar asignatura.");
        }
        
    }

    public static void ConsultaEliminar(String claveAsignatura){
        Connection miConexion = BaseDatos.ObtenerConexion();
        String unaClave = claveAsignatura;
        
        try{
            Statement consulta = miConexion.createStatement();
            consulta.executeUpdate("DELETE FROM asignaturas WHERE claveAsignatura = " + unaClave + ";");
            System.out.println("Asignatura con clave [" + unaClave + "] eliminado.");
        }catch(SQLException ex){
            System.err.println("Error al eliminar aisgnatura.");
        }
    }
    
    public static ArrayList<Asignatura> ObtenerLista() throws SQLException{
        Connection miConexion = BaseDatos.ObtenerConexion();
      
        ArrayList<Asignatura> lista = new ArrayList<>();
        try{
            PreparedStatement consulta = miConexion.prepareStatement("SELECT claveAsignatura, nombreAsignatura FROM asignaturas");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                lista.add(new Asignatura(resultado.getString("claveAsignatura"), resultado.getString("nombreAsignatura")));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    return lista;
   }
}
