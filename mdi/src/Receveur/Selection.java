/**
 * @(#) Selection.java
 */

package Receveur;

public class Selection
{
	private Integer debut;
	
	private Integer fin;
	
	public Selection(int debut, int fin){
		this.debut = debut;
		this.fin = fin;
	}
	
	public Integer getDebut( )
	{
		return debut;
	}
	
	public Integer getFin( )
	{
		return fin;
	}
	
	public void setSelection( Integer newDebut, Integer newFin)
	{
		this.debut = Math.min(newDebut, newFin);
		this.fin = Math.max(newDebut, newFin);
	}	
}
