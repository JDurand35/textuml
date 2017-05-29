package IHM;

import java.util.HashMap;
import java.util.Scanner;

import Actions.Action;
import Client.Client;

public class IHMconsole implements IHM {
	
	private HashMap<String, Action> actions;
	private ZoneDeTexte ZoneDeTexte;
	
	public IHMconsole() {
		//IHM possede une Zone de texte vide au debut
		//Une selection a 0
		//Une liste d action
		this.ZoneDeTexte = new ZoneDeTexte();
		ZoneDeTexte.setDebut(0);
		ZoneDeTexte.setFin(0);
		this.actions = new HashMap<String,Action>();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int choix = 0;
		boolean end = false;

		while(!end) {
			String menu = "\nEtat :\n"
					+ "Position du curseur: [" + ZoneDeTexte.getDebut() + "," + ZoneDeTexte.getFin() + "]\n"
					+ "Texte actuel : " + ZoneDeTexte.getTexte() + "\n"
					+ "Actions:\n"
					+ "1: Ecrire\n"
					+ "2: Coller\n"
					+ "3: Copier\n"
					+ "4: Couper\n"
					+ "5: Sélectionner\n"
					+ "-1: Quitter\n"
					+ "Selectionnez un numero.";
			System.out.println(menu);

			try {
				choix = sc.nextInt();
			} catch (Exception e) {
				choix = -1;
			} 

			switch (choix) {
			case 1:
				String newLine = "";
				try {
					newLine = sc.next();
				} catch (Exception e) {
					newLine = "";
				}
				String s = ZoneDeTexte.getTexte();
				String res = "";
				for(int i = 0; i<ZoneDeTexte.getDebut(); i++){
					res+=s.charAt(i);
				}
				res+=newLine;
				for(int i = ZoneDeTexte.getFin(); i<s.length(); i++ ){
					res+=s.charAt(i);
				}
				ZoneDeTexte.setTexte(res);
				execAction(Client.ECRIRE);
				break;
			case 2:
				execAction(Client.COLLER);
				break;
			case 3:
				execAction(Client.COPIER);
				break;
			case 4:
				String s1 = ZoneDeTexte.getTexte();
				String res1 = "";
				for(int i = 0; i<ZoneDeTexte.getDebut(); i++){
					res1+=s1.charAt(i);
				}
				for(int i = ZoneDeTexte.getFin(); i<s1.length(); i++ ){
					res1+=s1.charAt(i);
				}
				ZoneDeTexte.setTexte(res1);
				execAction(Client.COUPER);
				break;
			case 5:
				try {
					System.out.println("Debut de sélection: ");
					ZoneDeTexte.setDebut(sc.nextInt());
					System.out.println("Fin de sélection: ");
					ZoneDeTexte.setFin(sc.nextInt());

				} catch (Exception e) {				
					ZoneDeTexte.setDebut(0);
					ZoneDeTexte.setFin(0);
					System.out.println("Parametres incorrectes, selection remise à (0,0).");
					break;
				}
				execAction(Client.SELECTIONNER);
				break;
			case -1:
				end = true;
				break;
			default:
				System.out.println("Action incorrecte.");
				break;
			}
		}
		sc.close();
		System.out.println("Fin.");
	}
	
	//Permet de lancer les actions
	private void execAction(String act) {
		actions.get(act).execute();
	}

	public String getTexte() {
		return ZoneDeTexte.getTexte();
	}

	@Override
	public Integer getDebut() {
		return ZoneDeTexte.getDebut();
	}

	@Override
	public Integer getFin() {
		return ZoneDeTexte.getFin();
	}

	@Override
	public void addBouton(String string, Action action) {
		this.actions.put(string, action);		
	}

	@Override
	public void setText(String s) {
		ZoneDeTexte.setTexte(s);
	}
	
	public void setZDT(String s){
		ZoneDeTexte.setTexte(s);
	}

}
