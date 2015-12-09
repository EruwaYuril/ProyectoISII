/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoDatos;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Cristian Xool
 */

public class ValidadorDeLongitudTexto extends PlainDocument {
    
    public ValidadorDeLongitudTexto(int limite) {
        
        super();
        this.limite = limite;
        
    }
    
    @Override
    public void insertString(int offset, String  str, AttributeSet attr)throws BadLocationException {
        
        if (str == null){
            return;
        }
        
        if ((getLength() + str.length()) <= limite) {
            
            super.insertString(offset, str, attr);
        }
        
    }
    
    public static final int LONGITUD_CLAVE = 8;
    public static final int LONGITUD_MATRICULA = 8;
    
    private final int limite;
    
}

