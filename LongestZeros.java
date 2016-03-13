package interviewcake;

public class LongestZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(longestZeros(15));

	}
	
	public static int longestZeros(int number) {
		int maxCount = 0;
		int count = 0;
		while (number > 0) {
			int bit = number & 1;
			System.out.print(bit);
			if (bit == 0) {
				count++;
			} else {
				maxCount = count > maxCount? count:maxCount;
			}
			number = number >> 1;
		}
		
		return maxCount;
	}

}
