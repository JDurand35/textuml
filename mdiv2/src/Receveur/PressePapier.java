/**
 * @(#) PressePapier.java
 */

package Receveur;

public class PressePapier
{
	private final int capacity = 500;	
	private StringBuffer texte;
	
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
	
	public String couper( Selection selection ){
		int debut = selection.getDebut();
		int fin = selection.getFin();
		if(debut > texte.length()-1){
			debut=texte.length()-1;
		}
		if(fin > texte.length()-1){
			fin=texte.length()-1;
		}
		
		texte.delete(debut, fin);
		return texte.substring(debut,fin);	
	}
}
