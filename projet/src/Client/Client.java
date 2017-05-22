/**
 * @(#) Client.java
 */

package Client;

import Receveur.Editeur;
import Receveur.EditeurImpl;


import java.util.HashMap;

import Actions.*;
import IHM.IHM;
import IHM.IHMimpl;

public class Client
{
	public static final String COLLER = "coller";
	public static final String COPIER = "copier";
	public static final String COUPER = "couper";
	public static final String ECRIRE = "ecrire";
	public static final String SELECTIONNER = "changerSelection";
	
	private static Editeur editeur;
	private static IHMimpl ihm;
	private Action actions;
		
	public static void main(String[] args) {
		editeur = new EditeurImpl();
		ihm = new IHMimpl();
		
		ihm.addBouton(COLLER, new Coller(editeur));
		ihm.addBouton(COPIER, new Copier(editeur));
		ihm.addBouton(COUPER, new Couper(editeur));
		ihm.addBouton(ECRIRE, new Ecrire(editeur, ihm));
		ihm.addBouton(SELECTIONNER, new Selectionner(editeur, ihm));
		ihm.run();
	}
	
}
