package bowling;

import java.util.LinkedList;

/**
 * @author suhas
 *
 */
public class Game {
	private String rollSequence;
	private LinkedList<BowlingFrame> frames = new LinkedList<BowlingFrame>();
	private int score;

	/**
	 * @param rollSequence
	 */
	public Game(String rollSequence) {
		super();
		setRollSequence(rollSequence);
	}

	/**
	 * @return the rollSequence
	 */
	public String getRollSequence() {
		return rollSequence;
	}

	/**
	 * @param rollSequence
	 *            the rollSequence to set
	 */
	public void setRollSequence(String rollSequence) {
		this.rollSequence = rollSequence;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
}