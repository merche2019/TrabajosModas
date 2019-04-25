/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tarod
 */
public class ModeloTabla extends DefaultTableModel {
    private Prenda[] lasPrendas;

    public ModeloTabla() {
        this.lasPrendas = GestoraInformacion.getInstance().devolverPrendasOrdenado();
    }

    @Override
    public int getRowCount() {
        return this.lasPrendas == null ? 0 : this.lasPrendas.length;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String[] columnTitles = {
            "CÓDIGO",
            "ESTILO",
            "TALLA ESPECIAL",
            "PROVEEDOR"
        };
        
        return columnTitles[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> [] columnClasses = {
            String.class,
            TipoPrenda.class,
            Boolean.class,
            String.class
        };
        
        return columnClasses[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] prendaData = {
            this.lasPrendas[rowIndex].getCodigo(),
            this.lasPrendas[rowIndex].getTipo(),
            this.lasPrendas[rowIndex].isEspecial(),
            this.lasPrendas[rowIndex].getElProveedor().toString()
        };
        
        return prendaData[columnIndex];
    }
    
}
