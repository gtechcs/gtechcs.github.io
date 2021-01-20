
public class Fib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
	}
	
	// Iterative
	// Recursive
	// Memoization
	// 
	// Iterative solution with only two variables

	// Creates a Tree, extra nodes
	public int fibonacciR(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		return 	fibonacciR(n-1) + fibonacciR(n-2);
	}
	
	
	public int fibonacciIterWithMemo(int n) {
		int[] result = new int[n+1];//Memoized soilution
		result[0] = 0;
		result[1] = 1;
		for(int i = 2;i <= n;i++) {
			result[i] = result[i-1] = result[i-2];
		}
		return result[n];
	}

	public int fibonacciIter(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		int fibNMinusTwo = 0
		int fibNMinusOne = 1
		for(int i = 2;i < n;i++) {
			int current = fibNMinusTwo + fibNMinusOne;
			fibNMinusTwo = fibNMinusOne;
			fibNMinusOne = current;
		}
		return fibNMinusOne + fibNMinusTwo; 
	}
	
	
	
}
