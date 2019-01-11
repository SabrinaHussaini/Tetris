/**
 * This method is for tetris piece s1
 * @author sabrinahussaini
 *
 */
public class TetrisS1 extends TetrisPiece{
	/**
	 * This method is for tetris s1 which takes in degrees row and columns
	 */
	public TetrisS1() {
		// 0 degrees
		filledSquares[0] [1] [2] = true;
		filledSquares[0] [1] [3] = true;
		filledSquares[0] [2] [1] = true;
		filledSquares[0] [2] [2] = true;
		// 90 degrees
		filledSquares[1] [0] [1] = true;
		filledSquares[1] [1] [1] = true;
		filledSquares[1] [1] [2] = true;
		filledSquares[1] [2] [2] = true;
		// 180 degrees
		filledSquares[2] [1] [2] = true;
		filledSquares[2] [1] [3] = true;
		filledSquares[2] [2] [1] = true;
		filledSquares[2] [2] [2] = true;
		// 270 degrees
		filledSquares[3] [0] [1] = true;
		filledSquares[3] [1] [1] = true;
		filledSquares[3] [1] [2] = true;
		filledSquares[3] [2] [2] = true;
	}
}