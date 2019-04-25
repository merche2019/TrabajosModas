/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author didi
 */
public class GestoraInformacion {
    
    private TreeMap<String, Prenda> listaPrendas= new TreeMap<String, Prenda>();
    private TreeMap<String, Proveedor> listaProveedor= new TreeMap<String, Proveedor>();
    
    public GestoraInformacion(){
        this.cargarDatosIniciales();
    }
    
    public Proveedor[] getLosProveedores(){
        return listaProveedor.values().toArray(new Proveedor []{});
    }
    
    public Prenda[] devolverPrendasOrdenado(){
        ArrayList<Prenda> lista = new ArrayList(listaPrendas.values());
        Collections.sort(lista);
        return lista.toArray(new Prenda[]{});
    }
    
    public boolean agregarProveedor(Proveedor p){
        //return listaProveedor.put(p.getNombre(), p) != null;
        if(!this.existeProveedor(p)){
            this.listaProveedor.put(p.getNombre(), p);
            return true;
        }
        return false;
    }
    
    public boolean agregarPrenda(Prenda p){
        if (!this.existePrenda(p)) { 
            this.listaPrendas.put(p.getCodigo(), p);
            return true;
        }
        return false;
    }
    
    public Proveedor devolverProveedor(String nombre){
        if(this.listaProveedor.containsKey(nombre)){
            return listaProveedor.get(nombre);
        }
        else{
            return null;
        }
    }
    
    public Prenda devolverPrenda(String codigo){
        if (this.listaPrendas.containsKey(codigo)) {
            return listaPrendas.get(codigo);
        }
        else{
            return null;
        }
    }
    
    public String[] devolverNombresProveedor(){
        if(this.listaProveedor == null || this.listaProveedor.size() == 0) {
            this.listaProveedor = new TreeMap<String, Proveedor>();
            this.cargarDatosIniciales();
        }
        return this.listaProveedor.keySet().toArray(new String []{});
    }
    
    public boolean existePrenda(Prenda prenda){
        return this.listaPrendas.containsKey(prenda.getCodigo());
    }
    
    public boolean existeProveedor(Proveedor p){
        return this.listaProveedor.containsKey(p.getNombre());
    }
    
    public int devolverNumeroDeProveedores(){
        return listaProveedor.size();
    }
    
    public int devolverNumeroDePrendas(){
        return listaPrendas.size();
    }
    
    public void eliminarPrenda(String codigo){
        this.listaPrendas.remove(codigo);
    }
    
    public void cargarFichero(){
        try {
            FileInputStream cargar= new FileInputStream("prendas.dat");
            ObjectInputStream o= new ObjectInputStream(cargar);
            while(cargar.available() > 0) {
                this.agregarPrenda((Prenda)o.readObject());
            }
          
            o.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestoraInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestoraInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestoraInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarFichero(){
        try{
            FileOutputStream guardar= new FileOutputStream("prendas.dat");
            ObjectOutputStream o= new ObjectOutputStream(guardar);
            for(Prenda p : this.devolverPrendasOrdenado()){
                o.writeObject(p);    
            }
            
            o.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestoraInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestoraInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarDatosIniciales(){
        this.agregarProveedor(new Proveedor("CEPRESA SL", "983111111"));
        this.agregarProveedor(new Proveedor("FAMECA SA", "616333333"));
        this.agregarProveedor(new Proveedor("MODELOS SA", "654222222"));
    }
}
