package arrays;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Search2DArray {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int height = matrix[0].length - 1;
        while (i < matrix.length && height >= 0) {
            if (target == matrix[i][height]) return true;
            else if (matrix[i][height] > target) height--;
            else if (matrix[i][height] < target) i++;
        }
        return false;
    }
}
