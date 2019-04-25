/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import java.io.Serializable;

/**
 *
 * @author César
 */
public class Prenda implements Serializable, Comparable<Prenda>{
    private String codigo;
    private TipoPrenda tipo;
    private boolean especial;
    private Proveedor elProveedor;

    public Prenda(String c, TipoPrenda t, boolean e, Proveedor p) {
        this.codigo = c;
        this.tipo=t;
        this.especial = e;
        this.elProveedor=p;
    }

    public String getCodigo() {
        return codigo;
    }

    public TipoPrenda getTipo() {
        return tipo;
    }

    public boolean isEspecial() {
        return especial;
    }

    public Proveedor getElProveedor() {
        return elProveedor;
    }

    @Override
    public int compareTo(Prenda o) {
        return this.getCodigo().compareTo(o.codigo);
    }
   
}
