
public class MinimaxSearch {
	
	private static String _bestMoveMax;
	private static String _bestMoveMin;
	
	public static String minimaxDecisionMax(GameState state)
	{
		// TO DO: finds best action for Max at state -- see figure 5.3
		// Returns an action
		
		minValue(state);
		return null;
		//return _bestMoveMax;
	}
	
	public static String minimaxDecisionMin(GameState state)
	{
		// TO DO: finds best action for Min at state -- see figure 5.3
		// Returns an action

		maxValue(state);
		return _bestMoveMin;
	}
	
	public static double minValue(GameState state)
	{
		// TO DO: see fig 5.3 in text
		// Returns a utility value
		
		if(state.isTerminal() == true)
		{
			return state.utility(state.player());
		}
		else
		{
			double bestScore = Double.POSITIVE_INFINITY;
			for(String s : state.actions())
			{
				double score = maxValue(state.result(s));
				if(score < bestScore)
				{
					bestScore = score;
					_bestMoveMax = s;
				}
			}
			return bestScore;
		}
	}
	
	public static double maxValue(GameState state)
	{
		// TO DO: see fig 5.3 in text
		// Returns a utility value
		
		if(state.isTerminal() == true)
		{
			return state.utility(state.player());
		}
		else
		{
			double bestScore = Double.NEGATIVE_INFINITY;
			for(String s : state.actions())
			{
				double score = minValue(state.result(s));
				if(score > bestScore)
				{
					bestScore = score;
					_bestMoveMin = s;
				}
			}
			return bestScore;
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// could be useful in testing Minimax search code
	}
}
