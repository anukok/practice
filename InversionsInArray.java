package interviewcake;

public class InversionsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(numberOfInversions(new int[]{-1,6,3,4,7,4}, 0,5));

	}
	
	public static int numberOfInversions(int[] input, int start, int end) { // start and end are inclusive
		// input validation
		//base cases
		if (start == end) {
			return 0;
		}
		if (start == end-1) {
			if (input[start]> input[end]) {
				int temp = input[start];
				input[start] = input[end];
				input[end] = input[start];
				return 1;
			}
			else return 0;
		}
		
		int mid = (start + end)/2;
		
		int left = numberOfInversions(input,start, mid);
		int right = numberOfInversions(input, mid+1, end);
		
		int mergeInversions = mergeInversions(input, start, mid, end);
		
		return left+right+mergeInversions;
	}

	public static int mergeInversions(int[] input, int start, int mid, int end) {
		int inversions = 0;
		int i=start,j=mid+1,k=0;
		int len1 = mid-start+1;
		int len2 = end-mid+1;
		int[] merged = new int[end-start+1];
		while (i<=mid && j<=end) {
			if (input[i]<=input[j]) {
				merged[k] = input[i];
				i++;
				k++;
			} else {
				merged[k] = input[j];
				j++;
				k++;
				inversions += mid -i+1;
			}
		}
		while (i< mid+1) {
			merged[k] = input[i];
			i++;k++;
		}
		for (int m=start, n=0; m<=end; m++,n++) {
			input[m] = merged[n];
		}
		
		return inversions;
	}
}
