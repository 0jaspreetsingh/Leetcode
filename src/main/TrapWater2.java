package main;

// https://leetcode.com/problems/trapping-rain-water-ii/

public class TrapWater2 {

	public int trapRainWater(int[][] heightMap) {
		int water = 0;

		int m = heightMap.length;
		if (m == 0) {
			return water;
		}
		int n = heightMap[0].length;
		int l1[][] = new int[m][n];
		int l2[][] = new int[m][n];
		int r1[][] = new int[m][n];
		int r2[][] = new int[m][n];

		for (int i = 0; i < m; i++) {
			l1[i][0] = heightMap[i][0];
			for (int j = 1; j < n; j++) {
				if (heightMap[i][j] > l1[i][j - 1]) {
					l1[i][j] = heightMap[i][j];
				} else {
					l1[i][j] = l1[i][j - 1];
				}
			}
			r1[i][n - 1] = heightMap[i][n - 1];
			for (int j = n - 2; j >= 0; j--) {
				if (heightMap[i][j] > r1[i][j + 1]) {
					r1[i][j] = heightMap[i][j];
				} else {
					r1[i][j] = r1[i][j + 1];
				}
			}
		}

		for (int j = 0; j < n; j++) {
			l2[0][j] = heightMap[0][j];
			for (int i = 1; i < m; i++) {
				if (heightMap[i][j] > l2[i - 1][j]) {
					l2[i][j] = heightMap[i][j];
				} else {
					l2[i][j] = l2[i - 1][j];
				}
			}
			r2[m - 1][j] = heightMap[m - 1][j];
			for (int i = m - 2; i >= 0; i--) {
				if (heightMap[i][j] > r2[i + 1][j]) {
					r2[i][j] = heightMap[i][j];
				} else {
					r2[i][j] = r2[i + 1][j];
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int min = getMin(l1[i][j], l2[i][j], r1[i][j], r2[i][j]);
				int temp = min - heightMap[i][j];
				if (temp > 0) {
					water += temp;
				}
			}
		}

		return water;
	}

	private int getMin(int i, int j, int k, int l) {
		int min = i;
		min = Math.min(min, j);
		min = Math.min(min, k);
		min = Math.min(min, l);
		return min;
	}

	public static void main(String[] args) {
		TrapWater2 tw2 = new TrapWater2();
		int heightMap[][] = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
		// [[12,13,1,12],[13,4,13,12],[13,8,10,12],[12,13,12,12],[13,13,13,13]]
		// expected 14
		// output 15
		// don't know why....
		System.out.println(tw2.trapRainWater(heightMap));
	}
}
