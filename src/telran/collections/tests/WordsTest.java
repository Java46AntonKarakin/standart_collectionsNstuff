package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import telran.util.Words;

class WordsTest {
	static String[][] arrayOfWords = { { "applepie", "apple", "applepay" },
			{ "bugtam", "bugsyam", "bugfix", "bugman", "bug" },
			{ "garaz", "garazniy", "garazik" }, {"morozzzzzz"}};
	Words words = new Words();

	@Test
	void testAddWord() {
		Arrays.stream(arrayOfWords).flatMap(Stream::of).forEach(x -> {
			System.out.println(x);
			assertTrue(words.addWord(x));
			assertFalse(words.addWord(x));
		});
		assertThrows(IllegalArgumentException.class, () -> {
			words.addWord("123");
		});
	}

	@Test
	void testGetWordByPrefix() {
		Arrays.stream(arrayOfWords).flatMap(Stream::of).forEach(words::addWord);
		
		assertThrows(IllegalArgumentException.class, () -> {
			words.getWordByPrefix("123");
		});

		String[] expectedApple = { "apple", "applepay", "applepie" };
		String[] expectedBug = {"bug" , "bugfix", "bugman", "bugsyam", "bugtam" };
		String[] expectedGaraz = { "garaz", "garazik", "garazniy" };
		

		assertArrayEquals(words.getWordByPrefix("apple").toArray(), expectedApple);
		assertArrayEquals(words.getWordByPrefix("bug").toArray(), expectedBug);
		assertArrayEquals(words.getWordByPrefix("garaz").toArray(), expectedGaraz);
		assertArrayEquals(words.getWordByPrefix("moroz").toArray(), new String []{"morozzzzzz"});
		
		assertThrows(IllegalArgumentException.class, () -> {
			words.getWordByPrefix("abstractWord");
		});
	}
}
