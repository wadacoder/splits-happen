package bowling;

import java.util.ArrayList;
import java.util.List;

/**
 * A frame in a bowling game
 * 
 * @author suhas
 *
 */
public class BowlingFrame {
	private List<Roll> rolls;

	/**
	 * @return the rolls
	 */
	public List<Roll> getRolls() {
		return rolls;
	}

	public void addRoll(Roll roll) {
		if (getRolls() == null) {
			rolls = new ArrayList<Roll>();
		}
		rolls.add(roll);
	}
}