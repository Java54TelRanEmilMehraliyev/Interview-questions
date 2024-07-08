package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import telran.interviews.AutoCompletion;

class AutoCompletionTest {
String [] words = {"ab", "ABC", "avfdr", "aV", "aVV", "aaA"};
String [] wordsAb = {"ab", "ABC"};
String [] wordsAv = {"aV", "avfdr", "aVV", };
String [] wordsAa = {"aaA"};
	@Test
	void test() {
		AutoCompletion autoCompletion = new AutoCompletion();
		for(String word: words) {
			autoCompletion.addWord(word);
		}
		assertArrayEquals(wordsAb, autoCompletion.getVariants("ab"));
		assertArrayEquals(wordsAv, autoCompletion.getVariants("av"));
		assertArrayEquals(wordsAa, autoCompletion.getVariants("aa"));
	}

}
