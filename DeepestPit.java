package interviewcake;

public class DeepestPit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*

A non-empty zero-indexed array A consisting of N integers is given. A pit in this array is any triplet of integers (P, Q, R) such that:

0 ≤ P < Q < R < N;
sequence [A[P], A[P+1], ..., A[Q]] is strictly decreasing, 
i.e. A[P] > A[P+1] > ... > A[Q];
sequence A[Q], A[Q+1], ..., A[R] is strictly increasing, 
i.e. A[Q] < A[Q+1] < ... < A[R].
The depth of a pit (P, Q, R) is the number min{A[P] − A[Q], A[R] − A[Q]}.

For example, consider array A consisting of 10 elements such that:

  A[0] =  0
  A[1] =  1
  A[2] =  3
  A[3] = -2
  A[4] =  0
  A[5] =  1
  A[6] =  0
  A[7] = -3
  A[8] =  2
  A[9] =  3
Triplet (2, 3, 4) is one of pits in this array, because sequence [A[2], A[3]] is strictly decreasing (3 > −2) and sequence [A[3], A[4]] is strictly increasing (−2 < 0). Its depth is min{A[2] − A[3], A[4] − A[3]} = 2. Triplet (2, 3, 5) is another pit with depth 3. Triplet (5, 7, 8) is yet another pit with depth 4. There is no pit in this array deeper (i.e. having depth greater) than 4.
*/