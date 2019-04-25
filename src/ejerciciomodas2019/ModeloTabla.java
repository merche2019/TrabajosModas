package ejerciciomodas2019;


import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class ModeloTabla extends DefaultTableModel{

    private Prenda[] lasPrendas;
    
    
    public ModeloTabla(Prenda[] p){
        lasPrendas = p;
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
        String[] titulos = {
            "CODIGO",
            "ESTILO",
            "TALLA ESPECIAL",
            "PROVEEDOR"
        };
        return titulos[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?>[] clases = {
            String.class,
            TipoPrenda.class,
            Boolean.class,
            String.class
        };
        return clases[columnIndex];        
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prenda prenda = lasPrendas[rowIndex];
        if (prenda == null) {
            return null;
        }            

        Object[] infoPrenda = {
            this.lasPrendas[rowIndex].getCodigo().toUpperCase(),
            this.lasPrendas[rowIndex].getTipo(),
            this.lasPrendas[rowIndex].isEspecial(),
            this.lasPrendas[rowIndex].getElProveedor(),
        };
        
        return infoPrenda[columnIndex];
     }

    
    
}
