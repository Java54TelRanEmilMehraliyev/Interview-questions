package telran.interviews;
import java.util.*;
public class AutoCompletion {
 TreeSet<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	public boolean addWord(String word) {
		//adds new word into auto-completion variants
		//returns true if added, false otherwise (if a given word already exists)
		if(words.contains(word)) {
			return false;
		}
		return words.add(word);
	}
	public String [] getVariants(String prefix) {
		//returns all words beginning with a given prefix
		//Complexity of finding the variants is O[logN]
		return words.subSet(prefix, prefix + Character.MAX_VALUE).toArray(String[]::new);
	}
}