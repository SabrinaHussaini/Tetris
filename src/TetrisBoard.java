import java.util.Random;
/**
 * Class for tetris board that is basically is control of alot of the aspects of tetris. It deals with the initial
 * board and then the current grid position. Tetris board is in control of the movements and rotations.
 * Tetris board also adds new piece to the board. Basically anything related to the board and specifics of the piece, tetris board
 * is in charge of.
 * @author sabrina hussaini
 *
 */
public class TetrisBoard {
	// instance variables used for tetris board
	static final int NUM_COLS = 10;
	static final int NUM_ROWS = 18;
	private static final int numCols = 4;
	private static final int numRows = 4;
	public int countFormedLines = 0;
	public int countFormedTetrises = 0;
	// changed the name from matrix to board
	boolean [][] board;
	private TetrisPiece currentPiece;
	// an array that tells where the piece is currently
	private int [] currentPieceGridPosition;



	/**
	 *  constructor for tetris board that calls on initBoard and addNewPiece
	 */
	public TetrisBoard() {
		initBoard();
		addNewPiece();

	}
	/**
	 * initialize the current grid position for the piece on tetris board and calls on the check if lost method
	 */
	public void initCurrentGP() {
		currentPieceGridPosition = new int [2];
		currentPieceGridPosition[0] = 0;
		currentPieceGridPosition[1] = 3;
		checkIfLost();



	}
	/**
	 * initializes the board, prepares the game by having a boolean of row and cols
	 */
	public void initBoard() {
		board = new boolean [NUM_ROWS] [NUM_COLS];

	}
	/**
	 * when the piece falls all the way down to the other pieces, it then becomes
	 * apart of the board
	 */
	public void landPiece() {
		// double for loop to go through row and col and if curr piece is filled then the board is true
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				// if the current piece is filled and gets the rotation of the piece, it being true
				if (currentPiece.isFilled (currentPiece.getPieceRotation(), i, j)){
					board[currentPieceGridPosition [0] + i] [currentPieceGridPosition [1]+j] = true;
				}
			}
		}

		// adds the new piece method
		addNewPiece();

	}
	/**
	 * where the piece will move to the left, and if it is successful or not
	 * @return false if it is not valid move
	 * @return true if it is
	 */
	public boolean moveLeft() {
		// if detect out of bounds and detect collision find curr piece and have it labeled to where it moves left else it does not
		if (!validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0], currentPieceGridPosition[1]-1)) {
			return false;
		} else {
			currentPieceGridPosition[1] = currentPieceGridPosition [1] - 1;
			return true;
		}
	}

	/**
	 * where the piece will move to the right, and it will determine if it is
	 * successful or not
	 * @return false if it is not moving right
	 * @return true if it is
	 */
	public boolean moveRight() {
		// checks detect out of bounds and detect collision
		if(!validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0], currentPieceGridPosition [1] + 1)) {
			return false;
		} else {
			currentPieceGridPosition[1] = currentPieceGridPosition [1] + 1;
			return true;
		}
	}
	/**
	 * where the piece will move down, and it will determine if it is
	 * successful in moving down or not
	 * @return false if not valid move
	 * @return true if valid move is true
	 *
	 */
	public boolean moveDown() {
		// detect out of bounds and detect collision are both checking current piece
		if (!validMove(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0] + 1, currentPieceGridPosition [1])) {
			// calls land piece so when it goes down it lands the piece
			landPiece();
			return false;
			// else statement if it does move down
		} else {
			currentPieceGridPosition[0] = currentPieceGridPosition [0] + 1;
			return true;

		}

	}
	/**
	 * where the piece will rotate clock wise, and it will determine if it
	 * successfully rotated clock wise or not
	 *
	 */
	public void rotateCW() {
		currentPiece.rotateCW();
		// if detect out of bounds and detect collison move in regards to rotation
		if (detectOutOfBounds(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0], currentPieceGridPosition [1])
				|| (detectCollision(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0] , currentPieceGridPosition[1] ))) {
			currentPiece.rotateCCW();
			// else it will not
		} else {
		}
	}
	/**
	 * where the piece will rotate counter clock wise and it will determine if it
	 * successfully rotated counter clock wise or not
	 *
	 */
	public void rotateCCW() {
		currentPiece.rotateCCW();
		// if statement for the rotation ccw which checks if bounds and collision is at the current piece rotation
		if (detectOutOfBounds(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0], currentPieceGridPosition [1]) ||
				(detectCollision(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0] , currentPieceGridPosition[1] ))) {
			currentPiece.rotateCW();
			// else won't
		} else {

		}

	}
	/**
	 * makes sure there is no overlap between the pieces by using for loop to go through the grid col and row
	 * @param piece it is the tetris piece
	 * @param rot an int for rotation
	 * @param gridRow int for the grid row
	 * @param gridCol int for the grid col
	 * @return true if it is filled else return false
	 */
	public boolean detectCollision(TetrisPiece piece, int rot, int gridRow, int gridCol) {
		// double for loop to check the i and j so they are not colliding
		for (int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				// if curr piece is filled then return true
				if (currentPiece.isFilled(rot, i, j)) {

					if (board[gridRow + i][gridCol+j]) {

						return true;
					}

				}
			}
		}

		return false;
	}
	/**
	 * makes sure it is on the board and not off the board by using for loops to go through the grid
	 * @param piece it is the tetris piece
	 * @param rot int for the rotation
	 * @param gridRow int for the gridRow
	 * @param gridCol int for the gridCol
	 * @return true if current piece is filled else it is false
	 */
	public boolean detectOutOfBounds(TetrisPiece piece, int rot, int gridRow, int gridCol) {
		// double for loop to check through array
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				// if the current piece is filled
				if(currentPiece.isFilled(rot, i, j) == true){
					if (gridRow < 0 || gridRow + i >= NUM_ROWS || gridCol + j < 0 || gridCol + j >= NUM_COLS) {
						return true;
					}

				}
			}
		}

		return false;

	}
	/**
	 * checks if the move is valid, meaning it doesnt go out of bound and does not
	 * get placed somewhere where there is already a piece there
	 * @param piece it is the tetris piece
	 * @param rot int for the rotation
	 * @param gridRow int for the gridRow
	 * @param gridCol int for the gridCol
	 * @return true if valid move is not true else false
	 */
	public boolean validMove(TetrisPiece piece, int rot, int gridRow, int gridCol) {
		// if detect out of bounds and detect collision return false
		if (!detectOutOfBounds (piece, rot, gridRow, gridCol)){
			if (!detectCollision (piece, rot, gridRow, gridCol)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * checks if there is a piece at a specific row and column and if there is a piece then it will not
	 * let another piece there. Basically checking if there is a current piece on the board that is filled.
	 * @param row int for rows
	 * @param col int for the columns
	 * @return true if it is blocked
	 */
	public boolean hasBlock(int row, int col) {
		int x;
		int y;
		// double for loop for row and column
		for(int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				x = currentPieceGridPosition[0] + i;
				y = currentPieceGridPosition[1] + j;
				if (x == row && col == y && currentPiece.isFilled(currentPiece.getPieceRotation(), i, j)  ){

					return true;

				}

			}

		}
		return board [row][col];
	}
	/**
	 * adds a new piece to the board once the last piece is sitting at a specific location meaning that the last piece
	 * is all the way down, uses random generator to create random pieces falling
	 */
	public void addNewPiece() {
		// create random generator so new pieces are present
		Random randomGen = new Random();

		int rand = randomGen.nextInt(7);
		//rand = 5;
		if (rand == 0) {
			currentPiece = new TetrisL1(); }
		else if (rand == 1) {
			currentPiece = new TetrisL2(); }
		else if (rand == 2) {
			currentPiece = new TetrisS1(); }
		else if (rand == 3) {
			currentPiece = new TetrisS2(); }
		else if (rand == 4) {
			currentPiece = new TetrisSquare(); }
		else if (rand == 5) {
			currentPiece = new TetrisStick(); }
		else if (rand == 6) {
			currentPiece = new TetrisT(); }
		initCurrentGP();
	}

	/**
	 * determine if there is a full line of row pieces on the board
	 * @param row the int for row
	 * @return false if full line is false else return true
	 **/
	public boolean fullLine(int row) {
		// checks throughout the entire row to see if it is full
		for(int j = 0; j < NUM_COLS; j++) {
			// if it is full return as false so it checks every single one
			if (board[row][j] == false) {
				return false;
			}
		}
		return true;

	}

	/**
	 * removes an entire line for the row if it is full
	 * @param row int for row
	 */
	public void removeLine(int row) {
		// use double for loop to go through i and j to help remove the line
		for(int i = row; i > 0; i--) {

			//System.out.println("null" + countFormedLines);

			for(int j = 0 ; j <NUM_COLS; j++)
			{


				board[i][j] = board[i-1][j];

			}

		}
	}


	/**
	 * the amount of rows that get filled and are considered a point for the game
	 * @return x which is the lines formed
	 */
	public int numberOfFormedLines() {
		// create temp var 
		int removedLines = 0;
		// for loop to go through the rows to see is there is a formed line
		for(int row = 0; row < getNumRows(); row++){

			// goes through the full line
			if(fullLine(row)){
				removedLines++;
				removeLine(row);

			}
		}
		// makes the four tetrises basically
		countFormedLines += removedLines;
		if (removedLines == 4) {
			countFormedTetrises++;
		}
		// return the count formed lines
		return countFormedLines;
	}


	/**
	 * This method checks if you lost or not. It detects the collision and then it will determine if you lose if the you get to the top
	 * and exceed the amount of pieces
	 */
	public void checkIfLost() {
		// if statement to see if a piece is misplaced and when it is misplaced at the top then it means you lost the game
		if (detectCollision(currentPiece, currentPiece.getPieceRotation(), currentPieceGridPosition[0], currentPieceGridPosition[1])) {


		}
	}
	/**
	 * a getter for count formed tetrises
	 * 
	 * @return the count formed tetrises
	 */
	public int getCountFormedTetrises(){

		return countFormedTetrises;

	}
	/**
	 * a getter for the count formed lines
	 * @return the count formed lines
	 */
	public int getCountFormedLines() {
		return countFormedLines;
	}
	/**
	 * returns the block matrix
	 * @return board which is the getter
	 */
	public boolean [] [] getBoard(){
		return board;

	}
	/**
	 * returns the current piece
	 * @return currentPiece which is the getter
	 */
	public TetrisPiece getCurrentPiece() {
		return currentPiece;

	}
	/**
	 * returns the current piece grid position
	 * @return currentPieceGridPosition which is getter
	 */
	public int [] getCurrentPieceGridPosition() {
		return currentPieceGridPosition;

	}
	/**
	 * return numCols
	 * @return NUM_COLS which is getter
	 */

	public int getNumCols() {
		return NUM_COLS;

	}
	/**
	 * return num rows
	 * @return NUM_ROWS which is the getter
	 */
	public int getNumRows() {
		return NUM_ROWS;

	}
}