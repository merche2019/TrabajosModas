/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Alex
 */
public class ModeloTabla extends DefaultTableModel{
    private Prenda[] lasPrendas;
    
    public ModeloTabla(Prenda[] lasPrendas){
        this.lasPrendas = lasPrendas;
    }

    @Override
    public int getRowCount() {
        return lasPrendas ==null ? 0 : lasPrendas.length;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String[] nombres = {"CÓDIGO", "ESTILO", "TALLA ESPECIAL", "PROVEEDOR"
        };
        return nombres[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?>[] clases = {
            String.class,
            TipoPrenda.class,
            boolean.class,
            Proveedor.class
        };
        return clases[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prenda prenda = lasPrendas[rowIndex];
        if (prenda == null) return null;
        String tipo = prenda.getCodigo();
        Object[] informacionPrenda = {
            this.lasPrendas[rowIndex].getCodigo(),
            this.lasPrendas[rowIndex].getTipo(),
            this.lasPrendas[rowIndex].isEspecial(),
            this.lasPrendas[rowIndex].getElProveedor()
        };
        return informacionPrenda[columnIndex];
    }
    
}
