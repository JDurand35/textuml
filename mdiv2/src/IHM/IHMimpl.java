/**
 * @(#) IHMimpl.java
 */

package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import Actions.Action;
import Client.Client;

public class IHMimpl extends JFrame implements IHM
{	
	private HashMap<String, Action> actions;
	private ZoneDeTexte ZoneDeTexte;
	JTextArea txt = new JTextArea();
	
	public IHMimpl() {
		super("Editeur de texte");
		
		this.setSize(700,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.ZoneDeTexte = new ZoneDeTexte();
		ZoneDeTexte.setDebut(0);
		ZoneDeTexte.setFin(0);
		this.actions = new HashMap<String,Action>();
		
		JPanel container = new JPanel(new BorderLayout());
		JPanel menu = new JPanel(new FlowLayout());		
		JButton copier = new JButton("Copier");
		JButton coller = new JButton("Coller");
		JButton couper = new JButton("Couper");
		
		JButton undo = new JButton("Annuler");
		JButton redo = new JButton("Revenir");
		
	    
		copier.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				execAction(Client.COPIER);			
				// Gestion visuelle de l'IHM
				txt.copy();
			}		
		});
		
		coller.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				execAction(Client.COLLER);				
				// Gestion visuelle de l'IHM
				txt.paste();
				
				ZoneDeTexte.setTexte(txt.getText());
				execAction(Client.ECRIRE);
				
				ZoneDeTexte.setTexte(txt.getText());
				execAction(Client.ADDUNDO);
			}		
		});
		
		couper.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				execAction(Client.COUPER);				
				// Gestion visuelle de l'IHM
				txt.cut();
				
				ZoneDeTexte.setTexte(txt.getText());
				execAction(Client.ADDUNDO);
			}		
		});
		
		undo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				execAction(Client.UNDO);				
			}		
		});
		redo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				execAction(Client.REDO);				
			}		
		});
		
		menu.add(copier);
		menu.add(coller);
		menu.add(couper);
		
		menu.add(undo);
		menu.add(redo);
		
		txt.addCaretListener(new CaretListener(){
			@Override
			public void caretUpdate(CaretEvent e) {
				ZoneDeTexte.setDebut(e.getDot());
				ZoneDeTexte.setFin(e.getMark());

				execAction(Client.SELECTIONNER);
			}
		});
		
		txt.addKeyListener(new KeyListener(){
			
			@Override
			public void keyReleased(KeyEvent e) {
				ZoneDeTexte.setTexte(txt.getText());	
				execAction(Client.ECRIRE);
				
				ZoneDeTexte.setTexte(txt.getText());
				execAction(Client.ADDUNDO);
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub		
			}	
		});
		
		JScrollPane scrollTxt = new JScrollPane(txt); 
		txt.setEditable(true);
		
		container.add(menu, BorderLayout.NORTH);
		container.add(scrollTxt, BorderLayout.CENTER);
	    this.setContentPane(container);
	    
		setVisible(true);
	}

	public void execAction(String act) {
		actions.get(act).execute();
	}
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		int choix = 0;
		boolean end = false;

		while(!end) {
			String menu = "Etat actuel du systeme:\n"
					+ "Position du curseur: [" + ZoneDeTexte.getDebut() + "," + ZoneDeTexte.getFin() + "]\n\n"
					+ "Liste des commandes disponibles:\n"
					+ "1: Ecrire\n"
					+ "2: Coller\n"
					+ "3: Copier\n"
					+ "4: Couper\n"
					+ "5: Bouger curseur\n"
					+ "-1: Quitter l'application\n"
					+ "Votre choix? SELECTIONNER d'un numero.";
			System.out.println(menu);

			try {
				choix = sc.nextInt();
			} catch (Exception e) {
				choix = -99;
			} 

			switch (choix) {
			case 1:
				execAction(Client.ECRIRE);
				break;
			case 2:
				execAction(Client.COLLER);
				break;
			case 3:
				execAction(Client.COPIER);
				break;
			case 4:
				execAction(Client.COUPER);
				break;
			case 5:
				try {
					System.out.println("Debut de la selection: ");
					ZoneDeTexte.setDebut(sc.nextInt());
					System.out.println("Fin de la selection: ");
					ZoneDeTexte.setFin(sc.nextInt());

				} catch (Exception e) {
					System.out.println("Parametre incorrect.");
					ZoneDeTexte.setDebut(0);
					ZoneDeTexte.setFin(0);
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

	@Override
	public char getDerChar() {
		return ZoneDeTexte.getDerChar();
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
	public void setText(String s) {
		txt.setText(s);	
	}

	@Override
	public void addBouton(String string, Action action) {
		this.actions.put(string, action);		
	}

	@Override
	public void setBoutons() {
		// TODO Auto-generated method stub
		
	}
	
}
