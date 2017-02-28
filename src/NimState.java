import java.util.Arrays;
import java.util.List;

public class NimState implements GameState {
	
	private boolean _player1;
	private boolean _player2;

	@Override
	public String player() 
	{
		// Defines which player has the move in a state.
		if(_player1 == true && _player2 == false)
		{
			return "Player 1";
		}
		else if(_player2 == true && _player1 == false)
		{
			return "Player 2";
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<String> actions() {
		List<String> actionList = Arrays.asList("REMOVE 1", "REMOVE 2", "REMOVE 3");
		return actionList;
	}

	@Override
	public GameState result(String action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTerminal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double utility(String player) {
		// TODO Auto-generated method stub
		return 0;
	}

}
