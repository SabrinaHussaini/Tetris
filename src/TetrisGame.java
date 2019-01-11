/**
 * This class is for tetris game that is in control of the attempt move for the words that are typed in the keyboard
 * and then a specific action occurs
 * @author sabrinahussaini
 *
 */
public class TetrisGame {
	// var for right left down cw and ccw num lines num tetrises
	final static int LEFT = 1;
	final static int RIGHT = 2;
	final  static int DOWN = 3;
	final static int CW = 4;
	final static int CCW = 5;
	int numLines;
	int numTetrises;
	private TetrisBoard tetrisBoard;

	/**
	 * constructor for tetris game
	 */
	public TetrisGame() {
		tetrisBoard = new TetrisBoard();
	}
	/**
	 * method for attempt move that uses string which goal is to move piece
	 * @param move for type string
	 */
	public void attemptMove(String move) {
		if (move.equals("r")){
			tetrisBoard.moveRight();
		}
		else if (move.equals("l")) {
			tetrisBoard.moveLeft();
		}
		else if (move.equals("d"))
		{
			if (tetrisBoard.moveDown ()  == false) {
				endRound();

			}
		}
		else if (move.equals("z")) {
			tetrisBoard.rotateCW();
		}
		else if (move.equals("x")) {
			tetrisBoard.rotateCCW();
		}
		else if (move.equals("quit")) {
			System.out.println("you have to quit game");


		}
	}

	/**
	 * method for end round where tetris board lands piece, adds new piece, and number of formed lines
	 */
	public void endRound() {

		tetrisBoard.numberOfFormedLines();


	}
	/**
	 * gets num lines
	 * @return CCW
	 */
	public int getNumLines() {
		return numLines;


	}
	/**
	 * gets num tetrises
	 * @return ccw
	 */
	public int getScore() {
		return tetrisBoard.getCountFormedLines();


	}
	/**
	 * a getter for the number of tetrises
	 * @return the amount you count
	 */
	public int getTetrises() {
		return tetrisBoard.getCountFormedTetrises();

	}
	/**
	 * get tetris baord
	 * @return tetris board
	 */
	public TetrisBoard getTetrisBoard() {
		return tetrisBoard;


	}
}