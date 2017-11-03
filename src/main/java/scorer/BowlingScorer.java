package scorer;

/**
 * @author suhas
 *
 */
public class BowlingScorer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args != null && args.length == 1 && !args[0].trim().isEmpty()) {
			ScoringHelper scoringHelper = new ScoringHelper();
			System.out.println(scoringHelper.score());
		}
	}

}
