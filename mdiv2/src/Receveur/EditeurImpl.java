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
		pressePapier.setContenu(buffer.getContenu(selection));
	}

	@Override
	public void coller() {
		buffer.ecrire(pressePapier.getContenu(), selection);		
	}

	@Override
	public void ecrire(String s) {
		buffer.ecrire(s, selection);	
	}

	@Override
	public void couper() {
		pressePapier.setContenu(buffer.getContenu(selection));	
	}

	@Override
	public void selectionner(int debut, int fin) {
		selection.setSelection(debut, fin);		
	}

	@Override
	public String getTexte() {
		return buffer.toString();
	}

	@Override
	public void setContent(String s) {
		//buffer.ecrire(s, new Selection(0,buffer.getTexte().length()));		
		buffer.ecraser(s);
	}
	
}
