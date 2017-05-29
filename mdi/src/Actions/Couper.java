/**
 * @(#) Effacer.java
 */

package Actions;

import IHM.IHM;
import Receveur.Editeur;

public class Couper implements Action
{
	private Editeur editeur;
	private IHM ihm;
	
	public Couper(Editeur e, IHM i){
		editeur = e;
		ihm = i;
	}
	
	@Override
	public void execute( )
	{
		editeur.couper(ihm.getTexte());
	}
	
	
}
