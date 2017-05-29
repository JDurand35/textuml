/**
 * @(#) ZoneDeTexte.java
 */

package IHM;

public class ZoneDeTexte
{
	private Integer debut;
	
	private Integer fin;
	
	private String textAff = "";
	
	public Integer getDebut( )
	{
		return debut;
	}
	
	public Integer getFin( )
	{
		return fin;
	}
	
	public String getTexte( )
	{
		return textAff;
	}
	
	public void setTexte( String string )
	{
		this.textAff=string;
	}
	
	public void setDebut(int deb){
		debut = deb;
	}
	
	public void setFin(int fin){
		this.fin = fin;
	}	
	
}
