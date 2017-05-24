/**
 * @(#) Buffer.java
 */

package Receveur;

public class Buffer
{
	private final int capacity = 500;
	
	private StringBuffer texte;
	
	public Buffer(){
		texte = new StringBuffer(capacity);
	}
	
	public String getContenu( Selection selection )
	{
		int debut = selection.getDebut();
		int fin = selection.getFin();
		if(debut > texte.length()-1){
			debut=texte.length()-1;
		}
		if(fin > texte.length()-1){
			fin=texte.length()-1;
		}
		return texte.substring(debut,fin);		
	}
	
	public void ecrire(String s, Selection selection)
	{		
		int debut = selection.getDebut();
		int fin = selection.getFin();
		if(debut > texte.length()-1){
			debut=texte.length()-1;
		}
		if(fin > texte.length()-1){
			fin=texte.length()-1;
		}
		if(texte.length()==0){
			texte.append(s);
		}else{
			texte.replace(debut, fin,s);
		}	
	}
	
	public StringBuffer getTexte( )
	{
		return texte;
	}
	
	public void ecraser(String newText){
		texte.replace(0, texte.length(), newText);
	}
	
}
