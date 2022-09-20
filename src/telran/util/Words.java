package telran.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Words {

	TreeSet<String> tree = new TreeSet<>((word1, word2) -> {
		if (word1.equals(word2)) {
			return 0;
		}

		int res = 0;
		int minLength = word1.length() < word2.length() ? word1.length() : word2.length();

		for (int i = 0; i < minLength; i++) {
			if (word1.charAt(i) != word2.charAt(i)) {
				res = word1.charAt(i) > word2.charAt(i) ? res + 1 : res - 1;
				break;
			}
		}
		return res != 0 ? res : word1.length() > word2.length() ? 1 : -1;
	});

	public boolean addWord(String word) {
		if (!word.matches("[A-Za-z]*")) {
			throw new IllegalArgumentException(String.format(" <<%s>> doesn't match ([A-Z])*", word));
		}
		word.toLowerCase();
		return tree.add(word);
	}

	public List<String> getWordByPrefix(String prefix) {
		if (!prefix.matches("[A-Za-z]*")) {
			throw new IllegalArgumentException(String.format(" <<%s>> doesn't match ([A-Z])*", prefix));
		}

		prefix.toLowerCase();
		String border = getBorder(prefix);
		var wiev = tree.subSet(prefix, true, border, false);
		if (wiev.isEmpty()) {
			throw new IllegalArgumentException(String.format(" there are no words begining with <<%s>> ", prefix));
		}
		return new ArrayList<>(wiev);
	}

	private String getBorder(String prefix) {
		char[] prefixChArr = prefix.toCharArray();
		for (int i = prefixChArr.length - 1;; i--) {
			if (prefixChArr[i] != 122) {
				prefixChArr[i]++;
				break;
			}
			if (i == 1) {
				throw new IllegalArgumentException("nobody likes z");
			}
		}
		return String.copyValueOf(prefixChArr);
	}
}
