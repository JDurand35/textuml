/**
 * @(#) Effacer.java
 */

package Actions;

import Receveur.Editeur;

public class Couper implements Action
{
	private Editeur editeur;
	
	public Couper(Editeur e){
		editeur = e;
	}
	
	@Override
	public void execute( )
	{
		editeur.couper();
	}
	
	
}
