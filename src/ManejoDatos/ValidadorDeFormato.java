/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoDatos;

import javax.swing.text.MaskFormatter;

/**
 *
 * @author Edwin
 */
public class ValidadorDeFormato {
       
    public static MaskFormatter crearFormato(String s) {
        MaskFormatter formato = null;
        try {
            formato = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("El formato es incorrecto: " + exc.getMessage());
            System.exit(-1);
        }
        return formato;
    }
}
