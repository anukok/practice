package codewars;

import java.math.BigDecimal;

public class Xbonnacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    //assertArrayEquals(new double []{0,1,1,2,3,5,8,13,21,34},
		    		print(xbonacci(new double []{18.0, 18.0, 18.0, 16.0, 2.0, 4.0, 13.0, 7.0, 2.0, 14.0, 11.0, 8.0, 3.0},63));
		   // assertArrayEquals(new double []{1,1,2,3,5,8,13,21,34,55}, variabonacci.xbonacci(new double []{1,1},10));
		   // assertArrayEquals(new double []{0,0,0,0,1,1,2,4,8,16}, variabonacci.xbonacci(new double []{0,0,0,0,1},10));    
		   // assertArrayEquals(new double []{1,0,0,0,0,0,1,2,3,6}, variabonacci.xbonacci(new double []{1,0,0,0,0,0,1},10));   
		
	}
	
	private static void print(double[] xbonacci) {
		// TODO Auto-generated method stub
		for (double d : xbonacci) {
			System.out.print(d + ", ");
		}
		System.out.println("");
	}

	public static double[] xbonacci(double[] signature, int n) {
	      double[] results = new double[n];
	      int k = signature.length;
	      System.arraycopy(signature, 0, results, 0, k);
	      // 0 to k-1 are already filled
	      double first = 0;
	      for (double sig: signature) {
	        first += sig;
	      }
	      
	      results[k] = first;
	      
	      for (int i=k+1; i<n; i++) {
	        // sum of first k+1 - first =   2* sum of k - first 
	        double next = (((new BigDecimal (results[i-1])).multiply(new BigDecimal(2.0))).subtract(new BigDecimal( results[i-k-1]))).doubleValue();
	        results[i] = next;
	      }
	      
	      return results;
	  }


}
