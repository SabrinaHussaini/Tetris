/**
 * class for tetris piece l1
 * @author sabrinahussaini
 *
 */
public class TetrisL1 extends TetrisPiece {
	public TetrisL1(){
		// 0 degree
		filledSquares[0] [0] [2] = true;
		filledSquares[0] [1] [2] = true;
		filledSquares[0] [2] [2] = true;
		filledSquares[0] [2] [3] = true;
		// 90 degree
		filledSquares[1] [1] [1] = true;
		filledSquares[1] [1] [2] = true;
		filledSquares[1] [1] [3] = true;
		filledSquares[1] [2] [1] = true;
		// 180 degree
		filledSquares[2] [0] [1] = true;
		filledSquares[2] [0] [2] = true;
		filledSquares[2] [1] [2] = true;
		filledSquares[2] [2] [2] = true;
		// 270 degree
		filledSquares[3] [0] [3] = true;
		filledSquares[3] [1] [1] = true;
		filledSquares[3] [1] [2] = true;
		filledSquares[3] [1] [3] = true;

	}
}