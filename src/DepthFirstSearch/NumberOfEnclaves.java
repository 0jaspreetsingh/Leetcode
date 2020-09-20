package DepthFirstSearch;

import java.util.stream.IntStream;

/**
 * 1020. Number of Enclaves
 * https://leetcode.com/problems/number-of-enclaves/
 */
public class NumberOfEnclaves {

    public int numEnclaves(int[][] A) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }
        int bre = A[0].length;


        for (int i = 0; i < len; i++) {
            process(A, i, 0, len, bre);
            process(A, i, bre - 1, len, bre);
        }

        for (int i = 1; i < bre - 1; i++) {
            process(A, 0, i, len, bre);
            process(A, len - 1, i, len, bre);
        }
        int ans = 0;

        for (int ll[] : A) {
            ans += IntStream.of(ll).sum();
        }

        return ans;
    }

    int ii[] = {1, 0, -1, 0};
    int jj[] = {0, 1, 0, -1};

    private void process(int[][] arr, int i, int j, int len, int bre) {
        if (arr[i][j] == 1) {
            arr[i][j] = 0;
            for (int p = 0; p < 4; p++) {
                int iii = i + ii[p];
                int jjj = j + jj[p];
                if (iii >= 0 && iii < len && jjj >= 0 && jjj < bre) {
                    process(arr, iii, jjj, len, bre);
                }
            }
        }
    }


    public static void main(String[] args) {
        int arr[][] = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        NumberOfEnclaves n = new NumberOfEnclaves();
        System.out.println(n.numEnclaves(arr));
    }
}
