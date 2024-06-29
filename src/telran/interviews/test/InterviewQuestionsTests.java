package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.interviews.InterviewQuestions.*;

import org.junit.jupiter.api.Test;

class InterviewQuestionsTests {

	@Test
	void displayOccurrencesTest() {
		String[] strings = {"b", "a","bb", "aa", "lmn", "aa", "lmn", "lmn", "bb"};
		displayOccurrences(strings);
		//Should be displayed out the following:
		/*
		 * lmn => 3
		 * aa => 2
		 * a => 1
		 * b => 1
		 */
	}

}
