package interviewcake;

import java.util.Arrays;

public class ProductOfNumbers2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input = new int[] {1, 2, 6, 5, 9};

		System.out.println(Arrays.toString(getProducts(input)));
	}
	
	public static int[] getProducts(int[] numbers) {
		// filter edge cases
		int size = numbers.length;
		int[] prefixProducts = new int[numbers.length]; // from 1 to size-1 , no prefix for 0
		int[] suffixProducts = new int[numbers.length]; // from 0 to size-2, no suffix for size-1
		
		// initialize 
		prefixProducts[0] = 1;
		suffixProducts[size-1] = 1;
		prefixProducts[1] = numbers[0];
		suffixProducts[size-2] = numbers[size-1];
		
		// populate prefix products
		for (int i=2; i<=size-1; i++) {
			prefixProducts[i] = numbers[i-1] * prefixProducts[i-1];
		}
		// populate suffix products
		for (int j=size-3; j>=0; j--) {
			suffixProducts[j] = numbers[j+1] * suffixProducts[j+1];
		}
		int[] desiredProducts = new int[size];
		//initialize
		
		// populate desired products
		for (int k=0; k<size ; k++) {
			desiredProducts[k] = prefixProducts[k] * suffixProducts[k];
		}
		
		return desiredProducts;
	}

}
