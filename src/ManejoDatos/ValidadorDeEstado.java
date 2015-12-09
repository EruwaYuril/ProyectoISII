/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoDatos;

/**
 *
 * @author Cristian Xool
 */
public class ValidadorDeEstado {
    
    public static final int NO_SELECCION = -1;
    
    public static boolean Exito(int estado){
        final int EXITO = 0;
        if(estado == EXITO){
            return true;
        }else{
            return false;
        }
    }
}
