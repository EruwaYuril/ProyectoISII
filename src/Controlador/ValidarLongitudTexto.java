/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Cristian Xool
 */

public class ValidarLongitudTexto extends PlainDocument {
    
    public ValidarLongitudTexto(int limite) {
        super();
        this.limite = limite;
    }
    
    @Override
    public void insertString(int offset, String  str, AttributeSet attr)
            throws BadLocationException {
        
        if (str == null){
            return;
        }
        
        if ((getLength() + str.length()) <= limite) {
            if (aMayusculas){
                str = str.toUpperCase();
            }
            super.insertString(offset, str, attr);
        }
    }
    
    private final int limite;
    private final boolean aMayusculas = false;
}

