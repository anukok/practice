package interviewcake;

import interviewcake.models.CakeType;

public class KnapsackUnbounded {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CakeType cake1 = new CakeType(7, 160);

		CakeType cake2 = new CakeType(3, 90);
		CakeType[] cakes = new CakeType[]{cake1, cake2};
		
		System.out.println(maxDuffleBagValue(cakes, 20));
	}
	
	public static int maxDuffleBagValue(CakeType[] cakes, int capacity) {

		// verify input

		int[] memory = new int[capacity+1];
		memory[0] = 0;

		for (int i=0; i<= capacity; i++) {
			// iterate over cakes
			int maxValue = 0;
			for ( CakeType cake : cakes) {
				if (cake.weight < capacity) { // take the cake
					int value = memory[capacity-cake.weight] + cake.value;
					maxValue = value > maxValue? value : maxValue;
				}
			}
			memory[i] = maxValue;
		}

		return memory[capacity];
	}




}
