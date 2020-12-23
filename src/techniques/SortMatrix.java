package techniques;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/sort-the-matrix-diagonally/
 * explanation is good on leetcode
 */
public class SortMatrix {

    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer, PriorityQueue<Integer>> hm = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                hm.putIfAbsent(i - j, new PriorityQueue<Integer>());
                hm.get(i - j).add(mat[i][j]);
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = hm.get(i - j).poll();
            }
        }
        return mat;
    }
}
