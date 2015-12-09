package Controlador;

import ManejoDatos.DAOGrupoEscolar;
import ManejoDatos.ValidadorDeEstado;
import Modulo.GrupoAlumno;
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
                
        if(ValidadorDeEstado.Exito(DAOGrupoEscolar.Guardar(unGrupo))){
            return "Grupo registrado!";
        }else{
            return "Error al registrar grupo.";
        }
    }
    
    public static String Modificar(GrupoEscolar unGrupo){
        
        if(ValidadorDeEstado.Exito(DAOGrupoEscolar.Actualizar(unGrupo))){
            return "Grupo modificado!";
        }else{
            return "Error al modificar grupo.";
        }
        
    }
    
    public static String Eliminar(String clave){
        
        if(ValidadorDeEstado.Exito(DAOGrupoEscolar.Borrar(clave))){
            return "Grupo Eliminado!";
        }else{
            return "Error al eliminar grupo.";
        }
        
    }
    
    public static ArrayList<GrupoEscolar> ObtenerLista(){
        
        ArrayList<GrupoEscolar> lista = DAOGrupoEscolar.GenerarLista();
        return lista;
   }
    
    public static ArrayList<GrupoAlumno> ObtenerListaDeGrupo(String claveGrupo){
        
        ArrayList<GrupoAlumno> lista = DAOGrupoEscolar.GenerarListaAlumnos(claveGrupo);
        return lista;
   }
 
}
