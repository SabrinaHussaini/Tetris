/**
 * Class for tetris piece that deals with the rotation, and the pieces
 * @author sabrinahussaini
 *
 */
public class TetrisPiece {
	boolean [] [] [] filledSquares;
	int pieceRotation;
	/**
	 * constructor for tetris piece
	 */
	public TetrisPiece() {
		filledSquares = new boolean [4][4][4];
		//pieceRotation = 0;

	}
	/**
	 * method for rotation of clock wise
	 */
	// rotate the piece clock wise
	public void rotateCW() {
		if (pieceRotation == 3) {
			pieceRotation = 0;
		}else {
			pieceRotation++;

		}
	}


	/**
	 * rotation of counter clock wise
	 */
	// rotation for the piece for counter clock wise
	public void rotateCCW() {
		if (pieceRotation == 0) {
			pieceRotation = 3;
		}else {
			pieceRotation--;

		}
	}

	/**
	 * gets piece rotation
	 * @return
	 */
	public int getPieceRotation() {
		return pieceRotation;

	}
	/**
	 * if it is filled then returns true else returns false
	 * @param rot
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean isFilled(int rot, int row, int col) {
		if (filledSquares [rot][row][col] == true) {
			return true;
		}


		return false;

	}


}
