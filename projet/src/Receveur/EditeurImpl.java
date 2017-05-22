/**
 * @(#) EditeurImpl.java
 */

package Receveur;

public class EditeurImpl implements Editeur
{
	private PressePapier pressePapier;
	
	private Buffer buffer;
	
	private Selection selection;
	
	public EditeurImpl() {
		this.buffer = new Buffer();
		this.selection = new Selection(0,0); //au début rien n'est sélectionner
		this.pressePapier = new PressePapier();
	}

	@Override
	public void copier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void coller() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ecrire() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effacer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectionner() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTexte() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
