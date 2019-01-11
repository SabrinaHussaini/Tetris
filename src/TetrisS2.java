/**
 * This class is for tetris piece S2 
 * @author sabrinahussaini
 *
 */
public class TetrisS2 extends TetrisPiece{
	/**
	 * This method is for tetris s2 piece which takes in specific values and equals them to true
	 */
	public TetrisS2() {
		//0 degrees 
		filledSquares[0] [1] [1] = true;
		filledSquares[0] [1] [2] = true;
		filledSquares[0] [2] [2] = true;
		filledSquares[0] [2] [3] = true;
		//90 degrees
		filledSquares[1] [0] [3] = true;
		filledSquares[1] [1] [2] = true;
		filledSquares[1] [1] [3] = true;
		filledSquares[1] [2] [2] = true;
		//180 degrees
		filledSquares[2] [1] [1] = true;
		filledSquares[2] [1] [2] = true;
		filledSquares[2] [2] [2] = true;
		filledSquares[2] [2] [3] = true;
		//270 degrees
		filledSquares[3] [0] [3] = true;
		filledSquares[3] [1] [2] = true;
		filledSquares[3] [1] [3] = true;
		filledSquares[3] [2] [2] = true;
	}

}