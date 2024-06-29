package telran.interviews;

import java.util.*;

public class InterviewQuestions {

	public static void displayOccurrences(String[] strings) {
		HashMap<String, Integer> mapOccurrences = getOccurrencesMap(strings);
		TreeMap<Integer, TreeSet<String>> treeMapOccurrences = getTreeMapOccurrences(mapOccurrences);
		displayOccurrences(treeMapOccurrences);
	}

	private static void displayOccurrences(TreeMap<Integer, TreeSet<String>> treeMapOccurrences) {
		treeMapOccurrences.entrySet().forEach(e -> {
			e.getValue().forEach(str -> System.out.printf("%s => %d\n", str, e.getKey()));
		});

	}

	private static TreeMap<Integer, TreeSet<String>> getTreeMapOccurrences(HashMap<String, Integer> mapOccurrences) {
		TreeMap<Integer, TreeSet<String>> result = new TreeMap<Integer, TreeSet<String>>(Comparator.reverseOrder());
		mapOccurrences.entrySet()
				.forEach(e -> result.computeIfAbsent(e.getValue(), k -> new TreeSet<>()).add(e.getKey()));

		return result;
	}

	private static HashMap<String, Integer> getOccurrencesMap(String[] strings) {
		HashMap<String, Integer> result = new HashMap<>();
		for (String str : strings) {
			result.merge(str, 1, Integer::sum);
		}
		return result;
	}
	
	
	static public boolean isSum2(int[] array,int sum) {
		Set<Integer> seenNumbers = new HashSet<>();
		
		for(int num : array) {
			int complement = sum - num;
			if(seenNumbers.contains(complement)) {
				return true;
			}
			seenNumbers.add(num);
		}
		return false;
	}
	
	static public int getMaxWithNegativePresentation(int [] array) {
		Set<Integer> numbers = new HashSet<>();
		int max = -1;
		
		for(int num : array) {
			numbers.add(num);
		}
		
		for(int num : array) {
			if(num > 0 && numbers.contains(-num)) {
				max = Math.max(max, num);
			}
		}
		return max;
	}
}