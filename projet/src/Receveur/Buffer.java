/**
 * @(#) Buffer.java
 */

package Receveur;

public class Buffer
{
	private final int capacity = 500;
	
	private StringBuffer texte;
	
	private Selection selection;
	
	public Buffer(){
		texte = new StringBuffer(capacity);
	}
	
	public String getContenu( Selection selection )
	{
		return texte.substring(selection.getDebut(),selection.getFin());		
	}
	
	public void ecrire(String s )
	{
		texte.append(s, selection.getDebut(), selection.getFin());
	}
	
	public void setSelection( Integer positionDeb, Integer positionFin )
	{
		selection.setSelection(positionDeb, positionFin);
	}
	
	public Selection getSelection( )
	{
		return selection;
	}
	
	public StringBuffer getTexte( )
	{
		return texte;
	}
	
	
}
