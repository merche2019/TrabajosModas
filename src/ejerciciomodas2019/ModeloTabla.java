/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Usuario
 */
public class ModeloTabla extends DefaultTableModel {
    private int filas;
    private Prenda[] lasPrendas;
    
    public ModeloTabla(Prenda[] lasPrendas) {
        this.lasPrendas=lasPrendas;
    }
    
    @Override
    public int getRowCount() {
        return lasPrendas==null?0:lasPrendas.length;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String[] columnName = {"CÓDIGO", "ESTILO", "TALLA ESPECIAL", "PROVEEDOR"};
        return columnName[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class[] lasClases = {String.class, TipoPrenda.class, Boolean.class, Proveedor.class};
        return lasClases[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(getRowCount()>0){
            switch (columnIndex){
                case 0:return lasPrendas[rowIndex].getCodigo();
                case 1:return lasPrendas[rowIndex].getTipo();
                case 2:return lasPrendas[rowIndex].isEspecial();
                case 3:return lasPrendas[rowIndex].getElProveedor();
            }
            
        }
        return null;
    }

    

    
    
    
}
