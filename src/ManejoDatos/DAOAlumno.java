/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoDatos;

import Modulo.Alumno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian Xool
 */
public class DAOAlumno extends DAOBase{
    
     public static int Guardar(Alumno unAlumno){
        
         String nombreTabla = "alumnos (matricula, nombreAlumno, apellidosAlumno)";
         
         String nombreAlumno = unAlumno.GetNombre();
         String apellidosAlumno = unAlumno.GetApellidos();
         String matricula = unAlumno.GetMatricula();
         String valores = "'" + matricula + "', '"+ nombreAlumno + "', '" +
                 apellidosAlumno + "'";
         
         int estado = EjecutarGuardado(nombreTabla, valores);
         
         if(FueExitoso(estado)){
             System.out.println("Alumno: " + matricula + " " + nombreAlumno +
                     " " + apellidosAlumno + ", registrado.");
             return EXITO;
         }else{
             System.err.println("Error al registrar alumno con matricula " + matricula);
             return ERROR;
         }
     }
     
     public static int Actualizar(Alumno unAlumno){
         
         String matricula = unAlumno.GetMatricula();
         String nuevoNombre = unAlumno.GetNombre();
         String nuevosApellidos = unAlumno.GetApellidos();
         
         String nombreTabla = "Alumnos";
         String nuevosValores = "nombreAlumno = '" + nuevoNombre +
                 "' AND apellidosAlumno = '" + nuevosApellidos + "'";
         String condicion = "matricula = " + matricula;
         
         int estado = EjecutarActualizacion(nombreTabla, nuevosValores, condicion);
         
         if(FueExitoso(estado)){
             System.out.println("Nombre y apellidos del registro con matricula " + 
                     matricula + " actualizado.");
             return EXITO;
         }else{
             System.err.println("Error al actualizar el alumno con matricula " + matricula);
             return ERROR;
         }
         
     }
     
     public static int Borrar(String matricula){
         
         String unaMatricula = matricula;
         String nombreTabla = "Alumnos";
         String condicion = "matricula = " + matricula;
         
         int estado = EjecutarEliminacion(nombreTabla, condicion);
         
         if(FueExitoso(estado)){
             System.out.println("Alumno con matricula [" + unaMatricula + "] eliminado.");
             return EXITO;
         }else{
             System.err.println("Error al eliminar alumno con matricula " + matricula);
             return ERROR;
         }
     }
    
    public static ArrayList<Alumno> GenerarLista(){
        
        ArrayList<Alumno> lista = new ArrayList<>();
        try{
            Statement consulta = miConexion.createStatement();
            ResultSet resultado = consulta.executeQuery(
                    "SELECT matricula, nombreAlumno, apellidosAlumno FROM alumnos");
            
            while(resultado.next()){
                lista.add(new Alumno(
                        resultado.getString("matricula"),
                        resultado.getString("nombreAlumno"),
                        resultado.getString("apellidosAlumno")));
            }
        }catch(SQLException ex){
            System.err.println("Error al generar lista de alumnos. " + ex.getSQLState());
            JOptionPane.showMessageDialog(null, "Error al generar la lista de alumnos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
}
