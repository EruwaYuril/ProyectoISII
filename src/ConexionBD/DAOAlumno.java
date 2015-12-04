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
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian Xool
 */
public class DAOAlumno {
     public static int ConsultaRegistro(Alumno unAlumno){
        
        String nombreAlumno = unAlumno.GetNombre();
        String apellidosAlumno = unAlumno.GetApellidos();
        String matricula = unAlumno.GetMatricula();
     
        Connection miConexion = BaseDatos.ObtenerConexion(); 
        try{
            Statement consulta = miConexion.createStatement();
            
            consulta.executeUpdate("INSERT INTO alumnos (matricula, nombreAlumno, apellidosAlumno) " +
                    "VALUES ('" + matricula + "', '"+ nombreAlumno + "', '" +
                    apellidosAlumno + "')");
            System.out.println("Alumno: " + matricula + " " + nombreAlumno + 
                    " " + apellidosAlumno + ", registrado.");
            return 0;
          
        }catch(SQLException ex){
            System.err.println("Error al registrar alumno. " + ex);
            return -1;
        }
    }
    
    public static int ConsultaModificar(Alumno unAlumno){
       
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
                return 1;
            }
            
            return 0;
            
        }catch(SQLException ex){
            System.err.println("Error al modificar alumno. " + ex);
            return -1;
        }
        
    }

    public static int ConsultaEliminar(String matricula){
        Connection miConexion = BaseDatos.ObtenerConexion();
        String unaMatricula = matricula;
        
        try{
            Statement consulta = miConexion.createStatement();
            consulta.executeUpdate("DELETE FROM Alumnos WHERE matricula = " + unaMatricula + ";");
            System.out.println("Alumno con matricula [" + unaMatricula + "] eliminado.");
            return 0;
        }catch(SQLException ex){
            System.err.println("Error al eliminar alumno. " + ex);
            return -1;
        }
    }

    public static ArrayList<Alumno> GenerarLista(){
        Connection miConexion = BaseDatos.ObtenerConexion();
        
        ArrayList<Alumno> lista = new ArrayList<>();
        try{
            PreparedStatement consulta = miConexion.prepareStatement("SELECT matricula, nombreAlumno, apellidosAlumno FROM alumnos");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                lista.add(new Alumno(resultado.getString("matricula"),
                        resultado.getString("nombreAlumno"), 
                        resultado.getString("apellidosAlumno")));
            }
        }catch(SQLException ex){
            System.err.println("Error al generar lista de alumnos. " + ex);
            JOptionPane.showMessageDialog(null, "Error al generar la lista de alumnos.",
                    "Error Lista", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
}
