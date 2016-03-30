package interviewcake;

public class MaxSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(maxSubarray(A));
		
	}

	public static int maxSubarray (int[] input) {
		//basic validation
		int maxSum = input[0], prevMax = input[0];
		
		for (int i=1; i<input.length; i++) {
			int max = Math.max(input[i], input[i] + prevMax );
			maxSum = max > maxSum ? max : maxSum;
		}
		
		return maxSum;
	}
}
