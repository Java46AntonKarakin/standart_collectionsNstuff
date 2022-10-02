package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.junit.jupiter.api.*;

public class Java8StreamTests {

	static class Programmer {
		String name;
		int age;
		String[] technologies;

		public Programmer(String name, int age, String[] technologies) {
			super();
			this.name = name;
			this.age = age;
			this.technologies = technologies;
		}

		public int getAge() {
			return age;
		}

		public String[] getTechnologies() {
			return technologies;
		}

	}

	List<Programmer> programmers;
	String[] tech1 = { "Java", "SQL", "C++" };
	String[] tech2 = { "Java" };
	String[] tech3 = { "Java", "React", "SQL" };
	private int elements = 1_000_000;
	private int minValue = 0;
	private int maxValue = Integer.MAX_VALUE;

	@BeforeEach
	void setUp() {
		programmers = Arrays.asList(new Programmer("Vasya", 30, tech1), new Programmer("Petya", 25, tech2),
				new Programmer("Sarah", 35, tech3));
	}

	@Test
	void test() {
		int[][] ar = { { Integer.MAX_VALUE, 2 }, { 3, 4, 5 }, { 7 } };
		assertEquals((long) Integer.MAX_VALUE + 21, sumToDimArray(ar));
	}

	private Long sumToDimArray(int[][] ar) {

		return Arrays.stream(ar).flatMapToInt(a -> Arrays.stream(a)).asLongStream().sum();
	}

	@Test
	void averageProgTest() {
		assertEquals(30.0, getAverageAge());
	}

	@Test
	void getMostPopularTechnologyTest() {
		assertEquals("Java", getMostPopularTechnology());
	}

	private String getMostPopularTechnology() {
		return programmers.stream().flatMap(p -> Arrays.stream(p.getTechnologies()))
				.collect(Collectors.groupingBy(t -> t, Collectors.counting())).entrySet().stream()
				.sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())).map(Map.Entry<String, Long>::getKey)
				.findFirst().orElse(null);
	}

	private Double getAverageAge() {
		return programmers.stream().collect(Collectors.averagingInt(Programmer::getAge));
	}

	@Test
	void printDigits() {
		printDigits(elements, minValue, maxValue);

		// generate 1 million random numbers in range [0 - Integer.MAX_VALUE)
		// print digits occurrence in descending order of occurences
		// 1: <occurences>
		// 2: <occurences>
		// ...
	}

	private void printDigits(int elements, int minValue, int maxValue) {
		
		int [] zero = new int [2];
		
		new Random()
		.ints(elements, minValue, maxValue)
		.flatMap(x -> String.valueOf(x).chars()) 
		.map(x -> Character.valueOf((char)(x-'0')))
		.collect(HashMap::new, (a, b) -> a.put(b, (int)a.getOrDefault(b, 0)+1), (a, b) -> a.putAll(b))
		.entrySet()
		.stream()
		.peek(x -> {
			if ((int)x.getKey() == 0) {
				zero[0] = (int)x.getKey(); 
				zero[1] = (int)x.getValue();
				};
		})
		.filter(x -> (int)x.getKey() != 0)
		.forEach(x -> System.out.printf("%d: <%d>\n", x.getKey(), x.getValue()));
		
		System.out.printf("%d: <%d>\n", zero[0], zero[1]);
	}
}
