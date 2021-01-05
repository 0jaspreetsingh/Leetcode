package Greedy;

/**
 * https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
 */
public class FindValidMatrixGivenRowandColumnSums {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int ans[][] = new int[rowSum.length][colSum.length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
            }
        }
        return ans;
    }

    // optimized
    public int[][] restoreMatrixOptimized(int[] rowSum, int[] colSum) {
        int ans[][] = new int[rowSum.length][colSum.length];
        int i = 0, j = 0;
        while (i < rowSum.length && j < colSum.length) {
            ans[i][j] = Math.min(rowSum[i], colSum[j]);
            rowSum[i] -= ans[i][j];
            colSum[j] -= ans[i][j];
            if (rowSum[i] == 0) i++;
            if (colSum[j] == 0) j++;
        }

        return ans;
    }
}
