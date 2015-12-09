/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Edwin
 */
public abstract class DAOBase {
    
    static Connection conexion;
    
    static final int EXITO = 0;
    static final int ERROR = -1;
    
    static int EjecutarGuardado(String nombreTabla, String valores){
        
        try{
            Statement consulta = conexion.createStatement();
            
            int filasAgregadas = consulta.executeUpdate("INSERT INTO " + nombreTabla +
                    " VALUES (" + valores + ");");
            System.out.println("Guardado realizado con exito! " +
                    "filas agregadas: " + filasAgregadas);
            
            return EXITO;
          
        }catch(SQLException ex){
            System.err.println("Error al añadir nuevo registro. " + ex.getMessage());
            return ERROR;
        }
    }
    
    static int EjecutarActualizacion(String nombreTabla, String nuevosValores, String condiciones){
        try{
            Statement consulta = conexion.createStatement();
            
            int filasModificadas = consulta.executeUpdate("UPDATE " + nombreTabla + " SET " +
                        nuevosValores + " WHERE " + condiciones + ";");
            
            if(filasModificadas == 0){
                 JOptionPane.showMessageDialog(null, "ERROR: Registro no existe.",
                    "Registro Invalido", JOptionPane.ERROR_MESSAGE);
                 return ERROR;
            }
            
            System.out.println("Actualizacion realizada con exito! " +
                    "filas modificadas: " + filasModificadas);
            
            return EXITO;
            
        }catch(SQLException ex){
            System.err.println("Error al actualizar registro. " + ex.getMessage());
            return ERROR;
        }
    }
    
    static int EjecutarEliminacion(String nombreTabla, String condicion){
        
        try{
            Statement consulta = conexion.createStatement();
            
            int filasEliminadas = consulta.executeUpdate("DELETE FROM " + nombreTabla +" WHERE " +
                    condicion + ";");
            
            if(filasEliminadas == 0){
                 JOptionPane.showMessageDialog(null, "ERROR: Registro no existe.",
                    "Registro Invalido", JOptionPane.ERROR_MESSAGE);
                 return ERROR;
            }
            
            System.out.println("Eliminacion realizada con exito! " +
                    "filas eliminadas: " + filasEliminadas);
            return EXITO;
        }catch(SQLException ex){
            System.err.println("Error al eliminar registro. " + ex.getMessage());
            return ERROR;
        }
        
    }
    
    static void setConexion(Connection unaConexion){
        conexion = unaConexion;
    }
    
}
