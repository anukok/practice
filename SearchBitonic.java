package algoqueue;

public class SearchBitonic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(search(new int[]{1,3,5,7,9,8,4,2}, 6));
	}

	//http://www.algoqueue.com/algoqueue/default/view/2818048/search-in-a-bitonic-array
	// A bitonic array is comprised of an increasing sequence of integers
	// followed immediately by a decreasing sequence of integers. 
	
	public static boolean search(int[] input, int key) {
		
		if (input == null) return false;
		
		// this is a bitonic array, so find the max point
		int index = findmax(input,0,input.length-1);
		
		System.out.println(index);
		
		return (binarySearch(input, 0, index, key) ||
		binarySearch(input, index+1, input.length-1, key));
		
	}
	
	public static boolean binarySearch(int[] input, int start, int end, int key) {
		if (start > end) return false;
		if (start == end && input[start] == key) return true;
		if (start == end && input[start] != key) return false;
		
		int mid = (start+end) /2;
		
		if (input[mid] == key) return true;
		return (binarySearch(input, start, mid, key) || binarySearch(input, mid+1, end, key));
				
	}
	
	public static int findmax(int[] input, int start, int end) {
		if (end-start+1 < 3) throw new IllegalArgumentException();
		
		int mid = (start+end) /2;
		
		if (input[mid-1] < input[mid] ) {
			if (input[mid+1] < input[mid] ) {
				return mid;
			}
			// max is in right half
			return findmax(input, mid, end);
		}
		
		if (input[mid-1] > input[mid] ) {
			
			// max is in left half
			return findmax(input, start, mid);
		}
		
		return 0;
	}
}
