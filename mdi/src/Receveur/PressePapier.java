/**
 * @(#) PressePapier.java
 */

package Receveur;

public class PressePapier
{
	private final int capacity = 200;	
	private StringBuffer texte;
	
	// Le presse papier contient le contenu a coller
	public PressePapier(){
		texte = new StringBuffer(capacity);
	}
	
	public String getContenu( )
	{
		return texte.toString();
	}
	
	public void setContenu( String newContenu )
	{
		texte.delete(0, texte.length());
		texte.append(newContenu);
	}
}
