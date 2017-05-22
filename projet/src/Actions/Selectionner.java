/**
 * @(#) Selectionner.java
 */

package Actions;

import IHM.IHM;
import Receveur.Editeur;

public class Selectionner implements Action
{
	private Editeur editeur;
	private IHM ihm;
	
	public Selectionner(Editeur e,IHM ihm){
		editeur = e;
		this.ihm = ihm;
	}
	
	@Override
	public void execute( )
	{
		editeur.selectionner(ihm.getDebut(), ihm.getFin());
	}
	
	
}
