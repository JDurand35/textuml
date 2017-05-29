/**
 * @(#) EditeurImpl.java
 */

package Receveur;

import IHM.IHM;

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
	public void coller(IHM ihm) {
		buffer.ecrire(pressePapier.getContenu(), selection);
		ihm.setZDT(this.buffer.getTexte().toString()); //permet de synchronise la ZDT avec le buffer (code modifié entre v1 et v2)
	}

	@Override
	public void ecrire(String s) {
		buffer.ecrire(s, selection);	
	}

	@Override
	public void couper(String s) {
		pressePapier.setContenu(buffer.getContenu(selection));	
		buffer.ecrire(s, new Selection(0,buffer.getTexte().length()));		
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
		buffer.ecrire(s, new Selection(0,buffer.getTexte().length()));		
	}
	
}
