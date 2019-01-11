/**
 * This class is created for the tetris piece t which is true on specific rows and columns. 
 * @author sabrinahussaini
 *
 */
public class TetrisT extends TetrisPiece{
	/**
	 * This method focuses on degrees, rows, and columns for a filled square
	 */
	public TetrisT() {
		//0 degree for tetris t
		filledSquares[0] [1] [1] = true;
		filledSquares[0] [1] [2] = true;
		filledSquares[0] [1] [3] = true;
		filledSquares[0] [2] [2] = true;
		//90 degree for tetris t
		filledSquares[1] [0] [2] = true;
		filledSquares[1] [1] [1] = true;
		filledSquares[1] [1] [2] = true;
		filledSquares[1] [2] [2] = true;
		//180 degree for tetris t
		filledSquares[2] [0] [2] = true;
		filledSquares[2] [1] [1] = true;
		filledSquares[2] [1] [2] = true;
		filledSquares[2] [1] [3] = true;
		//270 degree for tetris t
		filledSquares[3] [0] [1] = true;
		filledSquares[3] [1] [1] = true;
		filledSquares[3] [1] [2] = true;
		filledSquares[3] [2] [1] = true;
	}
}