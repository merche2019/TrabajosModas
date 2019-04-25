package ejerciciomodas2019;


import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class MiExcepcion extends Exception {
    
    private JComponent elComponente;

    public MiExcepcion(JComponent elComponente, String string) {
        super(string);
        this.elComponente = elComponente;
    }

    public JComponent getElComponente() {
        return elComponente;
    }

}
