import java.util.Scanner;

public class TicTacToeGame {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Tic Tac Toe");
		
		createBoard();
		abilityToChoosePlayer();
	}

	// Creating the empty board
	private static void createBoard() {
		char[] tictactoeboard = new char[10];
		for (int i = 0; i < tictactoeboard.length; i++) {
			tictactoeboard[i] = ' ';
		}
		System.out.println("Created a Game Board of size " + tictactoeboard.length);
	}

	// Here player will choose the letter with whom he wants to play
	private static void abilityToChoosePlayer() {
		System.out.println("Which letter you want to choose: X  Or O ");
		char player = sc.next().charAt(0);
		char computer = ' ';
		if (player == 'X' || player == 'x') {
			computer = 'O';
		} else if(player == 'O' || player == 'o') {
			computer = 'X';
		}
		System.out.println("letter choosen by player: " + player+" computer: "+computer);
	}

}
