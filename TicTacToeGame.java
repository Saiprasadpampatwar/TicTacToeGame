import java.util.Scanner;

public class TicTacToeGame {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Tic Tac Toe");
		
		char [] board = createBoard();
		char player = abilityToChoosePlayer();
		char computer = ' ';
		if (player == 'X' || player == 'x') {
			computer = 'O';
		} else if(player == 'O' || player == 'o') {
			computer = 'X';
		}
		System.out.println("letter choosen by player: " + player+" computer: "+computer);
		displayBoard(board);
	}

	// Creating the empty board
	private static char [] createBoard() {
		char[] tictactoeboard = new char[10];
		for (int i = 0; i < tictactoeboard.length; i++) {
			tictactoeboard[i] = ' ';
		}
		System.out.println("Created a Game Board of size " + tictactoeboard.length);
		return tictactoeboard;
	}

	// Here player will choose the letter with whom he wants to play
	private static char abilityToChoosePlayer() {
		System.out.println("Which letter you want to choose: X  Or O ");
		char player = sc.next().charAt(0);
		
		return player;
	}
	//Displaying the board
	private static void displayBoard(char [] tictactoeboard) {
		System.out.println(tictactoeboard[1]+ " | "+tictactoeboard[2]+ " | "+tictactoeboard[3]);
		System.out.println("___________");
		System.out.println(tictactoeboard[4]+ " | "+tictactoeboard[5]+ " | "+tictactoeboard[6]);
		System.out.println("___________");
		System.out.println(tictactoeboard[7]+ " | "+tictactoeboard[8]+ " | "+tictactoeboard[9]);
	}

}
