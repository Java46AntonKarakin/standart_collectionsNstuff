package telran.collections.tests;

import telran.util.MyArray;
import telran.util.MyArray_2;

import java.util.Arrays;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayTests {
	MyArray_2<String> array = new MyArray_2<>(6);
//	MyArray<String> array = new MyArray<>(6);
	String[] volumes = { "cat", "kitten", "dog", "puppy", "hamster", "parrot", "New Guinea" };
	String commonValue = "egg";

	@BeforeEach
	void setUp() {
		int[] index = { 0 };
		Arrays.stream(volumes)
		.forEach(x -> {	array.set(index[0]++, x);});
	}

	@Test
	void testSetAll() {
		assertFalse(containsOnlyValue(array, commonValue));
		array.setAll(commonValue);
		assertTrue(containsOnlyValue(array, commonValue));
		
	}

	private boolean containsOnlyValue(MyArray_2<String> array, String commonValue) {
		for (int i = 0; i < volumes.length; i++) {
			if (array.get(i) != commonValue) {
				return false;
			}
		}
		return true;
	}

	@Test
	void testGet() {
		for (int i = 0; i < volumes.length; i++) {
			assertEquals(array.get(i), volumes[i]);
		}
	}

	@Test
	void testSet() {
		for (int i = 0; i < volumes.length; i++) {
			assertFalse(array.get(i).equals(commonValue));
			assertTrue(array.get(i).equals(volumes[i]));
			array.set(i, commonValue);
			assertTrue(array.get(i).equals(commonValue));
			assertFalse(array.get(i).equals(volumes[i]));
		}
		assertThrows(IndexOutOfBoundsException.class, () -> array.set(volumes.length+1, commonValue));
		assertThrows(IndexOutOfBoundsException.class, () -> array.set(-1, commonValue));
		array.setAll("abc");
		for (int i = 0; i < volumes.length; i++) {
			assertTrue(array.get(i).equals("abc"));
		}
		
	}

}
