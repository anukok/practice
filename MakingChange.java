package interviewcake;

import java.util.HashMap;
import java.util.Map;

public class MakingChange {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numWays(int amount, int[] denoms) {
		
		Map<String,Integer> memory = new HashMap<String, Integer>();
		
		int numWays = 0;
		int localAmount = amount;
		for (int i=0; i< denoms.length; i++) {
			localAmount -= denoms[i];
		
		}
		return 0;
	}

}
