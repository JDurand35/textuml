package Actions;

import IHM.IHM;
import Memento.MementoUndo;
import Undo.Undo;

public class AddUndo implements Action{

	private IHM ihm;
	private Undo undo;
	
	public AddUndo(Undo newUndo, IHM newIHM) {
		this.undo = newUndo;
		this.ihm = newIHM;	
		execute();
	}
	
	@Override
	public void execute() {
		undo.add(new MementoUndo(ihm.getTexte()));	
	}
}
