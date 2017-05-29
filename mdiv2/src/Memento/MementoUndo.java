package Memento;

public class MementoUndo{
	private String texte;
	
	//Les mementosUndos contiennent le texte de chaque moment
	public MementoUndo(String newTexte){
		this.setTexte(newTexte);
	}
	
	public String getTexte(){
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
}
