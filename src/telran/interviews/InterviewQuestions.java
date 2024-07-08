package telran.interviews;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewQuestions {

	public static void displayOccurrences(String[] strings) {
		HashMap<String, Integer> mapOccurrences = getOccurrencesMap(strings);
		TreeMap<Integer, TreeSet<String>> treeMapOccurrences = getTreeMapOccurrences(mapOccurrences);
		displayOccurrences(treeMapOccurrences);
	}

	public static void displayOccurrencesStream(String[] strings) {
		Arrays.stream(strings).collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream()
				.sorted((e1, e2) -> {
					int res = Long.compare(e2.getValue(), e1.getValue());
					return res == 0 ? e1.getKey().compareTo(e2.getKey()) : res;
				}).forEachOrdered(e -> System.out.printf("%s -> %d\n", e.getKey(), e.getValue()));
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

	static public boolean isSum2(int[] array, int sum) {
		Set<Integer> seenNumbers = new HashSet<>();

		for (int num : array) {
			int complement = sum - num;
			if (seenNumbers.contains(complement)) {
				return true;
			}
			seenNumbers.add(num);
		}
		return false;
	}

	static public int getMaxWithNegativePresentation(int[] array) {
		Set<Integer> numbers = new HashSet<>();
		int max = -1;

		for (int num : array) {
			numbers.add(num);
		}

		for (int num : array) {
			if (num > 0 && numbers.contains(-num)) {
				max = Math.max(max, num);
			}
		}
		return max;
	}

	public static Map<Integer, Integer> getMapSquares(List<Integer> numbers) {
		Map<Integer, Integer> res = numbers.stream()
				.collect(Collectors.toMap(n -> n, n -> n * n, (v1, v2) -> v1, LinkedHashMap::new));
		return res;
	}

	public static boolean isAnagram(String word, String anagram) {
		// DONE
		// returns true if "anagram" string contains all
		// letters from "word" in another order (case sensitive)
		// O[N] (sorting is disallowed)
		if (word.equals(anagram) || word.length() != anagram.length()) {
			return false;
		}
		Map<Character, Long> wordCharCount = word.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<Character, Long> anagramCharCount = anagram.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		return wordCharCount.equals(anagramCharCount);

	}

	public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory, List<LocalDate> dates) {
		// DONE
		// create List<DateRole> with roles matching with the given dates
		// most effective data structure
		TreeMap<LocalDate, String> roleMap = new TreeMap<>();
		for (DateRole role : rolesHistory) {
			roleMap.put(role.date(), role.role());
		}
		List<DateRole> result = new ArrayList<>();
		for (LocalDate date : dates) {
			Map.Entry<LocalDate, String> entry = roleMap.floorEntry(date);
			String role = (entry != null) ? entry.getValue() : null;
			result.add(new DateRole(date, role));
		}

		return result;
	}

	public static void displayDigitsStatistics() {
		// DONE
		// display out statistics in the following format (example)
		/*
		 * 1 -> <count of occurrences> 2 -> ..... .........
		 */
		// sorted by counts of occurrences in the descending order
		// takes 1000000 random numbers in range [0-Integer.MAX_VALUE)
		// one pipeline with no additional yours methods
		new Random().ints(1_000_000, 0, Integer.MAX_VALUE)
				.flatMap(n -> Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt))
				.boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream()
				.sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
				.forEach(entry -> System.out.printf("%d -> %d\n", entry.getKey(), entry.getValue()));
	}
}
