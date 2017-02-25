import java.util.Arrays;
import java.util.List;

public class NimState implements GameState {

	@Override
	public String player() {
		// TODO Auto-generated method stub
		return null;
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
