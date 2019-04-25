/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author César
 */
public class GestoraInformacion implements Serializable{
    
    private TreeMap<String, Proveedor> lProveedor=new TreeMap<String, Proveedor>();
    private TreeMap<String, Prenda> lPrenda= new TreeMap<String, Prenda>();
    
    public GestoraInformacion(){
        //El metodo "cargarDatosIniciales" es privado, por lo que al hacer un "new GestoraInformacio" desde la ventana, se cargarán estos datos
        try {
            cargarDatosIniciales();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestoraInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Proveedor[] getLosProveedores(){
       return lProveedor.values().toArray(new Proveedor[]{});
    }
    
    public Prenda[] devolverPrendasOrdenado(String seleccion){
        //Se ordenará en función de lo elegido en el jComboBox
        ArrayList<Prenda> listaPrendas=new ArrayList(lPrenda.values());
        switch (seleccion) {
            case "CODIGO":
                Collections.sort(listaPrendas, new ComparadoraCodigo());
                break;
            case "ESTILO":
                Collections.sort(listaPrendas, new ComparadoraEstilo());
                break;
            case "PROVEEDOR":
                Collections.sort(listaPrendas, new ComparadoraProveedor());
                break;
        }
//        Collections.sort(listaPrendas);
        return listaPrendas.toArray(new Prenda[]{});
    }
    
    public boolean agregarProveedor(Proveedor p){
        if(!existeProveedor(p)){
            lProveedor.put(p.getNombre(), p);
            return true;
        }
        return false;
    }
    
    public boolean agregarPrenda(Prenda p){
        if(!existePrenda(p)){
            lPrenda.put(p.getCodigo(), p);
            return true;
        }
        return false;
    }
    
    public Proveedor devolverProveedor(String nombre){
        for (Proveedor unProveedor : getLosProveedores()) {
            if(unProveedor.getNombre().equals(nombre)){
                return unProveedor;
            }
        }
        return null;
    }
    
    public Prenda devolverPrenda(String codigo){
        for (Prenda unaPrenda : devolverPrendasOrdenado("CODIGO")) {
            if(unaPrenda.getCodigo().equals(codigo)){
                return unaPrenda;
            }
        }
        return null;
    }
    
    public String[] devolverNombresProveedor(){
        int longitud=getLosProveedores().length;
        String[] listaNombres=new String[longitud];
        int contador=0;
        for (Proveedor unProveedor : getLosProveedores()) {
            listaNombres[contador]=unProveedor.getNombre();
            contador++;
        }
        return listaNombres;
    }
    
    public boolean existePrenda(Prenda prenda){
        return lPrenda.containsKey(prenda.getCodigo());
    }
    
    public boolean existeProveedor(Proveedor p){
        return lProveedor.containsKey(p.getNombre());
    }
    
    public int devolverNumeroDeProveedores(){
        return lProveedor.size();
    }
    
    public int devolverNumeroDePrendas(){
        return lPrenda.size();
    }
    
    private void cargarDatosIniciales() throws FileNotFoundException{
        Proveedor proveedor1 = new Proveedor("MODELOS S.A", "654222222");
        Proveedor proveedor2 = new Proveedor("CEPRESA S.L", "983111111");
        Proveedor proveedor3 = new Proveedor("FAMECA S.A", "616333333");
        
        
        Prenda prenda1 = new Prenda("ZHE-99", TipoPrenda.ROCKERA, false, proveedor3);
        Prenda prenda2 = new Prenda("AXD-22", TipoPrenda.GALA, false, proveedor1);
        Prenda prenda3 = new Prenda("CHA-65", TipoPrenda.SPORT, true, proveedor2);
        
        
        this.lProveedor.put(proveedor1.getNombre(), proveedor1);
        this.lProveedor.put(proveedor2.getNombre(), proveedor2);
        this.lProveedor.put(proveedor3.getNombre(), proveedor3);
        
        this.lPrenda.put(prenda1.getCodigo(), prenda1);
        this.lPrenda.put(prenda2.getCodigo(), prenda2);
        this.lPrenda.put(prenda3.getCodigo(), prenda3);
    }
    
    public void modificarDivisa(int prendaOriginal, Prenda prendaModificada) {
        Prenda[] arrayPrendas=devolverPrendasOrdenado("CODIGO");
        Prenda prendaOrigen=arrayPrendas[prendaOriginal];
        this.lPrenda.replace(prendaOrigen.getCodigo(), prendaOrigen, prendaModificada);
    }
    
    public void eliminar(int[] seleccionada){
        Prenda[] arrayPrendas=devolverPrendasOrdenado("CODIGO");
        for (int i : seleccionada) {
            Prenda unaPrenda=arrayPrendas[i];
            this.lPrenda.remove(unaPrenda.getCodigo());
        }
    }
}
