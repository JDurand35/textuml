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
		
		JPanel container = new JPanel(new BorderLayout());
		JPanel menu = new JPanel(new FlowLayout());	
		
		//Creation des icones a partir d image
		BufferedImage copyIcon = ImageIO.read(new File(".\\src\\Copy.png"));
		BufferedImage pastIcon = ImageIO.read(new File(".\\src\\Col.jpg"));
		BufferedImage cutIcon = ImageIO.read(new File(".\\src\\Cut.png"));
		
		//Creation des boutons a partir des icones
		JButton copier = new JButton(new ImageIcon(copyIcon));
		JButton coller = new JButton(new ImageIcon(pastIcon));
		JButton couper = new JButton(new ImageIcon(cutIcon));
	    
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
			}		
		});
		
		couper.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				execAction(Client.COUPER);	
				txt.cut();
			}		
		});
		
		//On ajoute les boutons
		menu.add(copier);
		menu.add(coller);
		menu.add(couper);
		
		//Permet de capturer le curseur
		txt.addCaretListener(new CaretListener(){
			@Override
			public void caretUpdate(CaretEvent e) {
				ZoneDeTexte.setDebut(e.getDot());
				ZoneDeTexte.setFin(e.getMark());

				execAction(Client.SELECTIONNER);
			}
		});
		
		//Permet de capturer les touches claviers
		txt.addKeyListener(new KeyListener(){
			
			@Override
			public void keyReleased(KeyEvent e) {
				ZoneDeTexte.setTexte(txt.getText());	
				execAction(Client.ECRIRE);
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
	}

	//Permet de lancer les actions
	private void execAction(String act) {
		actions.get(act).execute();
	}
	
	/**
	 * Méthode permettant d'utiliser l'editeur dans la console
	 */
	public void run() {
		setVisible(true);
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
		txt.setText(s);
	}
	
	public void setZDT(String s){
		ZoneDeTexte.setTexte(s);
	}
}
