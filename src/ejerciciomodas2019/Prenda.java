/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import java.text.Collator;
import java.util.HashMap;

/**
 *
 * @author Alex
 */
public class Prenda extends HashMap<TipoPrenda, Object> implements Comparable<Prenda> {
    private String codigo;
    private boolean especial;
    private TipoPrenda tipo;
    private Proveedor elProveedor;
    
    public Prenda(String c, TipoPrenda t, boolean e, Proveedor p){
        this.codigo = c.toUpperCase();
        this.especial = e;
        this.tipo = t;
        this.elProveedor = p;
        
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    
    public Proveedor getElProveedor(){
        return this.elProveedor;
    }
    
    public boolean isEspecial(){
        return this.especial;
    }
    
    public TipoPrenda getTipo(){
        return this.tipo;
    }
            

    @Override
    public int compareTo(Prenda o) {
        Collator alfabeto = Collator.getInstance();
        alfabeto.setStrength(Collator.PRIMARY);
        
        int[] criterios = {
            alfabeto.compare(this.codigo, o.codigo),
            this.tipo.compareTo(o.tipo),
            alfabeto.compare(this.elProveedor.toString(), o.getElProveedor().toString())
        };
        for (int criterio : criterios)
            if (criterio != 0) return criterio;
        return 0;
    }
    
    
}
