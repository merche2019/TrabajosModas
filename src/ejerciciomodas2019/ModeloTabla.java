/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author César
 */
public class ModeloTabla extends DefaultTableModel{
    private Prenda[] lasPrendas;

    public ModeloTabla(Prenda[] lasPrendas) {
        this.lasPrendas = lasPrendas;
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
        String[] nombreColumna={"CODIGO", "ESTILO", "TALLA ESPECIAL","PROVEEDOR"};
        return nombreColumna[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class[] lasClases={String.class, Enum.class, Boolean.class, String.class};
        return lasClases[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prenda prenda=lasPrendas[rowIndex];
        Object[] campos={prenda.getCodigo(),prenda.getTipo(), prenda.isEspecial(), prenda.getElProveedor().getTelefono()+"-"+prenda.getElProveedor().getNombre()};
        return campos[columnIndex];
    }
    
}
