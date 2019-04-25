/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import javax.swing.JComponent;

/**
 *
 * @author fer
 */
public class MiExcepcion extends Exception{
    
    private JComponent comp;
    private String string;
    
    public MiExcepcion(JComponent comp, String string){
        this.string=string;
        this.comp=comp;        
    }
    
    public JComponent getComp(){
        return comp;
    }
}
