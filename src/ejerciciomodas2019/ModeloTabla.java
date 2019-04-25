package ejerciciomodas2019;


import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rafa
 */
public class ModeloTabla extends DefaultTableModel {

    private int filas = 0;
    Prenda[] listado = null;
    String[] columnas = {"CÓDIGO", "ESTILO", "TALLA ESPECIAL", "PROVEEDOR"};
    Class[] tipos = {String.class, TipoPrenda.class, Boolean.class, String.class};

    public ModeloTabla(Prenda[] lasPrendas) {
        this.listado = lasPrendas;
        this.filas = listado.length;
    }

    @Override
    public int getRowCount() {
        return filas;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return tipos[columnIndex];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return listado[row].getCodigo();
            case 1:
                return listado[row].getTipo();
            case 2:
                return listado[row].isEspecial();
            case 3:
                return listado[row].getElProveedor();
        }
        return null;
    }

}
