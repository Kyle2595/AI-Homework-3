import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TicTacToeState implements GameState {

	private boolean _player1;
	private boolean _player2;
	private static int[] _board;
	private String _winner;

	public static int[] getBoard() {
		return _board;
	}

	public void setBoard(int[] _board) {
		TicTacToeState._board = _board;
	}

	public TicTacToeState(String player, int[] board)
	{
		if(player == "Player 1")
		{
			_player1 = true;
			_player2 = false;
		}
		else if(player == "Player 2")
		{
			_player1 = false;
			_player2 = true;
		}
		else
		{
			System.out.println("Bad Player Choice");
		}

		setBoard(board);
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
		// Returns the set of legal moves in a state
		List<String> actionList = new LinkedList<String>(Arrays.asList());
		
		if(getBoard()[0] == 0)
		{
			actionList.add("TOP LEFT");
		}
		if(getBoard()[1] == 0)
		{
			actionList.add("TOP MIDDLE");
		}
		if(getBoard()[2] == 0)
		{
			actionList.add("TOP RIGHT");
		}
		if(getBoard()[3] == 0)
		{
			actionList.add("MIDDLE LEFT");
		}
		if(getBoard()[4] == 0)
		{
			actionList.add("MIDDLE MIDDLE");
		}
		if(getBoard()[5] == 0)
		{
			actionList.add("MIDDLE RIGHT");
		}
		if(getBoard()[6] == 0)
		{
			actionList.add("BOTTOM LEFT");
		}
		if(getBoard()[7] == 0)
		{
			actionList.add("BOTTOM MIDDLE");
		}
		if(getBoard()[8] == 0)
		{
			actionList.add("BOTTOM RIGHT");
		}
		return actionList;
	}

	@Override
	public GameState result(String action)
	{
		// The transition model, which defines the result of a move
		// 1 = X
		// 2 = O

		int[] current = getBoard();

		if(action == "TOP LEFT")
		{
			if(player() == "Player 1")
			{
				current[0] = 1;
			}
			if(player() == "Player 2")
			{
				current[0] = 2;
			}
		}
		if(action == "TOP MIDDLE")
		{
			if(player() == "Player 1")
			{
				current[1] = 1;
			}
			if(player() == "Player 2")
			{
				current[1] = 2;
			}
		}
		if(action == "TOP RIGHT")
		{
			if(player() == "Player 1")
			{
				current[2] = 1;
			}
			if(player() == "Player 2")
			{
				current[2] = 2;
			}
		}
		if(action == "MIDDLE LEFT")
		{
			if(player() == "Player 1")
			{
				current[3] = 1;
			}
			if(player() == "Player 2")
			{
				current[3] = 2;
			}
		}
		if(action == "MIDDLE MIDDLE")
		{
			if(player() == "Player 1")
			{
				current[4] = 1;
			}
			if(player() == "Player 2")
			{
				current[4] = 2;
			}
		}
		if(action == "MIDDLE RIGHT")
		{
			if(player() == "Player 1")
			{
				current[5] = 1;
			}
			if(player() == "Player 2")
			{
				current[5] = 2;
			}
		}
		if(action == "BOTTOM LEFT")
		{
			if(player() == "Player 1")
			{
				current[6] = 1;
			}
			if(player() == "Player 2")
			{
				current[6] = 2;
			}
		}
		if(action == "BOTTOM MIDDLE")
		{
			if(player() == "Player 1")
			{
				current[7] = 1;
			}
			if(player() == "Player 2")
			{
				current[7] = 2;
			}
		}
		if(action == "BOTTOM RIGHT")
		{
			if(player() == "Player 1")
			{
				current[8] = 1;
			}
			if(player() == "Player 2")
			{
				current[8] = 2;
			}
		}

		// Players change turns (not sure if here is where I should do this)
		_player1 = !_player1;
		_player2 = !_player2;

		GameState result = new TicTacToeState(player(), current);
		return result;
	}

	@Override
	public boolean isTerminal()
	{
		// Is true when the game is over and false otherwise.

		if(getBoard()[0] == 1 && getBoard()[1] == 1 && getBoard()[2] == 1)
		{
			// Top across
			_winner = "Player 1";
			return true;
		}
		
		else if(getBoard()[0] == 2 && getBoard()[1] == 2 && getBoard()[2] == 2)
		{
			_winner = "Player 2";
			return true;
		}

		else if(getBoard()[3] == 1 && getBoard()[4] == 1 && getBoard()[5] == 1)
		{
			// Middle across
			_winner = "Player 1";
			return true;
		}
		
		else if(getBoard()[3] == 2 && getBoard()[4] == 2 && getBoard()[5] == 2)
		{
			_winner = "Player 2";
			return true;
		}

		else if(getBoard()[6] == 1 && getBoard()[7] == 1 && getBoard()[8] == 1)
		{
			// Bottom across
			_winner = "Player 1";
			return true;
		}
		
		else if(getBoard()[6] == 2 && getBoard()[7] == 2 && getBoard()[8] == 2)
		{
			_winner = "Player 2";
			return true;
		}

		else if(getBoard()[0] == 1 && getBoard()[3] == 1 && getBoard()[6] == 1)
		{
			// Left down
			_winner = "Player 1";
			return true;
		}
		
		else if(getBoard()[0] == 2 && getBoard()[3] == 2 && getBoard()[6] == 2)
		{
			_winner = "Player 2";
			return true;
		}

		else if(getBoard()[1] == 1 && getBoard()[4] == 1 && getBoard()[7] == 1)
		{
			// Middle down
			_winner = "Player 1";
			return true;
		}
		
		else if(getBoard()[1] == 2 && getBoard()[4] == 2 && getBoard()[7] == 2)
		{
			_winner = "Player 2";
			return true;
		}

		else if(getBoard()[2] == 1 && getBoard()[5] == 1 && getBoard()[8] == 1)
		{
			// Right down
			_winner = "Player 1";
			return true;
		}
		
		else if(getBoard()[2] == 2 && getBoard()[5] == 2 && getBoard()[8] == 2)
		{
			_winner = "Player 2";
			return true;
		}

		else if(getBoard()[0] == 1 && getBoard()[4] == 1 && getBoard()[8] == 1)
		{
			// Diagonal left
			_winner = "Player 1";
			return true;
		}
		
		else if(getBoard()[0] == 2 && getBoard()[4] == 2 && getBoard()[8] == 2)
		{
			_winner = "Player 2";
			return true;
		}

		else if(getBoard()[2] == 1 && getBoard()[4] == 1 && getBoard()[6] == 1)
		{
			// Diagonal right
			_winner = "Player 1";
			return true;
		}
		
		else if(getBoard()[2] == 2 && getBoard()[4] == 2 && getBoard()[6] == 2)
		{
			_winner = "Player 2";
			return true;
		}

		else if(getBoard()[0] != 0 && getBoard()[1] != 0 && getBoard()[2] != 0 && getBoard()[3] != 0 && getBoard()[4] != 0 && getBoard()[5] != 0 && getBoard()[6] != 0 && getBoard()[7] != 0 && getBoard()[8] != 0)
		{
			// Nobody wins
			_winner = "draw";
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
		
		double val = 0;
		if(this.isTerminal())
		{
			if(player == "Player 1")
			{
				if(_winner.equalsIgnoreCase("Player 1"))
				{
					val = 1;
				}
				
				else if(_winner.equalsIgnoreCase("Player 2"))
				{
					val = -1;
				}
			}
			
			if(player == "Player 2")
			{
				if(_winner.equalsIgnoreCase("Player 2"))
				{
					val = 1;
				}
				
				else if(_winner.equalsIgnoreCase("Player 1"))
				{
					val = -1;
				}
			}
			
			else if(_winner.equalsIgnoreCase("draw"))
			{
				val = 0;
			}
			
			return val;
		}
		else
		{
			return (Double) null;
		}
	}

	public void print()
	{
		// Prints just for visual testing 

		String[] temp = new String[9];

		for(int i = 0; i < getBoard().length; i++)
		{
			if(getBoard()[i] == 0)
			{
				temp[i] = " ";
			}

			if(getBoard()[i] == 1)
			{
				temp[i] = "X";
			}

			if(getBoard()[i] == 2)
			{
				temp[i] = "O";
			}
		}

		System.out.println();
		System.out.print(temp[0]); System.out.print("|"); System.out.print(temp[1]); System.out.print("|"); System.out.print(temp[2]); System.out.println();
		System.out.print("-"); System.out.print("-"); System.out.print("-"); System.out.print("-"); System.out.print("-"); System.out.println();
		System.out.print(temp[3]); System.out.print("|"); System.out.print(temp[4]); System.out.print("|"); System.out.print(temp[5]); System.out.println();
		System.out.print("-"); System.out.print("-"); System.out.print("-"); System.out.print("-"); System.out.print("-"); System.out.println();
		System.out.print(temp[6]); System.out.print("|"); System.out.print(temp[7]); System.out.print("|"); System.out.print(temp[8]); System.out.println();
		System.out.println();
	}
}
