package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
//http://www.programcreek.com/2014/04/leetcode-letter-combinations-of-a-phone-number-java/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> results = letterCombinations("23");
		System.out.println(results);

	}
	
	public static List<String> letterCombinations(String digits) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
	    map.put(2, "abc");
	    map.put(3, "def");
	    map.put(4, "ghi");
	    map.put(5, "jkl");
	    map.put(6, "mno");
	    map.put(7, "pqrs");
	    map.put(8, "tuv");
	    map.put(9, "wxyz");
	    map.put(0, "");
	    
	    List<String> results = new ArrayList<String>();
	    
	    if (digits.length() == 0) return results;
	    
		String digit = digits.substring(0,1);
		if (digits.length() ==1) {
			for(char c : (map.get(Integer.valueOf(digit))).toCharArray()) {
				results.add(""+c);
			}
			return results;
		}
		
		List<String> sub = letterCombinations(digits.substring(1));
		
		
		for(char c : (map.get(Integer.valueOf(digit))).toCharArray()) {
			for (String s : sub) {
				String result = c + s;
				results.add(result);
			}
			
		}
		
		return results;
	}

}
