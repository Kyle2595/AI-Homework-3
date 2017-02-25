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
	
		}
		else if (choice == 2)
		{
			// code to do Tic-Tac-Toe here.  the user should be able to specify a state 
			// of the game to search from. 
			
		}
		else 
			System.out.println("Bad choice");
	}
}
