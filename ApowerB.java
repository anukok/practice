package interviewcake;

public class ApowerB {
//http://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(aPowerB(10,5));
	}
	
	public static int aPowerB(int a, int b) {
		if (b == 1) {
			return a;
		}
		int half =  aPowerB(a, b/2);
		
		if (b%2 == 0) {
			return half*half;
		} else {
			return half* half*a;
		}
	}

}
