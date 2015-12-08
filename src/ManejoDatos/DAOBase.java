/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Edwin
 */
public abstract class DAOBase {
    
    static Connection miConexion;
    
    static final int EXITO = 0;
    static final int ERROR = -1;
    
    static int EjecutarGuardado(String nombreTabla, String valores){
        
        try{
            Statement consulta = miConexion.createStatement();
            
            int filasAgregadas = consulta.executeUpdate("INSERT INTO " + nombreTabla +
                    " VALUES (" + valores + ");");
            System.out.println("Guardado realizado con exito! " +
                    "filas agregadas: " + filasAgregadas);
            
            return EXITO;
          
        }catch(SQLException ex){
            System.err.println("Error al añadir nuevo registro. " + ex.getSQLState());
            return ERROR;
        }
    }
    
    static int EjecutarActualizacion(String nombreTabla, String nuevosValores, String condiciones){
        try{
            Statement consulta = miConexion.createStatement();
            
            int filasModificadas = consulta.executeUpdate("UPDATE " + nombreTabla + " SET " +
                        nuevosValores + " WHERE " + condiciones + ";");
            System.out.println("Actualizacion realizada con exito! " +
                    "filas modificadas: " + filasModificadas);
            
            return EXITO;
            
        }catch(SQLException ex){
            System.err.println("Error al actualizar registro. " + ex.getSQLState());
            return ERROR;
        }
    }
    
    static int EjecutarEliminacion(String nombreTabla, String condicion){
        try{
            Statement consulta = miConexion.createStatement();
            
            int filasEliminadas = consulta.executeUpdate("DELETE FROM " + nombreTabla +" WHERE " +
                    condicion + ";");
            System.out.println("Eliminacion realizada con exito! " +
                    "filas eliminadas: " + filasEliminadas);
            
            return EXITO;
        }catch(SQLException ex){
            System.err.println("Error al eliminar registro. " + ex.getSQLState());
            return ERROR;
        }
    }
    
    static void setConexion(Connection unaConexion){
        miConexion = unaConexion;
    }
    
    static boolean FueExitoso(int estado){
        if(estado == EXITO){
            return true;
        }else{
            return false;
        }
    }
    
}
