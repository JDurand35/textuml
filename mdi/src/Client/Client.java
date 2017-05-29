/**
 * @(#) Client.java
 */

package Client;

import Receveur.Editeur;
import Receveur.EditeurImpl;

import java.io.IOException;

import Actions.*;
import IHM.IHM;
import IHM.IHMconsole;
import IHM.IHMimpl;

public class Client
{
	
	//On defini les noms des actions afin qu'ils ne puissent se modifier seulement ici pour le client et les ihms
	public static final String COLLER = "coller";
	public static final String COPIER = "copier";
	public static final String COUPER = "couper";
	public static final String ECRIRE = "ecrire";
	public static final String SELECTIONNER = "changerSelection";
	
	private static Editeur editeur;
	private static IHM ihm;
		
	public static void main(String[] args) throws IOException {
		editeur = new EditeurImpl();
		ihm = new IHMconsole();
		
		ihm.addBouton(COLLER, new Coller(editeur,ihm));
		ihm.addBouton(COPIER, new Copier(editeur));
		ihm.addBouton(COUPER, new Couper(editeur, ihm));
		ihm.addBouton(ECRIRE, new Ecrire(editeur, ihm));
		ihm.addBouton(SELECTIONNER, new Selectionner(editeur, ihm));
		ihm.run();
	}
	
}
