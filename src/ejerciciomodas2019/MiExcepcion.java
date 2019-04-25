/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import javax.swing.JComponent;

/**
 *
 * @author César
 */
public class MiExcepcion extends Exception{
    private JComponent componente;

    public MiExcepcion (JComponent componente, String string) {
        super(string);
        this.componente = componente;
    }

    public JComponent getComponente() {
        return componente;
    }
}
