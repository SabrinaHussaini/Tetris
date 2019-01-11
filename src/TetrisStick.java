/**
 * This class purpose is for tetris piece stick and calls it degrees and rows and columns
 * @author sabrina hussaini
 *
 */
public class TetrisStick extends TetrisPiece{
	/**
	 * This method is for tetris stick which takes in degree, row, and column
	 */
	public TetrisStick() {
		// rotation of zero degrees
		filledSquares[0] [0] [0] = true;
		filledSquares[0] [0] [1] = true;
		filledSquares[0] [0] [2] = true;
		filledSquares[0] [0] [3] = true;
		// rotation for 90 degrees
		filledSquares[1] [0] [0] = true;
		filledSquares[1] [1] [0] = true;
		filledSquares[1] [2] [0] = true;
		filledSquares[1] [3] [0] = true;
		// rotation for 180 degrees
		filledSquares[2] [0] [0] = true;
		filledSquares[2] [0] [1] = true;
		filledSquares[2] [0] [2] = true;
		filledSquares[2] [0] [3] = true;
		// rotation for 270 degrees
		filledSquares[3] [0] [0] = true;
		filledSquares[3] [1] [0] = true;
		filledSquares[3] [2] [0] = true;
		filledSquares[3] [3] [0] = true;
	}
}