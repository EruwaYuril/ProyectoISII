/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoDatos;

import Modulo.Asignatura;
import Modulo.GrupoEscolar;
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
public class DAOGrupoEscolar extends DAOBase{
    
    
    public static int Guardar(GrupoEscolar unGrupo){
        
        String nombreTabla = "grupoescolar (claveGrupo, claveAsignatura, claveProfesor, aula, horario)";
        
        String claveProfesor = unGrupo.GetUnProfesor().GetClave();
        String claveAsignatura = unGrupo.GetUnaAsignatura().GetClave();
        String clave = unGrupo.GetClave();
        String horario = unGrupo.GetHorario();
        String aula = unGrupo.GetAula();
        
        String valores = "'" + clave + "', '"+ claveAsignatura + "', '" +
                 claveProfesor + "', '" + aula + "', '"+ horario + "'" ;
        
       
        
        int estado = EjecutarGuardado(nombreTabla, valores);
        
        
        if(FueExitoso(estado)){
             System.out.println("Grupo " + clave + " registrado");
             return EXITO;
         }else{
             System.err.println("Error al registrar grupo " + clave);
             return ERROR;
         }
    }
    
    public static int Actualizar(GrupoEscolar unGrupo){
        
        String nombreTabla = "grupoescolar";
               
        String claveProfesor = unGrupo.GetUnProfesor().GetClave();
        String claveAsignatura = unGrupo.GetUnaAsignatura().GetClave();
        String clave = unGrupo.GetClave();
        String horario = unGrupo.GetHorario();
        String aula = unGrupo.GetAula();
        
        String valores = "claveAsignatura = " + clave + ", claveProfesor = " + claveProfesor +
                ", aula = " + claveAsignatura + ", horario = " + horario;
        String condicion = "claveGrupo = " + clave;
                        
        int estado = EjecutarActualizacion(nombreTabla, valores, condicion);
            
         if(FueExitoso(estado)){
             System.out.println("Grupo " + clave + " actualizado.");
             return EXITO;
         }else{
             System.err.println("Error al actualizar el grupo " + clave);
             return ERROR;
         }
        
        
    }

    public static int Borrar(String clave){
            
            String nombreTabla = "grupoescolar";
            String condicion = "claveGrupo = '" + clave + "'";
            
            int estado = EjecutarEliminacion(nombreTabla, condicion);
            
         if(FueExitoso(estado)){
             System.out.println("Grupo [" + clave + "] eliminado.");
             return EXITO;
         }else{
             System.err.println("Error al eliminar grupo " + clave);
             return ERROR;
         }
        
    }

    public static ArrayList<GrupoEscolar> GenerarLista(){
              
        ArrayList<GrupoEscolar> lista = new ArrayList<>();
        try{
            
            Statement consulta = miConexion.createStatement();
            ResultSet resultado = consulta.executeQuery(
                    "SELECT * FROM grupoescolar gpo JOIN asignaturas asig ON "
                            + "gpo.claveAsignatura = asig.claveAsignatura JOIN profesores prof "
                            + "ON gpo.claveProfesor = prof.claveProfesor");
           
            while(resultado.next()){
                Profesor unProfesor= new Profesor(resultado.getString("nombreProfesor"), resultado.getString("apellidosProfesor"), resultado.getString("claveProfesor"));
                Asignatura unaAsignatura = new Asignatura(resultado.getString("nombreAsignatura"), resultado.getString("claveAsignatura"));
                
                lista.add(new GrupoEscolar(
                        resultado.getString("claveGrupo"), unaAsignatura, unProfesor, resultado.getString("aula"), resultado.getString("horario")));
            }
        }catch(SQLException ex){
            System.err.println("Error al generar lista. " + ex);
            JOptionPane.showMessageDialog(null, "Error al generar la lista.",
                    "Error Lista", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
   }

    public static void Inscribir(String clave, String matricula) {
             
       /* Connection miConexion = BaseDatos.ObtenerConexion(); 
        try{
            PreparedStatement consulta = miConexion.prepareStatement("INSERT INTO "+
                    "inscripciongrupo (claveGrupo, matricula) "+
                    "VALUES (?, ?)");
            consulta.setString(1,clave );
            consulta.setString(2, matricula);
            
            
            consulta.executeUpdate();
            System.out.println("Alumno: " + clave + ", registrado.");
          
        }catch(SQLException ex){
            System.err.println("Error al inscribir alumno.");
        }*/
        
    }
    
}
