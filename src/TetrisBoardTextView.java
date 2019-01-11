/**
 * This class is the tetris board text view that deals with the strings of the boards and creates the board
 * essentially.
 * @author sabrinahussaini
 *
 */
public class TetrisBoardTextView {
	TetrisBoard board;
	String s;
	/**
	 * constructor for tetris board which get the board string and board is board
	 * @param board which is for the tetrisBoard
	 */
	public TetrisBoardTextView(TetrisBoard board) {
		this.board = board;
		getBoardString();

	}
	/**
	 * This method uses string to print the board and the things on the board
	 * @return s which is the string used
	 */
	public String getBoardString() {
		// var used for game board
		boolean [][] gameBoard = board.getBoard();
		// out prints that are needed for the board
		System.out.println("Please enter a move(l,r,d,z,x) or type Quit to end");
		System.out.println("Number of Tetrises Cleared:" + board.getCountFormedTetrises());

		System.out.println("Number of Lines Cleared:" + board.getCountFormedLines());

		System.out.println("----------");
		// open string
		s = "";
		// double for loop to check through row and col
		for (int i = 0; i < gameBoard.length; i++) {
			for(int j = 0; j < gameBoard[i].length; j++) {
				// if board has block it returns true
				if (board.hasBlock(i, j)) {
					// open string
					s += "X";


					// else it goes through so if row and col are less than the position
				}
				else {
					s += " ";

				}
			}

			// if i is unequal to the game board
			if ( i != gameBoard.length-1) {
				// creates space
				s += "\n";

			}
		}

		// system out print line for string
		System.out.println(s);
		System.out.println("----------");
		return s;

	}


}

