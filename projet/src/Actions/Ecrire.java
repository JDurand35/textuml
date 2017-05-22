/**
 * @(#) Ecrire.java
 */

package Actions;

import Receveur.Editeur;

public class Ecrire implements Action
{
	private Editeur editeur;
	
	public Ecrire(Editeur e){
		editeur = e;
	}
	
	@Override
	public void execute( )
	{
		editeur.ecrire();
	}
	
	
}
