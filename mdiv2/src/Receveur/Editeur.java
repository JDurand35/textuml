/**
 * @(#) Editeur.java
 */

package Receveur;

public interface Editeur
{
	void copier( );
	
	void coller( );
	
	void ecrire(String s);
	
	void couper( );
	
	void selectionner(int debut, int fin);
	
	String getTexte( );
	
	void setContent(String s);
}
