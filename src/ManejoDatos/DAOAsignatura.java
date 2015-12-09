/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoDatos;

import Modulo.Asignatura;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian Xool
 */
public class DAOAsignatura extends DAOBase{
    
     public static int Guardar(Asignatura unaAsignatura){
        
        String nombreTabla = "asignaturas(claveAsignatura, nombreAsignatura)";
        
        String nombreAsignatura = unaAsignatura.GetNombre();
        String claveAsignatura = unaAsignatura.GetClave();
        String valores = "'" + claveAsignatura + "','" + nombreAsignatura + "'";
        
        int estado = EjecutarGuardado(nombreTabla, valores);
        
        if(ValidadorDeEstado.Exito(estado)){
            System.out.println("Asignatura: " + claveAsignatura + " " + nombreAsignatura + 
                    ", registrado.");
            return EXITO;
        }else{
            System.err.println("Error al registrar asignatura con clave: " + claveAsignatura);
            return ERROR;
        }
    }
    
    public static int Actualizar(Asignatura unaAsignatura){
       
        String claveAsignatura = unaAsignatura.GetClave();
        String nuevoNombre = unaAsignatura.GetNombre();
        
        String nombreTabla = "asignaturas";
        String nuevosValores = "nombreAsignatura = '" + nuevoNombre +"'";
        String condicion = "claveAsignatura = '" + claveAsignatura + "'";
        
        
        int estado = EjecutarActualizacion(nombreTabla, nuevosValores, condicion);
        
        if(ValidadorDeEstado.Exito(estado)){
            System.out.println("Nombre del registro con clave: " + 
                    claveAsignatura + "actualizado.");
            return EXITO;
        }else{
            System.err.println("Error al actualizar la asignatura con clave " + claveAsignatura);
            return ERROR;
        }
    }
    
    public static int Borrar(String claveAsignatura){
        
        String unaClave = claveAsignatura;
        String nombreTabla = "asignaturas";
        String condicion = "claveAsignatura = '" + unaClave + "'";
        
        int estado = EjecutarEliminacion(nombreTabla, condicion);
        
        if(ValidadorDeEstado.Exito(estado)){
            System.out.println("Asignatura con clave [" + unaClave + "] eliminado.");
            return EXITO;
        }else{
            System.err.println("Error al eliminar asignatura con clave: " + claveAsignatura);
            return ERROR;
        }
    }
    
    public static ArrayList<Asignatura> GenerarLista() {
      
        ArrayList<Asignatura> lista = new ArrayList<>();
        try{
            Statement consulta = conexion.createStatement();
            ResultSet resultado = consulta.executeQuery(
                    "SELECT claveAsignatura, nombreAsignatura FROM asignaturas");
            while(resultado.next()){
                lista.add(new Asignatura(resultado.getString("claveAsignatura"),
                        resultado.getString("nombreAsignatura")));
            }
        }catch(SQLException ex){
            System.err.println("Error al generar lista de asignaturas. " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al generar la lista de asignaturas.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
   }
}
