/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author fer
 */
public class ModeloTabla extends DefaultTableModel {

    private Prenda[] lasPrendas;
    
    public ModeloTabla(Prenda lasPrendas[]){
        this.lasPrendas=lasPrendas;  
    }
    
    @Override
    public int getRowCount() {
        return this.lasPrendas==null?0:this.lasPrendas.length;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String[] nombres={"CODIGO", "TIPO", "ESPECIAL", "PROVEEDOR"};
        return nombres[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
       Class<?> [] clases= {String.class, TipoPrenda.class, Boolean.class, Proveedor.class};
       return clases[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Prenda unaPrenda =lasPrendas[rowIndex];
        Object[] partesInformacion = {unaPrenda.getCodigo(), unaPrenda.getTipo(),
        unaPrenda.getProveedor(), unaPrenda.isEspecial()};
        return partesInformacion[columnIndex];
    }
    
}
