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
	
	void couper(String s); //s est la string � supprimer du buffer
	
	void selectionner(int debut, int fin);
	
	String getTexte( );
	
	
}
