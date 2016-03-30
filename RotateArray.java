package leetcode;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{1,2,3,4,5,6,7};
		rotateArray(input,3);
		System.out.println(Arrays.toString(input));

	}
	
	public static void rotateArray(int[] input, int shift) {
		if (input.length < 2) return;
		if (shift >= input.length) {
			shift = shift - input.length;
		}
				
		int i=shift;
		int len = input.length;
		int temp = input[shift];
		
		input[shift] = input[0];
		// start from first node, you are done when you come back to first node
		
		while (i != 0) {
			int next = i + shift;
			if (next >= len) {
				next = next - len;
			}
			// move next value to temp2, temp to next, temp2 to temp
			int temp2 = input[next];
			input[next] = temp;
			temp = temp2;
			i = next;
		}
		
	}

}
