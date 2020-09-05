package techniques;

// https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/

public class Fibonacci {

	public int fibSimple(int n) {
		if (n <= 1) {
			return n;
		}
		return fibSimple(n - 1) + fibSimple(n - 2);
	}

	public int fibInLogN(int n) {
		if (n == 0) {
			return 0;
		}
		int M[][] = { { 1, 1 }, { 1, 0 } };    //   {{fib(n+1),fib(n)},{fib(n),fib(n-1)}},
		power(M, n - 1);
		return M[0][0];
	}

	public void power(int M[][], int n) {
		if (n == 1 || n == 0) {
			return;
		}
		power(M, n / 2);
		multiply(M, M);
		if (n % 2 != 0) {
			int F[][] = { { 1, 1 }, { 1, 0 } };
			multiply(M, F);
		}

	}

	public void multiply(int M[][], int N[][]) {
		int a = M[0][0] * N[0][0] + M[0][1] * N[1][0];
		int b = M[0][0] * N[0][1] + M[0][1] * N[1][1];
		int c = M[1][0] * N[0][0] + M[1][1] * N[1][0];
		int d = M[1][0] * N[0][1] + M[1][1] * N[1][1];
		M[0][0] = a;
		M[0][1] = b;
		M[1][0] = c;
		M[1][1] = d;
	}

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.println(f.fibInLogN(9));
		System.out.println(f.fibSimple(9));
	}
}
