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

}
