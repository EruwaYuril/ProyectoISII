package Modulo;

/**
 *
 * @author Cristian Xool
 * 
 * Clase objeto que describe los atributos de los grupos.
 * 
 */
public class GrupoEscolar {
    
    private Profesor unProfesor;
    private Asignatura unaAsignatura;
    private String clave;
    private String horario;
    private String aula;

    public GrupoEscolar(Profesor unProfesor, Asignatura unaAsignatura, String clave, String horario, String aula) {
        this.unProfesor = unProfesor;
        this.unaAsignatura = unaAsignatura;
        this.clave = clave;
        this.horario = horario;
        this.aula = aula;
    }

    public void SetUnProfesor(Profesor unProfesor) {
        this.unProfesor = unProfesor;
    }

    public void SetUnAsignatura(Asignatura unaAsignatura) {
        this.unaAsignatura = unaAsignatura;
    }

    public void SetClaveGrupo(String claveGrupo) {
        this.clave = clave;
    }

    public void SetHorario(String horario) {
        this.horario = horario;
    }

    public void SetAula(String aula) {
        this.aula = aula;
    }
    
    public Profesor GetUnProfesor() {
        return unProfesor;
    }

    public Asignatura GetUnaAsignatura() {
        return unaAsignatura;
    }

    public String GetClave() {
        return clave;
    }

    public String GetHorario() {
        return horario;
    }

    public String GetAula() {
        return aula;
    }   
}
