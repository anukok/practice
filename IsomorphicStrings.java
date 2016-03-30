package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		test("bad", "add");
		test("foo","bar");
		Integer n = new Integer(1);
		Integer m = new Integer(1);
		Integer sum = m+n;
	}
	public static void test (String s1, String s2) {
		System.out.println(s1 + " " + s2 + " " + isIsomorphic(s1, s2));
	}

	public static boolean isIsomorphic(String s1, String s2) {
		// validtion and base cases
		Map<Character, Character> map = new HashMap<Character,Character>();
		int len = s1.length();
		
		for (int i=0; i< len; i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			
			if (map.get(c1) != null && !map.get(c1).equals(c2)) {
				return false;
			} else if (map.get(c1) == null) {
				map.put(c1,c2);
			}
			
		}
		
		return true;
	}
	
	 public static String message(String rwy, int windDirection, int windSpeed) {
		    System.out.println(Math.sin(windDirection) * windSpeed);
		    System.out.println(Math.cos(windDirection) * windSpeed);
		    
		    int crossWind = (int)(Math.sin(windDirection) * windSpeed);
		    int headWind = (int) (Math.cos(windDirection) * windSpeed);
		    
		    String headOrTail = (headWind >= 0) ? "Head" : "Tail" ;
		    String rightOrLeft = (crossWind >= 0) ? "right" : "left";

		    return headOrTail + "wind " + Math.abs(headWind) +
		    " knots. Crosswind " + Math.abs(crossWind) + " knots from your " + rightOrLeft + ".";
     }
	 
	 @Test
	  public void testMessage() throws Exception {
	    assertEquals("Headwind 15 knots. Crosswind 3 knots from your left.", IsomorphicStrings.message("18L", 170, 15));
	    assertEquals("Headwind 10 knots. Crosswind 17 knots from your left.", IsomorphicStrings.message("22", 160, 20));
	  }
}
