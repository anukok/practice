package interviewcake;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getPermutations("dogs"));
	}
	
	public static Set<String> getPermutations(String input) {
		
		// base cases
		
		 
		Set<String> permutations = new HashSet<String>();

		if (input.length() ==1) {
			permutations.add(input);
			return permutations; 
		}
		 
		Set<String > permutationsSubset = getPermutations(input.substring(0, input.length()-1));

		//permutations.addAll(permutationsSubset);

		Character lastC = input.charAt(input.length()-1);

		for (String s: permutationsSubset) {
			for (int position =0; position <=s.length(); position ++) {
				// can be 0 to length. because length of new string is length+1
				String prefix = "", suffix = "";
				if (position != 0) {
					prefix = s.substring(0, position);
					
				}
				if (position != s.length()) {
					suffix = s.substring(position);
				}
				permutations.add(prefix+lastC+suffix);
			}
		}

		return permutations;
	}

}
