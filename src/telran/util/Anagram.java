package telran.util;

import java.util.*;

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

	public static boolean isAnagram(String word, String anagram) {
		char[] first = word.toLowerCase().toCharArray();
		char[] second = anagram.toLowerCase().toCharArray();
		Arrays.sort(first);
		Arrays.sort(second);
		return Arrays.equals(first, second);
		
//		TreeMap<Character, Integer> first = StringToMap(word);
//		TreeMap<Character, Integer> second = StringToMap(anagram);
//		return first.equals(second);
	}

	private static TreeMap<Character, Integer> StringToMap(String str) {
		TreeMap<Character, Integer> res = new TreeMap<>();
		str.toLowerCase().chars().mapToObj(i -> (char) i).forEach(x -> {
			Integer count = res.getOrDefault(x, 0);
			res.put(x, count + 1);
		});
		return res;
	}
}
