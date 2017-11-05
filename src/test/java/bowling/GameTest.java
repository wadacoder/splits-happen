package bowling;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSetRollSequence_AllMisses() {
		Game game = new Game("--------------------");
		assertEquals(10, game.getFrames().size());
	}

	@Test
	public void testSetRollSequence_AllStrikes() {
		Game game = new Game("XXXXXXXXXXXX");
		assertEquals(10, game.getFrames().size());
	}

}
