import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author Andrei Yahorau
 *
 */
public class Analizator {
	private final static String SEPARATOR = "\\s*\\W+\\s*";

	private static Map<String, Integer> separationText(String text) {
		Map<String, Integer> words = new HashMap<>();
		String[] arrayWords = text.split(SEPARATOR);
		for (String word : arrayWords) {
			word = word.toLowerCase();
			int count = 0;
			if (words.containsKey(word)) {
				count = words.get(word);
			}
			count++;
			words.put(word, count);
		}
		return words;
	}

	public static int frequencyWord(String word, String text) {
		Map<String, Integer> words = separationText(text);
		int frequency = 0;
		if (words.containsKey(word)) {
			frequency = words.get(word);
		}
		return frequency;
	}

}
