import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
/**
 * This class has the functions of the GUI components which uses JComponent to create the tetris board. Has functions of painting the blocks and
 * then recording the positions of the pieces in the game. Then paints out the outline for the board that is all black.
 * Then paints out each block in tetris game. And then computes the sizes.
 * @author sabrinahussaini
 *
 */
public class TetrisBoardGUIView extends JComponent{
	// name tetris board boardX
	private TetrisBoard boardX;
	// var for the size of the block
	int blockSize;
	/**
	 * This is the constructor for tetris board gui view
	 * @param b this is the paramter for tetrisboard
	 */
	public TetrisBoardGUIView(TetrisBoard b) {
		boardX = b;
		repaint();
	}
	/**
	 * This method paints the game for tetris using graphics. It uses for loops and if statements
	 * so the pieces on the grid are appearing and then being computed correctly in its size.
	 **/
	public void paint(Graphics g) {
		// just vars i use, i do this so that it shortens code
		paintBoardOutline(g, computeBlockSize());
		int [] position = boardX.getCurrentPieceGridPosition();
		int left = position[0];
		int right = left + 3;
		int front = position[1];
		int back = front + 3;
		// double for loop to go through row and col which are i and j
		for(int i = 0; i < boardX.getNumRows(); i++){
			for(int j = 0; j < boardX.getNumCols(); j++){
				// if the positions for the board pieces are correct
				if ((left <= i) && ( right > i) && (front <= j) && (back > j)){
					int onPieceGridRow = i - left, onPieceGridCol = j - front;
					// if board gets the current piece that is filled so that it then paints the block
					if ((boardX.getCurrentPiece()).isFilled( boardX.getCurrentPiece().getPieceRotation() , onPieceGridRow, onPieceGridCol)== true){
						paintBlock (g,i, j, computeBlockSize());
						// else statement for the board blocks
					} else {
						if (boardX.hasBlock(i, j)) {
							paintBlock(g, i, j, computeBlockSize());
						}
					}
				}
				// else statement so that the block appears when it goes down all the way
				else {
					if (boardX.hasBlock(i, j)) {
						//paints the block using graphics for i and j
						paintBlock(g, i, j, computeBlockSize());
					}
				}
			}
		}
	}
	/**
	 * This method paints the board out line for tetris game which uses a draw rect which creates a draw rect
	 * that is used
	 * @param g
	 * @param blockSize
	 */
	public void paintBoardOutline(Graphics g, int blockSize) {
		// draws the rect for the outline for tetris
		g.drawRect(0, 0, blockSize*boardX.getNumCols(), blockSize*boardX.getNumRows());
	}
	/**
	 * Paint the block at grid row and col which sets the color of the fill rect to green and then the set color of the rect black
	 * @param g just graphics
	 * @param row an int of row
	 * @param col an int of col
	 * @param blockSize the size of the block
	 */
	public void paintBlock(Graphics g, int row, int col, int blockSize) {
		// sets the color of the filled block green
		g.setColor(Color.green);
		g.fillRect( col*blockSize + 1, row*blockSize, blockSize, blockSize);
		// sets the color of the rect black
		g.setColor(Color.black);
		g.drawRect( col*blockSize + 1, row*blockSize, blockSize, blockSize);
	}
	/**
	 * compute the block size for the piece
	 * @return the height divided by 18 which the cols
	 */
	public int computeBlockSize() {
		return (getHeight() / 18);

	}
}