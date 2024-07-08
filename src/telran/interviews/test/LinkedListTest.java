package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {
Integer[] numbers = {30, -10, 20, 17, 30};
LinkedList<Integer> list;
@BeforeEach
void setUp() {
	list = new LinkedList<>(List.of(numbers));
}
	@Test
	void removeTest() {
		Integer[] expected = {-10, 20, 17, 30};
		list.remove();
		runTest(expected, list);
		LinkedList<Integer> emptyList = new LinkedList<>();
		assertThrowsExactly(NoSuchElementException.class, () -> emptyList.remove());
	}
	@Test
	void sublistTest() {
		List<Integer> sublist = list.subList(3, 5);
		Integer[]expected = {17, 30};
		runTest(expected, sublist);
	}
	@Test
	void sublistAsViewTest() {
		List<Integer> sublist = list.subList(3, 5);
		sublist.add(1,40);
		sublist.add(500);
		sublist.add(3, 100);
		
		assertTrue(sublist.contains(500));
		Integer[] expected = {30, -10, 20, 17, 40, 30, 100, 500};
		runTest(expected, list);
		
		
		
	}
	private void runTest (Integer[] expected, List<Integer> list) {
		assertArrayEquals(expected, list.toArray(Integer[]::new));
	}

}