package interviewcake;


public class RomanNumerals {
	
	public enum Letters {
		M(1000), CM(900), D(500), CD(400), C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);
		
		private int value;
		
		private Letters(int value) {
			this.value = value;
		}
	};

	public static void main(String[] args) {
				
		System.out.println(getRoman(1999));
		System.out.println(getArabic("MCMXCIX"));
	}
	
	public static int getArabic (String roman) {
		int arabicValue = 0; int i=0;
		
		while (i< roman.length()) {
			char letter = roman.charAt(i);
			int matchValue = Letters.valueOf(""+letter).value;
			if (i < roman.length()-1) {
				char nextLetter = roman.charAt(i+1);
				int nextValue = Letters.valueOf(""+nextLetter).value;
				if (nextValue>matchValue) {
					matchValue = nextValue-matchValue;
					i++;
				}
			}
			arabicValue += matchValue;
			i++;
		}
		
		return arabicValue;
	}
	
	public static String getRoman(int number) {
		
		int current = number;
				
		StringBuffer result = new StringBuffer("");
		for (Letters l : Letters.values()) {
			if (current >= l.value) {
				current = processNumeral(current, l.value, l.name(), result);
			}
		}
	
		return result.toString();
	}
	
	
	public static int processNumeral(int number, int divisor, String letter, StringBuffer roman) {
		
		int times = number/divisor;
		int reminder = number%divisor;
		for (int i=0; i<times; i++) {
			roman.append(letter);
		}
		return reminder;
	}
	
}
