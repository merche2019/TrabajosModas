package ejerciciomodas2019;

import java.io.Serializable;
import java.util.Arrays;
import java.util.TreeMap;

public class GestoraInformacion implements Serializable
{
	private TreeMap<String, Prenda> lasPrendas;
	private TreeMap<String, Proveedor> losProveedores;
	private static GestoraInformacion INSTANCE;

	private GestoraInformacion()
	{
		this.lasPrendas = new TreeMap<>();
		this.losProveedores = new TreeMap<>();
	}

	public static GestoraInformacion getInstance()
	{
		if(GestoraInformacion.INSTANCE == null)
		{
			GestoraInformacion.INSTANCE = GestoraArchivos.cargarDatos();
			if(GestoraInformacion.INSTANCE == null)
			{
				GestoraInformacion.INSTANCE = new GestoraInformacion();
				GestoraInformacion.INSTANCE.cargarDatos();
			}
		}
		return GestoraInformacion.INSTANCE;
	}

	public Proveedor[] getLosProveedores()
	{
		Proveedor[] sol = new Proveedor[this.losProveedores.size()];
		return this.losProveedores.values().toArray(sol);
	}

	public Prenda[] devolverLasPrendasOrdenado()
	{
		Prenda[] sol = new Prenda[this.lasPrendas.size()];
		return this.lasPrendas.values().toArray(sol);
	}

	public boolean agregarProveedor(Proveedor p)
	{
		Proveedor sol = this.losProveedores.put(p.getNombre(), p);
		return sol != null;
	}

	public boolean agregarPrenda(Prenda p)
	{
		return this.lasPrendas.put(p.getCodigo(), p) != null;
	}

	public Proveedor devolverProveedor(String nombre)
	{
		return this.losProveedores.get(nombre);
	}

	public Prenda devolverPrenda(String codigo)
	{
		return this.lasPrendas.get(codigo);
	}

	public String[] devulveNombresProveedor()
	{
		Object[] sol = losProveedores.keySet().toArray();
		return Arrays.copyOf(sol, sol.length, String[].class);
	}

	public boolean existePrenda(Prenda p)
	{
		return this.lasPrendas.get(p.getCodigo()) != null;
	}

	public boolean existeProveedor(Proveedor p)
	{
		return this.losProveedores.get(p.getNombre()) != null;
	}
	
	public int devulveNumeroDeProveedores()
	{
		return	this.losProveedores.size();
	}

	public int devuelveNumeroDePrendas()
	{
		return	this.lasPrendas.size();
	}

	public void eliminarPrenda(String c)
	{
		this.lasPrendas.remove(c);
	}

	public void cargarDatos()
	{
            Proveedor proveedor1 = new Proveedor("Zara", "553825364");
            Proveedor proveedor2 = new Proveedor("Textiles pepe", "665387687");
            Proveedor proveedor3 = new Proveedor("Calcetines Manolo", "779453654");

            Prenda prenda2 = new Prenda("ABC-14", TipoPrenda.GALA,   false, proveedor1);
            Prenda prenda1 = new Prenda("DEF-15", TipoPrenda.SPORT,   true, proveedor2);
            Prenda prenda3 = new Prenda("GHI-16", TipoPrenda.ROCKERA, true, proveedor3);

            this.lasPrendas.put(prenda1.getCodigo(), prenda1);
            this.lasPrendas.put(prenda2.getCodigo(), prenda2);
            this.lasPrendas.put(prenda3.getCodigo(), prenda3);
        
            this.losProveedores.put(proveedor1.getNombre(), proveedor1);
            this.losProveedores.put(proveedor2.getNombre(), proveedor2);
            this.losProveedores.put(proveedor3.getNombre(), proveedor3);		
	}
}
