package telran.util;

import java.util.HashMap;

public class Anagram {

	/**
	 * 
	 * @param word
	 * @param anagram
	 * @return true if anagram is one of the possible anagrams of a given word
	 *         anagram is a string containing all symbols from a given word with
	 *         different order Example: yellow (wolely, lowlye, yellow) , wrong
	 *         anagrams (yello, yelllw)
	 */

	// write the method by using the Java 8 Map methods merge and compute
	public static boolean isAnagram(String word, String anagram) {
		if (word.length() != anagram.length()) {
			return false;
		}
		
		HashMap<Character, Integer> wordMap = word.toLowerCase()
				.chars()
				.mapToObj(i -> (char) i)
				.collect(HashMap::new,(a, b) -> a.put(b, a.getOrDefault(b, 0) + 1), (a, b) -> a.putAll(b));
		
		anagram.toLowerCase()
		.chars()
		.mapToObj(i -> (char) i)
		.forEach(x -> {
			wordMap.merge(x, -1, (x1, x2) -> {
				return x2 == 1 ? null : x2 - 1;
			});
		});

		return wordMap.isEmpty();
	}
}