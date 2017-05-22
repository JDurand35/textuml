/**
 * @(#) IHM.java
 */

package IHM;

import Actions.Action;

public interface IHM
{
	void setZDT( Integer int1, Integer int2 );
	
	void addBouton( String string, Action action );
	
	void setBoutons( );
	
	char getDerChar( );
	
	String getTexte( );
	
	Integer getDebut( );
	
	Integer getFin( );
	
	
}
