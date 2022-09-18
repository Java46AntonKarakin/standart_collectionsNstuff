package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.IntStream;

class ListTests {
	Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	List<Integer> list = Arrays.asList(numbers);
	List<Integer> listMutable = new ArrayList<>(list);

	@BeforeEach
	void setUp() {
		listMutable = new ArrayList<>(list);
	}

	@Test
	void listMutableTest() {
		assertThrows(UnsupportedOperationException.class, () -> list.remove(0));
		Integer[] expected = { 3, 4, 5, 6, 7, 8, 9, 10 };
		assertEquals(1, listMutable.remove(0));
		listMutable.remove(0);
		assertArrayEquals(listMutable.toArray(new Integer[0]), expected);
	}

	@Test
	void listViewTest() {
		List<Integer> subList = listMutable.subList(2, 10);
		Integer[] expected = { 3, 4, 5, 6, 7, 8, 9, 10 };
		assertArrayEquals(subList.toArray(new Integer[0]), expected);
		Integer[] expectedAfterRemove = { 1, 2, 3, 4, 5, 6, 8, 9, 10 }; // no 7
		subList.remove(4);
		assertArrayEquals(listMutable.toArray(new Integer[0]), expectedAfterRemove);
		subList.add(4, 7);
		assertArrayEquals(listMutable.toArray(new Integer[0]), numbers);
		subList.clear();
		assertEquals(2, listMutable.size());

		listMutable.stream().forEach(i -> System.out.printf("%d ", i));
	}

	@Test
	void queueTest() {
		Stack<Integer> stack = new Stack<>();
		IntStream.range(1, 10).forEach(x -> stack.add(x)); 
		stack.add(1, 10);
		stack.remove(2);
		
		Queue <Integer> queue = new LinkedList<>(list);
		queue.remove();
		Integer[] expected = {2, 3, 4, 5, 6, 7, 8, 9, 10 };
		assertArrayEquals(queue.toArray(new Integer[0]), expected);
		Queue<Integer> queue1 = new LinkedList<>();
		assertThrows(NoSuchElementException.class, () -> queue1.remove());
		assertNull(queue1.poll());
		queue.remove(7);
		assertFalse(queue.contains(7));
		queue.stream().forEach(i -> System.out.printf("%d ", i));
		listMutable.remove(7);
		assertTrue(listMutable.contains(7));
		assertFalse(listMutable.contains(8));
	}
}
