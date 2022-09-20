package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void half() {
		int[] ararWithHalfSum = { 40, -20, 50, 10, 20 }; // sum = 100, 40 + 10 = 50
		int[] ararWithNoHalfSum = { 40, -20, 50, 5, 25 }; // sum = 100, no two numbers with sum = 50
		assertTrue(isHalfSumTwoNumbers(ararWithHalfSum));
		assertTrue(isHalfSumTwoNumbers(ararWithNoHalfSum));
	}

	/**
	 * @param ararWithNoHalfSum with no limitations at all
	 * @return true if there are two numbers with sum equals half of total suu of
	 *         array
	 */
	private boolean isHalfSumTwoNumbers(int[] ararWithNoHalfSum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Test
	void valueWithMaxNegativeTest() {
		int[] arWithNegative = { 10, 2000000000, 2, 4, 40, -4, 10, -20000000, -2 };	// 20 -> -20 => true
		int[] arWithNoNegative = { 10, 20, 2000000000, 4, 40, -14, 10, -2000000001, -3 };	// there no pair => true
		
		assertEquals(20, valueWithMaxNegative(arWithNegative));
		assertEquals(-1, valueWithMaxNegative(arWithNoNegative));

	}

	/**
	 * @param arWithNegative
	 * @return maximal value with existing negative image
	 */
	private Integer valueWithMaxNegative(int[] arWithNegative) {
		// TODO Auto-generated method stub
		return -1;
	}
}
