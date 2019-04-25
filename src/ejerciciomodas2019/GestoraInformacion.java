package ejerciciomodas2019;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
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
 * @author Rafa
 */
public class GestoraInformacion {

    private TreeMap<String, Prenda> lasPrendas = new TreeMap<String, Prenda>();
    private TreeMap<String, Proveedor> losProveedores = new TreeMap<String, Proveedor>();

    public GestoraInformacion() {
        cargarDatosIniciales();
    }

    public Proveedor[] getLosProveedores() {
        return losProveedores.values().toArray(new Proveedor[]{});
    }

    public Prenda[] devolverPrendasOrdenado() {
        ArrayList<Prenda> prendas = new ArrayList(lasPrendas.values());
        Collections.sort(prendas);
        return prendas.toArray(new Prenda[]{});
    }

    public boolean agregarProveedor(Proveedor p) {
        if (!this.existeProveedor(p)) {
            this.losProveedores.put(p.getNombre(), p);
            return true;
        }
        return false;
    }

    public boolean agregarPrenda(Prenda p) {
        if (!this.existePrenda(p)) {
            this.lasPrendas.put(p.getCodigo(), p);
            return true;
        }
        return false;
    }

    public Proveedor devolverProveedor(String nombre) {
        if (losProveedores.containsKey(nombre)) {
            return losProveedores.get(nombre);
        } else {
            return null;
        }
    }

    public Prenda devolverPrenda(String codigo) {
        if (lasPrendas.containsKey(codigo)) {
            return lasPrendas.get(codigo);
        } else {
            return null;
        }
    }

    public String[] devolverNombresProveedor() {
        if (losProveedores == null || losProveedores.size() == 0) {
            losProveedores = new TreeMap<String, Proveedor>();
            this.cargarDatosIniciales();
        }
        return losProveedores.keySet().toArray(new String[]{});
    }

    public boolean existePrenda(Prenda prenda) {
        return this.lasPrendas.containsKey(prenda.getCodigo());
    }

    public boolean existeProveedor(Proveedor p) {
        return this.lasPrendas.containsKey(p.getNombre());
    }

    public int devolverNumeroDeProveedores() {
        return losProveedores.size();
    }

    public int devolverNumeroDePrendas() {
        return lasPrendas.size();
    }

    public void cargarDatosIniciales() {
        this.agregarProveedor(new Proveedor("CEPRESA SL", "983111111"));
        this.agregarProveedor(new Proveedor("FAMECA SA", "616333333"));
        this.agregarProveedor(new Proveedor("MODELOS SA", "654222222"));
    }

    public void eliminarPrenda(String codigo) {
        this.lasPrendas.remove(codigo);
    }

    public void cargarFichero() {
        try {
            FileInputStream cargar = new FileInputStream("prendas.dat");
            ObjectInputStream o = new ObjectInputStream(cargar);
            while (cargar.available() > 0) {
                this.agregarPrenda((Prenda) o.readObject());
            }
            o.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestoraInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestoraInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestoraInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarFichero() {
        try {
            FileOutputStream guardar = new FileOutputStream("prendas.dat");
            ObjectOutputStream o = new ObjectOutputStream(guardar);
            for (Prenda p : this.devolverPrendasOrdenado()) {
                o.writeObject(p);
            }

            o.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestoraInformacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestoraInformacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
