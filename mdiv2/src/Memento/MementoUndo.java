package Memento;

public class MementoUndo implements Memento {
	private String texte;

	public MementoUndo(String newTexte){
		this.setTexte(newTexte);
	}
	
	public String getTexte(){
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	
	@Override
	public boolean equals(Object o){
		return texte.equals(o.toString());
	}
	
	@Override
	public String toString(){
		return texte;
	}
}
