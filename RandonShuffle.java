package interviewcake;

import java.util.concurrent.ThreadLocalRandom;

public class RandonShuffle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] randomShuffle(int[] input) {
		ThreadLocalRandom rnd = ThreadLocalRandom.current();
		int len = input.length;
		for (int i=0; i<input.length-1; i++) {
			int j = rnd.nextInt(i, len); 
			int temp = input[i];
			input[i] = input[j];
			input[j] = temp;
		}
		
		return input;
	}

}
