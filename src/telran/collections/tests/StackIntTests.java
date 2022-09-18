package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.util.StackInt;

class StackIntTests {

	static final int N_ELEMENTS = 1000000;
	static int[] values;
	StackInt stack = new StackInt();

	// .of((int) (Math.random() * ((Integer.MAX_VALUE - 1) + 1) + 1)
	
	@BeforeEach
	void setUp() {
		stack = new StackInt();
		values = new Random().ints(0, Integer.MAX_VALUE)
				.distinct()
				.limit(N_ELEMENTS)
				.toArray();
		values [values.length-1] = Integer.MAX_VALUE;
	}

	@Test
	public void popTest() {
		assertThrows(NoSuchElementException.class, () -> {
			stack.pop();
		});
		Arrays.stream(values).forEach(x -> {
			stack.push(x);
			assertEquals(x, stack.pop());
		});
	}

	@Test
	public void pushTest() {
		Arrays.stream(values).forEach(x -> {
			stack.push(x);
			assertEquals(x, stack.pop());
			assertTrue(stack.isEmpty());
		});
	}

	@Test
	public void isEmptyTest() {
		assertTrue(stack.isEmpty());
		stack.push(1);
		assertFalse(stack.isEmpty());
	}

	@Test
	public void getMaxNumberTest() {
		assertThrows(NoSuchElementException.class, () -> {
			stack.getMaxNumber();
		});

		Arrays.stream(values).forEach(x -> {
			stack.push(x);
		});
		assertEquals(Integer.MAX_VALUE, stack.getMaxNumber());
	}
}
