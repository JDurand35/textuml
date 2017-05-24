package Actions;

import Undo.Undo;

public class UndoActions implements Action{
	private Undo undo;
	
	public UndoActions(Undo u) {
		this.undo=u;
	}
	
	@Override
	public void execute() {
		undo.undo();		
	}
	
}
