package telran.util;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.IntStream;

public class MyArray<T> {

	private Map<Integer, T> mapValues = new HashMap<>();
	private List<Entry<Integer, T>> listEntrys;

	public MyArray(int size) {
		IntStream.rangeClosed(0, size).forEach(x -> mapValues.put(x, null));
		listEntrys = new ArrayList<>(mapValues.entrySet());
	}

	public void setAll(T value) {
		IntStream.rangeClosed(0, mapValues.size()).forEach(x -> mapValues.replace(x, value));
		
	}

	public void set(int index, T value) {
		if (index < 0 || index > listEntrys.size() - 1) {
			throw new IndexOutOfBoundsException();
		}
		var entry = listEntrys.get(index);
		entry.setValue(value);
	}

	public T get(int index) {
		return mapValues.getOrDefault(index, null);
	}

}
