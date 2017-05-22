/**
 * @(#) Coller.java
 */

package Actions;

import Receveur.Editeur;

public class Coller implements Action
{
	private Editeur editeur;
	
	public Coller(Editeur e){
		editeur = e;
	}
	
	@Override
	public void execute( )
	{
		editeur.coller();
	}
	
	
}
