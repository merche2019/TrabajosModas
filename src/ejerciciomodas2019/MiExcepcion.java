
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diego
 */
public class MiExcepcion extends Exception
{
	private JTextField componenteEntrada;

	public MiExcepcion(JTextField comp, String string)
	{
		super(string);
		this.componenteEntrada = comp;
	}

	public JTextField getComponenteEntrada()
	{
		return this.componenteEntrada;
	}
}
