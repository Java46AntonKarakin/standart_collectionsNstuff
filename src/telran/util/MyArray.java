package telran.util;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.IntStream;

/**
 * All methods of the class should have complexity O[1]
 * 
 * @author User
 *
 * @param <T>
 */
public class MyArray<T> {

	private Map<Integer, T> mapValues = new HashMap<>();
	private List<Entry<Integer, T>> listEntrys;
	

	public MyArray(int size) {
		IntStream.rangeClosed(0, size).forEach(x -> mapValues.put(x, null));
		listEntrys = new ArrayList<>(mapValues.entrySet());
	}

	/**
	 * sets all array's elements with a given value
	 * 
	 * @param value
	 */
	public void setAll(T value) {
		IntStream.rangeClosed(0, mapValues.size()).forEach(x -> mapValues.replace(x, value));
	}

	/**
	 * sets a given value at a given index throws IndexOutOfBoundsException in the
	 * case of wrong index
	 * 
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) {
		if (index < 0 || index > listEntrys.size()-1) {
			throw new IndexOutOfBoundsException();
		}
		var entry = listEntrys.get(index);
		entry.setValue(value);
	}

	/**
	 * 
	 * @param index
	 * @return value at given index or null if index is wrong
	 */
	public T get(int index) {
		return mapValues.getOrDefault(index, null);
	}

}
