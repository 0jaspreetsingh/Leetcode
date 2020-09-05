package arrays;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		int m = matrix.length;
		if (m == 0) {
			return list;
		}
		int n = matrix[0].length;
		int totalElements = m * n;
		int si = 0, sj = 0;
		int ei = m - 1, ej = n - 1;
		int counter = 0;
		if (counter == totalElements) {
			return list;
		}
		for (int i = 0; i < totalElements; i++) {

			for (int j = sj; j <= ej; j++) {
				list.add(matrix[si][j]);
				counter++;
				if (counter == totalElements) {
					return list;
				}

			}

			for (int j = si + 1; j < ei; j++) {
				list.add(matrix[j][ej]);
				counter++;
				if (counter == totalElements) {
					return list;
				}
			}

			for (int j = ej; j > sj; j--) {
				list.add(matrix[ei][j]);
				counter++;
				if (counter == totalElements) {
					return list;
				}
			}

			for (int j = ei; j > si; j--) {
				list.add(matrix[j][sj]);
				counter++;
				if (counter == totalElements) {
					return list;
				}
			}

			si++;
			sj++;
			ej--;
			ei--;
		}

		return list;
	}

	public static void main(String args[]) {
		SpiralMatrix sm = new SpiralMatrix();
		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(sm.spiralOrder(matrix));
	}

}
