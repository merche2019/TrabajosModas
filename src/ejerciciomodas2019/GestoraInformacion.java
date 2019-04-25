/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import java.util.ArrayList;
import java.util.TreeMap;


/**
 *
 * @author fer
 */
public class GestoraInformacion extends TreeMap<String, Prenda>{
    
    private TreeMap<String, Proveedor> conjProve= new TreeMap<String, Proveedor>();
    
    public GestoraInformacion(){
    
        GestoraInformacion informacion = (GestoraInformacion)GestoraAlmacenamiento.leerDatos();
        if(informacion.equals(null)){
            this.cargarDatosIniciales();
        }else{
            informacion.putAll(this);
        }
    }
    
    public Proveedor[] getLosProveedores(){
        Proveedor[] proveedor=null;
        
        return proveedor;
    }
    
    public Prenda[] devolverPrendasOrdenadas(){
        Prenda[] prenda=new Prenda[this.size()];
        
        return prenda;
    }
    
    public boolean codigoCorrecto(String codigo){
        return codigo.matches("[a-z]{3}[-]{1}[0-9]{2}");
    }
    
    public boolean agregarProveedor(Proveedor prov){
        boolean devolver=true;        
        boolean[] criterios={this.containsValue(prov)};
        for(boolean criterio:criterios){
            if(criterio==true){
                devolver = devolver;
            }
        }return devolver;
    }
    
    public boolean agregarPrenda(Prenda p){
        
        return false;
    }
    
    public Proveedor devolverProveedor(String nombre){
        Proveedor[] listaPro= new Proveedor[getLosProveedores().length];
        for (Proveedor buscaProveedor : listaPro) {
            if (buscaProveedor.getNombre().equals(nombre)) {
                return buscaProveedor;
            }
        }
        return null;
    }
    
    public Prenda devolverPrenda(String codigo){
        Prenda [] buscaPrenda=new Prenda[devolverPrendasOrdenadas().length];
        for(Prenda laPrenda:buscaPrenda){
            if(laPrenda.getCodigo().equals(codigo)){
                return laPrenda;
            }
        }
        return null;
    }
    
    public String[] devolverNombresProveedor(){
        String[] nombresProveedor=new String[getLosProveedores().length];
        for(int i=0; i<getLosProveedores().length; i++){
            nombresProveedor[i]=getLosProveedores()[i].getNombre();
        }
        return nombresProveedor;
    }
    
    public boolean existeProveedor(Proveedor p){
        return this.containsValue(p);
    }
    
    public boolean existePrenda(Prenda p){
        return this.containsValue(p);
    }
    
    public int devolverNumeroProveedores(){
        int numeroPro=0;
        Proveedor[] listaP=new Proveedor[getLosProveedores().length];
        for(Proveedor elProveedor:listaP){
            numeroPro++;
        }
        return numeroPro;
    }   
    
    public int devolverNumeroPrendas(){
        int numeroPre=0;
        Prenda[] lasPrendas=new Prenda[devolverPrendasOrdenadas().length];
        for(Prenda unaP:lasPrendas){
            numeroPre++;
        }
        return numeroPre;
    }
    
    public void cargarDatosIniciales(){
        
    }
    
}
