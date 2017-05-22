/**
 * @(#) Selectionner.java
 */

package Actions;

import Receveur.Editeur;

public class Selectionner implements Action
{
	private Editeur editeur;
	
	public Selectionner(Editeur e){
		editeur = e;
	}
	
	@Override
	public void execute( )
	{
		editeur.selectionner();
	}
	
	
}
