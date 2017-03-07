
public class MinimaxSearch {

	public static String minimaxDecisionMax(GameState state)
	{
		// TO DO: finds best action for Max at state -- see figure 5.3
		// Returns an action

		String result = null;
		double negitiveResultValue = Double.NEGATIVE_INFINITY;
		double positiveResultValue = Double.POSITIVE_INFINITY;
		String player = state.player();
		
		for (String action : state.actions())
		{
			double value = minValue(state.result(action), player);
			
			if(player.equalsIgnoreCase("Player 2"))
			{
				// Maximize value
				if (value > negitiveResultValue) 
				{
					result = action;
					negitiveResultValue = value;
				}
			}
			
			if(player.equalsIgnoreCase("Player 1"))
			{
				// Minimize value
				if (value < positiveResultValue) 
				{
					result = action;
					negitiveResultValue = value;
				}
			}
		}
		return result;
	}

	public static double minValue(GameState state, String player)
	{
		// TO DO: see fig 5.3 in text
		// Returns a utility value

		if(state.isTerminal() == true)
		{
			return state.utility(player);
		}
		
		else
		{
			double value = Double.POSITIVE_INFINITY;
			for (String action : state.actions())
			{
				value = Math.min(value, maxValue(state.result(action), player));
			}
			return value;
		}
	}

	public static double maxValue(GameState state, String player)
	{
		// TO DO: see fig 5.3 in text
		// Returns a utility value

		if(state.isTerminal() == true)
		{
			return state.utility(state.player());
		}
		
		else
		{
			double value = Double.NEGATIVE_INFINITY;			
			for (String action : state.actions())
			{
				value = Math.max(value, minValue(state.result(action), player));
			}
			return value;
		}
	}
}
