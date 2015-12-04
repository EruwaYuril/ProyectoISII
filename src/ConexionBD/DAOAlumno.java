/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import Modulo.Alumno;
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
public class DAOAlumno {
     public static void ConsultaRegistro(Alumno unAlumno){
        
        String nombreAlumno = unAlumno.GetNombre();
        String apellidosAlumno = unAlumno.GetApellidos();
        String matricula = unAlumno.GetMatricula();
     
        Connection miConexion = BaseDatos.ObtenerConexion(); 
        try{
            PreparedStatement consulta = miConexion.prepareStatement("INSERT INTO "+
                    "alumnos (matricula, nombreAlumno, apellidosAlumno) "+
                    "VALUES (?, ?, ?)");
            consulta.setString(1, matricula);
            consulta.setString(2, nombreAlumno);
            consulta.setString(3, apellidosAlumno);
            consulta.executeUpdate();
            System.out.println("Alumno: " + matricula + " " + nombreAlumno + 
                    " " + apellidosAlumno + ", registrado.");
          
        }catch(SQLException ex){
            System.err.println("Error al registrar alumno.");
        }
    }
    
    public static void ConsultaModificar(Alumno unAlumno){
       
        Connection miConexion = BaseDatos.ObtenerConexion();
        Alumno nuevosDatos = unAlumno;
        try{
            String matricula = unAlumno.GetMatricula();
            String nuevoNombre = unAlumno.GetNombre();
            String nuevosApellidos = unAlumno.GetApellidos();
            Statement consulta = miConexion.createStatement();
            
            if(!nuevoNombre.equals("") && nuevosApellidos.equals("")){
                consulta.executeUpdate("UPDATE Alumnos SET nombreAlumno = '" + nuevoNombre +
                        "' WHERE matricula = " + matricula + ";");
                System.out.println("Nombre del registro con matricula " + matricula +
                        " actualizado.");
            }else if(!nuevosApellidos.equals("") && nuevoNombre.equals("")){
                consulta.executeUpdate("UPDATE Alumnos SET apellidosAlumno = '" + nuevosApellidos +
                        "' WHERE matricula = " + matricula + ";");
                System.out.println("Apellidos del registro con matricula " + matricula +
                        " actualizado.");
            }else if(!nuevoNombre.equals("") && !nuevosApellidos.equals("")){
                consulta.executeUpdate("UPDATE Alumnos SET nombreAlumno = '" + nuevoNombre +
                        "' WHERE matricula = " + matricula + ";");
                consulta.executeUpdate("UPDATE Alumnos SET apellidosAlumno = '" + nuevosApellidos +
                        "' WHERE matricula = " + matricula + ";");
                System.out.println("Nombre y apellidos del registro con matricula " + matricula +
                        " actualizado.");
            }else{
                System.err.println("Datos para modificar alumno incorrectos.");
            }
            
        }catch(SQLException ex){
            System.err.println("Error al modificar alumno.");
        }
        
    }

    public static void ConsultaEliminar(String matricula){
        Connection miConexion = BaseDatos.ObtenerConexion();
        String unaMatricula = matricula;
        
        try{
            Statement consulta = miConexion.createStatement();
            consulta.executeUpdate("DELETE FROM Alumnos WHERE matricula = " + unaMatricula + ";");
            System.out.println("Alumno con matricula [" + unaMatricula + "] eliminado.");
        }catch(SQLException ex){
            System.err.println("Error al eliminar alumno.");
        }
    }

    public static ArrayList<Alumno> ObtenerLista() throws SQLException{
        Connection miConexion = BaseDatos.ObtenerConexion();
      
        ArrayList<Alumno> lista = new ArrayList<>();
        try{
            PreparedStatement consulta = miConexion.prepareStatement("SELECT matricula, nombreAlumno, apellidosAlumno FROM alumnos");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                lista.add(new Alumno(resultado.getString("matricula"), resultado.getString("nombreAlumno"), resultado.getString("apellidosAlumno")));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    return lista;
   }
}
