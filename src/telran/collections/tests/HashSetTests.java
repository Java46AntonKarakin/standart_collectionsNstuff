package telran.collections.tests;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;

class HashSetTests {
	Integer[] numbers = { 40, 20, 32, 9, 64 };
	HashSet <Integer> hashSet;
	LinkedHashSet <Integer> linkedHashSet;
	
	@BeforeEach
	void setUp() {
		hashSet = new HashSet<Integer>(Arrays.asList(numbers));
		linkedHashSet = new LinkedHashSet<Integer>(Arrays.asList(numbers));
	}
	
	@Test
	void toArrayTest() {
		Integer [] expectedHashSet = {32, 64, 20, 40, 9};
		Integer [] expectedLinkedHashSet = Arrays.copyOf(numbers, numbers.length);
		assertArrayEquals(expectedHashSet, hashSet.toArray(Integer[]::new));
		assertArrayEquals(expectedLinkedHashSet, linkedHashSet.toArray(Integer[]::new));
	}

}
