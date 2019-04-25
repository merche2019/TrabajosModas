/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import javax.swing.JComponent;

/**
 *
 * @author Alex
 */
public class MyException extends Exception {
    private JComponent componente;

    public MyException(JComponent componente, String mensaje) {
        super(mensaje);
        this.componente = componente;
    }
    
    public JComponent getComponente() {
        return componente;
    }
}
