/**
 * @(#) Coller.java
 */

package Actions;

import IHM.IHM;
import Receveur.Editeur;

public class Coller implements Action
{
	private Editeur editeur;
	private IHM ihm;
	
	public Coller(Editeur e, IHM i){
		editeur = e;
		ihm = i;
	}
	
	@Override
	public void execute( )
	{
		editeur.coller(ihm);
	}
	
	
}
