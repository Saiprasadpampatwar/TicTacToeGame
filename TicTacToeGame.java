import java.util.Scanner;

public class TicTacToeGame {
	static Scanner sc = new Scanner(System.in);
	static final int HEAD = 0;
	static final int TAIL = 1;

	public static void main(String[] args) {

		System.out.println("Welcome to Tic Tac Toe");

		char[] board = createBoard();
		char player = abilityToChoosePlayer();
		char computer = ' ';
		if (player == 'X' || player == 'x') {
			computer = 'O';
		} else if (player == 'O' || player == 'o') {
			computer = 'X';
		}
		System.out.println("letter choosen by player: " + player + " computer: " + computer);
		displayBoard(board);
		char whoWon = toss(player, computer);
		playingUntilGameEnds(whoWon, player, computer, board);
	}

	// Creating the empty board
	private static char[] createBoard() {
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

	// Displaying the board
	private static void displayBoard(char[] tictactoeboard) {
		System.out.println(tictactoeboard[1] + " | " + tictactoeboard[2] + " | " + tictactoeboard[3]);
		System.out.println("___________");
		System.out.println(tictactoeboard[4] + " | " + tictactoeboard[5] + " | " + tictactoeboard[6]);
		System.out.println("___________");
		System.out.println(tictactoeboard[7] + " | " + tictactoeboard[8] + " | " + tictactoeboard[9]);
	}

	// Ability to move anywhere in board while checking the space is empty
	private static void abilityToMove(char[] tictactoeboard, char player) {
		System.out.println("Enter the position where you want to move from(1 to 9):");
		int position = sc.nextInt();
		if (position > 9 || position < 1) {
			System.out.println("please enter valid position");
			abilityToMove(tictactoeboard, player);
		} else {
			if (tictactoeboard[position] == ' ') {
				tictactoeboard[position] = player;
				displayBoard(tictactoeboard);
				// System.out.println("Choose 1. for playing 2. Exit");
				// int option = sc.nextInt();
				// if (option == 1) {
				// abilityToMove(tictactoeboard, player);
				// }
			} else {
				System.out.println("Enter Valid position its accupied\n");
				abilityToMove(tictactoeboard, player);
			}
		}
	}

	// toss to start the game
	private static char toss(char player, char computer) {
		char result = ' ';
		int toss_in_the_sky = (int) Math.floor(Math.random() * 2);
		if (toss_in_the_sky == HEAD) {
			System.out.println("player won the toss");
			result = player;
		} else if (toss_in_the_sky == TAIL) {
			System.out.println("Computer won the toss");
			result = computer;
		}
		return result;
	}

	// Checking for winning condition
	private static boolean isWinner(char[] tictactoeboard, char l) {
		boolean result = ((tictactoeboard[1] == l && tictactoeboard[2] == l && tictactoeboard[3] == l)
				|| (tictactoeboard[4] == l && tictactoeboard[5] == l && tictactoeboard[6] == l)
				|| (tictactoeboard[7] == l && tictactoeboard[8] == l && tictactoeboard[9] == l)
				|| (tictactoeboard[1] == l && tictactoeboard[4] == l && tictactoeboard[7] == l)
				|| (tictactoeboard[2] == l && tictactoeboard[5] == l && tictactoeboard[8] == l)
				|| (tictactoeboard[3] == l && tictactoeboard[6] == l && tictactoeboard[9] == l)
				|| (tictactoeboard[1] == l && tictactoeboard[5] == l && tictactoeboard[9] == l)
				|| (tictactoeboard[3] == l && tictactoeboard[5] == l && tictactoeboard[7] == l));
		return result;
	}

	// checking for tie condition
	private static boolean isTie(char[] tictactoeboard) {
		boolean result = true;
		for (int i = 1; i < tictactoeboard.length; i++) {
			if (tictactoeboard[i] != ' ')
				continue;
			else {
				result = false;
				break;
			}
		}
		return result;
	}

	// Providing computers turn using generating random numbers from 1 to 9
	private static void computersTurn(char[] tictactoeboard, char computer, char player) {
		int select = 0;
		for (int i = 1; i <= 9; i++) {
			if (tictactoeboard[i] == ' ') {
				tictactoeboard[i] = computer;
				if (isWinner(tictactoeboard, computer)) {
					select = 1;
					continue;
				} else {
					tictactoeboard[i] = ' ';
				}
			}
		}

		if (select != 1) {
			int bposition = blockPosition(tictactoeboard, player);
			if (bposition <= 9 && bposition >= 1) {
				tictactoeboard[bposition] = computer;
			} else {
				int cPosition = chooseCornerPosition(tictactoeboard);
				if(cPosition<=9 && cPosition>=1)
				{
					tictactoeboard[cPosition] = computer;
				}
				else 
				{
					if(chooseCentre(tictactoeboard)) {
						tictactoeboard[5] = computer;
					}
					else {
						int number = (int) Math.floor(Math.random() * 9) + 1;

						while (tictactoeboard[number] != ' ') {

							number = (int) Math.floor(Math.random() * 9) + 1;
						}
						tictactoeboard[number] = computer;
					}
					
				}
				
			}
		}

		displayBoard(tictactoeboard);
	}

	// Checking for blocking position so that opponent can't win
	private static int blockPosition(char[] tictactoeboard, char player) {
		int position = 0;
		for (int i = 1; i <= 9; i++) {
			if (tictactoeboard[i] == ' ') {
				tictactoeboard[i] = player;
				if (isWinner(tictactoeboard, player)) {
					position = i;
					break;
				} else {
					tictactoeboard[i] = ' ';
				}
			}
		}
		return position;
	}

	// choosing corner positions
	private static int chooseCornerPosition(char[] tictactoeboard) {
		int[] boardCorners = { 1, 3, 7, 9 };
		for (int position = 0; position < boardCorners.length; position++) {
			if (tictactoeboard[boardCorners[position]] == ' ') {
				return boardCorners[position];
			}

		}
		return 0;
	}
	
	// ChoosingCentre position 
	private static boolean chooseCentre(char[] tictactoeboard) {
		boolean centre = false;
		if(tictactoeboard[5]==' ') {
			centre = true;
		}
		return centre;
	}
	private static void playingUntilGameEnds(char whoWon,char player,char computer,char[] board) {
		if (whoWon == player) {
			abilityToMove(board, player);
			for (int i = 0; i < 4; i++) {
				if (isWinner(board, player)) {
					System.out.println("Player own");
					break;
				}
				System.out.println("Computer is playing");
				computersTurn(board, computer, player);
				if (isWinner(board, computer)) {
					System.out.println("Computer own");
					break;
				}
				System.out.println("player is playing");
				abilityToMove(board, player);

			}
		} else {
			computersTurn(board, computer, player);
			for (int i = 0; i < 4; i++) {
				if (isWinner(board, computer)) {
					System.out.println("Computer own");
					break;
				}
				System.out.println("player is playing");
				abilityToMove(board, player);
				if (isWinner(board, player)) {
					System.out.println("Player own");
					break;
				}
				System.out.println("Computer is playing");
				computersTurn(board, computer, player);
				// abilityToMove(board, computer);
			}
		}
		if (isTie(board)) {
			System.out.println("It's tie");
		}
	}
}