package interviewcake;

public class GenerateValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateParantheses(3,3,"");

	}
	
	public static void generateParantheses(int left, int right, String permutation) {
		
		if (left == 0 && right == 0) {
			System.out.println(permutation);
		}
		
		if (left > 0) {
			generateParantheses(left-1, right, permutation+"(");
		}
		if (right > 0 && right > left) {
			generateParantheses(left, right-1, permutation+")");
		}
		
	}

}
