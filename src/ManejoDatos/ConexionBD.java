package ManejoDatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cristian Xool
 * 
 * Clase que tiene las funciones para hacer conexiÃ³n
 * con la base de datos, al igual que crear la BD y sus
 * respectivas tablas en caso que no existan.
 * 
 */
public class ConexionBD {
    
    
    public static int Conectar(){
        miConexion = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost/" + baseDatos;
            String usuario = "root";
            String contrasenia = "";
            miConexion = DriverManager.getConnection(servidor, usuario, contrasenia);
            
            System.out.println("Conexion exitosa!");
            DAOBase.setConexion(miConexion);
            return EXITO;
        } catch (ClassNotFoundException e){
            System.err.println("No se encontro Driver de JBDC. " + e.getMessage());
            return ERROR_JBDC;
        } catch (SQLException ex){
            System.err.println("No se pudo conectar a la Base de Datos. " + ex.getSQLState());
            return ERROR_CONEXION_BD;
        }
     
    }
    
//    public static Connection ObtenerConexion(){
//        if(miConexion == null){
//            System.err.println("No hay conexion con la base de datos.");
//        }
//        return miConexion;
//    }
    
    public static int GenerarBD(){
        Statement consulta;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexionInicial = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=");
            consulta = conexionInicial.createStatement();
            
            consulta.executeUpdate("CREATE DATABASE IF NOT EXISTS " +
                baseDatos + ";");
            conexionInicial.close();
            Conectar();
            consulta = miConexion.createStatement();
            
            consulta.executeUpdate("CREATE TABLE IF NOT EXISTS Alumnos"+
                    "(matricula varchar(8) NOT NULL,"+
                    " nombreAlumno varchar(30),"+
                    " apellidosAlumno varchar(30),"+
                    " PRIMARY KEY(matricula)"+
                    ");");
            
            consulta.executeUpdate("CREATE TABLE IF NOT EXISTS Asignaturas"+
                    "(claveAsignatura varchar(8) NOT NULL,"+
                    " nombreAsignatura varchar(30),"+
                    " PRIMARY KEY(claveAsignatura)"+
                    ");");
            
            consulta.executeUpdate("CREATE TABLE IF NOT EXISTS Profesores"+
                    "(claveProfesor varchar(8) NOT NULL,"+
                    " nombreProfesor varchar(30),"+
                    " apellidosProfesor varchar(30),"+
                    " PRIMARY KEY(claveProfesor)"+
                    ");");
            
            consulta.executeUpdate("CREATE TABLE IF NOT EXISTS GrupoEscolar"+
                    "(claveGrupo varchar(8) NOT NULL,"+
                    " claveAsignatura varchar(30),"+
                    " claveProfesor varchar(30),"+
                    " aula varchar(3),"+
                    " horario varchar(11),"+
                    " PRIMARY KEY(claveGrupo),"+
                    " FOREIGN KEY(claveAsignatura) REFERENCES Asignaturas(claveAsignatura),"+
                    " FOREIGN KEY(claveProfesor) REFERENCES Profesores(claveProfesor)"+
                    ");");
            
              consulta.executeUpdate("CREATE TABLE IF NOT EXISTS InscripcionGrupo"+
                    "(claveGrupo varchar(8) NOT NULL,"+
                    " matricula varchar(8) NOT NULL,"+
                    " CONSTRAINT claveInscripcion PRIMARY KEY(claveGrupo, matricula),"+
                    " FOREIGN KEY(claveGrupo) REFERENCES GrupoEscolar(claveGrupo),"+
                    " FOREIGN KEY(matricula) REFERENCES Alumnos(matricula)"+
                    ");");
              
              System.out.println("Base de datos generada!");
              return EXITO;
            
        } catch (ClassNotFoundException e){
            System.err.println("No se encontro Driver de JBDC. " + e.getMessage());
            return ERROR_JBDC;
        } catch (SQLException ex) {
            System.err.println("No se pudo generar la Base de Datos. " + ex.getSQLState());
            return ERROR_CONEXION_BD;
        }
    }
    
    private static Connection miConexion = null;
    private static String baseDatos = "administradorgpo";
    private static final int EXITO = 0;
    private static final int ERROR_CONEXION_BD = -1;
    private static final int ERROR_JBDC = -2;
    
}
