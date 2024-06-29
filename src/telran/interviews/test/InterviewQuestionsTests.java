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
	@Test
	void isSum2Test() {
		int [] array = {-10, 2, 40, -30};
		assertTrue(isSum2(array, 30));
		assertFalse(isSum2(array, 32));
	}
	@Test
	void maxPositiveWithNegativeTest() {
		int[] array1 = {-200, 10, -10, 1, 2, 3, -3, 200};
		int [] array2 = {-200, -200, 100, 10, 10};
		assertEquals(200, getMaxWithNegativePresentation(array1));
		assertEquals(-1, getMaxWithNegativePresentation(array2));
	}

}
