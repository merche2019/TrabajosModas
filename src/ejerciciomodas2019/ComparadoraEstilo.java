/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomodas2019;

import java.text.Collator;
import java.util.Comparator;

/**
 *
 * @author César
 */
public class ComparadoraEstilo implements Comparator<Prenda> {

    @Override
    public int compare(Prenda o1, Prenda o2) {
        Collator alfabeto=Collator.getInstance();
        alfabeto.setStrength(Collator.PRIMARY);
        int[] criterios={
            alfabeto.compare(o1.getTipo().name(), o2.getTipo().name()),
            o1.getCodigo().compareTo(o2.getCodigo()),
            alfabeto.compare(o1.getElProveedor().getNombre(), o2.getElProveedor().getNombre()),
            o1.getElProveedor().getTelefono().compareTo(o2.getElProveedor().getTelefono())
        };
        for (int criterio:criterios){
            if (criterio!=0){
                return criterio;
            }
        }
        return 0;
    }
    
}
