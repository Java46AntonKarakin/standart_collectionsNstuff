package telran.util;

import java.util.*;

public class MyArray_2<T> {

	int size = 0;
	boolean flSetAll = false;
	private int indexOfNextElement = 0;
	private T commonValue;
	private HashMap<Integer, Integer> nodesMap = new HashMap<>();
	private ArrayList<T> arrayOfValues = new ArrayList<>(size);

	public MyArray_2(int size) {
		this.size = size;
		for (Integer i = 0; i < size; i++) {
			nodesMap.put(i, 0);
		}
	}

	public void setAll(T value) {
		flSetAll = true;
		commonValue = value;
		arrayOfValues = new ArrayList<>(size);
	}

	public void set(int index, T value) {
		Integer temp = nodesMap.get(index);
		if (temp == 0) {
			arrayOfValues.add(indexOfNextElement, value);
			nodesMap.put(index, indexOfNextElement++);
		} else {
			arrayOfValues.add(temp, value);
			nodesMap.replace(index, temp);
		}
	}

	public T get(int index) {
		var res = arrayOfValues.get(index);
		if (flSetAll && nodesMap.get(index) == null) {
			res = commonValue;
		}
		return res;
	}
}
