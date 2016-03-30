package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//print(allSubsets(new int[]{1,2,3}, 0,2));
		
		print(allSubsetsSizeK(new int[]{1,2,3,4},2, 0,3));

	}
	
	public static Set<int[]> allSubsets (int[] input, int start, int end) {
		
		Set<int[]> subsets = new HashSet<int[]>();
		if (start == end) {
			subsets.add(new int[]{input[end]});
			subsets.add(new int[0]);
			return subsets;
		}
		Set<int[]> sets = allSubsets(input, start +1, end);
		subsets.addAll(sets); 
		for (int[] subset : sets ) {
			int l = subset.length;
			int[] newSet = new int[l + 1];
			System.arraycopy(subset, 0, newSet, 0, l);
			newSet[l] = input[start];
			subsets.add(newSet);
		}
		
		
		return subsets;
			
	}
	
	public static Set<int[]> allSubsetsSizeK (int[] input, int k, int start, int end) {
	
		Set<int[]> subsets = new HashSet<int[]>();
		if (k==0) {
			return subsets;
		}
		if (k==1) {
			for (int i= start; i<=end; i++) {
				int[] set = new int[]{input[i]};
				subsets.add(set);
			}
			return subsets;
		}
		if (end - start +1 == k) {
			int[] set = new int[k];
			System.arraycopy(input, start, set, 0, k);
			subsets.add(set);
			return subsets;
		}
		
		Set<int[]> temp = allSubsetsSizeK(input, k, start+1, end);
		
		subsets.addAll(temp);
		
		Set<int[]> temp2 = allSubsetsSizeK(input, k-1, start+1, end);
		
		for (int[] set : temp2) {
			int[] newSet = new int[k];
			System.arraycopy(set, 0, newSet, 0, k-1);
			newSet[k-1] = input[start];
			subsets.add(newSet);
		}
		
		return subsets;
	}
	
	public static void print(Set<int[]> subsets) {
		for (int[] set : subsets) {
			System.out.println(Arrays.toString(set));
		}
		
	}

}
