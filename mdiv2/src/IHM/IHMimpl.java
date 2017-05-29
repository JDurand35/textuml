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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
	
	public IHMimpl() throws IOException {
		super("Editeur de texte");
		
		this.setSize(1000,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//IHM possede une Zone de texte vide au debut
		//Une selection a 0
		//Une liste d action
		this.ZoneDeTexte = new ZoneDeTexte();
		ZoneDeTexte.setDebut(0);
		ZoneDeTexte.setFin(0);
		this.actions = new HashMap<String,Action>();
		
		//Creation des icones a partir d image
		BufferedImage copyIcon = ImageIO.read(new File("C:\\Users\\Johann Durand\\Desktop\\JD\\prog\\workspace\\mdiv2\\src\\Copy.png"));
		BufferedImage pastIcon = ImageIO.read(new File("C:\\Users\\Johann Durand\\Desktop\\JD\\prog\\workspace\\mdiv2\\src\\Col.jpg"));
		BufferedImage cutIcon = ImageIO.read(new File("C:\\Users\\Johann Durand\\Desktop\\JD\\prog\\workspace\\mdiv2\\src\\Cut.png"));
		BufferedImage undoIcon = ImageIO.read(new File("C:\\Users\\Johann Durand\\Desktop\\JD\\prog\\workspace\\mdiv2\\src\\Undo.jpg"));
		BufferedImage redoIcon = ImageIO.read(new File("C:\\Users\\Johann Durand\\Desktop\\JD\\prog\\workspace\\mdiv2\\src\\Redo.jpg"));

		
		JPanel container = new JPanel(new BorderLayout());
		JPanel menu = new JPanel(new FlowLayout());		
		
		//Creation des boutons a partir des icones
		JButton copier = new JButton(new ImageIcon(copyIcon));
		JButton coller = new JButton(new ImageIcon(pastIcon));
		JButton couper = new JButton(new ImageIcon(cutIcon));
		
		JButton undo = new JButton(new ImageIcon(undoIcon));
		JButton redo = new JButton(new ImageIcon(redoIcon));
		
		//On ajoute des actions sur nos boutons
	    
		copier.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				execAction(Client.COPIER);			
				txt.copy();
			}		
		});
		
		coller.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				execAction(Client.COLLER);				
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
		
		//On ajoute les boutons
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
	
	
	/**
	 * Méthode permettant d'utiliser l'editeur dans la console
	 */
	public void runConsole() {
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
					+ "5: Undo\n"
					+ "6: Redo\n"
					+ "7: Sélectionner\n"
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
				System.out.println("ihm : ecrire" + ZoneDeTexte.getTexte());
				execAction(Client.ADDUNDO);
				break;
			case 2:
				execAction(Client.COLLER);
				System.out.println("ZDT COLLER : "+ZoneDeTexte.getTexte());
				execAction(Client.ADDUNDO);
				break;
			case 3:
				System.out.println("ZDT COPIER : "+ZoneDeTexte.getTexte());
				execAction(Client.COPIER);		
				execAction(Client.ADDUNDO);
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
				System.out.println("ZDT COUPER : "+ZoneDeTexte.getTexte());
				execAction(Client.COUPER);
				execAction(Client.ADDUNDO);
				break;
			case 5:
				System.out.println("test");
				execAction(Client.UNDO);
				break;
			case 6:
				execAction(Client.REDO);
				break;
			case 7:
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
				end=true;
				System.out.println("Mauvaise opération.");			
				break;
			}
		}
		sc.close();
		System.out.println("Application Fermée.");
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
	
	public void setZDT(String s) {
		ZoneDeTexte.setTexte(s);
	}

	@Override
	public void addBouton(String string, Action action) {
		this.actions.put(string, action);		
	}
}
