import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * This class is for the tetris game text controller that is in control of the bufferedReader.
 * Quits the line when needed and moves the pieces.
 * @author sabrinahussaini
 *
 */
public class TetrisGameTextController {
	TetrisGame game;
	TetrisBoardTextView view;

	/**
	 * constructor for tetris game text controller that holds the game and view
	 */
	public TetrisGameTextController() {
		game = new TetrisGame();
		view = new TetrisBoardTextView(game.getTetrisBoard());
		readInPut();

	}
	/**
	 * class for read input that does what the command line says
	 */
	public void readInPut() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



		String line = "";
		try
		{


			line = br.readLine();


			while ((!line.equals("Quit"))) {

				moveEntered(line);
				refreshDisplay();
				{



					line = br.readLine();
				}
			}
		}

		catch (IOException ioe) {
			ioe.printStackTrace();

		}


	}
	/**
	 * method refreshes the display and gets the board string
	 */
	public void refreshDisplay() {


		view.getBoardString();





	}
	/**
	 * method moves the pieces in regards to the words typed
	 * @param move
	 */
	public void moveEntered(String move) {
		if (move.equals("d")){
			game.attemptMove("d");


		}
		else if (move.equals("l")) {
			game.attemptMove("l");
		}
		else if (move.equals("r")){
			game.attemptMove("r");

		} else if (move.equals("z")) {
			game.attemptMove(move);
		} else if (move.equals("x")) {
			game.attemptMove(move);
		} else if (move.equals("Quit")) {
			System.out.println("you have to quit game");




		}

	}
}