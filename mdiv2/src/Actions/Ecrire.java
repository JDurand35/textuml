/**
 * @(#) Ecrire.java
 */

package Actions;

import IHM.IHM;
import Receveur.Editeur;

public class Ecrire implements Action
{
	private Editeur editeur;
	private IHM ihm;
	
	public Ecrire(Editeur e, IHM ihm){
		editeur = e;
		this.ihm = ihm;
	}
	
	@Override
	public void execute( )
	{
		editeur.ecrire(ihm.getTexte());
	}
	
}
