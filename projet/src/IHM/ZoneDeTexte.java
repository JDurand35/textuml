/**
 * @(#) ZoneDeTexte.java
 */

package IHM;

public class ZoneDeTexte
{
	private Integer debut;
	
	private Integer longueur;
	
	private char lastChar;
	
	private String textAff;
	
	public Integer getDebut( )
	{
		return debut;
	}
	
	public Integer getLongueur( )
	{
		return longueur;
	}
	
	public char getDerChar( )
	{
		return textAff.charAt(textAff.length()-1); //a voir
	}
	
	public String getTexte( )
	{
		return textAff;
	}
	
	public void setTexte( String string )
	{
		this.textAff=string;
	}
	
	public void refresh( String string, Integer int1, Integer int2 )
	{
		
	}
	
	
}
