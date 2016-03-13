package interviewcake;

import java.util.HashSet;
import java.util.Set;

public class IntervalScheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,7,9,9};
		int[] B = {5,6,8,9,10};
		System.out.println(maxNonOverlappingIntervals(A, B));
	}
	
	public static int maxNonOverlappingIntervals(int[] start, int[] end) { // sorted by ends
		// for each segment, find the overlapping segments

		
	           // select the first segment and then remove all the segments that it overlaps with
		Set<Integer> removed = new HashSet<Integer>();
		Set<Integer> selected = new HashSet<Integer>();
		int len = start.length;
		for (int i=0; i < start.length; i++) {
			// check if i is removed already
			if (! removed.contains(i)) {
				selected.add(new Integer(i));
				int j= i+1;
				while ( j < len && start[j] <= end[i] ) {
					removed.add(new Integer(j));
					j++;
				}
			}
		}
		
		return selected.size();
	}

}
