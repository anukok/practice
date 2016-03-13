package interviewcake;

public class AppleStocks1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};

		int maxProfit = getMaxProfit(stockPricesYesterday);
		System.out.println(maxProfit);
	}
	
	  public static int getMaxProfit(int[] stockPricesYest) {
		  
		  int size = stockPricesYest.length;
		  int[] maxSuffixPrice = new int[size-1]; // no suffix for last element
		  int maxProfit = 0;
		  
		  //base cases
		  if (size < 2) return 0;
		  if (size == 2) return (stockPricesYest[1] > stockPricesYest[0] ? stockPricesYest[1] - stockPricesYest[0] : 0);
		  
		  maxSuffixPrice[size-2] = stockPricesYest[size-1]; // there is only one price in suffix
		  // for j we look at j+1 to size-1
		  for (int j=size-3; j>=0; j--) {
			  maxSuffixPrice[j] = stockPricesYest[j+1] > maxSuffixPrice[j+1] ?
					  stockPricesYest[j+1] : maxSuffixPrice[j+1];
		  }
		  
		  // buy at index 0 to size-2
		  for (int i=0; i<=size-2; i++) {
			  int profit = maxSuffixPrice[i] - stockPricesYest[i];
			  maxProfit = profit > maxProfit ? profit : maxProfit;
		  }
		  
		  return maxProfit;
	  }

}
