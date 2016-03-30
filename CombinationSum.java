package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	//http://www.programcreek.com/2014/02/leetcode-combination-sum-java/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{2,3,6,7,15};

		System.out.println(combinationSum(input,0, 7));
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int start, int target) {
		
		// base cases
		List<List<Integer>> subProblem1 = new ArrayList<List<Integer>>();
					
		Arrays.sort(candidates);
		
		if (start >= candidates.length || candidates[start] > target) return subProblem1;
		
		
		if (candidates[start] == target) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(candidates[start]);
			subProblem1.add(list);
			return subProblem1;
		} 
		
		if (candidates[start] < target) { // take the first candidate
		   subProblem1 = combinationSum(candidates, start, target-candidates[start] );
		   for (List<Integer> list : subProblem1) {
				list.add(candidates[start]);
			}
		}
		// dont take the first candidate
		List<List<Integer>> subProblem2 = combinationSum(candidates, start+1, target );
		
		subProblem1.addAll(subProblem2);
		
		return subProblem1;
	}
	
	

}
