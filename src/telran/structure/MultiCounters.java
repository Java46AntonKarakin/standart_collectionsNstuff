package telran.structure;

import java.util.Set;

public interface MultiCounters {
	/**
	 * 
	 * @param item
	 * @return how many times item has been added. if item is the new one - return
	 *         1;
	 */
	Integer addItem(Object item);

	/**
	 * 
	 * @param item how many times the item has been added. if item is the new one -
	 *             return null;
	 */

	Integer getValue(Object item);

	/**
	 * removes item with all counters
	 * 
	 * @param item
	 * @return true if item fas been removed, otherwise - false (if the given item
	 *         has been removed)
	 */
	boolean remove(Object item);

	/**
	 * 
	 * @return set of items with maximal counters
	 */
	Set<Object> getMaxItems();
}
