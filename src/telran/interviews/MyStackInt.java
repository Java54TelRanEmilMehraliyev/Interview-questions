package telran.interviews;

import java.util.*;
//All methods should have complexity O[1]
public class MyStackInt {
 Stack<Integer> stack = new Stack<>();
 Stack<Integer> maxes = new Stack<>();
	public void push(int num) {
		//adds num into top of stack (last element)
		stack.push(num);
		if(maxes.isEmpty() || num >= maxes.peek()) {
			maxes.push(num);
		}
	}
	public int pop() {
		//removes element from top of stack (last element)
		//returns being removed number
		//throws exception if the stack is empty
		int res = stack.pop();
		if(res == maxes.peek()) {
			maxes.pop();
		}
		return res;
	}
	public int peek() {
		//returns last number
		//throws exception if the stack is empty
		return stack.peek();
	}
	public boolean isEmpty() {
		//returns true if the stack is empty, otherwise false
		return stack.isEmpty();
	}
	public int getMaxElement() {
		//returns the max number from the stack
		//throws exception if the stack is empty
		return maxes.peek();
	}
}