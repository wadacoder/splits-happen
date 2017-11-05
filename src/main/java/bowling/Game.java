package bowling;

import java.util.LinkedList;
import java.util.List;

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
		frames.clear();
		setFrames(rollSequence);
		score = -1;
	}

	/**
	 * @return the frames
	 */
	public LinkedList<BowlingFrame> getFrames() {
		return frames;
	}

	private void setFrames(String rollSequence) {
		String[] rolls = rollSequence.split("");
		for (String rollString : rolls) {
			Roll roll = Roll.find(rollString);
			BowlingFrame frame = null;
			if (frames.isEmpty()) {
				frame = new BowlingFrame();
				frame.addRoll(roll);
				frames.addLast(frame);
			} else {
				frame = frames.getLast();
				if ((isThirdRoll(frame) || isFirstRollStrike(frame)) && !isLastFrame(frame)) {
					frame = new BowlingFrame();
					frame.addRoll(roll);
					frames.addLast(frame);
				} else {
					frame.addRoll(roll);
				}
			}
		}
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	private boolean isLastFrame(BowlingFrame frame) {
		// a bowling game has maximum 10 frames
		if (frames.indexOf(frame) == 9)
			return true;
		else
			return false;
	}

	private boolean isFirstRollStrike(BowlingFrame frame) {
		List<Roll> rolls = frame.getRolls();
		if (rolls.size() == 1 && rolls.get(0).equals(Roll.STRIKE))
			return true;
		else
			return false;
	}

	private boolean isThirdRoll(BowlingFrame frame) {
		if (frame.getRolls().size() == 2)
			return true;
		else
			return false;
	}
}