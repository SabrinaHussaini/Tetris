import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * This class is for the controlling aspect for tetris which basically uses key listeners so that you can use the arrows for the game. It also
 * deals with the layouts for the parts and where it will be located.
 * @author sabrinahussaini
 *
 */
public class TetrisGameGUIController extends JPanel implements KeyListener, ActionListener {
	// var for the controller which is used throughout
	static int DEFAULT_DROP_RATE = 1000;
	TetrisGame game;
	TetrisBoardGUIView view;
	Timer gameTimer;
	int dropRate = 1000;
	private JLabel linesLabel;
	private JLabel tetrisLabel;
	JPanel score;

	/**
	 * This is the constructor for the gui controller which adds the borderLayout for the game
	 */
	public TetrisGameGUIController() {
		// create new borderLayout
		super(new BorderLayout());
		game = new TetrisGame();
		view = new TetrisBoardGUIView(game.getTetrisBoard());
		// add the score to the north for the border layout
		add(createScore(),BorderLayout.NORTH);
		// calls on create view
		createView();
		// calls create score
		//createScore();
		// calls setupTimer
		//setText();
		setupTimer();
		//adds key listener
		addKeyListener(this);
		//calls refresh
		refreshDisplay();
		//set focusable to true
		setFocusable(true);



	}
	/**
	 * This sets up the timer for the game
	 */
	public void setupTimer() {
		gameTimer = new Timer (dropRate, this);
		gameTimer.setInitialDelay(DEFAULT_DROP_RATE);
		gameTimer.start();


	}

	/**
	 * action performed so it could have key moves
	 */
	public void actionPerformed(ActionEvent e) {
		game.attemptMove("d");
		repaint();
		refreshDisplay();
	}
	/**
	 * This method is for the create view which just puts the view to the center
	 *
	 */
	public void createView() {
		// add view to center
		add(view, BorderLayout.CENTER);


	}

	/**
	 * This method creates the score by using a JPanel and also adds the score results
	 * @return the jPanel
	 */
	public JPanel createScore() {

		String scoreText = ("Number of line cleared:" + game.getScore());
		String tetrisText = ("Number of tetrises cleared:" + game.getTetrises());



		score = new JPanel();
		score.setLayout(new GridLayout(2,0));

		linesLabel = new JLabel(scoreText);
		tetrisLabel = new JLabel(tetrisText);

		score.add(linesLabel);
		score.add(tetrisLabel);

		return score;










	}
	/**
	 * This method is so it refreshes the display for tetris
	 */
	public void refreshDisplay() {

		linesLabel.setText("Number of line cleared:" + game.getScore());
		tetrisLabel.setText("Number of tetrises cleared:" + game.getTetrises());
		repaint();

	}
	/**
	 * This method is for keyTyper
	 * @param e
	 */
	public void keyTyper(KeyEvent e) {

	}
	/**
	 * This method is for key released but nothing goes in it
	 */
	public void keyReleased(KeyEvent e) {

	}
	/**
	 * This method is so that when you use the arrows on the keyboard it will do what it says like move down and stuff
	 */
	public void keyPressed(KeyEvent e) {
		// this is for every key arrow and then the z and stuff
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			DEFAULT_DROP_RATE = 1;
			game.attemptMove("d");

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			game.attemptMove("l");
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			game.attemptMove("r");

		}else if (e.getKeyCode() == KeyEvent.VK_X){
			game.attemptMove("x");
		} else if (e.getKeyCode() == KeyEvent.VK_Z) {
			game.attemptMove("z");




		}
		// repaints the board
		repaint();
		// refreshes the display for the board
		refreshDisplay();

	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}


}