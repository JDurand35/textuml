/**
 * @(#) Effacer.java
 */

package Actions;

import Receveur.Editeur;

public class Effacer implements Action
{
	private Editeur editeur;
	
	public Effacer(Editeur e){
		editeur = e;
	}
	
	@Override
	public void execute( )
	{
		editeur.effacer();
	}
	
	
}
