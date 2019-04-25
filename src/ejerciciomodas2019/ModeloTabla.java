/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author didi
 */
public class ModeloTabla extends DefaultTableModel{
    
    private int filas = 0;
    Prenda[] lista= null;
    String nombres[] = new String[] {"CÓDIGO", "ESTILO", "TALLA ESPECIAL", "PROVEEDOR"};
    Class tipos[]= new Class[] {String.class, TipoPrenda.class, Boolean.class, String.class};
    
    public ModeloTabla(Prenda lasPrendas[]){
        this.lista= lasPrendas;
        this.filas = this.lista.length;
    }
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    @Override
    public int getRowCount(){
        return this.filas;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return this.nombres[columnIndex];
    }
    
    @Override
    public Object getValueAt(int f, int c){
        switch(c){
            case 0:
                return this.lista[f].getCodigo();
            case 1:
                return this.lista[f].getTipo();
            case 2:
                return this.lista[f].isEspecial();
            case 3:
                return this.lista[f].getElProveedor();
        }
        return null;
    }
    
    @Override
    public Class getColumnClass(int columnIndex){
      return tipos[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
}
