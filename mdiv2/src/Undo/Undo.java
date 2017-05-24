package Undo;

import java.util.LinkedList;
import java.util.List;

import IHM.IHM;
import Memento.MementoUndo;
import Receveur.Editeur;

public class Undo {
	private List<MementoUndo> version;
	private Editeur editeur;
	private IHM ihm;
	private int current;
	
	public Undo(Editeur newEdit, IHM newIhm){
		this.editeur=newEdit;
		this.ihm=newIhm;
		this.current=0;
		this.version= new LinkedList<MementoUndo>();
	}
	
	public void add(MementoUndo m){
		version.add(m);
		current=version.size()-1;
	}
	
	private void update(){
		String newText=version.get(current).getTexte();
		System.out.println("update "+newText);
		ihm.setText(newText);
		System.out.println(ihm.getTexte());
		editeur.setContent(newText);
	}
	
	public void redo(){
		if(current<version.size()-1){
			current++;
			update();
		}
	}
	
	public void undo(){
		if(current>0){
			current--;
			update();
		}
	}
	
}
