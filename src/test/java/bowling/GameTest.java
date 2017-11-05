package bowling;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSetRollSequence_AllMisses() {
		Game game = new Game("--------------------");
		LinkedList<BowlingFrame> frames = game.getFrames();
		assertEquals(10, frames.size());
		for (BowlingFrame frame : frames) {
			List<Roll> rolls = frame.getRolls();
			assertEquals(2, rolls.size());
			assertEquals(Roll.MISS, rolls.get(0));
			assertEquals(Roll.MISS, rolls.get(1));
		}
	}

	@Test
	public void testSetRollSequence_AllStrikes() {
		Game game = new Game("XXXXXXXXXXXX");
		LinkedList<BowlingFrame> frames = game.getFrames();
		assertEquals(10, frames.size());
		for (int count = 0; count < frames.size() - 1; count++) {
			List<Roll> rolls = frames.get(0).getRolls();
			assertEquals(1, rolls.size());
			assertEquals(Roll.STRIKE, rolls.get(0));
		}
		assertEquals(frames.getLast().getRolls().size(), 3);
		assertEquals(Roll.STRIKE, frames.getLast().getRolls().get(0));
		assertEquals(Roll.STRIKE, frames.getLast().getRolls().get(1));
		assertEquals(Roll.STRIKE, frames.getLast().getRolls().get(2));
	}

	@Test
	public void testSetRollSequence_MaxRolls() {
		Game game = new Game("5/5/5/5/5/5/5/5/5/5/5");
		LinkedList<BowlingFrame> frames = game.getFrames();
		assertEquals(10, frames.size());
		for (int count = 0; count < frames.size() - 1; count++) {
			List<Roll> rolls = frames.get(0).getRolls();
			assertEquals(2, rolls.size());
			assertEquals(Roll.FIVE, rolls.get(0));
			assertEquals(Roll.SPARE, rolls.get(1));
		}
		assertEquals(frames.getLast().getRolls().size(), 3);
		assertEquals(Roll.FIVE, frames.getLast().getRolls().get(0));
		assertEquals(Roll.SPARE, frames.getLast().getRolls().get(1));
		assertEquals(Roll.FIVE, frames.getLast().getRolls().get(2));
	}

	@Test
	public void testSetRollSequence_ProvidedSequence() {
		Game game = new Game("X7/9-X-88/-6XXX81");
		LinkedList<BowlingFrame> frames = game.getFrames();
		assertEquals(10, frames.size());

		List<Roll> rolls_1 = frames.get(0).getRolls();
		assertEquals(1, rolls_1.size());
		assertEquals(Roll.STRIKE, rolls_1.get(0));

		List<Roll> rolls_2 = frames.get(1).getRolls();
		assertEquals(2, rolls_2.size());
		assertEquals(Roll.SEVEN, rolls_2.get(0));
		assertEquals(Roll.SPARE, rolls_2.get(1));

		List<Roll> rolls_3 = frames.get(2).getRolls();
		assertEquals(2, rolls_3.size());
		assertEquals(Roll.NINE, rolls_3.get(0));
		assertEquals(Roll.MISS, rolls_3.get(1));

		List<Roll> rolls_4 = frames.get(3).getRolls();
		assertEquals(1, rolls_4.size());
		assertEquals(Roll.STRIKE, rolls_4.get(0));

		List<Roll> rolls_5 = frames.get(4).getRolls();
		assertEquals(2, rolls_5.size());
		assertEquals(Roll.MISS, rolls_5.get(0));
		assertEquals(Roll.EIGHT, rolls_5.get(1));

		List<Roll> rolls_6 = frames.get(5).getRolls();
		assertEquals(2, rolls_6.size());
		assertEquals(Roll.EIGHT, rolls_6.get(0));
		assertEquals(Roll.SPARE, rolls_6.get(1));

		List<Roll> rolls_7 = frames.get(6).getRolls();
		assertEquals(2, rolls_7.size());
		assertEquals(Roll.MISS, rolls_7.get(0));
		assertEquals(Roll.SIX, rolls_7.get(1));

		List<Roll> rolls_8 = frames.get(7).getRolls();
		assertEquals(1, rolls_8.size());
		assertEquals(Roll.STRIKE, rolls_8.get(0));

		List<Roll> rolls_9 = frames.get(8).getRolls();
		assertEquals(1, rolls_9.size());
		assertEquals(Roll.STRIKE, rolls_9.get(0));

		List<Roll> rolls_10 = frames.get(9).getRolls();
		assertEquals(3, rolls_10.size());
		assertEquals(Roll.STRIKE, rolls_10.get(0));
		assertEquals(Roll.EIGHT, rolls_10.get(1));
		assertEquals(Roll.ONE, rolls_10.get(2));
	}

}
