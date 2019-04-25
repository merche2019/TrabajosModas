package ejerciciomodas2019;
import java.io.Serializable;
import java.text.Collator;



public class Prenda implements Serializable
{
	private String codigo;
	private boolean especial;
	private Proveedor proveedor;
	private TipoPrenda tipo;
	
	public Prenda(String c, TipoPrenda t, boolean e, Proveedor p)
	{
		this.codigo=c;
		this.tipo=t;
		this.especial=e;
		this.proveedor=p;
	}

	public String getCodigo()
	{
		return this.codigo;
	}

	public Proveedor getProveedor()
	{
		return this.proveedor;
	}

	public boolean isEspecial()
	{
		return this.especial;
	}

	public TipoPrenda getTipo()
	{
		return this.tipo;
	}

	public int compareTo(Prenda o)
	{
		Collator alafabeto = Collator.getInstance();
		alafabeto.setStrength(Collator.PRIMARY);
		int[] criterios = 
		{
			this.getCodigo().compareTo(o.getCodigo()),
			this.getProveedor().getNombre().compareTo(o.getProveedor().getNombre())
		};
		for(int criterio:criterios)
			if (criterio != 0) {return criterio;}
		return 0;
	}

}
