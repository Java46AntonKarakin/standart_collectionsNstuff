package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Anagram.*;
import org.junit.jupiter.api.Test;

class AnagramTests {
	private static final int N_RUNS = 100000;
	String [] true1 = {"Yellow", "wolely", "lowlye"};
	
	String [] false1 = {"Yellow", "Yello", "Yeellow"};

	@Test
	void isAnagramTestTrue() {
		for (int i = N_RUNS; i > 0; i--) {
			assertTrue(isAnagram(true1[0], true1[0]));
			assertTrue(isAnagram(true1[0], true1[1]));
			assertTrue(isAnagram(true1[0], true1[2]));
			assertTrue(isAnagram(true1[1], true1[2]));
		}
	}
	
	@Test
	void isAnagramTestFalse() {
		for (int i = N_RUNS; i > 0; i--) {
			assertFalse(isAnagram(false1[0], false1[1]));
			assertFalse(isAnagram(false1[0], false1[2]));
			assertFalse(isAnagram(false1[1], false1[2]));
		}
	}
}
