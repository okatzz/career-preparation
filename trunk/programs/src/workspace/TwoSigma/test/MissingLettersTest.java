import static org.junit.Assert.*;

import org.junit.Test;

public class MissingLettersTest {


	@Test
	public void testGetMissingLetters1() {
		MissingLetters test = new MissingLetters();
		assertEquals(test.getMissingLetters("A quick brown fox jumps over the lazy dog"), "");
	}
	
	@Test
	public void testGetMissingLetters2() {
		MissingLetters test = new MissingLetters();
		assertEquals(test.getMissingLetters("A slow yellow fox crawls under the proactive dog"), "bjkmqz");
	}
	
	@Test
	public void testGetMissingLetters3() {
		MissingLetters test = new MissingLetters();
		assertEquals(test.getMissingLetters("Lions, and tigers, and bears, oh my!"), "cfjkpquvwxz");
	}

	@Test
	public void testGetMissingLetters4() {
		MissingLetters test = new MissingLetters();
		assertEquals(test.getMissingLetters(""), "abcdefghijklmnopqrstuvwxyz");
	}
	
}
