
public class TicTacToeGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Tic Tac Toe");
		TicTacToeGame TTTG = new TicTacToeGame();
		TTTG.GameBoard();
	}
	
	public void GameBoard() {
		char [] tictactoeboard = new char[10]; 
		for(int i=0; i<tictactoeboard.length;i++)
		{
			tictactoeboard[i]= ' ';
		}
		System.out.println("Created a Game Board of size "+ tictactoeboard.length);
	}

}
