/**
 * @(#) IHM.java
 */

package IHM;

import Actions.Action;

public interface IHM
{
	void setText(String s);
	
	void addBouton( String string, Action action );
	
	String getTexte( );
	
	Integer getDebut( );
	
	Integer getFin( );
	
	void setZDT(String s);
	
	void run();
}
