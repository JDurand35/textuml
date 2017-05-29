/**
 * @(#) Editeur.java
 */

package Receveur;

import IHM.IHM;

public interface Editeur
{
	void copier( );
	
	void coller(IHM ihm);
	
	void ecrire(String s);
	
	void couper(String s);
	
	void selectionner(int debut, int fin);
	
	String getTexte( );
	
	void setContent(String s);
}
