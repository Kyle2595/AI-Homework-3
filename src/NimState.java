import java.util.Arrays;
import java.util.List;

public class NimState implements GameState {

	private boolean _player1;
	private boolean _player2;
	private int _numSticks;
	private String _winner;

	public int getNumSticks() 
	{
		return _numSticks;
	}

	public void setNumSticks(int _numSticks) 
	{
		this._numSticks = _numSticks;
	}

	public NimState(String player, int sticks)
	{
		setNumSticks(sticks);

		if(player == "Player 1")
		{
			//System.out.println("Player 1");
			_player1 = true;
			_player2 = false;
		}
		else if(player == "Player 2")
		{
			//System.out.println("Player 2");
			_player1 = false;
			_player2 = true;
		}
		else
		{
			System.out.println("Bad Player Choice");
		}
	}

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
	public List<String> actions() 
	{
		List<String> actionList = Arrays.asList();

		if(getNumSticks() >= 3)
		{
			actionList.add("REMOVE 1");
			actionList.add("REMOVE 2");
			actionList.add("REMOVE 3");
		}

		else if(getNumSticks() == 2)
		{
			actionList.add("REMOVE 1");
			actionList.add("REMOVE 2");
		}

		else if(getNumSticks() == 1)
		{
			actionList.add("REMOVE 1");
		}

		else if(getNumSticks() == 0)
		{
			// No possible moves
		}

		return actionList;
	}

	@Override
	public GameState result(String action) 
	{
		// The transition model, which defines the result of a move

		int current = getNumSticks();

		if(action == "Remove 1")
		{
			current = current - 1;
		}

		else if(action == "Remove 2")
		{
			current = current - 2;
		}

		else if(action == "Remove 3")
		{
			current = current - 3;
		}

		// Players change turns (not sure if here is where I should do this)
		_player1 = !_player1;
		_player2 = !_player2;

		GameState result = new NimState(player(), current);
		return result;
	}

	@Override
	public boolean isTerminal() 
	{
		// Is true when the game is over and false otherwise.

		if(getNumSticks() == 0)
		{
			_winner = player();
			return true;
		}

		else{return false;}
	}

	@Override
	public double utility(String player) 
	{
		// Defines the final numeric value for a game that ends in terminal state S for a player P
		// Player 1 = 1
		// Draw = 0
		// Player 2 = -1

		if(isTerminal() == true && player == "Player 1")
		{
			System.out.println(player + " WINS!");
			return 1;
		}
		
		else if(isTerminal() == true && player == "Player 2")
		{
			System.out.println(player + " WINS!");
			return -1;
		}

		else{return 0;}
	}
}
