/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author Alex
 */
public class GestoraInformacion {
    private TreeMap<String, Prenda> lasPrendas;
    private TreeMap<String, Proveedor> losProveedores;

    public GestoraInformacion() {
        this.lasPrendas = new TreeMap<String, Prenda>();
        this.losProveedores = new TreeMap<String, Proveedor>();
    }
    
    public static GestoraInformacion getInstance(){
        GestoraInformacion gestora = new GestoraInformacion();
        gestora.cargarDatosIniciales();
        return gestora;
    }
    
    public Proveedor[] getLosProveedores(){
        return (Proveedor[])this.losProveedores.values().toArray();
    }
    
    public Prenda[] devolverPrendasOrdenado(){
        return (Prenda[])this.lasPrendas.values().toArray();
    }
    
    public boolean agregarProveedor(Proveedor p){
        return this.losProveedores.put(p.getNombre(), p) != null;
    }
    
    public boolean agregarPrenda(Prenda p){
        return this.lasPrendas.put(p.getCodigo(), p) != null;
    }
    
    public Proveedor devolverProveedor(String nombre){
        return this.losProveedores.get(nombre);
    }
    
    public Prenda devolverPrenda(String nombre){
        return this.lasPrendas.get(nombre);
    }
    
    public String[] devolverNombresProveedor(){
        Object[] clavesProveedor = this.losProveedores.keySet().toArray();
        return Arrays.copyOf(clavesProveedor, clavesProveedor.length, String[].class);
    }
    
    public boolean existePrenda(Prenda prenda){
        String codigo = prenda.getCodigo();
        return this.lasPrendas.get(codigo) != null; 
    }
    
    public boolean existeProveedor(Proveedor p){
        String nombre = p.getNombre();
        return this.losProveedores.get(nombre) != null;
    }
    
    public int devolverNumeroProveedores(){
        return this.losProveedores.size();
    }
    
    public int devolverNumeroPrendas(){
        return this.lasPrendas.size();
    }
    
    public void cargarDatosIniciales(){
        Proveedor proveedor1 = new Proveedor("Modelos S.A", "654222222");
        Proveedor proveedor2 = new Proveedor("Fameca S.A", "616333333");
        Proveedor proveedor3 = new Proveedor("Cepresa S.A", "983111111");
        
        Prenda prenda1 = new Prenda("AXD-22", TipoPrenda.GALA, false, proveedor1);
        Prenda prenda2 = new Prenda("CBP-05", TipoPrenda.CLASICA, false, proveedor2);
        Prenda prenda3 = new Prenda("CBÑ-01", TipoPrenda.SPORT, true, proveedor3);
        Prenda prenda4 = new Prenda("CBÑ-10", TipoPrenda.SPORT, true, proveedor3);
        Prenda prenda5 = new Prenda("CHA-65", TipoPrenda.SPORT, true, proveedor1);
        
        
        this.lasPrendas.put(prenda1.getCodigo(), prenda1);
        this.lasPrendas.put(prenda2.getCodigo(), prenda2);
        this.lasPrendas.put(prenda3.getCodigo(), prenda3);
        this.lasPrendas.put(prenda4.getCodigo(), prenda4);
        
        this.losProveedores.put(proveedor1.getNombre(), proveedor1);
        this.losProveedores.put(proveedor2.getNombre(), proveedor2);
        this.losProveedores.put(proveedor3.getNombre(), proveedor3);
        
        
    }
}
