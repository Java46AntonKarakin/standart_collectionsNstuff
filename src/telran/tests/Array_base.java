package telran.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ArrayTests {
	/**
	 * The method doesn't update a given array
	 * @param <T>
	 * @param array
	 * @return true if there is exactly one swap for getting sorted array
	 * examples: 
	 * {1, 2, 10,-1, 5, 6} -> false
	 * {1, 2, 3, 5, 6, 10} -> false
	 * {1, 3, 2, 4, 3, 10} -> false
	 * 
	 * {10, 2, 3, 4, 5, 1} -> true
	 * {1, 2, 4, 3, 5, 10} -> true
	 * {1, 5, 3, 4, 2, 10} -> true
	 * {"lmn", "ab", "bc", "cd", "a"} -> true
	 * An Array should contain Comparable elements
	 */
	
	<T> boolean isOneSwapForSorted(T [] array) {
		
		return false;
	}
	
	@Test
	void isOneSwapTestTrue() {
		Object[][] sourceTrue = { { 100, 150, 125, 200 }, { 10, 2, 3, 4, 1 }, { 1, 2, 4, 3, 5, 10 },
				{ 1, 5, 3, 4, 2, 10 }, { "lmn", "ab", "bc", "cd", "a" }, };
		assertTrue(isOneSwapForSorted(sourceTrue[0]));
		assertTrue(isOneSwapForSorted(sourceTrue[1]));
		assertTrue(isOneSwapForSorted(sourceTrue[2]));
		assertTrue(isOneSwapForSorted(sourceTrue[3]));
		assertTrue(isOneSwapForSorted(sourceTrue[4]));
	}

	@Test
	void isOneSwapTestFalse() {
		Object[][] sourceFalse = { { 1, 2, 3, 10, -1, 5, 6 }, { 1, 2, 3, 5, 6, 10 }, { 1, 3, 2, 4, 3, 10 }, };
		assertFalse(isOneSwapForSorted(sourceFalse[0]));
		assertFalse(isOneSwapForSorted(sourceFalse[1]));
		assertFalse(isOneSwapForSorted(sourceFalse[2]));
	}
}