/**
 * @(#) Buffer.java
 */

package Receveur;

public class Buffer
{
	private final int capacity = 400;
	
	private StringBuffer texte;
	
	//Le buffer contient ce que l'on a ecrit
	public Buffer(){
		texte = new StringBuffer(capacity);
	}
	
	public String getContenu( Selection selection )
	{
		int debut = selection.getDebut();
		int fin = selection.getFin();
		
		debut = (debut > texte.length()-1) ? texte.length()-1 : debut;
		fin = (fin > texte.length()-1) ? texte.length()-1 : fin;

		return texte.substring(debut,fin);		
	}
	
	//On ecrit soit au début de la string soit au niveau de la selection
	public void ecrire(String s, Selection selection)
	{		
		int debut = selection.getDebut();
		int fin = selection.getFin();
		debut = (debut > texte.length()-1) ? texte.length()-1 : debut;
		fin = (fin > texte.length()-1) ? texte.length()-1 : fin;
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
}
