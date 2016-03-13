package interviewcake;

public class SubstringWithoutRepetition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int longestSubstring(String input) {
		int max=0; int len = input.length();
		int[] counts = new int[26];
		
		int i=0, j=0;
		
		while (j<len) {
			Character c = input.charAt(i);
			if (counts[c-'a'] <1) {
				j++;
			} else { // repetition found
				
				max = j-i > max? j-i : max;
				while ( !c.equals(input.charAt(i)) ) {
					counts[i] -= 1;
					i++;
				}
				j++;
				i++;
			}
		}
		
		return max;
	}

}
