/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;



import java.util.Collection;
import java.util.TreeMap;

/**
 *
 * @author Usuario
 */
public class GestoraInformación {
    TreeMap<String, Prenda> lasPrendas = new TreeMap<>();
    TreeMap<String, Proveedor> losProveedores = new TreeMap<>();
    
    public Proveedor[] getLosProveedores(){
        Collection<Proveedor> listaProv = losProveedores.values();
        
        Proveedor[] prov = new Proveedor[losProveedores.size()];
        
        prov = (Proveedor[]) listaProv.toArray();
        return prov;
    }
    public Prenda[] devolverPrendasOrdenado(){
        Collection<Prenda> listaPren = lasPrendas.values();
        
        Prenda[] pren = new Prenda[lasPrendas.size()];
        
        pren = (Prenda[]) listaPren.toArray();
        return pren;
    }
    public boolean agregarProveedor(Proveedor p){
        if (!losProveedores.containsKey(p.getNombre())) {
            losProveedores.put(p.getNombre(), p);
            return true;
        }
        return false;
    }
    public boolean agregarPrenda(Prenda p ){
        if (!lasPrendas.containsKey(p.getCodigo())) {
            lasPrendas.put(p.getCodigo(), p);
            return true;
        }
        return false;
    }
    public Proveedor devolverProveedor(String nombre){
        
        return losProveedores.get(nombre);
        
    }
    public Prenda devolverPrenda(String codigo){
        
        return lasPrendas.get(codigo);
    }
    public String[] devolverNombresProveedor(){
        Collection<String> listaNombres = losProveedores.keySet();
        String[] nombres = new String[losProveedores.size()];
        nombres = listaNombres.toArray(new String[losProveedores.size()]);
        return nombres;
    }
    public boolean existePrenda(Prenda prenda){
        
        return lasPrendas.containsKey(prenda.getCodigo());
    }
    public boolean existeProveedor(Proveedor p){
        
        return losProveedores.containsKey(p.getNombre());
    }
    public int devolverNumeroDeProveedores(){
        
        return losProveedores.size();
    }
    public int devolverNumeroDePrendas(){
        
        return lasPrendas.size();
    }
    private void cargarDatosIniciales(){
        
    }
}
