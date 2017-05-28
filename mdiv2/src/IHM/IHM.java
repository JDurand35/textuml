/**
 * @(#) IHM.java
 */

package IHM;

import Actions.Action;

public interface IHM
{
	void setText(String s);
	
	void addBouton( String string, Action action );
	
	void setBoutons( );
	
	char getDerChar( );
	
	String getTexte( );
	
	Integer getDebut( );
	
	Integer getFin( );
	
	public String getNewLine();
}
