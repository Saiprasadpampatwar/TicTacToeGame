import java.util.Scanner;

public class TicTacToeGame {
	static Scanner sc = new Scanner(System.in);
		 
	static char [] tictactoeboard = new char[10]; 		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Tic Tac Toe");
		for(int i=0; i<tictactoeboard.length;i++)
		{
			tictactoeboard[i]= ' ';
		}
		TicTacToeGame TTTG = new TicTacToeGame();
		TTTG.AbilityToChoosePlayer();
		TTTG.AbilityToMove(tictactoeboard);
		TTTG.DisplayBoard(tictactoeboard);
	}
	
	
	public void AbilityToChoosePlayer() {
		System.out.println("Which letter you want to choose:\n 1.X (UpperCase)\n 2. O (UpperCase)");
		char player = sc.next().charAt(0);
		System.out.println("letter choosen by player: "+player);
		char computer;
		if (player == 'X') {
			computer = 'O';
		}
		else
		{
			computer = 'X';
		}
		System.out.println("letter choosen by computer: "+computer);
	}
	
	public void DisplayBoard(char [] tictactoeboard) {
		System.out.println(tictactoeboard[1]+ " | "+tictactoeboard[2]+ " | "+tictactoeboard[3]);
		System.out.println("___________");
		System.out.println(tictactoeboard[4]+ " | "+tictactoeboard[5]+ " | "+tictactoeboard[6]);
		System.out.println("___________");
		System.out.println(tictactoeboard[7]+ " | "+tictactoeboard[8]+ " | "+tictactoeboard[9]);
	}
	
	public void AbilityToMove(char [] tictactoeboard) {
		System.out.println("Enter the position where you want to move from(1 to 9):");
		int position = sc.nextInt();
		if (position > 9 || position < 1) {
			System.out.println("please enter valid position");	
		}
		else {
			tictactoeboard[position] = 'X';
		}
		
	}

}
