package scorer;

import bowling.Game;

/**
 * @author suhas
 *
 */
public class BowlingScoreReporter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args != null && args.length == 1 && !args[0].trim().isEmpty()) {
			Game game = new Game(args[0]);
			System.out.println(game.getScore());
		}
	}

}
