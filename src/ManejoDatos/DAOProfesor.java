/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoDatos;

import Modulo.Profesor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian Xool
 */
public class DAOProfesor extends DAOBase{
    
     public static int Guardar(Profesor unProfesor){
        
        String nombreTabla = "profesores(claveProfesor, nombreProfesor, apellidosProfesor)";
         
        String nombreProfesor = unProfesor.GetNombre();
        String apellidosProfesor = unProfesor.GetApellidos();
        String claveProfesor = unProfesor.GetClave();
        String valores = "'" + claveProfesor + "','" + nombreProfesor + "','" +
                apellidosProfesor + "'";
        
        int estado = EjecutarGuardado(nombreTabla, valores);
        
        if(ValidadorDeEstado.Exito(estado)){
            System.out.println("Profesor: " + claveProfesor + " " + nombreProfesor + 
                    " " + apellidosProfesor + ", registrado.");
            return EXITO;
        }else{
            System.err.println("Error al registrar profesor con clave: " + claveProfesor);
            return ERROR;
        }
    }
     
    public static int Actualizar(Profesor unProfesor){
        
        String claveProfesor = unProfesor.GetClave();
        String nuevoNombre = unProfesor.GetNombre();
        String nuevosApellidos = unProfesor.GetApellidos();
        
        String nombreTabla = "profesores";
        String nuevosValores = "nombreProfesor = '" + nuevoNombre + 
                "', apellidosProfesor = '" + nuevosApellidos + "'";
        String condicion = "claveProfesor = " + claveProfesor;
        
        int estado = EjecutarActualizacion(nombreTabla, nuevosValores, condicion);
        
        if(ValidadorDeEstado.Exito(estado)){
            System.out.println("Nombre y apellidos del registro con calve: " +
                    claveProfesor + " actualizado.");
            return EXITO;
        }else{
            System.err.println("Error al actualizar al profesor con clave " + claveProfesor);
            return ERROR;
        }
    }
    
    public static int Borrar(String claveProfesor){
        
        String unaClave = claveProfesor;
        String nombreTabla = "profesores";
        String condicion = "claveProfesor = " + claveProfesor;
        
        int estado = EjecutarEliminacion(nombreTabla, condicion);
        
        if(ValidadorDeEstado.Exito(estado)){
            System.out.println("Profesor con clave [" + unaClave + "] eliminado.");
            return EXITO;
        }else{
            System.err.println("Error al eliminar profesor con clave: " + claveProfesor);
            return ERROR;
        }
    }
    
    public static ArrayList<Profesor> GenerarLista() {
      
        ArrayList<Profesor> lista = new ArrayList<>();
        try{
            Statement consulta = conexion.createStatement();
            ResultSet resultado = consulta.executeQuery(
                    "SELECT claveProfesor, nombreProfesor, apellidosProfesor FROM profesores");
            while(resultado.next()){
                lista.add(new Profesor(
                        resultado.getString("claveProfesor"),
                        resultado.getString("nombreProfesor"), 
                        resultado.getString("apellidosProfesor")));
            }
        }catch(SQLException ex){
            System.err.println("Error al generar lista de profesores. " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al generar la lista de profesores.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    return lista;
   }
}
