package interviewcake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChanging {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> input = new ArrayList<Integer>(Arrays.asList(1,2,3));
		System.out.println(minCoins2(new Integer(4), input));
	}
	
	public int minCoins(int[] denoms, int amount) { // assuming denoms are sorted
		int size = denoms.length;
		int[][] memory = new int[amount+1][size+1];
		int MAX = Integer.MAX_VALUE;
		// initialize memory
		// for zero amount
		
		for (int i=0; i< amount+1; i++) {
			memory[i][0] = MAX;
		}

		for (int a=1; a<=amount; a++) {
			for (int d=1; d<=size; d++) {
				int coin = denoms[d-1];
				if (a < coin) {
					memory[a][d] = memory[a][d-1];
				} else {
				 	memory[a][d] = Math.min( memory[a-coin][d] +1, memory[a][d-1]);
				}
			}
	 	}

		return memory[amount][size];
	}

	// I am a genius to come up with this solution
	public static Integer minCoins2(Integer A, List<Integer> D ){

		List<Integer> minNumCoins = new ArrayList<Integer>();


		for(int i=0; i<=A; i ++)
			minNumCoins.add(Integer.MAX_VALUE);
		minNumCoins.set(0, 0);

		// need initialization for other amounts to the amount itself


		for(int amount =1; amount <= A; amount ++){

			int min = minNumCoins.get(amount);

			for(int i=0; i<D.size(); i ++){
			    if(amount >= D.get(i) && minNumCoins.get(amount-D.get(i))+1 < min ){
			   	 min =  minNumCoins.get(amount-D.get(i)) +1;
				
				}
				
			}
		   minNumCoins.set(amount, min);
		}

		return minNumCoins.get(A);

		}


}
