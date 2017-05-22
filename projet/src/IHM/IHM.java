/**
 * @(#) IHM.java
 */

package IHM;

import Actions.Action;

public interface IHM
{
	void setZDT( Integer int1, Integer int2 );
	
	void setBouton( String string, Action action );
	
	void setBoutons( );
	
	char getDerChar( );
	
	void display( );
	
	Integer getDebut( );
	
	Integer getLongueur( );
	
	
}
