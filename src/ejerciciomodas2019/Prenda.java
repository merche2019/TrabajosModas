/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import java.io.Serializable;
import java.text.Collator;

/**
 *
 * @author Tarod
 */
public class Prenda implements Comparable<Prenda>, Serializable {
    private String codigo;
    private TipoPrenda tipo;
    private boolean especial;
    private Proveedor elProveedor;

    public Prenda(String c, TipoPrenda t, boolean e, Proveedor p) {
        this.tipo = t;
        this.especial = e;
        this.elProveedor = p;
        this.codigo = c.toUpperCase();
    }

    public String getCodigo() {
        return codigo;
    }
    
    public Proveedor getElProveedor() {
        return this.elProveedor;
    }
    
    public boolean isEspecial() {
        return this.especial;
    }
    
    public TipoPrenda getTipo() {
        return this.tipo;
    }
    
    public void setTipo(TipoPrenda tipo) {
        this.tipo = tipo;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public void setElProveedor(Proveedor elProveedor) {
        this.elProveedor = elProveedor;
    }
    
    public int compareTo(Prenda o) {
        Collator alfabeto = Collator.getInstance();
        alfabeto.setStrength(Collator.PRIMARY);
        
        int[] criterios = {
            alfabeto.compare(this.codigo, o.codigo),
            this.tipo.compareTo(o.tipo),
            alfabeto.compare(this.elProveedor.toString(), o.getElProveedor().toString())
        };
        
        for(int criterio : criterios)
            if (criterio != 0) return criterio;
        
        return 0;
    }
}
