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

			// The boolean value in the constructor is for Nim'
			NimState initial = new NimState("Player 1", sticks, true);

			String MinMaxResult = MinimaxSearch.minimaxDecisionMax(initial);
			System.out.println(MinMaxResult);

		}
		else if (choice == 2)
		{
			// code to do Tic-Tac-Toe here.  the user should be able to specify a state 
			// of the game to search from. 

			// Defines the starting board
			// 0 = blank
			// 1 = X
			// 2 = O
			
			int[] test = new int[9];
			test[0] = 1;
			test[1] = 1;
			test[2] = 0;
			test[3] = 0;
			test[4] = 0;
			test[5] = 0;
			test[6] = 0;
			test[7] = 2;
			test[8] = 2;

			GameState initial = new TicTacToeState("Player 1", test);
			System.out.println("Initial state:");
			initial.print();

			while(initial.isTerminal() == false)
			{
				String MinMaxResult = MinimaxSearch.minimaxDecisionMax(initial);
				//System.out.println(MinMaxResult);
				
				System.out.println("Next Move:");

				initial = initial.result(MinMaxResult);
				initial.print();
			}
		}
		
		else {System.out.println("Bad choice");}
	}
}
