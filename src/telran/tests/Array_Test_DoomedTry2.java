package telran.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class Array_Test_DoomedTry2 {

	@Test
	void isOneSwapTestTrue1() {
		Integer[] ar0 = { 1, 4, 3, 2, 5 };
		Integer[] ar1 = { 1, 2, 4, 3, 5 };
		Integer[] ar2 = { 10, 2, 3, 4, 1 };
		Integer[] ar3 = { 1, 2, 4, 3, 5, 10 };
		Integer[] ar4 = { 1, 5, 3, 4, 2, 10 };
		Integer[] ar5 = { 1, 5, 3, 4, 2, 10 };
		Integer[] ar6 = { 1, 2, 3, 4, 10, 5 };
		Integer[] ar7 = { 2, 1, -3, 4, 5, 10 };
		Integer[] ar8 = { 1, 2, 4, 3, 5, 10 };
		Integer[] ar9 = { 1, 2, 3, 10, 5, 4 };
		Integer[] ar10 = { 3, 2, 1, 4, 5, 6 };
		String[] ar11 = { "lmn", "ab", "bc", "cd", "a" };

		assertTrue(isOneSwapForSorted(ar0));
		assertTrue(isOneSwapForSorted(ar1));
		assertTrue(isOneSwapForSorted(ar2));
		assertTrue(isOneSwapForSorted(ar3));
		assertTrue(isOneSwapForSorted(ar4));
		assertTrue(isOneSwapForSorted(ar5));
		assertTrue(isOneSwapForSorted(ar6));
		assertTrue(isOneSwapForSorted(ar7));
		assertTrue(isOneSwapForSorted(ar8));
		assertTrue(isOneSwapForSorted(ar9));
		assertTrue(isOneSwapForSorted(ar10));
		assertTrue(isOneSwapForSorted(ar11));
	}

	@Test
	void isOneSwapTestFalse1() {
		Integer[] ar1 = { 30, 3, 20, 4, 5, 11, 2 };
		Integer[] ar2 = { 1, 3, 20, 4, 5, 11, 2 };
		Integer[] ar3 = { 1, 3, 20, 4, 5, 6, 10 };
		Integer[] ar4 = { 1, 2, 3, 10, -1, 5, 6 };
		Integer[] ar5 = { 1, 2, 3, 4, 5, 10 };
		Integer[] ar6 = { 5, 1, 2, 4, 6, 10 };
		Integer[] ar7 = { 1, 5, 2, 4, 3, 10 };
		Integer[] ar8 = { 1, 3, 2, 5, 4, 10, 8 };
		Integer[] ar9 = { 1, 2, 3, 15, 4, 5, 10 };

		assertFalse(isOneSwapForSorted(ar1));
		assertFalse(isOneSwapForSorted(ar2));
		assertFalse(isOneSwapForSorted(ar3));
		assertFalse(isOneSwapForSorted(ar4));
		assertFalse(isOneSwapForSorted(ar5));
		assertFalse(isOneSwapForSorted(ar6));
		assertFalse(isOneSwapForSorted(ar7));
		assertFalse(isOneSwapForSorted(ar8));
		assertFalse(isOneSwapForSorted(ar9));
	}

//	@Test
	void isOneSwapTestTrue() {
		Integer[] ar91 = { 1, 2, 4, 3, 5 };// 2 3
		Integer[] ar92 = { 1, 4, 3, 2, 5 };// 1 3
		Integer[] ar93 = { 5, 2, 3, 4, 1 };// 0 4
		Integer[] ar94 = { 2, 1, 3, 4, 5 };// 0 1
		Integer[] ar95 = { 1, 2, 3, 5, 4 };// 3 4
		Integer[] ar96 = { 4, 2, 3, 1, 5 };// 0 3
		Integer[] ar97 = { 1, 5, 3, 4, 2 };// 1 4

		Object source[][] = { { 1, 2, 4, 3, 5 }, { 10, 2, 3, 4, 1 }, { 1, 2, 4, 3, 5, 10 }, { 1, 5, 3, 4, 2, 10 },
				{ 1, 5, 3, 4, 2, 10 }, { 1, 2, 3, 4, 10, 5 }, { 2, 1, -3, 4, 5, 10 }, { 1, 2, 4, 3, 5, 10 },
				{ 1, 2, 3, 10, 5, 4 }, { 3, 2, 1, 4, 5, 6 }, { "lmn", "ab", "bc", "cd", "a" } };

		for (var ar : source) {
			assertTrue(isOneSwapForSorted(ar));
		}

		assertTrue(isOneSwapForSorted(ar91));
		assertTrue(isOneSwapForSorted(ar92));
		assertTrue(isOneSwapForSorted(ar93));
		assertTrue(isOneSwapForSorted(ar94));
		assertTrue(isOneSwapForSorted(ar95));
		assertTrue(isOneSwapForSorted(ar96));
		assertTrue(isOneSwapForSorted(ar97));
	}

	@Test
	void isOneSwapTestFalse() {
		Object source[][] = { { 1, 3, 20, 4, 5, 11, 2 }, { 1, 3, 20, 4, 5, 11, 2 }, { 1, 3, 20, 4, 5, 6, 10 },
				{ 1, 2, 3, 10, -1, 5, 6 }, { 1, 2, 3, 4, 5, 10 }, { 5, 1, 2, 4, 6, 10 }, { 1, 5, 2, 4, 3, 10 },
				{ 1, 3, 2, 5, 4, 10, 8 }, { 1, 2, 3, 15, 4, 5, 10 } };

		for (var ar : source) {
			assertFalse(isOneSwapForSorted(ar));
		}
	}

	static <T> boolean isOneSwapForSorted(T[] array) {
		int indexFirst = getTroublemakerIndex(array, 0);
		if (indexFirst == -1 || indexFirst == array.length - 1) {
			return false;
		}
		int indexSecond = getTroublemakerIndex(array, indexFirst + 1);

		return checkPseudoSwap(array, indexFirst, indexSecond == -1 ? indexFirst + 1 : indexSecond + 1);
	}

	private static <T> int getTroublemakerIndex(T[] array, int startFrom) {
		for (; startFrom <= array.length - 2; startFrom++) {
			if (!compareFirstAndSecond(array[startFrom], array[startFrom + 1])) {
				return startFrom;
			}
		}
		return -1;
	}

	private static <T> boolean checkPseudoSwap(T[] array, int indexFirst, int indexSecond) {
		boolean res = true;

		T nextElm = null;
		T currElm = null;
		T prevElm = null;

		boolean reverceCheck = false;
		boolean frontCheck = false;

		for (int i = 0; i <= array.length - 1; i++) {

			prevElm = null;
			currElm = array[i];
			nextElm = array[i + 1];

			reverceCheck = false;
			frontCheck = false;

			if (i == indexFirst) {
				if (indexFirst == 0) {
					if (indexSecond != array.length - 1) {
						reverceCheck = true;
						frontCheck = true;
						prevElm = array[indexSecond - 1];
						nextElm = array[indexSecond + 1];
					} else {
						reverceCheck = true;
						prevElm = array[indexSecond - 1];
					}
				}
			} else if (i == indexFirst - 1) {
				frontCheck = true;
				nextElm = array[indexSecond];
			} else if (i == indexFirst + 1) {
				if (indexSecond != array.length -1) {
					reverceCheck = true;
					prevElm = array[indexSecond];
				}
			}
			
			if (i == indexSecond) {
				if (indexSecond == array.length -1) {
					if (indexFirst != 0) {
						reverceCheck = true;
						frontCheck = true;
						prevElm = array[indexFirst - 1];
						nextElm = array[indexFirst + 1];
					} else {
						frontCheck = true;
						nextElm = array[indexFirst + 1];
					}
				}
			} else if (i == indexSecond - 1) {
				if (indexFirst != 0) {
					reverceCheck = true;
					frontCheck = true;
					prevElm = array[indexFirst - 1];
					nextElm = array[indexFirst + 1];
				}
				frontCheck = true;
				nextElm = array[indexSecond];
			} else if (i == indexFirst + 1) {
				if (indexSecond != array.length -1) {
					reverceCheck = true;
					prevElm = array[indexSecond];
				}
			}

			if (i == indexFirst) {
				if (indexFirst == 0) {
					frontCheck = true;
					nextElm = indexFirst + 1 == indexSecond ? array[indexSecond + 1] : array[indexFirst + 1];
				}
			} else if (i == indexSecond) {
				if (indexSecond == array.length - 1) {
					reverceCheck = true;
					prevElm = indexSecond - 1 == indexFirst ? array[indexFirst - 1] : array[indexSecond - 1];
				}
			}

			if (i == indexFirst - 1) {
				frontCheck = true;
				nextElm = array[indexSecond];
			} else if (i == indexSecond - 1 && indexSecond != 0) {
				frontCheck = true;
				nextElm = array[indexFirst];
			}

			if (i == indexFirst + 1) {
				reverceCheck = true;
				prevElm = array[indexSecond - 1];
			} else if (i == indexSecond + 1 && indexSecond != 0) {
				reverceCheck = true;
				prevElm = array[indexFirst];
			}

			if (frontCheck) {
				res = compareFirstAndSecond(currElm, nextElm);
			}

			if (reverceCheck) {
				res = compareFirstAndSecond(prevElm, currElm);
			}

			if (!res) {
				break;
			}
		}
		return res;
	}
	
//	 first < second ---> true
	@SuppressWarnings("unchecked")
	private static <T> boolean compareFirstAndSecond(T first, T second) {
		return ((Comparable<T>) first).compareTo(second) <= 0;
	}
}