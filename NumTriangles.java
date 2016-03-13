package interviewcake;

public class NumTriangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int findTriplets(int[] input) { // input is sorted array
		int len = input.length;
		int numTriangles = 0;
		for (int i=0; i<len ;i++) { // 1st element
			int a = input[i];
			for ( int j=0; j< len; j++) { // 2nd element
				int b = input[j];
				int k = j+1;
				while (k < len && input[k] < a+b ) {
					k++;
				}
				int num = k - j -1;
				numTriangles +=num;
			}
		}

		return numTriangles;
	}




}
