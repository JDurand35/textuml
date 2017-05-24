package Actions;

import Undo.Undo;

public class RedoActions implements Action{
	private Undo undo;
	
	public RedoActions(Undo u) {
		this.undo=u;
	}
	
	@Override
	public void execute() {
		undo.redo();		
	}
	
}
