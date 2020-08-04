/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDeNegocio;

import javax.swing.text.AttributeSet;
import javax.swing.text.PlainDocument;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Flores Lira
 */
public class JTextAreaLimit extends PlainDocument {
    private int limit;

    public JTextAreaLimit(int limit) {
        super();
        this.limit = limit;
    }

    @Override
  public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
    if (str == null) return;
    if ((getLength() + str.length()) <= limit) {
        super.insertString(offset, str, attr);
    }
  }
}
