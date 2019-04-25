package ejerciciomodas2019;
import java.io.Serializable;

public class Proveedor implements Serializable
{
	private String nombre;
	private String telefono;

	public Proveedor(String n, String t)
	{
		this.nombre = n;
		this.telefono = t;
	}

	public String getNombre()
	{
		return this.nombre;
	}

	public String getTelefono()
	{
		return this.telefono;
	}

	@Override
	public String toString()
	{
		return this.telefono + "-" + this.nombre;
	}
}
