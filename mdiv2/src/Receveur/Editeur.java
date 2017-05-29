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
	
	// Change la selection
	void selectionner(int debut, int fin);
	
	//Récupère le contenue du buffer
	String getTexte( );
	
	//Modifie le contenu du buffer
	void setContent(String s);
}
