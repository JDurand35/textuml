/**
 * @(#) Copier.java
 */

package Actions;

import Receveur.Editeur;

public class Copier implements Action
{
	private Editeur editeur;
	
	public Copier(Editeur e){
		editeur = e;
	}
	
	@Override
	public void execute( )
	{
		editeur.copier();
	}
	
	
}
