package telran.util;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StackInt {

	ArrayList<Integer> StackArray = new ArrayList<>();
	private int maxNumber;
	
	
	public int pop() {
		if (this.isEmpty()) {
			throw new NoSuchElementException ("Stack is empty");
		}
		
		return StackArray.remove(StackArray.size()-1);
	}

	public void push(int number) {
		if (StackArray.size() == 0 || (StackArray.size() > 0 && this.pop() < number)) {
			maxNumber = number;
		}
		StackArray.add(number);
	}

	public boolean isEmpty() {
		return StackArray.size()==0;
	}

	public int getMaxNumber() {
		if (this.isEmpty()) {
			throw new NoSuchElementException ("Stack is empty");
		}
		return maxNumber;
	}
}