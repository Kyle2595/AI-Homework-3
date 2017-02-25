import java.util.Arrays;
import java.util.List;

public class TicTacToeState implements GameState {

	@Override
	public String player() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> actions() {
		List<String> actionList = Arrays.asList(
				"TOP LEFT", "TOP MIDDLE", "TOP RIGHT", 
				"MIDDLE LEFT", "MIDDLE MIDDLE", "MIDDLE RIGHT", 
				"BOTTOM LEFT", "BOTTOM MIDDLE", "BOTTOM RIGHT");
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
