/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modulo;

/**
 *
 * @author Aaron
 * 
 * Clase objeto que describe los atributos de los alumnos.
 * 
 */
public class GrupoAlumno {
    
    //HolaCristian
    
    private GrupoEscolar unGrupo; 
    private Alumno unAlumno; 
    

    public GrupoAlumno(GrupoEscolar unGrupo, Alumno unAlumno) {
        this.unGrupo = unGrupo;
        this.unAlumno = unAlumno;
    }

    public GrupoAlumno() {
        this.unGrupo = null;
        this.unAlumno = null;
    }

    public GrupoEscolar getUnGrupo() {
        return unGrupo;
    }

    public void setUnGrupo(GrupoEscolar unGrupo) {
        this.unGrupo = unGrupo;
    }

    public Alumno getUnAlumno() {
        return unAlumno;
    }

    public void setUnAlumno(Alumno unAlumno) {
        this.unAlumno = unAlumno;
    }
    
    
    
    

    
}


