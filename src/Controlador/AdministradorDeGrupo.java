package Controlador;

import ManejoDatos.DAOGrupoEscolar;
import Modulo.GrupoEscolar;
import java.util.ArrayList;

/**
 *
 * @author Cristian Xool
 * 
 * Controlador de las clases grupo. Permite crear un nuevo grupo, eliminar
 * uno existente y modificar los campos de uno existente.
 * 
 */
public class AdministradorDeGrupo {
    
    
    public static String Registrar(GrupoEscolar unGrupo){
                
        if(FueExitoso(DAOGrupoEscolar.Guardar(unGrupo))){
            return "Grupo guardado!";
        }else{
            return "Error al registrar grupo D:";
        }
    }
    
    public static String Eliminar(String clave){
        
        if(FueExitoso(DAOGrupoEscolar.Borrar(clave))){
            return "Grupo Eliminado!";
        }else{
            return "Error al eliminar";
        }
        
    }
    
    public static String Modificar(GrupoEscolar unGrupo){
        
        if(FueExitoso(DAOGrupoEscolar.Actualizar(unGrupo))){
            return "Alumno modificado!";
        }else{
            return "Error al modificar grupo.";
        }
        
    }
    
       
    public static ArrayList<GrupoEscolar> ObtenerLista(){
        
        ArrayList<GrupoEscolar> lista = DAOGrupoEscolar.GenerarLista();
        return lista;
   }
    
    
    
    private static final int EXITO = 0;
    
    private static boolean FueExitoso(int estado){
        if(estado == EXITO){
            return true;
        }else{
            return false;
        }
    }
}
