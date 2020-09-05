package main;

import java.util.Arrays;

// https://leetcode.com/problems/out-of-boundary-paths/

/**
 * 
 * @author jaspreetsingh03
 *
 */
public class BoundaryPath {

	int counter = 0;
	static int mod = 1000000007;

	/**
	 * complexity is O(mnN)
	 * @param m
	 * @param n
	 * @param N
	 * @param i
	 * @param j
	 * @return
	 */
	public int findPaths(int m, int n, int N, int i, int j) {
		int memoArr[][][] = memoArr = new int[m][n][N + 1];
		for (int[][] l : memoArr)
			for (int[] sl : l)
				Arrays.fill(sl, -1);
		if (isOut(i, j, m, n)) { // already outside
			return counter;
		}
		return findPathsRec(m, n, N, i, j, memoArr);
	}

	public int findPathsRec(int m, int n, int N, int i, int j, int memo[][][]) {

		if (isOut(i, j, m, n)) {

			return 1;
		}
		if (N <= 0) {
			return 0;
		}
		int indexi[] = { 0, -1, 0, +1 };
		int indexj[] = { -1, 0, +1, 0 };
		int ans = 0;
		if (memo[i][j][N] >= 0) {
			return memo[i][j][N];
		}
		for (int rec = 0; rec < 4; rec++) {
			ans += findPathsRec(m, n, N - 1, i + indexi[rec], j + indexj[rec], memo);
			ans = ans % mod;
		}
		memo[i][j][N] = ans;

		return memo[i][j][N];
	}

	public boolean isOut(int i, int j, int m, int n) {
		return !(i >= 0 && i < m && j >= 0 && j < n);
	}

	public static void main(String[] args) {
		BoundaryPath bp = new BoundaryPath();
		System.out.println(bp.findPaths(2, 2, 2, 0, 0));
	}
}
