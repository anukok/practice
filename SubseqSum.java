package interviewcake;

public class SubseqSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 60, 2, 7, 4, 1, 3, 6 };

		System.out.println(findSum2(input, 12));
	}

	public static boolean findSubSum(int[] input, int sum) {
		int len = input.length;

		int back = 0, front = 0, total = input[0];

		while (back < len && front < len) {

			if (total == sum) {
				return true;
			}
			if (total < sum) {
				front++;
				total = (front < len) ? total + input[front] : total;

			} else if (total > sum) {
				back++;
				if (back >= front) {
					front = back;
					total = input[back];
				} else {
					total = (back < len) ? total = total - input[back] : total;
				}
			}
		}
		return false;
	}
	
	public static boolean findSum2(int[] input, int sum) {
		int len = input.length;
		int total = 0;
		int front = 0;
		for ( int back=0; back<len; back++ ) {
			
			while (front < len  && total + input[front] <= sum){
				total += input[front];
				if (total == sum) return true;
				front++;
			}
			total -= input[back];
		}
		return false;
		
	}

}
