package ejerciciomodas2019;


import java.text.Collator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Prenda {
    
    private String codigo;
    private TipoPrenda tipo;
    private boolean especial;
    private Proveedor elProveedor;

    public Prenda(String c, TipoPrenda t, boolean e, Proveedor p) {
        this.codigo = c;
        this.tipo = t;        
        this.especial = e;
        this.elProveedor = p;
    }

    public String getCodigo() {
        return codigo.toUpperCase();
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
    
    public int compareTo(Prenda o) {               
        Collator alfabeto = Collator.getInstance();
        alfabeto.setStrength(Collator.PRIMARY);
        
        int[] criterios = {
            alfabeto.compare(this.codigo, o.codigo),
            this.tipo.compareTo(o.tipo),
            alfabeto.compare(this.elProveedor, o.elProveedor),
        };
        
        return 0;
    }
    
    
}
