/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoDatos;

import Modulo.Alumno;
import Modulo.Asignatura;
import Modulo.GrupoAlumno;
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
        
        
        if(ValidadorDeEstado.Exito(estado)){
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
            
         if(ValidadorDeEstado.Exito(estado)){
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
            
         if(ValidadorDeEstado.Exito(estado)){
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
            
            Statement consulta = conexion.createStatement();
            ResultSet resultado = consulta.executeQuery(
                    "SELECT * FROM grupoescolar gpo JOIN asignaturas asig ON "
                            + "gpo.claveAsignatura = asig.claveAsignatura JOIN profesores prof "
                            + "ON gpo.claveProfesor = prof.claveProfesor");
           
            while(resultado.next()){
                Profesor unProfesor= new Profesor(resultado.getString("nombreProfesor"), 
                        resultado.getString("apellidosProfesor"), 
                        resultado.getString("claveProfesor"));
                Asignatura unaAsignatura = new Asignatura(resultado.getString("nombreAsignatura"), 
                        resultado.getString("claveAsignatura"));
                
                lista.add(new GrupoEscolar(
                        resultado.getString("claveGrupo"), 
                        unaAsignatura, unProfesor, 
                        resultado.getString("aula"), 
                        resultado.getString("horario")));
            }
        }catch(SQLException ex){
            System.err.println("Error al generar lista. " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al generar la lista.",
                    "Error Lista", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
   }
    
    public static ArrayList<GrupoAlumno> GenerarListaAlumnos(String claveGrupo){
              
        ArrayList<GrupoAlumno> lista = new ArrayList<>();
        System.out.println(claveGrupo);
        try{
            
            Statement consulta = conexion.createStatement();
            ResultSet resultado = consulta.executeQuery(
                    "SELECT ins.claveGrupo, ins.matricula, nombreAlumno, apellidosAlumno, asig.claveAsignatura, nombreAsignatura, aula, horario,"
                            + "prof.claveProfesor, nombreProfesor, apellidosProfesor "
                            + "    FROM inscripciongrupo ins JOIN alumnos "
                            + "ON ins.matricula = alumnos.matricula "
                            + "JOIN grupoescolar gpo ON ins.claveGrupo = gpo.claveGrupo "
                            + "JOIN asignaturas asig ON gpo.claveAsignatura = asig.claveAsignatura "
                            + "JOIN profesores prof ON gpo.claveProfesor = prof.claveProfesor "
                            + "WHERE ins.claveGrupo = '" + claveGrupo + "'");
           
            while(resultado.next()){
                Profesor unProfesor= new Profesor(resultado.getString("nombreProfesor"), 
                        resultado.getString("apellidosProfesor"), 
                        resultado.getString("claveProfesor"));
                Asignatura unaAsignatura = new Asignatura(resultado.getString("claveAsignatura"), 
                        resultado.getString("nombreAsignatura"));
                GrupoEscolar unGrupo = new GrupoEscolar(resultado.getString("claveGrupo"), 
                        unaAsignatura, unProfesor, resultado.getString("aula"), 
                        resultado.getString("horario"));
                Alumno unAlumno = new Alumno(resultado.getString("matricula"), 
                        resultado.getString("nombreAlumno"), 
                        resultado.getString("apellidosAlumno"));
                
                lista.add(new GrupoAlumno(unGrupo, unAlumno));
            }
        }catch(SQLException ex){
            System.err.println("Error al generar lista. " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al generar la lista.",
                    "Error Lista", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
   }
    
}
