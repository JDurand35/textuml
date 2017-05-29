/**
 * @(#) Client.java
 */

package Client;

import Receveur.Editeur;
import Receveur.EditeurImpl;
import Undo.Undo;

import java.io.IOException;

import Actions.*;
import IHM.IHMimpl;

public class Client
{
	public static final String COLLER = "coller";
	public static final String COPIER = "copier";
	public static final String COUPER = "couper";
	public static final String ECRIRE = "ecrire";
	public static final String SELECTIONNER = "changerSelection";
	
	public static final String UNDO = "undo";
	public static final String REDO = "redo";
	public static final String ADDUNDO = "addUndo";
	
	private static Editeur editeur;
	private static IHMimpl ihm;
	private static Undo undo;
		
	public static void main(String[] args) throws IOException {
		editeur = new EditeurImpl();
		ihm = new IHMimpl();
		undo = new Undo(editeur,ihm);
		
		ihm.addBouton(COLLER, new Coller(editeur, ihm));
		ihm.addBouton(COPIER, new Copier(editeur));
		ihm.addBouton(COUPER, new Couper(editeur,ihm));
		ihm.addBouton(ECRIRE, new Ecrire(editeur, ihm));
		ihm.addBouton(SELECTIONNER, new Selectionner(editeur, ihm));
		
		ihm.addBouton(UNDO, new UndoActions(undo));
		ihm.addBouton(REDO, new RedoActions(undo));
		ihm.addBouton(ADDUNDO, new AddUndo(undo, ihm));
		
		ihm.runConsole();
	}
	
}
