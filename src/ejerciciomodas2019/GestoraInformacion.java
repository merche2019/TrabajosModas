package ejerciciomodas2019;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class GestoraInformacion extends TreeMap<String, Prenda>{

    private TreeMap<String, Prenda> lasPrendas;
    private TreeMap<String, Proveedor> losProveedores;

    public GestoraInformacion() {
        this.lasPrendas = new TreeMap<String, Prenda>();
        this.losProveedores = new TreeMap<String, Proveedor>();     
        this.cargarDatosIniciales();
    }    
    
    public Proveedor[] getLosProveedores() {
        return (Proveedor[])this.losProveedores.values().toArray();
    }
    
    public Prenda[] devolverPrendasOrdenado() {
        ArrayList<Prenda> prendas = new ArrayList<>();
        Collection<Prenda> coleccionPrendas = this.lasPrendas.values();
        
        for(Prenda unaPrenda : coleccionPrendas) {
            prendas.add(unaPrenda);
        }
        return prendas.toArray(new Prenda[prendas.size()]);
    }
    
    public boolean agregarProveedor(Proveedor p) {
        return this.losProveedores.put(p.getNombre(), p) != null;
    }
    
    public boolean agregarPrenda(Prenda p) {
        return this.lasPrendas.put(p.getCodigo(), p) != null;
    }
    
    public boolean eliminarPrenda(String key) {
        return this.lasPrendas.remove(key) != null;
    }
    
    public Proveedor devolverProveedor(String nombre) {
        return this.losProveedores.get(nombre);
    }
    
    public Prenda devolverPrenda(String codigo) {
        return this.lasPrendas.get(codigo);
    }
    
    public String[] devolverNombresProveedores() {
        Object[] clavesProveedores = this.losProveedores.keySet().toArray();
        return Arrays.copyOf(clavesProveedores,
                            clavesProveedores.length,
                            String[].class);
    }
    
    public boolean existePrenda(Prenda p) {
        String codigo = p.getCodigo();
        return this.lasPrendas.get(codigo) != null;
    }
    
    public boolean existeProveedor(Proveedor p) {
        String nombre = p.getNombre();
        return this.lasPrendas.get(nombre) != null;
    }
    
    public int devolverNumPrendas() {
        return this.lasPrendas.size();
    }
    
    public int devolverNumProveedores() {
        return this.losProveedores.size();
    }
    
    private void cargarDatosIniciales() {
        
        Proveedor proveedor1 = new Proveedor("FAMECA", "654321987");
        Proveedor proveedor2 = new Proveedor("MODELOS", "654987321");
        Proveedor proveedor3 = new Proveedor("CEPRESA", "654789123");
        
        this.losProveedores.put(proveedor1.getNombre(), proveedor1);
        this.losProveedores.put(proveedor2.getNombre(), proveedor2);
        this.losProveedores.put(proveedor3.getNombre(), proveedor3);
                
        
        Prenda prenda1 = new Prenda("AER-23", TipoPrenda.SPORT, true, proveedor2);
        Prenda prenda2 = new Prenda("KOP-21", TipoPrenda.GALA, false, proveedor1);
        Prenda prenda3 = new Prenda("ARÑ-56", TipoPrenda.ROCKERA, true, proveedor3);
        Prenda prenda4 = new Prenda("TTR-88", TipoPrenda.SPORT, false, proveedor1);
        Prenda prenda5 = new Prenda("YYP-12", TipoPrenda.CLÁSICA, false, proveedor2);
        Prenda prenda6 = new Prenda("AAA-53", TipoPrenda.ROCKERA, true, proveedor3);
        
        this.lasPrendas.put(prenda1.getCodigo(), prenda1);
        this.lasPrendas.put(prenda2.getCodigo(), prenda2);
        this.lasPrendas.put(prenda3.getCodigo(), prenda3);
        this.lasPrendas.put(prenda4.getCodigo(), prenda4);
        this.lasPrendas.put(prenda5.getCodigo(), prenda5);
        this.lasPrendas.put(prenda6.getCodigo(), prenda6);
                
    }
    
    private static final String FILE = "prendas.dat";
    static boolean escribirDatos(GestoraInformacion gestora){
        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(FILE))) {
            escritor.writeObject(gestora);
            return true;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestoraInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestoraInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false; 
    }
    static Object leerDatos() {
        try(ObjectInputStream lector = new ObjectInputStream(new FileInputStream(FILE))) {
            return lector.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestoraInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestoraInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestoraInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
