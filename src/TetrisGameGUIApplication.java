import javax.swing.JFrame;

/**
 * This is where the main will be located for the gui versions of tetris. It sets the j frame for the tetris game and then sets it to a size
 * @author sabrina hussaini
 *
 */
public class TetrisGameGUIApplication{
	/**
	 * the constructor for the application which creates tetris using jFrame
	 * 
	 */

	/**
	 * the main method for the application for gui
	 * @param args the string argument
	 */
	public static void main(String[] args) {


		JFrame tetrisFrame = new JFrame ("Tetris");
		tetrisFrame.setSize (500, 800);
		tetrisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tetrisFrame.add(new TetrisGameGUIController());
		tetrisFrame.setVisible(true);

	}


}
