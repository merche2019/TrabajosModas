/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import java.io.Serializable;
import java.util.Arrays;
import java.util.TreeMap;

/**
 *
 * @author Tarod
 */
public class GestoraInformacion implements Serializable {

    private static GestoraInformacion INSTANCE;
    private final TreeMap<String, Prenda> lasPrendas = new TreeMap<>();
    private final TreeMap<String, Proveedor> losProveedores = new TreeMap<>();

    private GestoraInformacion(){}

    public static GestoraInformacion getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new GestoraInformacion();
            INSTANCE.cargarDatosIniciales();
        }
        return INSTANCE;
    }

    public Proveedor[] getLosProveedores() {
        Object[] objetoProveedores = this.losProveedores.values().toArray();
        return Arrays.copyOf(objetoProveedores,
                             objetoProveedores.length,
                             Proveedor[].class);
    }

    public Prenda[] devolverPrendasOrdenado() {
        Object[] objetoPrendas = this.lasPrendas.values().toArray();
        return Arrays.copyOf(objetoPrendas,
                             objetoPrendas.length,
                             Prenda[].class);
    }

    public boolean agregarProveedor(Proveedor p) {
        return this.losProveedores.put(p.getNombre(), p) != null;
    }

    // TODO: Por que ==?
    public boolean agregarPrenda(Prenda p) {
        return this.lasPrendas.put(p.getCodigo(), p) == null;
    }
    
    /**
     * Modifica la prenda con el codigo respectivo.
     * @param nuevaPrenda
     * @return true si se ha modificado correctamente.
     */
    public boolean modificarPrenda(String codigo, Prenda nuevaPrenda) {
        return this.lasPrendas.put(codigo, nuevaPrenda) != null;
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

    public String[] devolverNombresProveedor() {
        Object[] clavesProveedor = this.losProveedores.keySet().toArray();
        return Arrays.copyOf(clavesProveedor,
                             clavesProveedor.length,
                             String[].class);
    }

    // TODO: Estos dos metodos podrian esperar directamente la supuesta clave.
    public boolean existePrenda(Prenda p) {
        return this.lasPrendas.get(p.getCodigo()) != null;
    }

    public boolean existeProveedor(Proveedor p) {
        return this.losProveedores.get(p.getNombre()) != null;
    }

    public int devolverNumeroDeProveedores() {
        return this.losProveedores.size();
    }

    public int devolverNumeroDePrendas() {
        return this.lasPrendas.size();
    }

    private void cargarDatosIniciales() {
        GestoraInformacion infoAlmacenada = GestoraAlmacenamiento.leerDatos();
        
        if(infoAlmacenada != null) {
            INSTANCE = infoAlmacenada;
        } else {
            Proveedor proveedor1 = new Proveedor("Fameca S.A", "645894765");
            Proveedor proveedor2 = new Proveedor("Modelos S.A", "645458637");
            Proveedor proveedor3 = new Proveedor("Cepresa S.L", "645459265");

            Prenda prenda1 = new Prenda("AER-23", TipoPrenda.SPORT,   true, proveedor2);
            Prenda prenda2 = new Prenda("KOP-21", TipoPrenda.GALA,   false, proveedor1);
            Prenda prenda3 = new Prenda("ARÑ-56", TipoPrenda.ROCKERA, true, proveedor3);

            this.lasPrendas.put(prenda1.getCodigo(), prenda1);
            this.lasPrendas.put(prenda2.getCodigo(), prenda2);
            this.lasPrendas.put(prenda3.getCodigo(), prenda3);
        
            this.losProveedores.put(proveedor1.getNombre(), proveedor1);
            this.losProveedores.put(proveedor2.getNombre(), proveedor2);
            this.losProveedores.put(proveedor3.getNombre(), proveedor3);
        }
    }
}
