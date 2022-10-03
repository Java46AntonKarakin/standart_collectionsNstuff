package telran.structure;

import java.util.*;

public class MultiCountersImpl implements MultiCounters {
	HashMap<Object, Integer> items = new HashMap<>(); // key - item, value - counter
	TreeMap <Integer, HashSet<Object>> counters = new TreeMap<>(); // key - counter, value - set of items
	// concider using the map method conputeIfAbsent
	
	@Override
	public Integer addItem(Object item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getValue(Object item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Object> getMaxItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
