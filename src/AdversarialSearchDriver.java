import java.util.Scanner;

public class AdversarialSearchDriver {

	public AdversarialSearchDriver() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 1 for Nim, 2 for Tic-Tac-Toe ");
		int choice = input.nextInt();
		if (choice == 1)
		{
			System.out.println("Enter the number of sticks to start with: ");
			int sticks = input.nextInt();
			// code to do minimax on Nim with the chosen number of sticks here
			
			NimState TEST = new NimState("Player 1", sticks);
			
		}
		else if (choice == 2)
		{
			// code to do Tic-Tac-Toe here.  the user should be able to specify a state 
			// of the game to search from. 
			GameState initial = new TicTacToeState("Player 1", new int[9]);
			
			// Just for testing
//			int[] test = new int[9];
//			test[0] = 1;
//			test[4] = 1;
//			test[8] = 1;
//			TicTacToeState TEST = new TicTacToeState("Player 1", test);
//			TEST.print();
//			TEST.utility("Player 1");
		}
		else 
			System.out.println("Bad choice");
	}
}
