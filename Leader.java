package interviewcake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Leader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLeader((List<Integer>) Arrays.asList(6,8,4,6,8,6,6)));

	}
	
	public static Integer findLeader(List<Integer> input) {
		
		// validate input 
		
		Stack<Integer> stack = new Stack<Integer>();
		//stack.push(input.get(0));
		
		for (Integer element: input) {
			if (stack.isEmpty()) {
				stack.push(element);
			} else if (element.equals(stack.peek())) {
				stack.push(element);
			} else { 
				stack.pop();
			}
		}
		
		Integer candidate = null; int count =0;
		if (!stack.isEmpty()) {
			candidate = stack.peek();
			for (Integer value : input) {
				if (value.equals(candidate)) {
					count++;
				}
			}
			if (count >= input.size()/2) return candidate;
		}
		
		return null;
	}

}
