package ejerciciomodas2019;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diego
 */
public class ModeloTabla extends DefaultTableModel
{

	private Prenda[] prendas;

	public ModeloTabla()
	{
		this.prendas = GestoraInformacion.getInstance().devolverLasPrendasOrdenado();
	}

	@Override
	public int getRowCount() 
	{
		return this.prendas != null ? this.prendas.length : 0;
	}

	@Override
	public int getColumnCount() 
	{
		return 4;
	}

	@Override
	public String getColumnName(int num)
	{
		String[] columNames = 
		{
			"CODIGO",
			"ESTILO",
			"TALLA ESPECIAL",
			"PROVEEDOR"
		};
		return columNames[num];
	}

	@Override
	public Class<?> getColumnClass(int num) 
	{
		Class<?>[] columnClasses = 
		{
			String.class,
			TipoPrenda.class,
			Boolean.class,
			String.class
		};
		return columnClasses[num];
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) 
	{
		return false;
	}

	@Override
	public Object getValueAt(int x, int y)
	{
		Prenda prendaElegida = this.prendas[x];
		Object[] values = 
		{
			prendaElegida.getCodigo(),
			prendaElegida.getTipo(),
			prendaElegida.isEspecial(),
			prendaElegida.getProveedor().toString()
		};
		return values[y];
	}
	
}
