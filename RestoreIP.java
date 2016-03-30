package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
//http://www.programcreek.com/2014/06/leetcode-restore-ip-addresses-java/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		restoreIP("25525511135", 0, 4, new ArrayList<String>());
	}
	
	public static void restoreIP(String input, int start, int n, List<String> results) { // n is 1/2/3/4
		String result = "";
		// ip looks like this xxx.xxx.xxx.xxx where xxx is 0 to 255
		//first xxx can be 1/2/3 digits
		int len = input.length();
		if (n==1) { // choosing last set of xxx
			if (len - start < 1) { // 1 means last char
				return "-1"; // invalid
			}
			return input.substring(start);
		}
		
		// choose next xxx
		if (len-start >= 3) {
			String xxx = input.substring(start, start+3);
			String remaining = restoreIP(input, start+3, n-1);
			if (remaining)
		}
		
		return result;
	}

}
